package com.hellowolrd.firstdbroom.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hellowolrd.firstdbroom.R
import com.hellowolrd.firstdbroom.adapters.ContentAdapter
import com.hellowolrd.firstdbroom.models.roomdb.ContentDB

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerContacts)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val contentDB = ContentDB.getInstance(this)
        val contentDao = contentDB.contentDao()
        val contents = contentDao.getAllContent()

        val contentAdapter = ContentAdapter(contents)

        recyclerView.adapter = contentAdapter

        contentAdapter.notifyDataSetChanged()
    }
}