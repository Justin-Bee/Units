package com.bee.units


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import kotlinx.android.synthetic.main.data.*
import java.lang.NumberFormatException
import java.math.BigInteger


class Data: Fragment(), View.OnClickListener, AdapterView.OnItemSelectedListener {

    var entry: String = ""
    var from: String=""
    var to: String=""

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.abutton-> {
                entry = textBox.text.toString()
            }else->{
        }
        }
        entry = textBox.text.toString()
        val result = convert(entry)
        textView.text = "Result: $result"
    }



    override fun onItemSelected(parent: AdapterView<*>, view: View, pos: Int, id: Long) {
        // An item was selected. You can retrieve the selected item using
        if(parent.getId()==(R.id.fromSpinner)) {
            parent.getItemAtPosition(pos)
            when (pos) {
                0 -> from = "h"
                1 -> from = "d"
                2 -> from = "b"
            }

        }else if(parent.getId()==(R.id.toSpinner)){
            parent.getItemAtPosition(pos)
            when (pos) {
                0 -> to = "h"
                1 -> to = "d"
                2 -> to = "b"
            }
        }

    }

    override fun onNothingSelected(parent: AdapterView<*>) {
        if(parent.getId()==R.id.fromSpinner) {
            from = "h"
        }else{
            to ="d"
        }
    }


    companion object {
        fun newInstance(): Data {
            return Data()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        // Inflate the layout for this fragment
        val view: View=  inflater.inflate(R.layout.data, container, false)
        val button: Button = view.findViewById(R.id.abutton)
        button.setOnClickListener(this)

        val fromSpinner: Spinner = view.findViewById(R.id.fromSpinner)
        // Create an ArrayAdapter using the string array and a default spinner layout
        fromSpinner.adapter = ArrayAdapter(
            activity,
            R.layout.spinner_item,
            resources.getStringArray(R.array.data_array)
        )
        val toSpinner: Spinner = view.findViewById(R.id.toSpinner)
        toSpinner.adapter = ArrayAdapter(
            activity,
            R.layout.spinner_item,
            resources.getStringArray(R.array.data_array)
        )
        fromSpinner.onItemSelectedListener= this
        toSpinner.onItemSelectedListener = this

        return view
    }


    fun convert(x: String):String {
                var result = ""
                if (from.equals("h") && to.equals("d")) {
                    result = hexToDec(x)
                }else if(from.equals("h") && to.equals("b")) {
                    result = hexToBinary(x)
                }else if(from.equals("d") && to.equals("h")){
                    result = decToHex(x)
                }else if(from.equals("d") && to.equals("b")){
                    result = decToBinary(x)
                }else if(from.equals("b") && to.equals("h")){
                    result = binaryToHex(x)
                }else if(from.equals("b") && to.equals("d")){
                    result = binaryToDec(x)
                }else{
                    result = "Please enter valid parameters"
                }
                return result.toString()
        }



    fun hexToDec(x: String): String{
        var result= ""
        try{
            var data: Int = Integer.parseInt(x, 16)
            result = data.toString()
        }catch(nfe: NumberFormatException){
            result= "Invalid Format"
        }
        return result
    }

    fun hexToBinary(x: String): String{
        var result=""
        result = BigInteger(x, 16).toString(2)
        return result
    }

    fun decToHex(x: String): String{
        var result=""
        try {
            var data: Int = Integer.parseInt(x)
            result = Integer.toHexString(data)
        }catch(nfe: NumberFormatException){
            result = "Invalid format"
        }
        return result
    }

    fun decToBinary(x: String): String{
        var result=""
        try{
            var data: Int = Integer.parseInt(x)
            result = Integer.toBinaryString(data)
        }catch(nfe: NumberFormatException){
            result = "Invalid Format"
        }
        return result
    }

    fun binaryToHex(x: String): String{
        var result=""
        try{
            var data: Int = Integer.parseInt(x, 2)
            result = Integer.toString(data, 16)
        }catch(nfe: NumberFormatException){
            result = "Invalid Format"
        }
        return result
    }

    fun binaryToDec(x: String): String{
        var result =""
        try{
            var data: Int = Integer.parseInt(x, 2)
            result = data.toString()
        }catch(nfe: NumberFormatException){
            result = "Invalid Format"
        }
        return result
    }

}