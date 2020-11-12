package com.hellowolrd.proyectounidad1.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.hellowolrd.proyectounidad1.models.entities.Gusto
import com.hellowolrd.proyectounidad1.R
import com.hellowolrd.proyectounidad1.adapters.GustoAdapter
import com.hellowolrd.proyectounidad1.adapters.UsuarioAdapter
import com.hellowolrd.proyectounidad1.models.entities.Usuario
import com.hellowolrd.proyectounidad1.viewmodels.MainActivityViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val activityViewModel: MainActivityViewModel by viewModels()
    private var UsuarioAdapter: UsuarioAdapter?= null
    private lateinit var chkFutbol : CheckBox
    private lateinit var chkBasquet : CheckBox
    private lateinit var chkBeis : CheckBox
    private lateinit var txtNombre : TextView
    private lateinit var txtEmail : TextView
    private lateinit var txtPassword : TextView
    private lateinit var rdMasculino : RadioButton
    private lateinit var rdFemenino : RadioButton


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fabAdd = findViewById<FloatingActionButton>(R.id.fltBtnVerUsuarios)
        fabAdd.setOnClickListener {
            val intent = Intent(this, ActivityVerUsuarios::class.java)
            startActivity(intent)
        }

        val editTextNombre = findViewById<EditText>(R.id.editTextNombre)
        val editTextEmail = findViewById<EditText>(R.id.editTextTextEmailAddress)
        val editTextPassword = findViewById<EditText>(R.id.editTxtPassword)
        val floatIconButtonVerMas = findViewById<FloatingActionButton>(R.id.fltBtnVer)
        chkBasquet = findViewById(R.id.chkBasquet)
        chkFutbol = findViewById(R.id.chkFutbol)
        chkBeis = findViewById(R.id.chkBaseball)
        rdFemenino = findViewById(R.id.rdFemenino)
        rdMasculino = findViewById(R.id.rdMasculino)
        floatIconButtonVerMas.setOnClickListener(floatIconBtnClick)
        chkFutbol.setOnCheckedChangeListener(checkedChange)
        chkBasquet.setOnCheckedChangeListener(checkedChange)
        chkBeis.setOnCheckedChangeListener(checkedChange)

        activityViewModel.notfyInsertUsuario().observe(this, { succesful ->
            if (succesful) {
                Toast.makeText(this, "Guardado exitoso", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "No se pudo completar el registro", Toast.LENGTH_LONG).show()
            }
        })
    }

    private val floatIconBtnClick  = View.OnClickListener { float->
        var nombre = editTextNombre.text
        var email = editTextTextEmailAddress.text
        var password = editTxtPassword.text
        var sexoObject = ""
        if(nombre.toString() == "" || email.toString() == "" || password.toString()=="" ){
            val alertDialog = AlertDialog.Builder(float.context)
                    .setTitle("ERROR AL AGREGAR")
                    .setMessage("CAMPO VACÍO")
                    .setPositiveButton("OK", null)
                    .create()
            alertDialog.show()
            return@OnClickListener
        }

        var gustos = "\nGUSTOS"
        if(chkFutbol.isChecked){
            gustos += "\n-Futbol"
        }
        if(chkBasquet.isChecked){
            gustos += "\n-Basquetbol"
        }
        if(chkBeis.isChecked){
            gustos += "\n-Beisbol"
        }
        var sexo = "\nSEXO"
        if(rdFemenino.isChecked){
            sexo += "\nMujer"
            sexoObject="Mujer"
        }
        else{
            sexoObject="Hombre"
            sexo+="\nHombre"
        }

        val usuario = Usuario(
                nombre = nombre.toString(),
                email =  email.toString(),
                password = password.toString(),
                gustos = gustos,
                sexo = sexoObject
        )
        activityViewModel.insertUsuario(usuario)
        var texto = "NOMBRE\n"  + nombre.toString() + "\n\nEMAIL\n" + email.toString()  + "\n\nCONTRASEÑA\n" + password.toString() +  "\n" + sexo + "\n" + gustos
        val alertDialog = AlertDialog.Builder(float.context)
            .setTitle("INFORMACION DEL USUARIO")
            .setMessage(texto)
            .setPositiveButton("OK", null)
            .create()
        alertDialog.show()
    }

    fun createGustos (): List<Gusto>{
        val gustos = mutableListOf<Gusto>()
        if(chkBasquet.isChecked){
            gustos.add(
                Gusto (
                    R.drawable.ic_baloncesto,
                    "Baloncesto"
                )
            )
        }

        if(chkBeis.isChecked) {
            gustos.add(
                Gusto(
                    R.drawable.ic_bate_de_beisbol,
                    "Beisbol"
                )
            )
        }
        if(chkFutbol.isChecked) {
            gustos.add(
                Gusto(
                    R.drawable.ic_jugador_de_futbol,
                    "Futbol"
                )
            )
        }
        return gustos
    }
    private val checkedChange  = CompoundButton.OnCheckedChangeListener { button, checked ->
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val gustoAdapter = GustoAdapter(createGustos())
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.adapter = gustoAdapter
        gustoAdapter.notifyDataSetChanged()
    }


}