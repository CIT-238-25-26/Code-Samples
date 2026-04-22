package com.example.cit_238_communications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.cit_238_communications.nfc.NfcViewModel
import com.google.android.material.switchmaterial.SwitchMaterial
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class NfcFragment : Fragment() {

    private val viewModel: NfcViewModel by activityViewModels()

    // View references
    private lateinit var tvNfcContent: TextView
    private lateinit var tvModeLabel: TextView
    private lateinit var tvInstruction: TextView
    private lateinit var switchWriteMode: SwitchMaterial
    private lateinit var tilWriteInput: TextInputLayout
    private lateinit var etWriteText: TextInputEditText
    private lateinit var ivNfcIcon: ImageView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_nfc, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Manually wire up views
        tvNfcContent   = view.findViewById(R.id.tv_nfc_content)
        tvModeLabel    = view.findViewById(R.id.tv_mode_label)
        tvInstruction  = view.findViewById(R.id.tv_instruction)
        switchWriteMode = view.findViewById(R.id.switch_write_mode)
        tilWriteInput  = view.findViewById(R.id.til_write_input)
        etWriteText    = view.findViewById(R.id.et_write_text)
        ivNfcIcon      = view.findViewById(R.id.iv_nfc_icon)

        // Observe NFC content
        viewModel.nfcContent.observe(viewLifecycleOwner) { content ->
            tvNfcContent.text = content
        }

        // Observe write mode
        viewModel.isWriteMode.observe(viewLifecycleOwner) { isWrite ->
            tvModeLabel.text = "Mode: ${if (isWrite) "Write" else "Read"}"
            tilWriteInput.visibility = if (isWrite) View.VISIBLE else View.GONE
            tvInstruction.text = if (isWrite)
                "Hold your phone near an NFC tag to write"
            else
                "Hold your phone near an NFC tag to read"
            tvInstruction.setTextColor(
                if (isWrite)
                    requireContext().getColor(android.R.color.holo_red_light)
                else
                    requireContext().getColor(R.color.secondary_text)
            )
            ivNfcIcon.setImageResource(
                if (isWrite) R.drawable.ic_write else R.drawable.ic_nfc
            )
        }

        // Write mode switch
        switchWriteMode.setOnCheckedChangeListener { _, isChecked ->
            val text = etWriteText.text?.toString() ?: ""
            viewModel.setWriteMode(isChecked, text)
        }
    }
}