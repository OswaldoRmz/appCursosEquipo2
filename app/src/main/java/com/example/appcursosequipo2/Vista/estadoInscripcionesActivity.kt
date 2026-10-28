package com.example.appcursosequipo2.Vista

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appcursosequipo2.Adapatdor.EstadoAdaptador
import com.example.appcursosequipo2.Modelo.dataCarreras
import com.example.appcursosequipo2.Modelo.dataEstadoCurso
import com.example.appcursosequipo2.Presentador.clsEstadoPresentador
import com.example.appcursosequipo2.R

class estadoInscripcionesActivity : AppCompatActivity() {
    private lateinit var presenter: clsEstadoPresentador
    private lateinit var spinnerCarreras: Spinner
    private lateinit var txtTotal: TextView
    private lateinit var recyclerEstado: RecyclerView
    private lateinit var btnVolverCatalogo: Button
    private lateinit var btnAtras: TextView
    private lateinit var adapterEstado: EstadoAdaptador

    private var esPrimeraCarga = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_estado_inscripciones)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        spinnerCarreras = findViewById(R.id.spnCarrerasEstado)
        txtTotal = findViewById(R.id.txtTotal)
        recyclerEstado = findViewById(R.id.rvEstado)
        btnVolverCatalogo = findViewById(R.id.btnVolverCatalogo)
        btnAtras = findViewById(R.id.btnAtras)

        recyclerEstado.layoutManager = LinearLayoutManager(this)
        adapterEstado = EstadoAdaptador(emptyList())
        recyclerEstado.adapter = adapterEstado

        presenter = clsEstadoPresentador(this)

        configurarListeners()
        presenter.iniciar()
    }

    private fun configurarListeners() {
        spinnerCarreras.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                presenter.seleccionarCarrera(position)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        btnVolverCatalogo.setOnClickListener { finish() }
        btnAtras.setOnClickListener { finish() }
    }

    fun mostrarCarreras(carreras: List<dataCarreras>) {
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, carreras)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerCarreras.adapter = adapter
    }

    fun mostrarListaEstado(lista: List<dataEstadoCurso>) {
        adapterEstado.actualizarLista(lista)
    }

    fun actualizarTotal(total: Int) {
        txtTotal.text = "Total: $total"
    }

    fun mostrarError(mensaje: String) {
        Toast.makeText(this, mensaje, Toast.LENGTH_LONG).show()
    }
}