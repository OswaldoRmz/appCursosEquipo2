package com.example.appcursosequipo2.Vista
import android.widget.ImageView
import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.os.Bundle
import android.view.KeyEvent
import android.view.inputmethod.EditorInfo
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.appcursosequipo2.Presentador.clsRegistroPresentador
//import com.example.appcursosequipo2.Presentador.clsRegistroCursoPresentador7
import com.example.appcursosequipo2.R
import com.google.type.Date
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale
import java.util.Locale.getDefault

class RegistroCursoActivity : AppCompatActivity() {

    private lateinit var presenter: clsRegistroPresentador
    private lateinit var txtCurso: TextView
    private lateinit var imgCurso: ImageView
    private lateinit var etMatricula: EditText
    private lateinit var etFecha: EditText
    private lateinit var etCorreo: EditText
    private lateinit var btnConfirmar: Button
    private lateinit var btnCancelar: Button
    private lateinit var btnAtras: TextView

    private var cursoId = 0
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro_curso)

        txtCurso = findViewById(R.id.txtCursoRegistro)
        imgCurso = findViewById(R.id.imgCursoRegistro)
        etMatricula = findViewById(R.id.etMatricula)
        etFecha = findViewById(R.id.etFecha)
        etCorreo = findViewById(R.id.etCorreo)
        btnConfirmar = findViewById(R.id.btnConfirmar)
        btnCancelar = findViewById(R.id.btnCancelar)
        btnAtras = findViewById(R.id.btnAtras)

        etMatricula.setOnEditorActionListener(this::buscardatos)
        cursoId = intent.getIntExtra("CURSO_ID", 0)
        txtCurso.text = (intent.getStringExtra("NOMBRE_CURSO") ?: "").uppercase()
        val urlImagen = intent.getStringExtra("URL_IMAGEN") ?: ""

        if (urlImagen.isNotEmpty()) {
            Glide.with(this)
                .load(urlImagen)
                .placeholder(android.R.drawable.ic_menu_gallery)
                .error(android.R.drawable.stat_notify_error)
                .into(imgCurso)
        }

        presenter = clsRegistroPresentador(this)

        // Configuración de la Fecha actual visual
        establecerFecha(Calendar.getInstance())
        etFecha.setOnClickListener { mostrarCalendario() }

        btnConfirmar.setOnClickListener { presenter.registrar(cursoId, etMatricula.text.toString().trim()) }

        btnCancelar.setOnClickListener { finish() }

    }
    private fun establecerFecha(cal: Calendar) {
        val formatoVisible = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
        etFecha.setText(formatoVisible.format(cal.time))
    }
    fun buscardatos(v: TextView?, actionId: Int, event: KeyEvent?): Boolean {
        if (actionId == EditorInfo.IME_ACTION_DONE) {
            presenter.buscarAlumno(etMatricula.text.toString().trim())
        }
        return false
    }
    private fun mostrarCalendario() {
        val cal = Calendar.getInstance()
        DatePickerDialog(
            this,
            { _, anio, mes, dia ->
                cal.set(anio, mes, dia)
                establecerFecha(cal)
            },
            cal.get(Calendar.YEAR),
            cal.get(Calendar.MONTH),
            cal.get(Calendar.DAY_OF_MONTH)
        ).show()
    }

    fun mostrarCorreo(correo: String) {
        etCorreo.setText(correo)
    }

    fun mostrarCargando(cargando: Boolean) {
        btnConfirmar.isEnabled = !cargando
        btnConfirmar.text = if (cargando) "ENVIANDO..." else "CONFIRMAR INSCRIPCIÓN"
    }

    fun registroExitoso(mensaje: String) {
        Toast.makeText(this, mensaje, Toast.LENGTH_LONG).show()
        finish()
    }

    fun mostrarError(mensaje: String) {
        Toast.makeText(this, mensaje, Toast.LENGTH_LONG).show()
    }
}