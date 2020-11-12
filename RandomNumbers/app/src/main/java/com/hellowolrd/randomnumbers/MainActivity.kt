package com.hellowolrd.randomnumbers

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val numbers = createRandomNumbers()
        val adapter = NumberAdapter(numbers)
        val recyclerView = findViewById<RecyclerView>(R.id.recycleNumbers)
        recyclerView.layoutManager= LinearLayoutManager(this)
        recyclerView.adapter = adapter
        adapter.notifyDataSetChanged()
    }
    fun createRandomNumbers () : List<Int>{
        var randomNumbers = mutableListOf<Int>()
        val size = Random.nextInt(100,5000)
        var i = 0
        while(i < size){
            var n = Random.nextInt()
            randomNumbers.add(n)
            i+=1
        }
        return randomNumbers
    }
}