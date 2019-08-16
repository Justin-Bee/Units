package com.bee.units


import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import kotlinx.android.synthetic.main.data.*

/** Copyright 2019 Justin Bee
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
**/

class Temperature: Fragment(), View.OnClickListener, AdapterView.OnItemSelectedListener {

    var from:String=""
    var to:String =""


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
                0 -> from = "c"
                1 -> from = "f"
                2 -> from = "k"
            }

        }else if(parent.getId()==(R.id.toSpinner)){
            parent.getItemAtPosition(pos)
            when (pos) {
                0 -> to = "c"
                1 -> to = "f"
                2 -> to = "k"
            }
        }

    }

    override fun onNothingSelected(parent: AdapterView<*>) {
        if(parent.getId()==R.id.fromSpinner) {
            from = "c"
        }else{
            to ="f"
        }
    }


    var entry: String = ""


    companion object {
        fun newInstance(): Temperature {
            return Temperature()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        // Inflate the layout for this fragment
        val view: View=  inflater.inflate(R.layout.temperature, container, false)
        val button: Button = view.findViewById(R.id.abutton)
        button.setOnClickListener(this)

        val fromSpinner: Spinner = view.findViewById(R.id.fromSpinner)
        // Create an ArrayAdapter using the string array and a default spinner layout
        fromSpinner.adapter = ArrayAdapter(
            activity,
            R.layout.spinner_item,
            resources.getStringArray(R.array.temp_array)
        )
        val toSpinner: Spinner = view.findViewById(R.id.toSpinner)
        toSpinner.adapter = ArrayAdapter(
            activity,
            R.layout.spinner_item,
            resources.getStringArray(R.array.temp_array)
        )
        fromSpinner.onItemSelectedListener= this
        toSpinner.onItemSelectedListener = this

        return view
    }


    fun convert(x: String):String{
        try {
            var num = Integer.parseInt(x)
            var result=""
            if (from.equals("c") && to.equals("f")){
                result = celsiusToFahrenheit(num)
            }else if(from.equals("c") && to.equals("k")){
                result = celsiusToKelvin(num)
            }else if(from.equals("f") && to.equals("c")){
                result = fahrenheitToCelcius(num)
            }else if(from.equals("f") && to.equals("k")){
                result = fahrenheitToKelvin(num)
            }else if(from.equals("k") && to.equals("c")){
                result = kelvinToCelsius(num)
            }else if(from.equals("k") && to.equals("f")){
                result = kelvinToFahrenheit(num)
            }else if(from.equals(to)){
                 result = "Please choose valid parameters"
            }

            return result.toString()
        }catch(nfe: NumberFormatException){
            return ("Invalid Input")
        }
    }

    fun celsiusToFahrenheit(x: Int): String{
        var result =""
        if (x<-273){
            result = "Number entered is below absolute zero."
        }else {
            var temp: Double = (x * 1.8) + 32
            result = temp.toString()
        }
        return result
    }

    fun celsiusToKelvin(x: Int): String{
        var result =""
        if(x<-273){
            result = "Number entered is below absolute zero."
        }else {
            var temp = x + 273
            result = temp.toString()
        }
        return result
    }

    fun fahrenheitToCelcius(x: Int): String{
        var result =""
        if(x<-459.5){
            result = "Number entered is below absolute zero."
        }else {
            var temp: Double = ((x - 32) * (0.5555555))
            result = temp.toString()
        }
        return result
    }

    fun fahrenheitToKelvin(x: Int): String{
        var result =""
        if(x<-459.5){
            result = "Number entered is below absolute zero."
        }else {
            var temp: Double = ((x - 32) * (0.5555555)) + 273
            result = temp.toString()
        }
        return result
    }

    fun kelvinToCelsius(x: Int): String{
        var result =""
        if(x<0){
            result = "Number entered is below absolute zero."
        }else {
            var temp = x - 273
            result = temp.toString()
        }
        return result
    }

    fun kelvinToFahrenheit(x: Int): String{
        var result =""
        if(x<0){
            result = "Number entered is below absolute zero."
        }else {
            var temp: Double = (x - 273) * 1.8 + 32
            result = temp.toString()
        }
        return result
    }



}
