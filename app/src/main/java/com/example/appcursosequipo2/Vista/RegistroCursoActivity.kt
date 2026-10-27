package com.example.appcursosequipo2.Vista
import android.widget.ImageView
import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
//import com.example.appcursosequipo2.Presentador.clsRegistroCursoPresentador7
import com.example.appcursosequipo2.R
import com.google.type.Date
import java.text.SimpleDateFormat
import java.util.Locale
import java.util.Locale.getDefault

class RegistroCursoActivity : AppCompatActivity() {
    //private lateinit var presentador: clsRegistroCursoPresentador7
    private lateinit var imgMiniaturaCurso: ImageView
    private lateinit var txtNombreCurso: TextView
    private lateinit var txtCurso: TextView
    private lateinit var txtMatricula: EditText
    private lateinit var txtFecha: EditText
    private lateinit var txtCorreo: EditText
    private lateinit var btnConfirmar: Button
    private lateinit var btnCancelar: Button

    private var idCurso: Int = -1
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro_curso)

        // Vincular los elementos del XML
        txtNombreCurso = findViewById(R.id.txtNombreCurso)
        txtCurso = findViewById(R.id.txtCurso)
        txtMatricula = findViewById(R.id.txtMatricula)
        txtFecha = findViewById(R.id.txtFecha)
        txtCorreo = findViewById(R.id.txtCorreo)
        btnConfirmar = findViewById(R.id.btnConfirmar)
        btnCancelar = findViewById(R.id.btnCancelar)
        imgMiniaturaCurso = findViewById(R.id.imgCurso)
        // Crear el presentador
        //presentador = clsRegistroCursoPresentador7(this)

        // Obtener información del curso enviado desde la pantalla anterior

        // 1. Obtener datos (o usar los de prueba si el Intent viene vacío)
        idCurso = intent.getIntExtra("id_cursos", 1)
        val nombreCurso = intent.getStringExtra("nombre_curso") ?: "PROGRAMACIÓN AVANZADA"

        // Usamos la URL real que tienes en tu BD para el curso 1
        val imagenUrl = intent.getStringExtra("imagen_url") ?: "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcReS2pNaGkFc4zW9xJiRvAIOZfFn7MJWC-FR0nRLglleYSGql7vXGpo_-oH&s=10"

        // 2. Asignar los textos
        txtNombreCurso.text = "INSCRIPCIÓN: "+nombreCurso
        txtCurso.text = nombreCurso

        // 3. Cargar la imagen con Glide
        Glide.with(this)
            .load(imagenUrl)
            .centerCrop() // Asegura que la imagen llene el espacio sin deformarse
            .into(imgMiniaturaCurso)

        txtNombreCurso.text = "INSCRIPCIÓN: " + nombreCurso
        txtCurso.text = nombreCurso

        // Mostrar la fecha actual solo como referencia visual.
        // La fecha definitiva la genera PHP al registrar.
        txtFecha.setText(
            SimpleDateFormat("dd/MM/yyyy", getDefault())
                .format(java.util.Date())
        )

        // Buscar alumno cuando se termine de escribir la matrícula
        txtMatricula.setOnFocusChangeListener { _, tieneFoco ->
            if (!tieneFoco) {
                consultarAlumno()
            }
        }

        // También permite consultar al pulsar Enter en el teclado
        txtMatricula.setOnEditorActionListener { _, _, _ ->
            consultarAlumno()
            true
        }

        // Registrar inscripción
        /*btnConfirmar.setOnClickListener {
            if (idCurso <= 0) {
                mostrarMensaje(
                    "No se recibió el ID del curso. Revisa cómo abres esta pantalla."
                )
            } else {
                presentador.registrarInscripcion(
                    txtMatricula.text.toString().trim(),
                    idCurso
                )
            }
        }*/

        // Cancelar y volver a la pantalla anterior
        btnCancelar.setOnClickListener {
            finish()
        }

    }
    fun consultarAlumno() {
        val matricula = txtMatricula.text.toString().trim()

        if (matricula.isBlank()) {
            mostrarMensaje("Escribe tu matrícula antes de consultar.")
            return
        }

        //presentador.buscarAlumno(matricula)
    }
    fun mostrarDatosAlumno(
        nombre: String,
        correo: String
    ) {
        txtCorreo.setText(correo)
    }
    fun mostrarMensaje(mensaje: String) {
        Toast.makeText(this, mensaje, Toast.LENGTH_LONG).show()
    }
    fun mostrarCargando(cargando: Boolean) {
        btnConfirmar.isEnabled = !cargando
        btnCancelar.isEnabled = !cargando
    }
}