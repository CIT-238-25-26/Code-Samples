package com.example.cit_238_fragmentintro

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.graphics.Color

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ColorFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ColorFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_color, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        Initialize the button click
        val redButton = view.findViewById<Button>(R.id.red_button)
        val greenButton = view.findViewById<Button>(R.id.green_button)
        val blueButton = view.findViewById<Button>(R.id.blue_button)
        val helloWorldTextView = view.findViewById<TextView>(R.id.hello_world)

        redButton.setOnClickListener {
            helloWorldTextView.setTextColor(Color.RED)
        }
        greenButton.setOnClickListener {
            helloWorldTextView.setTextColor(Color.GREEN)
        }
        blueButton.setOnClickListener {
            helloWorldTextView.setTextColor(Color.BLUE)
        }
    }
}