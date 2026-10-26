package com.example.appcursosequipo2.Modelo

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class clsCursosModelo {
    suspend fun obtenerCursosPorCarrera(carreraId: Int): List<dataCursos> = withContext(Dispatchers.IO) {
        try {
            // Si carreraId es 0 pasa null para traer todos los cursos sin filtrar
            val idParam = if (carreraId > 0) carreraId else null
            val response = RetrofitCliente.apiService.getCursos(idParam).execute()

            if (response.isSuccessful) {
                response.body() ?: emptyList()
            } else {
                emptyList()
            }
        } catch (e: Exception) {
            emptyList()
        }
    }
}