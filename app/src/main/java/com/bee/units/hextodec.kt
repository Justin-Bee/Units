package com.bee.units


import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.hextodec.*



class hextodec: Fragment(), View.OnClickListener {

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.abutton-> {
                entry = textBox.text.toString()
                textView.setText("Result: "+ entry)

            }else->{

        }

        }
        entry = textBox.text.toString()
        val result = convert(entry)
        textBox.setText(result)
    }

    var entry: String = ""


    companion object {
        fun newInstance(): hextodec {
            return hextodec()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        // Inflate the layout for this fragment
        val view: View=  inflater.inflate(R.layout.hextodec, container, false)
        val button: Button = view.findViewById(R.id.abutton)
        button.setOnClickListener(this)
        return view
    }


    fun convert(x: String):Int{
        var result= Integer.parseInt(x, 16)
        return result
    }


}