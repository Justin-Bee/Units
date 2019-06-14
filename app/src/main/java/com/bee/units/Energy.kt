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



class Energy: Fragment(), View.OnClickListener, AdapterView.OnItemSelectedListener {

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
                0 -> from = "j"
                1 -> from = "c"
                2 -> from = "b"
                3 -> from = "k"
            }

        }else if(parent.getId()==(R.id.toSpinner)){
            parent.getItemAtPosition(pos)
            when (pos) {
                0 -> to = "j"
                1 -> to = "c"
                2 -> to = "b"
                3 -> to = "k"
            }
        }

    }

    override fun onNothingSelected(parent: AdapterView<*>) {
        if(parent.getId()==R.id.fromSpinner) {
            from = "j"
        }else{
            to ="c"
        }
    }


    companion object {
        fun newInstance(): Energy {
            return Energy()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        // Inflate the layout for this fragment
        val view: View=  inflater.inflate(R.layout.energy, container, false)
        val button: Button = view.findViewById(R.id.abutton)
        button.setOnClickListener(this)

        val fromSpinner: Spinner = view.findViewById(R.id.fromSpinner)
        // Create an ArrayAdapter using the string array and a default spinner layout
        fromSpinner.adapter = ArrayAdapter(
            activity,
            R.layout.spinner_item,
            resources.getStringArray(R.array.energy_array)
        )
        val toSpinner: Spinner = view.findViewById(R.id.toSpinner)
        toSpinner.adapter = ArrayAdapter(
            activity,
            R.layout.spinner_item,
            resources.getStringArray(R.array.energy_array)
        )
        fromSpinner.onItemSelectedListener= this
        toSpinner.onItemSelectedListener = this

        return view
    }


    fun convert(x: String):String{
        try {
            var num = Integer.parseInt(x)
            var result=""
            if(from.equals("j") && to.equals("c")){
                result = joulesToCalories(num)
            }else if(from.equals("j") && to.equals("b")){
                result = joulesToBtu(num)
            }else if(from.equals("j") && to.equals("k")) {
                result = joulesToKilowatt(num)
            }else if(from.equals("c") && to.equals("j")) {
                result = caloriesToJoules(num)
            }else if(from.equals("c") && to.equals("b")) {
                result = caloriesToBtu(num)
            }else if(from.equals("c") && to.equals("k")) {
                result = caloriesToKilo(num)
            }else if(from.equals("b") && to.equals("j")) {
                result = btuToJoules(num)
            }else if(from.equals("b") && to.equals("c")) {
                result = btuToCalories(num)
            }else if(from.equals("b") && to.equals("k")) {
                result = btuToKilo(num)
            }else if(from.equals("k") && to.equals("j")) {
                result = kiloToJoules(num)
            }else if(from.equals("k") && to.equals("c")) {
                result = kiloToCalories(num)
            }else if(from.equals("k") && to.equals("b")) {
                result = kiloToBtu(num)
            }else{
                result = "Please choose valid parameters."
            }

            return result.toString()
        }catch(nfe: NumberFormatException){
            return ("Invalid Input")
        }
    }

    fun joulesToCalories(x: Int):String{
        return (x/4184.0).toString()
    }

    fun joulesToBtu(x: Int):String{
        return (x/1055.056).toString()
    }

    fun joulesToKilowatt(x: Int):String{
        return (x/0.0000002778).toString()
    }

    fun caloriesToJoules(x: Int):String{
        return (x*4184.0).toString()
    }

    fun caloriesToBtu(x: Int):String{
        return(x*3.966).toString()
    }

    fun caloriesToKilo(x: Int): String{
        return (x/860.421).toString()
    }

    fun btuToJoules(x: Int):String{
        return (x*1055.056).toString()
    }

    fun btuToCalories(x: Int): String{
        return (x/3.966).toString()
    }

    fun btuToKilo(x: Int):String{
        return (x/3412.142).toString()
    }

    fun kiloToJoules(x: Int):String {
        return (x*3600000.0).toString()
    }

    fun kiloToCalories(x: Int):String{
        return (x*860.421).toString()
    }

    fun kiloToBtu(x: Int):String{
        return (x*3412.142).toString()
    }


}

