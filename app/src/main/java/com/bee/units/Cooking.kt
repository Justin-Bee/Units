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

class Cooking: Fragment(), View.OnClickListener, AdapterView.OnItemSelectedListener {

    var from:String=""
    var to:String =""
    var entry: String = ""


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
                0 -> from = "ts"
                1 -> from = "tb"
                2 -> from = "c"
                3 -> from = "fo"
                4 -> from = "p"
                5 -> from = "q"
                6 -> from = "g"
            }

        }else if(parent.getId()==(R.id.toSpinner)){
            parent.getItemAtPosition(pos)
            when (pos) {
                0 -> to = "ts"
                1 -> to = "tb"
                2 -> to = "c"
                3 -> to = "fo"
                4 -> to = "p"
                5 -> to = "q"
                6 -> to = "g"
            }
        }

    }

    override fun onNothingSelected(parent: AdapterView<*>) {
        if(parent.getId()==R.id.fromSpinner) {
            from = "ts"
        }else{
            to ="tb"
        }
    }





    companion object {
        fun newInstance(): Cooking {
            return Cooking()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        // Inflate the layout for this fragment
        val view: View=  inflater.inflate(R.layout.cooking, container, false)
        val button: Button = view.findViewById(R.id.abutton)
        button.setOnClickListener(this)

        val fromSpinner: Spinner = view.findViewById(R.id.fromSpinner)
        // Create an ArrayAdapter using the string array and a default spinner layout
        fromSpinner.adapter = ArrayAdapter(
            activity,
            R.layout.spinner_item,
            resources.getStringArray(R.array.cooking_array)
        )
        val toSpinner: Spinner = view.findViewById(R.id.toSpinner)
        toSpinner.adapter = ArrayAdapter(
            activity,
            R.layout.spinner_item,
            resources.getStringArray(R.array.cooking_array)
        )
        fromSpinner.onItemSelectedListener= this
        toSpinner.onItemSelectedListener = this

        return view
    }


    fun convert(x: String):String{
        try {
            var num = Integer.parseInt(x)
            var result=""
            if (from.equals("ts") && to.equals("tb")){
                result = teaspoonToTablespoon(num)
            }else if (from.equals("ts") && to.equals("c")){
                result = teaspoonToCups(num)
            }else if (from.equals("ts") && to.equals("fo")){
                result = teaspoonToFluidOunce(num)
            }else if (from.equals("ts") && to.equals("p")){
                result = teaspoonToPints(num)
            }else if (from.equals("ts") && to.equals("q")){
                result = teaspoonToQuart(num)
            }else if (from.equals("ts") && to.equals("g")){
                result = teaspoonToGallon(num)
            }else if (from.equals("tb") && to.equals("ts")){
                result = tablespoonToTeaspoon(num)
            }else if (from.equals("tb") && to.equals("c")){
                result = tablespoonToCup(num)
            }else if (from.equals("tb") && to.equals("fo")){
                result = tablespoonToFluidOunce(num)
            }else if (from.equals("tb") && to.equals("p")){
                result = tablespoonToPint(num)
            }else if (from.equals("tb") && to.equals("q")){
                result = tablespoonToQuart(num)
            }else if (from.equals("tb") && to.equals("g")){
                result = tablespoonToGallon(num)
            }else if (from.equals("c") && to.equals("ts")){
                result = cupToTeaspoon(num)
            }else if (from.equals("c") && to.equals("tb")){
                result = cupToTablespoon(num)
            }else if (from.equals("c") && to.equals("fo")){
                result = cupToFluidOunce(num)
            }else if (from.equals("c") && to.equals("p")){
                result = cupToPints(num)
            }else if (from.equals("c") && to.equals("q")){
                result = cupsToQuarts(num)
            }else if (from.equals("c") && to.equals("g")){
                result = cupToGallons(num)
            }else if (from.equals("fo") && to.equals("ts")){
                result = fluidOunceToTeaspoon(num)
            }else if (from.equals("fo") && to.equals("tb")){
                result = fluidOunceToTablespoon(num)
            }else if (from.equals("fo") && to.equals("c")){
                result = fluidOunceToCup(num)
            }else if (from.equals("fo") && to.equals("p")){
                result = fluidOunceToPint(num)
            }else if (from.equals("fo") && to.equals("q")){
                result = fluidOunceToQuart(num)
            }else if (from.equals("fo") && to.equals("g")){
                result = fluidOunceToGallon(num)
            }else if (from.equals("p") && to.equals("ts")){
                result = pintToTeaspoon(num)
            }else if (from.equals("p") && to.equals("tb")){
                result = pintToTablespoon(num)
            }else if (from.equals("p") && to.equals("c")){
                result = pintToCup(num)
            }else if (from.equals("p") && to.equals("fo")){
                result = pintToFluidOunce(num)
            }else if (from.equals("p") && to.equals("q")){
                result = pintToQuart(num)
            }else if (from.equals("p") && to.equals("g")){
                result = pintToGallon(num)
            }else if (from.equals("q") && to.equals("ts")){
                result = quartToTeaspoon(num)
            }else if (from.equals("q") && to.equals("tb")){
                result = quartToTablespoon(num)
            }else if (from.equals("q") && to.equals("c")){
                result = quartToCups(num)
            }else if (from.equals("q") && to.equals("fo")){
                result = quartToFluidOunce(num)
            }else if (from.equals("q") && to.equals("p")){
                result = quartToPints(num)
            }else if (from.equals("q") && to.equals("g")){
                result = quartToGallons(num)
            }else if (from.equals("g") && to.equals("ts")){
                result = gallonToTeaspoon(num)
            }else if (from.equals("g") && to.equals("tb")){
                result = gallonToTablespoon(num)
            }else if (from.equals("g") && to.equals("c")){
                result = gallonToCup(num)
            }else if (from.equals("g") && to.equals("fo")){
                result = gallonToFluidOunce(num)
            }else if (from.equals("g") && to.equals("p")){
                result = gallonToPints(num)
            }else if (from.equals("g") && to.equals("q")){
                result = gallonToQuart(num)
            }else{
                 result = "Please choose valid parameters"
            }

            return result.toString()
        }catch(nfe: NumberFormatException){
            return ("Invalid Input")
        }
    }

    fun teaspoonToTablespoon(x: Int):String{
        return (x/3.0).toString()
    }

    fun teaspoonToCups(x: Int): String{
        return (x/48.0).toString()
    }

    fun teaspoonToFluidOunce(x: Int):String{
        return (x/6.0).toString()
    }

    fun teaspoonToPints(x: Int):String{
        return (x/96.0).toString()
    }
    
    fun teaspoonToQuart(x: Int):String{
        return (x/192.0).toString()
    }
    
    fun teaspoonToGallon(x: Int):String{
        return (x/768.0).toString()
    }
    
    fun tablespoonToTeaspoon(x: Int):String{
        return (x/3.0).toString()
    }
    
    fun tablespoonToCup(x:Int):String{
        return (x/16.0).toString()
    }
    
    fun tablespoonToFluidOunce(x: Int):String{
        return (x/2.0).toString()
    }
    
    fun tablespoonToPint(x: Int):String{
        return (x/32.0).toString()
    }
    
    fun tablespoonToQuart(x: Int):String{
        return (x/64.0).toString()
    }
    
    fun tablespoonToGallon(x: Int):String{
        return (x/256.0).toString()
    }
    
    fun cupToTeaspoon(x: Int):String{
        return (x*48.0).toString()
    }
    
    fun cupToTablespoon(x: Int):String{
        return (x*16.0).toString()
    }
    
    fun cupToFluidOunce(x: Int):String{
        return (x*8.0).toString()
    }
    
    fun cupToPints(x: Int):String{
        return (x/2.0).toString()
    }

    fun cupsToQuarts(x: Int):String {
        return (x / 4.0).toString()
    }

    fun cupToGallons(x: Int):String {
        return (x / 16.0).toString()
    }
    
    fun fluidOunceToTeaspoon(x: Int):String{
        return (x*6.0).toString()
    }
    
    fun fluidOunceToTablespoon(x: Int):String{
        return (x*2.0).toString()
    }
    
    fun fluidOunceToCup(x: Int):String{
        return (x/8.0).toString()
    }

    fun fluidOunceToPint(x: Int):String{
        return (x/16.0).toString()
    }

    fun fluidOunceToQuart(x: Int):String{
        return (x/32.0).toString()
    }

    fun fluidOunceToGallon(x: Int):String{
        return (x/128.0).toString()
    }

    fun pintToTeaspoon(x: Int):String{
        return (x*96.0).toString()
    }

    fun pintToTablespoon(x: Int):String{
        return (x*32.0).toString()
    }

    fun pintToCup(x: Int):String{
        return (x*2.0).toString()
    }

    fun pintToFluidOunce(x: Int):String{
        return (x*16.0).toString()
    }

    fun pintToQuart(x: Int):String{
        return (x/2.0).toString()
    }

    fun pintToGallon(x: Int):String{
        return (x/8.0).toString()
    }

    fun quartToTeaspoon(x: Int):String{
        return (x*192.0).toString()
    }

    fun quartToTablespoon(x: Int):String{
        return (x*64.0).toString()
    }

    fun quartToCups(x: Int):String{
        return (x*4.0).toString()
    }

    fun quartToFluidOunce(x: Int):String{
        return (x*32.0).toString()
    }

    fun quartToPints(x: Int):String{
        return (x*2.0).toString()
    }

    fun quartToGallons(x: Int):String{
        return (x/4.0).toString()
    }

    fun gallonToTeaspoon(x: Int):String{
        return (x*768.0).toString()
    }

    fun gallonToTablespoon(x: Int):String{
        return (x*256.0).toString()
    }

    fun gallonToCup(x: Int):String{
        return (x*16.0).toString()
    }

    fun gallonToFluidOunce(x: Int):String{
        return (x*128.0).toString()
    }

    fun gallonToPints(x: Int):String{
        return (x*8.0).toString()
    }

    fun gallonToQuart(x: Int):String{
        return (x*4.0).toString()
    }
    
}
