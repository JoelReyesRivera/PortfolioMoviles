package com.hellowolrd.camaraapp

import android.Manifest
import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.hardware.camera2.CameraCaptureSession
import android.hardware.camera2.CameraDevice
import android.hardware.camera2.CameraManager
import android.hardware.camera2.CaptureRequest
import android.hardware.camera2.params.OutputConfiguration
import android.hardware.camera2.params.SessionConfiguration
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.SurfaceHolder
import android.view.SurfaceView
import android.widget.Button
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.activity_main.*
import java.util.concurrent.Executors
import javax.security.auth.callback.Callback

class MainActivity : AppCompatActivity() {
    private val REQUEST_CAMERA = 10
    private val executorCamera = Executors.newSingleThreadExecutor()
    private lateinit var button : FloatingActionButton
    private var idCam=0;
    private lateinit var surfacePreview : SurfaceView
    private lateinit var captureSession : CameraCaptureSession
    private lateinit var cameraDevice: CameraDevice
    private lateinit var builderCapture: CaptureRequest.Builder

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        if (requestCode == REQUEST_CAMERA) {
            if (grantResults.contains(PackageManager.PERMISSION_GRANTED)) {
                configCamera()
            } else {
                Toast.makeText(this, "Es necesario aceptar el permiso de la camara para este ejercicio", Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button = findViewById(R.id.floatingActionButton)
        surfacePreview = findViewById<SurfaceView>(R.id.surface_preview)

        button.setOnClickListener(){
                change();
        }

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
            configCamera()
        } else {
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CAMERA), REQUEST_CAMERA)
        }
    }

    @SuppressLint("MissingPermission")
    fun configCamera() {
        surfacePreview.holder.addCallback(object: SurfaceHolder.Callback {
            override fun surfaceCreated(holder: SurfaceHolder) {

                val cameraManager = getSystemService(CAMERA_SERVICE) as CameraManager

                cameraManager.openCamera(cameraManager.cameraIdList.get(idCam),
                  callback ,null)
            }

            override fun surfaceChanged(holder: SurfaceHolder, format: Int, width: Int, height: Int) { }

            override fun surfaceDestroyed(holder: SurfaceHolder) { }

        })

    }
    private var callback =  object: CameraDevice.StateCallback() {

        override fun onOpened(camera: CameraDevice) {
            cameraDevice = camera;
            builderCapture  = camera.createCaptureRequest(CameraDevice.TEMPLATE_PREVIEW)
            builderCapture.addTarget(surfacePreview.holder.surface)

            val captureRequest = builderCapture.build()

            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.P) {
                camera.createCaptureSession(
                    listOf(surfacePreview.holder.surface),
                    object: CameraCaptureSession.StateCallback() {
                        override fun onConfigured(session: CameraCaptureSession) {
                            session.setRepeatingRequest(captureRequest, null, null)
                        }
                        override fun onConfigureFailed(session: CameraCaptureSession) { }
                    },
                    null
                )
            } else {
                val sessionConfiguration = SessionConfiguration(
                    SessionConfiguration.SESSION_REGULAR,
                    listOf(
                        OutputConfiguration(surfacePreview.holder.surface)
                    ),
                    executorCamera,
                    object: CameraCaptureSession.StateCallback() {
                        override fun onConfigured(session: CameraCaptureSession) {
                            captureSession = session;
                            session.setRepeatingRequest(captureRequest, null, null)
                        }

                        override fun onConfigureFailed(session: CameraCaptureSession) { }

                    }
                )

                camera.createCaptureSession(sessionConfiguration)
            }
        }

        override fun onDisconnected(camera: CameraDevice) { }

        override fun onError(camera: CameraDevice, error: Int) { }

    };
    @SuppressLint("MissingPermission")
    fun change(){
        val cameraManager = getSystemService(CAMERA_SERVICE) as CameraManager
        cameraDevice.close()
        if (idCam==0){
            idCam=1;
            cameraManager.openCamera(idCam.toString(), callback,null)
        }
        else{
            idCam=0;
            cameraManager.openCamera(idCam.toString(), callback,null)
        }
    }
}