package com.hellowolrd.forms

import android.app.DatePickerDialog
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.SwitchCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.text.DateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var checkElectronica : CheckBox
    private lateinit var checkHouse : CheckBox
    private lateinit var checkRock : CheckBox
    private lateinit var txtMusic : TextView
    private lateinit var radio1 : RadioButton
    private lateinit var radio2 : RadioButton
    private lateinit var radio3 : RadioButton
    private lateinit var txtRadio : TextView
    private lateinit var btnToast : Button



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val switch = findViewById<Switch>(R.id.Habilitar)

        val text = findViewById<TextView>(R.id.txtHabilitar)
        switch.setOnCheckedChangeListener{button, checked->
            if (checked)
                text.text = "Habilitado"
            else
                text.text = "Inhabilitado"
        }
        checkElectronica = findViewById(R.id.chkElectronica)
        checkHouse = findViewById(R.id.chkHouse)
        checkRock = findViewById(R.id.chkRock)
        txtMusic = findViewById(R.id.txtMusica)
        txtRadio = findViewById(R.id.txtRadio)

        radio1 = findViewById(R.id.rdRadio1)
        radio2 = findViewById(R.id.rdRadio2)
        radio3 = findViewById(R.id.rdRadio3)

        btnToast = findViewById(R.id.btnToast)


        checkElectronica.setOnCheckedChangeListener(checkedChange)
        checkRock.setOnCheckedChangeListener(checkedChange)
        checkHouse.setOnCheckedChangeListener(checkedChange)

        radio1.setOnCheckedChangeListener(radioChecked)
        radio2.setOnCheckedChangeListener(radioChecked)
        radio3.setOnCheckedChangeListener(radioChecked)

        btnToast.setOnClickListener(clickToast)
        val fabIconButton = findViewById<FloatingActionButton>(R.id.floatingActionButton)
        fabIconButton.setOnClickListener(fabClick)
        val floatIconButtonCalendar = findViewById<FloatingActionButton>(R.id.floatingBtnCalendar)
        floatIconButtonCalendar.setOnClickListener(fabCalendar)

    }

   private val checkedChange  = CompoundButton.OnCheckedChangeListener { button, checked ->
        var text = ""

        if (checkElectronica.isChecked) {
            text += "Electronica\n"
        }
        if (checkHouse.isChecked) {
            text += "House\n"
        }
        if (checkRock.isChecked){
            text += "Rock\n"
        }
        txtMusic.text = text
    }


    private val clickToast  = View.OnClickListener { view->
        Toast.makeText(view.context,"Toast Ejemplo",Toast.LENGTH_LONG).show()
    }

    private val fabClick  = View.OnClickListener { fab->
        val alertDialog = AlertDialog.Builder(fab.context)
            .setTitle("Alert dialog")
            .setMessage("Mensaje Ejemplo")
            .setPositiveButton("Yes",
            { view, p1 -> Toast.makeText(fab.context,"OK",Toast.LENGTH_LONG).show() })
            .setNegativeButton("No",
            {view, p1 -> Toast.makeText(fab.context,"NO",Toast.LENGTH_LONG).show()})
            .create()
        alertDialog.show()
    }

    private val fabCalendar  = View.OnClickListener { fab->
        var calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val day = calendar.get(Calendar.DAY_OF_MONTH)
        val month = calendar.get(Calendar.MONTH)
        val dayPickerDialog = DatePickerDialog(fab.context, {datePicker, year,month,dayOfMonth ->
            val dateFormat = DateFormat.getDateInstance(DateFormat.SHORT)
            val cal = Calendar.getInstance()
            cal.set(year,month,dayOfMonth)
            val date = cal.time
            val dateString = dateFormat.format(date)
            Toast.makeText(datePicker.context,dateString,Toast.LENGTH_LONG).show()
        }, year, month, day)
        dayPickerDialog.datePicker.minDate = calendar.timeInMillis
        calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH)+3)
        dayPickerDialog.datePicker.maxDate = calendar.timeInMillis
        dayPickerDialog.show()
    }

    private val radioChecked  = CompoundButton.OnCheckedChangeListener { button, checked ->
        var texto = ""
        if (radio1.isChecked){
            texto += "Radio 1 esta activo"
        }
        else if(radio2.isChecked){
            texto += "Radio 2 esta activo"
        }
        else if(radio3.isChecked){
            texto += "Radio 3 esta activo"
        }
        txtRadio.text = texto
    }
}