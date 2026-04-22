package com.example.cit_238_communications.nfc

import android.nfc.NdefMessage
import android.nfc.NdefRecord
import android.nfc.Tag
import android.nfc.tech.Ndef
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.nio.charset.Charset

class NfcViewModel : ViewModel() {

    private val _nfcContent = MutableLiveData("No tag detected")
    val nfcContent: LiveData<String> = _nfcContent

    private val _isWriteMode = MutableLiveData(false)
    val isWriteMode: LiveData<Boolean> = _isWriteMode

    private var _pendingWriteData: String? = null

    fun setWriteMode(enabled: Boolean, data: String? = null) {
        _isWriteMode.value = enabled
        _pendingWriteData = data
    }

    fun processTag(tag: Tag) {
        if (_isWriteMode.value == true) {
            _pendingWriteData?.let { writeTag(tag, it) }
        } else {
            readTag(tag)
        }
    }

    private fun readTag(tag: Tag): String {
        val ndef = Ndef.get(tag) ?: return "Tag is not NDEF formatted"
        return try {
            ndef.connect()
            val ndefMessage = ndef.ndefMessage
            val payload = ndefMessage.records[0].payload
            val text = String(payload, 3, payload.size - 3, Charset.forName("UTF-8"))
            _nfcContent.postValue("Read: $text")
            "Read: $text"
        } catch (e: Exception) {
            _nfcContent.postValue("Error reading tag: ${e.message}")
            "Error reading tag"
        } finally {
            ndef.close()
        }
    }

    private fun writeTag(tag: Tag, data: String): String {
        val ndef = Ndef.get(tag) ?: return "Tag is not NDEF formatted"
        return try {
            ndef.connect()
            val mimeRecord = NdefRecord.createMime("text/plain", data.toByteArray(Charset.forName("UTF-8")))
            val ndefMessage = NdefMessage(arrayOf(mimeRecord))
            ndef.writeNdefMessage(ndefMessage)
            _nfcContent.postValue("Write Successful: $data")
            "Write Successful"
        } catch (e: Exception) {
            _nfcContent.postValue("Error writing tag: ${e.message}")
            "Error writing tag"
        } finally {
            ndef.close()
        }
    }
}