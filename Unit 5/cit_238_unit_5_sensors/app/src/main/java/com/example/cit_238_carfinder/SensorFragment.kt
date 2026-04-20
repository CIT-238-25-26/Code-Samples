package com.example.cit_238_carfinder

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import kotlin.math.abs

class SensorFragment : Fragment(), SensorEventListener {

    private lateinit var sensorManager: SensorManager
    private var accelerometer: Sensor? = null
    private var gyroscope: Sensor? = null

    private lateinit var textDirection: TextView
    private lateinit var textValues: TextView
    private lateinit var tiltIndicator: View

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_sensor, container, false)

        textDirection = root.findViewById(R.id.text_direction)
        textValues = root.findViewById(R.id.text_values)
        tiltIndicator = root.findViewById(R.id.tilt_indicator)

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sensorManager = requireActivity().getSystemService(Context.SENSOR_SERVICE) as SensorManager
        accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)
        gyroscope = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE)
    }

    override fun onResume() {
        super.onResume()
        accelerometer?.let {
            sensorManager.registerListener(this, it, SensorManager.SENSOR_DELAY_UI)
        }
        gyroscope?.let {
            sensorManager.registerListener(this, it, SensorManager.SENSOR_DELAY_UI)
        }
    }

    override fun onPause() {
        super.onPause()
        sensorManager.unregisterListener(this)
    }

    override fun onSensorChanged(event: SensorEvent?) {
        if (event == null) return

        when (event.sensor.type) {
            Sensor.TYPE_ACCELEROMETER -> {
                val x = event.values[0]
                val y = event.values[1]
                val z = event.values[2]

                updateTiltUI(x, y, z)
            }
            Sensor.TYPE_GYROSCOPE -> {
                val gx = event.values[0]
                val gy = event.values[1]
                val gz = event.values[2]

                textValues.text = "Gyro: %.2f, %.2f, %.2f".format(gx, gy, gz)
            }
        }
    }

    private fun updateTiltUI(x: Float, y: Float, z: Float) {
        val direction = when {
            abs(x) < 1.0f && abs(y) < 1.0f -> "Flat"
            abs(x) > abs(y) -> if (x > 0) "Tilted Left" else "Tilted Right"
            else -> if (y > 0) "Tilted Down/Forward" else "Tilted Up/Backward"
        }

        textDirection.text = "Direction: $direction"

        tiltIndicator.translationX = -x * 20f
        tiltIndicator.translationY = y * 20f
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {}
}