package com.hellowolrd.constraintlayout

import android.animation.ValueAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.LinearInterpolator
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mars = findViewById<ImageView>(R.id.mars)
        val mercurio = findViewById<ImageView>(R.id.mercurio)
        val venus = findViewById<ImageView>(R.id.venus)
        val tierra = findViewById<ImageView>(R.id.earth)
        val jupiter = findViewById<ImageView>(R.id.jupiter)
        val neptuno = findViewById<ImageView>(R.id.neptuno)
        val urano = findViewById<ImageView>(R.id.urano)
        val saturno = findViewById<ImageView>(R.id.saturno)

        val animationMercurio = ValueAnimator.ofInt(0,359 )
        animationMercurio.addUpdateListener{value ->
            val animatedValue= value.animatedValue as Int
            val layoutParamsMercurio = mercurio.layoutParams as ConstraintLayout.LayoutParams
            layoutParamsMercurio.circleAngle = animatedValue.toFloat()
            mercurio.layoutParams = layoutParamsMercurio

        }
        animationMercurio.repeatMode = ValueAnimator.RESTART
        animationMercurio.repeatCount = ValueAnimator.INFINITE
        animationMercurio.interpolator = LinearInterpolator()
        animationMercurio.duration = 880
        animationMercurio.start()

        val animationVenus = ValueAnimator.ofInt(0,359 )
        animationVenus.addUpdateListener{value ->
            val animatedValue= value.animatedValue as Int
            val layoutParamsVenus = venus.layoutParams as ConstraintLayout.LayoutParams
            layoutParamsVenus.circleAngle = animatedValue.toFloat()
            venus.layoutParams = layoutParamsVenus

        }
        animationVenus.repeatMode = ValueAnimator.RESTART
        animationVenus.repeatCount = ValueAnimator.INFINITE
        animationVenus.interpolator = LinearInterpolator()
        animationVenus.duration = 2440
        animationVenus.start()

        val animationEarth = ValueAnimator.ofInt(0,359 )
        animationEarth.addUpdateListener{value ->
            val animatedValue= value.animatedValue as Int
            val layoutParamsTierra = tierra.layoutParams as ConstraintLayout.LayoutParams
            layoutParamsTierra.circleAngle = animatedValue.toFloat()
            tierra.layoutParams = layoutParamsTierra

        }
        animationEarth.repeatMode = ValueAnimator.RESTART
        animationEarth.repeatCount = ValueAnimator.INFINITE
        animationEarth.interpolator = LinearInterpolator()
        animationEarth.duration = 3650
        animationEarth.start()

        val animationMarte = ValueAnimator.ofInt(0,359 )
        animationMarte.addUpdateListener{value ->
            val animatedValue= value.animatedValue as Int
            val layoutParamsMarte = mars.layoutParams as ConstraintLayout.LayoutParams
            layoutParamsMarte.circleAngle = animatedValue.toFloat()
            mars.layoutParams = layoutParamsMarte

        }
        animationMarte.repeatMode = ValueAnimator.RESTART
        animationMarte.repeatCount = ValueAnimator.INFINITE
        animationMarte.interpolator = LinearInterpolator()
        animationMarte.duration = 6870
        animationMarte.start()

        val animationJupiter = ValueAnimator.ofInt(0,359 )
        animationJupiter.addUpdateListener{value ->
            val animatedValue= value.animatedValue as Int
            val layoutParamsJupiter = jupiter.layoutParams as ConstraintLayout.LayoutParams
            layoutParamsJupiter.circleAngle = animatedValue.toFloat()
            jupiter.layoutParams = layoutParamsJupiter

        }
        animationJupiter.repeatMode = ValueAnimator.RESTART
        animationJupiter.repeatCount = ValueAnimator.INFINITE
        animationJupiter.interpolator = LinearInterpolator()
        animationJupiter.duration = 43800
        animationJupiter.start()

        val animationSaturno = ValueAnimator.ofInt(0,359 )
        animationSaturno.addUpdateListener{value ->
            val animatedValue= value.animatedValue as Int
            val layoutParamsSaturno = saturno.layoutParams as ConstraintLayout.LayoutParams
            layoutParamsSaturno.circleAngle = animatedValue.toFloat()
            saturno.layoutParams = layoutParamsSaturno

        }
        animationSaturno.repeatMode = ValueAnimator.RESTART
        animationSaturno.repeatCount = ValueAnimator.INFINITE
        animationSaturno.interpolator = LinearInterpolator()
        animationSaturno.duration = 105850
        animationSaturno.start()

        val animationUrano = ValueAnimator.ofInt(0,359 )
        animationUrano.addUpdateListener{value ->
            val animatedValue= value.animatedValue as Int
            val layoutParamsUrano = urano.layoutParams as ConstraintLayout.LayoutParams
            layoutParamsUrano.circleAngle = animatedValue.toFloat()
            urano.layoutParams = layoutParamsUrano

        }
        animationUrano.repeatMode = ValueAnimator.RESTART
        animationUrano.repeatCount = ValueAnimator.INFINITE
        animationUrano.interpolator = LinearInterpolator()
        animationUrano.duration = 303600
        animationUrano.start()

        val animationNeptuno = ValueAnimator.ofInt(0,359 )
        animationNeptuno.addUpdateListener{value ->
            val animatedValue= value.animatedValue as Int
            val layoutParamsNeptumo = neptuno.layoutParams as ConstraintLayout.LayoutParams
            layoutParamsNeptumo.circleAngle = animatedValue.toFloat()
            neptuno.layoutParams = layoutParamsNeptumo

        }
        animationNeptuno.repeatMode = ValueAnimator.RESTART
        animationNeptuno.repeatCount = ValueAnimator.INFINITE
        animationNeptuno.interpolator = LinearInterpolator()
        animationNeptuno.duration = 901500
        animationNeptuno.start()
    }
}