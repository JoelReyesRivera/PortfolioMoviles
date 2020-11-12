package com.hellowolrd.activitylifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private val TAG ="MainActivity"
    private lateinit var logView : TextView

    private fun addLog(message : String){
        logView.text = logView.text.toString() + message + "\n"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(TAG, "ON CREATE")
        logView = findViewById(R.id.logView)
        addLog("ON CREATE")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "ON RESUME")
        addLog("ON START")
        addLog("ON START")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "ON RESTART")
        addLog("ON RESTART")

    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "ON PAUSE")
        addLog("ON PAUSE")

    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "ON STOP")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "ON DESTROY")
    }
}