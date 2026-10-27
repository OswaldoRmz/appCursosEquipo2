package com.example.appcursosequipo2.Presentador

import com.example.appcursosequipo2.Modelo.clsRegistroModelo
import com.example.appcursosequipo2.Vista.RegistroCursoActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class clsRegistroPresentador(private val vista: RegistroCursoActivity) {
    private val modelo = clsRegistroModelo()

    fun buscarAlumno(matriculaTexto: String) {
        val matriculaInt = matriculaTexto.toIntOrNull()
        if (matriculaInt == null || matriculaInt <= 0) {
            vista.mostrarCorreo("")
            return
        }

        CoroutineScope(Dispatchers.Main).launch {
            val respuesta = modelo.buscarAlumno(matriculaInt)
            if (respuesta.ok && respuesta.alumno != null) {
                vista.mostrarCorreo(respuesta.alumno.correo ?: "Sin correo registrado")
            } else {
                vista.mostrarCorreo("")
                vista.mostrarError(respuesta.mensaje ?: "Alumno no encontrado")
            }
        }
    }

    fun registrar(cursoId: Int, matriculaTexto: String) {
        if (cursoId <= 0) {
            vista.mostrarError("Curso no seleccionado correctamente")
            return
        }

        val matriculaInt = matriculaTexto.toIntOrNull()
        if (matriculaInt == null || matriculaInt <= 0) {
            vista.mostrarError("Ingrese una matrícula válida")
            return
        }

        vista.mostrarCargando(true)
        CoroutineScope(Dispatchers.Main).launch {
            try {
                val respuesta = modelo.registrarInscripcion(cursoId, matriculaInt)
                if (respuesta.ok) {
                    vista.registroExitoso(respuesta.mensaje)
                } else {
                    vista.mostrarError(respuesta.mensaje)
                }
            } catch (e: Exception) {
                vista.mostrarError("Error al registrar: " + e.localizedMessage)
            } finally {
                vista.mostrarCargando(false)
            }
        }
    }
}