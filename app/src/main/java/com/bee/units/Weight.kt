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
import kotlinx.android.synthetic.main.hextodec.*

class Weight: Fragment(), View.OnClickListener, AdapterView.OnItemSelectedListener {

    var from:String=""
    var to:String =""
    var entry: String = ""

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
                0 -> from = "o"
                1 -> from = "p"
                2 -> from = "g"
                3 -> from = "k"
                4 -> from = "n"
            }

        }else if(parent.getId()==(R.id.toSpinner)){
            parent.getItemAtPosition(pos)
            when (pos) {
                0 -> to = "o"
                1 -> to = "p"
                2 -> to = "g"
                3 -> to = "k"
                4 -> to = "n"
            }
        }

    }

    override fun onNothingSelected(parent: AdapterView<*>) {
        if(parent.getId()==R.id.fromSpinner) {
            from = "o"
        }else{
            to ="p"
        }
    }

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
        val view: View=  inflater.inflate(R.layout.weight, container, false)
        val button: Button = view.findViewById(R.id.abutton)
        button.setOnClickListener(this)

        val fromSpinner: Spinner = view.findViewById(R.id.fromSpinner)
        // Create an ArrayAdapter using the string array and a default spinner layout
        fromSpinner.adapter = ArrayAdapter(
            activity,
            R.layout.spinner_item,
            resources.getStringArray(R.array.weight_array)
        )
        val toSpinner: Spinner = view.findViewById(R.id.toSpinner)
        toSpinner.adapter = ArrayAdapter(
            activity,
            R.layout.spinner_item,
            resources.getStringArray(R.array.weight_array)
        )
        fromSpinner.onItemSelectedListener= this
        toSpinner.onItemSelectedListener = this

        return view
    }

    fun convert(x: String):String{
        try {
            var num = Integer.parseInt(x)
            var result=""
            if (from.equals("o") && to.equals("p")) {
                result = ouncesToPounds(num)
            }else if(from.equals("o")  && to.equals("g")){
                result = ouncesToGrams(num)
            }else if(from.equals("o") && to.equals("k")){
                result = ouncesToKilos(num)
            }else if(from.equals("o") && to.equals("n")){
                result = ouncesToNewtons(num)
            }else if(from.equals("p")  && to.equals("o")){
                result = poundsToOunces(num)
            }else if(from.equals("p") && to.equals("g")){
                result = poundsToGrams(num)
            }else if(from.equals("p") && to.equals("k")){
                result = poundsToKilos(num)
            }else if(from.equals("p") && to.equals("n")){
                result = poundsToNewtons(num)
            }else if(from.equals("g") && to.equals("o")){
                result = gramsToOunces(num)
            }else if(from.equals("g") && to.equals("p")){
                result = gramsToPounds(num)
            }else if(from.equals("g") && to.equals("k")){
                result = gramsToKilos(num)
            }else if(from.equals("g") && to.equals("n")){
                result = gramsToNewtons(num)
            }else if(from.equals("k") && to.equals("o")){
                result = kilosToOunces(num)
            }else if(from.equals("k") && to.equals("p")){
                result = kilosToPounds(num)
            }else if(from.equals("k") && to.equals("g")){
                result = kilosToGrams(num)
            }else if(from.equals("k") && to.equals("n")){
                result = kilosToNewtons(num)
            }else if(from.equals("n") && to.equals("o")){
                result = newtonsToOunces(num)
            }else if(from.equals("n") && to.equals("p")){
                result = newtonsToPounds(num)
            }else if(from.equals("n") && to.equals("g")){
                result = newtonsToGrams(num)
            }else if(from.equals("n") && to.equals("k")){
                result = newtonsToKilos(num)
            }else{
                result = "Please choose valid parameters."
            }


            return result.toString()
        }catch(nfe: NumberFormatException){
            return ("Invalid Input")
        }
    }

    fun ouncesToPounds(num:Int):String{
      var result =""
        var weight:Double = num /16.0
        result = weight.toString()
        return result
    }

    fun ouncesToGrams(num: Int): String{
        var result =""

        return result
    }

    fun ouncesToKilos(num: Int):String{
        var result=""

        return result
    }

    fun ouncesToNewtons(num: Int): String{
        var result=""

        return result
    }

    fun poundsToOunces(num: Int): String{
        var result=""

        return result
    }

    fun poundsToGrams(num: Int): String{
        var result=""

        return result
    }

    fun poundsToKilos(num: Int): String{
        var result=""

        return result
    }

    fun poundsToNewtons(num: Int): String{
        var result=""

        return result
    }

    fun gramsToOunces(num: Int): String{
        var result=""

        return result
    }

    fun gramsToPounds(num: Int): String{
        var result=""

        return result
    }

    fun gramsToKilos(num: Int): String{
        var result=""

        return result
    }

    fun gramsToNewtons(num: Int): String{
        var result=""

        return result
    }

    fun kilosToOunces(num: Int): String{
        var result=""

        return result
    }

    fun kilosToPounds(num: Int): String{
        var result=""

        return result
    }

    fun kilosToGrams(num: Int): String{
        var result=""

        return result
    }

    fun kilosToNewtons(num: Int): String{
        var result=""

        return result
    }

    fun newtonsToOunces(num: Int): String{
        var result=""

        return result
    }

    fun newtonsToPounds(num: Int): String{
        var result=""

        return result
    }

    fun newtonsToGrams(num: Int): String{
        var result=""

        return result
    }

    fun newtonsToKilos(num: Int): String{
        var result=""

        return result
    }
}