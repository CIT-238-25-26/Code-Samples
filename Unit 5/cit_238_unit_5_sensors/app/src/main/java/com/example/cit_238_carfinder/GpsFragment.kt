package com.example.cit_238_carfinder

import android.Manifest
import android.content.pm.PackageManager
import android.location.Location
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.location.Priority

class GpsFragment : Fragment() {

    private lateinit var fusedLocationClient: FusedLocationProviderClient

    private lateinit var textLatitude: TextView
    private lateinit var textLongitude: TextView
    private lateinit var textStatus: TextView
    private lateinit var btnGetLocation: Button

    private val requestPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestMultiplePermissions()
    ) { permissions ->
        val granted = permissions.entries.all { it.value }
        if (granted) {
            getLocation()
        } else {
            textStatus.text = "Permission Denied"
            Toast.makeText(context, "Permissions required for GPS", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_gps, container, false)

        textLatitude = root.findViewById(R.id.text_latitude)
        textLongitude = root.findViewById(R.id.text_longitude)
        textStatus = root.findViewById(R.id.text_status)
        btnGetLocation = root.findViewById(R.id.btn_get_location)

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(requireActivity())

        btnGetLocation.setOnClickListener {
            checkPermissionsAndGetLocation()
        }
    }

    private fun checkPermissionsAndGetLocation() {
        when {
            ContextCompat.checkSelfPermission(
                requireContext(),
                Manifest.permission.ACCESS_FINE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED -> {
                getLocation()
            }
            else -> {
                textStatus.text = "Requesting permissions..."
                requestPermissionLauncher.launch(
                    arrayOf(
                        Manifest.permission.ACCESS_FINE_LOCATION,
                        Manifest.permission.ACCESS_COARSE_LOCATION
                    )
                )
            }
        }
    }

    private fun getLocation() {
        textStatus.text = "Fetching location..."

        try {
            fusedLocationClient.getCurrentLocation(Priority.PRIORITY_HIGH_ACCURACY, null)
                .addOnSuccessListener { location: Location? ->
                    if (location != null) {
                        textLatitude.text = location.latitude.toString()
                        textLongitude.text = location.longitude.toString()
                        textStatus.text = "Success!"
                    } else {
                        textStatus.text = "Location not available (try turning on GPS)"
                    }
                }
                .addOnFailureListener { e ->
                    textStatus.text = "Error: ${e.message}"
                }
        } catch (e: SecurityException) {
            textStatus.text = "Security Exception: ${e.message}"
        }
    }
}