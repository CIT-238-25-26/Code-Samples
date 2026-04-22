package com.example.cit_238_communications

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cit_238_communications.adapters.DeviceAdapter
import com.example.cit_238_communications.bluetooth.BluetoothHelper
import com.google.android.material.button.MaterialButton

class BluetoothFragment : Fragment() {

    private lateinit var bluetoothHelper: BluetoothHelper
    private lateinit var deviceAdapter: DeviceAdapter

    // View references
    private lateinit var tvBtStatus: TextView
    private lateinit var tvDevicesCount: TextView
    private lateinit var tvEmpty: TextView
    private lateinit var progressScanning: ProgressBar
    private lateinit var btnScan: MaterialButton
    private lateinit var btnDiscoverable: MaterialButton
    private lateinit var rvDevices: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_bluetooth, container, false)
    }

    @SuppressLint("MissingPermission")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bluetoothHelper = (requireActivity() as MainActivity).bluetoothHelper

        // Manually wire up views
        tvBtStatus      = view.findViewById(R.id.tv_bt_status)
        tvDevicesCount  = view.findViewById(R.id.tv_devices_count)
        tvEmpty         = view.findViewById(R.id.tv_empty)
        progressScanning = view.findViewById(R.id.progress_scanning)
        btnScan         = view.findViewById(R.id.btn_scan)
        btnDiscoverable = view.findViewById(R.id.btn_discoverable)
        rvDevices       = view.findViewById(R.id.rv_devices)

        // Setup RecyclerView
        deviceAdapter = DeviceAdapter()
        rvDevices.layoutManager = LinearLayoutManager(requireContext())
        rvDevices.adapter = deviceAdapter

        // Observe devices list
        bluetoothHelper.foundDevicesLive.observe(viewLifecycleOwner) { devices ->
            deviceAdapter.submitList(devices.toList())
            tvDevicesCount.text = "Discovered Devices (${devices.size})"
            tvEmpty.visibility = if (devices.isEmpty() &&
                bluetoothHelper.isScanning.value == false) View.VISIBLE else View.GONE
        }

        // Observe scanning state
        bluetoothHelper.isScanning.observe(viewLifecycleOwner) { scanning ->
            progressScanning.visibility = if (scanning) View.VISIBLE else View.GONE
            btnScan.isEnabled = (bluetoothHelper.isBluetoothEnabled.value == true) && !scanning
            if (!scanning && deviceAdapter.currentList.isEmpty()) {
                tvEmpty.visibility = View.VISIBLE
            }
        }

        // Observe Bluetooth enabled state
        bluetoothHelper.isBluetoothEnabled.observe(viewLifecycleOwner) { enabled ->
            tvBtStatus.text = if (enabled) "Enabled" else "Disabled"
            btnScan.isEnabled = enabled && (bluetoothHelper.isScanning.value == false)
        }

        // Scan button
        btnScan.setOnClickListener {
            bluetoothHelper.startDiscovery()
        }

        // Make Discoverable button
        btnDiscoverable.setOnClickListener {
            bluetoothHelper.makeDiscoverable(requireContext())
        }
    }
}