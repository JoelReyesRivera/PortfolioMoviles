package com.hellowolrd.randomnumbers
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NumberAdapter (val numbers: List<Int> ) : RecyclerView.Adapter<NumberAdapter.NumberHolder>(){

    class NumberHolder(val view: View) : RecyclerView.ViewHolder(view){
        fun onBind (number: Int){
            val textView = view as TextView
            textView.text = number.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NumberHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.numbers_text,parent,false)
        val numberHolder = NumberHolder(view)
        return numberHolder
    }

    override fun onBindViewHolder(holder: NumberHolder, position: Int) {
        val number = numbers[position]
        holder.onBind(number)
    }

    override fun getItemCount(): Int {
        return numbers.size
    }

}
