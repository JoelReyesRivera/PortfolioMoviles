package com.hellowolrd.readassets

import android.app.Activity
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.io.BufferedReader

class MainActivity : AppCompatActivity() {
    private lateinit var textViewLastContent: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        textViewLastContent = findViewById(R.id.txtViewUltimoTexto)

        val contents = readContents()

        val contentAdapter = ContentAdapter(clickListener)

        val recyclerAssets = findViewById<RecyclerView>(R.id.recycler_assets)
        recyclerAssets.adapter = contentAdapter
        recyclerAssets.layoutManager = LinearLayoutManager(this)

        contents?.apply {
            contentAdapter.setData(contents)
            val sharePrefereces = getSharedPreferences(DEFAULT_SHARED_PREFERENCES, Activity.MODE_PRIVATE)
            val texto =  sharePrefereces.getString(LAST_TEXT,this[0])
            textViewLastContent.text = texto
        }
    }

    override fun onPause() {
        super.onPause()
        val sharedPreferences = getSharedPreferences(DEFAULT_SHARED_PREFERENCES, Activity.MODE_PRIVATE)
        var editor = sharedPreferences.edit()
        editor.putString("lastText",textViewLastContent.text.toString())
            .apply()
    }
    private val clickListener = View.OnClickListener { view ->
        val textView = view as TextView
        textViewLastContent.text = textView.text
        //Toast.makeText(this,textView.text, Toast.LENGTH_SHORT).show()
    }
    private fun readContents() = assets.list("contents")?.map{ file ->
            assets.open("contents/$file").bufferedReader().use(BufferedReader::readText)
        }?.toList()
}