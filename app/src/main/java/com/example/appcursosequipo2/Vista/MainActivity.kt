package com.example.appcursosequipo2.Vista

import android.os.Bundle
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appcursosequipo2.Adapatdor.CursosAdaptador
import com.example.appcursosequipo2.Modelo.dataCursos
import com.example.appcursosequipo2.Presentador.clsCursosPresentador
import com.example.appcursosequipo2.R

class MainActivity : AppCompatActivity() {
    private lateinit var presenter: clsCursosPresentador
    private lateinit var spinnerCarreras: Spinner
    private lateinit var recyclerCursos: RecyclerView
    private lateinit var adapterCursos: CursosAdaptador

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Conexión con los ID AL XML
        spinnerCarreras = findViewById(R.id.snpCarreras)
        recyclerCursos = findViewById(R.id.recyclerCursos)

        // Configuración del RecyclerView
        recyclerCursos.layoutManager = LinearLayoutManager(this)
        adapterCursos = CursosAdaptador(this, emptyList())
        recyclerCursos.adapter = adapterCursos

        // Inicialización del Presentador
        presenter = clsCursosPresentador(this)
        presenter.cargarCursos(1)
    }

    fun mostrarCursos(cursos: List<dataCursos>) {
        adapterCursos.actualizarLista(cursos)
    }

    fun mostrarError(mensaje: String) {
        Toast.makeText(this, mensaje, Toast.LENGTH_LONG).show()
    }
}