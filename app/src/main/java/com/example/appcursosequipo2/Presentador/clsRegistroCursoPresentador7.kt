/*package com.example.appcursosequipo2.Presentador

import com.example.appcursosequipo2.Modelo.RetrofitCliente
import com.example.appcursosequipo2.Modelo.dataInscripcion
import com.example.appcursosequipo2.Vista.RegistroCursoActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class clsRegistroCursoPresentador7(private val vista: RegistroCursoActivity) {
    // Buscar alumno por matrícula
    fun buscarAlumno(matriculaTexto: String) {
        val matriculaLimpia = matriculaTexto.trim()
        val matricula = matriculaLimpia.toIntOrNull()

        if (matricula == null || matricula <= 0) {
            vista.mostrarMensaje(
                "Matrícula recibida: '$matriculaLimpia'. Ingresa solo números."
            )
            return
        }

        CoroutineScope(Dispatchers.Main).launch {
            vista.mostrarCargando(true)

            try {
                val respuesta = withContext(Dispatchers.IO) {
                    RetrofitCliente.apiService.ge(matricula)
                }

                if (respuesta.ok && respuesta.alumno != null) {
                    vista.mostrarDatosAlumno(
                        respuesta.alumno.nombre,
                        respuesta.alumno.correo
                    )
                } else {
                    vista.mostrarMensaje(
                        respuesta.mensaje ?: "No se encontró el alumno."
                    )
                }

            } catch (e: Exception) {
                android.util.Log.e(
                    "ERROR_ALUMNO",
                    "Error al consultar alumno",
                    e
                )

                vista.mostrarMensaje(
                    "Error: ${e.javaClass.simpleName}: ${e.message}"
                )
            } finally {
                vista.mostrarCargando(false)
            }
        }
    }

    // Registrar inscripción
    fun registrarInscripcion(
        matriculaTexto: String,
        idCurso: Int
    ) {
        val matricula = matriculaTexto.toIntOrNull()

        if (matricula == null || matricula <= 0) {
            vista.mostrarMensaje("Ingresa una matrícula válida.")
            return
        }

        if (idCurso <= 0) {
            vista.mostrarMensaje("No se recibió un curso válido.")
            return
        }

        CoroutineScope(Dispatchers.Main).launch {
            vista.mostrarCargando(true)

            try {
                val respuesta = withContext(Dispatchers.IO) {
                    RetrofitCliente.apiService.registrarInscripcion(
                        dataInscripcion(
                            matricula = matricula,
                            id_cursos = idCurso
                        )
                    )
                }

                if (respuesta.ok) {
                    vista.mostrarMensaje(
                        "${respuesta.mensaje ?: "Inscripción exitosa."}" +
                                (respuesta.fecha?.let { "\nFecha: $it" } ?: "")
                    )
                } else {
                    vista.mostrarMensaje(
                        respuesta.mensaje ?: "No se pudo registrar la inscripción."
                    )
                }

            } catch (e: retrofit2.HttpException) {
                val mensaje = when (e.code()) {
                    404 -> "No existe el alumno o el curso."
                    409 -> "El alumno ya está inscrito o el curso no tiene cupo."
                    else -> "Error del servidor: ${e.code()}."
                }

                vista.mostrarMensaje(mensaje)

            } catch (e: Exception) {
                vista.mostrarMensaje(
                    "No se pudo registrar. Verifica la conexión con el servidor."
                )
            } finally {
                vista.mostrarCargando(false)
            }
        }
    }
}*/