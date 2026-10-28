package com.example.appcursosequipo2.Vista

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.appcursosequipo2.R
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appcursosequipo2.Adapatdor.CursosAdaptador
import com.example.appcursosequipo2.Modelo.dataCarreras
import com.example.appcursosequipo2.Modelo.dataCursos
import com.example.appcursosequipo2.Modelo.dataDetalleCursos
import com.example.appcursosequipo2.Presentador.clsCatalogoPresentador

class MainActivity : AppCompatActivity() {
    private lateinit var presenter: clsCatalogoPresentador
    private lateinit var spinnerCarreras: Spinner
    private lateinit var recyclerCursos: RecyclerView
    private lateinit var btnVerRegistros: Button
    private lateinit var adapterCursos: CursosAdaptador
    private var esPrimeraCarga = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        spinnerCarreras = findViewById(R.id.spnCarreras)
        recyclerCursos = findViewById(R.id.rvCursos)
        btnVerRegistros = findViewById(R.id.btnVerRegistros)

        // Catálogo en 2 columnas
        recyclerCursos.layoutManager = GridLayoutManager(this, 2)
        adapterCursos = CursosAdaptador(this, emptyList())
        recyclerCursos.adapter = adapterCursos

        presenter = clsCatalogoPresentador(this)
        configurarListeners()
        presenter.iniciar()
    }
    // Evento de selección en el Spinner de Carreras
    private fun configurarListeners() {
        spinnerCarreras.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                // Ignoramos la primera selección automática del sistema
                if (esPrimeraCarga) {
                    esPrimeraCarga = false
                    return
                }

                // Llamada segura al presenter
                try {
                    presenter.seleccionarCarrera(position)
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        btnVerRegistros.setOnClickListener {
            startActivity(Intent(this, estadoInscripcionesActivity::class.java))
        }
    }

    fun mostrarCarreras(carreras: List<dataCarreras>) {
        // Extraemos solo el nombre de cada carrera para mostrar en el Spinner
        val nombresCarreras = carreras.map { it.carrera } // Cambia "nombre" por el campo real de tu data class

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, nombresCarreras)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerCarreras.adapter = adapter
    }
    // Actualiza el listado de cursos en el RecyclerView.


    fun mostrarCursos(cursos: List<dataCursos>) {
        if (cursos != null) {
            adapterCursos.actualizarLista(cursos)
        } else {
            mostrarError("No se pudieron cargar los cursos.")
        }
    }

    // Los llama el adaptador desde los botones de cada tarjeta
    fun seleccionarCurso(curso: dataCursos) {
        presenter.seleccionarCurso(curso)
    }

    fun registrarseCurso(curso: dataCursos) {
        presenter.registrarseCurso(curso)
    }

    fun abrirDetalleCurso(id: Int) {
        val intent = Intent(this, detalleCursoActivity::class.java)
        intent.putExtra("CURSO_ID", id)
        startActivity(intent)
    }
    //formulario de registro para el curso seleccionado
    fun abrirRegistro(id: Int, nombre: String, urlImagen: String) {
        val intent = Intent(this, RegistroCursoActivity::class.java)
        intent.putExtra("CURSO_ID", id)
        intent.putExtra("NOMBRE_CURSO", nombre)
        intent.putExtra("URL_IMAGEN", urlImagen)
        startActivity(intent)
    }

    fun mostrarError(mensaje: String) {
        Toast.makeText(this, mensaje, Toast.LENGTH_LONG).show()
    }
}