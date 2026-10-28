package com.example.appcursosequipo2.Modelo

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class clsRegistroModelo {
    suspend fun buscarAlumno(matricula: Int): dataBuscarAlumno = withContext(Dispatchers.IO) {
    try {
        val response = RetrofitCliente.apiService.buscarAlumnoByMatricula(matricula).execute()
        if (response.isSuccessful) {
            response.body() ?: dataBuscarAlumno(ok = false, mensaje = "Sin datos de respuesta")
        } else {
            dataBuscarAlumno(ok = false, mensaje = "Alumno no encontrado")
        }
    } catch (e: Exception) {
        dataBuscarAlumno(ok = false, mensaje = "Error de conexión: ${e.localizedMessage}")
    }
}

    suspend fun registrarInscripcion(cursoId: Int, matricula: Int): RegistroResponse = withContext(Dispatchers.IO) {
        try {
            val request = RegistroRequest(matricula = matricula, idCurso = cursoId)
            val response = RetrofitCliente.apiService.registrarInscripcion(request).execute()
            if (response.isSuccessful) {
                response.body() ?: RegistroResponse(ok = false, mensaje = "Sin respuesta del servidor")
            } else {
                RegistroResponse(ok = false, mensaje = "No se pudo registrar la inscripción")
            }
        } catch (e: Exception) {
            RegistroResponse(ok = false, mensaje = "Error de red: ${e.localizedMessage}")
        }
    }
}