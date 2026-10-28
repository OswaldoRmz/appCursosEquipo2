package com.example.appcursosequipo2.Modelo

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class clsEstadoModelo {

    suspend fun obtenerEstadoInscripciones(carreraId: Int): List<dataEstadoCurso> = withContext(Dispatchers.IO) {
        try {
            val response = RetrofitCliente.apiService.getCursos(carreraId).execute()

            if (response.isSuccessful) {
                val cursos = response.body() ?: emptyList()

                cursos.map { curso ->
                    dataEstadoCurso(
                        idCurso = curso.id,
                        nombreCurso = curso.nombre,
                        imagenUrl = curso.urlImagenPrincipal,
                        inscritos = curso.inscritosRow, // Asigna el recuento real proveniente de la BD
                        cupoTotal = curso.cupo,
                        carreraId = curso.carreraId
                    )
                }
            } else {
                emptyList()
            }
        } catch (e: Exception) {
            emptyList()
        }
    }
}