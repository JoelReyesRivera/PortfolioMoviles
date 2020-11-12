package com.hellowolrd.firstdb

import android.content.ContentValues
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.button.MaterialButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText

class AddConctact : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_conctact)

        val contactDBHelper = DBHelper(this)
        val inputName = findViewById<TextInputEditText>(R.id.inputNombre)
        val inputApellido = findViewById<TextInputEditText>(R.id.inputApellido)
        val inputEdad = findViewById<TextInputEditText>(R.id.inputEdad)

        val btnGuardar = findViewById<MaterialButton>(R.id.btnGuardar)
        btnGuardar.setOnClickListener{view ->
            val db = contactDBHelper.writableDatabase
            val contentValues = ContentValues()
            contentValues.put(COLUMN_NAME,inputName.text.toString())
            contentValues.put(COLUMN_LASTNAME,inputApellido.text.toString())
            contentValues.put(COLUMN_AGE,inputEdad.text.toString().toInt())

            db.use{
                db.insert(TABLE_NAME_CONTACT,null, contentValues )
            }
            val snackbar = Snackbar.make(view.rootView, "Contacto Guardado", Snackbar.LENGTH_SHORT)
            snackbar.show()
        }
    }
}