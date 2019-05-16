package com.bee.units


import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.hextodec.*



class hextodec: Fragment() {

    var entry: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        // Inflate the layout for this fragment
        val view: View=  inflater.inflate(R.layout.hextodec, container, false)
        abutton.setOnClickListener {
            onClick(it)
        }
        return view
    }

    override fun onAttach(activity: Activity?) {
        super.onAttach(activity)
    }

    override fun onDetach() {
        super.onDetach()
    }

    fun convert(x: String):Int{
        var result=0
        var temp: Int


        return result
    }

         fun onClick(v: View?) {
                    entry = textBox.text.toString()
                    textBox.setText(entry)
        }

}



