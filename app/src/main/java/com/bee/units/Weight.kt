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
                5 -> from = "s"
            }

        }else if(parent.getId()==(R.id.toSpinner)){
            parent.getItemAtPosition(pos)
            when (pos) {
                0 -> to = "o"
                1 -> to = "p"
                2 -> to = "g"
                3 -> to = "k"
                4 -> to = "n"
                5 -> to = "s"
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
        fun newInstance(): Weight {
            return Weight()
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
            }else if(from.equals("o") && to.equals("s")){
                result = ouncesToStones(num)
            }else if(from.equals("p")  && to.equals("o")){
                result = poundsToOunces(num)
            }else if(from.equals("p") && to.equals("g")){
                result = poundsToGrams(num)
            }else if(from.equals("p") && to.equals("k")){
                result = poundsToKilos(num)
            }else if(from.equals("p") && to.equals("n")){
                result = poundsToNewtons(num)
            }else if(from.equals("p") && to.equals("s")){
                result = poundsToStones(num)
            }else if(from.equals("g") && to.equals("o")){
                result = gramsToOunces(num)
            }else if(from.equals("g") && to.equals("p")){
                result = gramsToPounds(num)
            }else if(from.equals("g") && to.equals("k")){
                result = gramsToKilos(num)
            }else if(from.equals("g") && to.equals("n")){
                result = gramsToNewtons(num)
            }else if(from.equals("g") && to.equals("s")){
                result = gramsToStones(num)
            }else if(from.equals("k") && to.equals("o")){
                result = kilosToOunces(num)
            }else if(from.equals("k") && to.equals("p")){
                result = kilosToPounds(num)
            }else if(from.equals("k") && to.equals("g")){
                result = kilosToGrams(num)
            }else if(from.equals("k") && to.equals("n")){
                result = kilosToNewtons(num)
            }else if(from.equals("k") && to.equals("s")){
                result = kilosToStones(num)
            }else if(from.equals("n") && to.equals("o")){
                result = newtonsToOunces(num)
            }else if(from.equals("n") && to.equals("p")){
                result = newtonsToPounds(num)
            }else if(from.equals("n") && to.equals("g")){
                result = newtonsToGrams(num)
            }else if(from.equals("n") && to.equals("k")){
                result = newtonsToKilos(num)
            }else if(from.equals("n") && to.equals("s")){
                result = newtonsToStones(num)
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
        var weight: Double = num * 28.3495
        result = weight.toString()
        return result
    }

    fun ouncesToKilos(num: Int):String{
        var result=""
        var weight: Double = (num /35.274)
        result = weight.toString()
        return result
    }

    fun ouncesToNewtons(num: Int): String{
        var result=""
        var weight: Double = (num /35.274) * 9.807
        result = weight.toString()
        return result
    }
    
    fun ouncesToStones(num: Int):String{
        var weight: Double = (num/224.0)
        return weight.toString()
    }
        
    fun poundsToOunces(num: Int): String{
        var result=""
        var weight: Double = num/16.0
        result = weight.toString()
        return result
    }

    fun poundsToGrams(num: Int): String{
        var result=""
        var weight:Double = num * 453.592
        result = weight.toString()
        return result
    }

    fun poundsToKilos(num: Int): String{
        var result=""
        var weight: Double = num / 2.205
        result = weight.toString()
        return result
    }

    fun poundsToNewtons(num: Int): String{
        var result=""
        var weight: Double = (num / 2.205) * 9.807
        result = weight.toString()
        return result
    }
    
    fun poundsToStones(num: Int):String{
        var weight: Double = (num/14.0)
        return weight.toString()
    }

    fun gramsToOunces(num: Int): String{
        var result=""
        var weight: Double = num / 28.35
        result = weight.toString()
        return result
    }

    fun gramsToPounds(num: Int): String{
        var result=""
        var weight: Double = num /453.592
        result = weight.toString()
        return result
    }

    fun gramsToKilos(num: Int): String{
        var result=""
        var weight: Double = num / 1000.0
        result = weight.toString()
        return result
    }

    fun gramsToNewtons(num: Int): String{
        var result=""
        var weight: Double = (num/1000)* 9.807
        result = weight.toString()
        return result
    }
    
    fun gramsToStones(num: Int):String{
        var weight: Double = (num/ 6350.293)
        return weight.toString()
    }

    fun kilosToOunces(num: Int): String{
        var result=""
        var weight: Double = num * 35.274
        result = weight.toString()
        return result
    }

    fun kilosToPounds(num: Int): String{
        var result=""
        var weight: Double = num *  2.205
        result = weight.toString()
        return result
    }

    fun kilosToGrams(num: Int): String{
        var result=""
        var weight: Double = num * 1000.0
        result = weight.toString()
        return result
    }

    fun kilosToNewtons(num: Int): String{
        var result=""
        var weight: Double = num * 9.807
        result = weight.toString()
        return result
    }
    
    fun kilosToStones(num: Int):String{
        var weight:Double = (num/6.35)
        return weight.toString()
    }

    fun newtonsToOunces(num: Int): String{
        var result=""
        var weight: Double = (num/9.807) * 35.274
        result = weight.toString()
        return result
    }

    fun newtonsToPounds(num: Int): String{
        var result=""
        var weight: Double = (num/9.807) * 2.205
        result = weight.toString()
        return result
    }

    fun newtonsToGrams(num: Int): String{
        var result=""
        var weight: Double = (num /9.807) * 1000
        result = weight.toString()
        return result
    }

    fun newtonsToKilos(num: Int): String{
        var result=""
        var weight: Double = num /9.807
        result = weight.toString()
        return result
    }
    
    fun newtonsToStones(num: Int):String{
        var weight:Double = (num/9.807)/6.35
        return weight.toString()
    }
}
