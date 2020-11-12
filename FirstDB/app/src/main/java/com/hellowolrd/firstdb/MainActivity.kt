package com.hellowolrd.firstdb

import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    lateinit var db : SQLiteDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnAddConctact = findViewById<FloatingActionButton>(R.id.btnAddContact)
        recyclerView = findViewById(R.id.recyclerContacts)

        btnAddConctact.setOnClickListener {
            val intent = Intent(this, AddConctact::class.java)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        val contactDBHelper = DBHelper(this)
        db = contactDBHelper.readableDatabase
        val cursor = db.query(TABLE_NAME_CONTACT, null, null, null, null, null, null)
        val contacts = mutableListOf<ContactData>()
        cursor.use{
            while (cursor.moveToNext()){
                val nombre = cursor.getString(cursor.getColumnIndex(COLUMN_NAME))
                val apellido = cursor.getString(cursor.getColumnIndex(COLUMN_LASTNAME))
                val edad = cursor.getInt(cursor.getColumnIndex(COLUMN_AGE))
                contacts.add(ContactData(nombre, apellido,edad))
            }
        }
        recyclerView.layoutManager = LinearLayoutManager(this)
        val contactAdapter = ContactAdapter(contacts)
        recyclerView.adapter = contactAdapter
    }
}