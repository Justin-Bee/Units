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

class Length:  Fragment(), View.OnClickListener, AdapterView.OnItemSelectedListener  {
    var to: String =""
    var from: String =""
    var entry: String=""

    override fun onClick(v: View?){
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
                0 -> from = "i"
                1 -> from = "f"
                2 -> from = "m"
                3 -> from = "c"
                4 -> from = "me"
                5 -> from = "km"
            }

        }else if(parent.getId()==(R.id.toSpinner)){
            parent.getItemAtPosition(pos)
            when (pos) {
                0 -> to = "i"
                1 -> to = "f"
                2 -> to = "m"
                3 -> to = "c"
                4 -> to = "me"
                5 -> to = "km"
            }
        }

    }

    override fun onNothingSelected(parent: AdapterView<*>) {
        if(parent.getId()==R.id.fromSpinner) {
            from = "i"
        }else{
            to ="f"
        }
    }

    companion object {
        fun newInstance(): Length {
            return Length()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        // Inflate the layout for this fragment
        val view: View=  inflater.inflate(R.layout.length, container, false)
        val button: Button = view.findViewById(R.id.abutton)
        button.setOnClickListener(this)

        val fromSpinner: Spinner = view.findViewById(R.id.fromSpinner)
        // Create an ArrayAdapter using the string array and a default spinner layout
        fromSpinner.adapter = ArrayAdapter(
            activity,
            R.layout.spinner_item,
            resources.getStringArray(R.array.length_array)
        )
        val toSpinner: Spinner = view.findViewById(R.id.toSpinner)
        toSpinner.adapter = ArrayAdapter(
            activity,
            R.layout.spinner_item,
            resources.getStringArray(R.array.length_array)
        )
        fromSpinner.onItemSelectedListener= this
        toSpinner.onItemSelectedListener = this

        return view
    }

    fun convert(x: String):String{
        try {
            var num = x.toDouble()
            var result=""
            if (from.equals("i") && to.equals("f")) {
                result = inchesToFeet(num)
            }else if(from.equals("i")  && to.equals("m")){
                result = inchesToMiles(num)
            }else if(from.equals("i") && to.equals("c")){
                result = inchesToCentimeters(num)
            }else if(from.equals("i") && to.equals("me")){
                result = inchesToMeters(num)
            }else if(from.equals("i")  && to.equals("km")){
                result = inchesToKilometers(num)
            }else if(from.equals("f") && to.equals("i")){
                result = feetToInches(num)
            }else if(from.equals("f") && to.equals("m")){
                result = feetToMiles(num)
            }else if(from.equals("f") && to.equals("c")){
                result = feetToCentimeters(num)
            }else if(from.equals("f") && to.equals("me")){
                result = feetToMeters(num)
            }else if(from.equals("f") && to.equals("km")){
                result = feetToKilometers(num)
            }else if(from.equals("m") && to.equals("i")){
                result = milesToInches(num)
            }else if(from.equals("m") && to.equals("f")){
                result = milesToFeet(num)
            }else if(from.equals("m") && to.equals("c")){
                result = milesToCentimeters(num)
            }else if(from.equals("m") && to.equals("me")){
                result = milesToMeters(num)
            }else if(from.equals("m") && to.equals("km")){
                result = milesToKilometers(num)
            }else if(from.equals("c") && to.equals("i")){
                result = centimetersToInches(num)
            }else if(from.equals("c") && to.equals("f")){
                result = centimetersToFeet(num)
            }else if(from.equals("c") && to.equals("m")){
                result = centimetersToMiles(num)
            }else if(from.equals("c") && to.equals("me")){
                result = centimetersToMeters(num)
            }else if(from.equals("c") && to.equals("km")){
                result = centimetersToKilometers(num)
            }else if(from.equals("me") && to.equals("i")){
                result = metersToInches(num)
            }else if(from.equals("me") && to.equals("f")){
                result = metersToFeet(num)
            }else if(from.equals("me") && to.equals("m")){
                result = metersToMiles(num)
            }else if(from.equals("me") && to.equals("c")){
                result = metersToCentimeters(num)
            }else if(from.equals("me") && to.equals("km")){
                result = metersToKilometers(num)
            }else if(from.equals("km") && to.equals("i")){
                result = kilometersToInches(num)
            }else if(from.equals("km") && to.equals("f")){
                result = kilometersToFeet(num)
            }else if(from.equals("km") && to.equals("m")){
                result = kilometersToMiles(num)
            }else if(from.equals("km") && to.equals("c")){
                result = kilometersToCentimeters(num)
            }else if(from.equals("km") && to.equals("me")){
                result = kilometersToMeters(num)
            }
            else{
                result = "Please choose valid parameters."
            }


            return result.toString()
        }catch(nfe: NumberFormatException){
            return ("Invalid Input")
        }
    }

    fun inchesToFeet(x: Double):String{
        return (x/12.0).toString()
    }

    fun inchesToMiles(x: Double):String{
        return (x/63360).toString()
    }

    fun inchesToCentimeters(x: Double):String{
        return (x*2.54).toString()
    }

    fun inchesToMeters(x: Double):String{
        return (x/39.37).toString()
    }

    fun inchesToKilometers(x: Double):String{
        return (x/39370.079).toString()
    }

    fun feetToInches(x: Double):String{
        return (x*12.0).toString()
    }

    fun feetToMiles(x: Double):String{
        return (x/5280).toString()
    }

    fun feetToCentimeters(x: Double):String{
        return (x*30.48).toString()
    }

    fun feetToMeters(x: Double):String{
        return (x/3.281).toString()
    }

    fun feetToKilometers(x: Double):String{
        return (x/3280.84).toString()
    }

    fun milesToInches(x:Double):String{
        return (x*63360).toString()
    }

    fun milesToFeet(x:Double):String{
        return (x*5280).toString()
    }

    fun milesToCentimeters(x: Double):String{
        return (x*160934.4).toString()
    }

    fun milesToMeters(x: Double):String{
        return (x*1609.344).toString()
    }

    fun milesToKilometers(x: Double):String{
        return (x*1.609).toString()
    }

    fun centimetersToInches(x: Double):String{
        return (x/2.54).toString()
    }

    fun centimetersToFeet(x: Double):String{
        return (x/30.48).toString()
    }

    fun centimetersToMiles(x: Double):String{
        return (x/160934.4).toString()
    }

    fun centimetersToMeters(x: Double):String{
        return (x/100).toString()
    }

    fun centimetersToKilometers(x: Double):String{
        return (x/100000).toString()
    }

    fun metersToInches(x: Double):String{
        return (x*39.37).toString()
    }

    fun metersToFeet(x: Double):String{
        return (x*3.281).toString()
    }

    fun metersToMiles(x: Double):String{
        return (x/1609.344).toString()
    }

    fun metersToCentimeters(x: Double):String{
        return (x*100).toString()
    }

    fun metersToKilometers(x: Double):String{
        return (x/1000.0).toString()
    }

    fun kilometersToInches(x: Double):String{
        return (x*39370.079).toString()
    }

    fun kilometersToFeet(x: Double):String{
        return (x*3280.84).toString()
    }

    fun kilometersToMiles(x: Double):String{
        return (x/1.609).toString()
    }

    fun kilometersToCentimeters(x: Double):String{
        return (x*100000).toString()
    }

    fun kilometersToMeters(x: Double):String{
        return (x*1000).toString()
    }
}
