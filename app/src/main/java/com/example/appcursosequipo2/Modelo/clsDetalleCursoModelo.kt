package com.example.appcursosequipo2.Modelo

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class clsDetalleCursoModelo {
    suspend fun obtenerDetalleCurso(cursoId: Int): dataDetalleCursos? = withContext(Dispatchers.IO) {
        try {
            // Reutilizamos obtener_cursos.php para buscar la lista
            val response = RetrofitCliente.apiService.getCursos().execute()
            if (response.isSuccessful) {
                val cursos = response.body() ?: emptyList()
                // Buscamos el curso que coincida con el ID seleccionado
                val cursoEncontrado = cursos.find { it.id == cursoId }

                if (cursoEncontrado != null) {
                    dataDetalleCursos(
                        id = cursoEncontrado.id,
                        carreraId = cursoEncontrado.carreraId,
                        nombre = cursoEncontrado.nombre,
                        descripcion = cursoEncontrado.descripcion,
                        espacio = cursoEncontrado.salon,
                        totalHoras = 80, // O asigna según tu BD
                        diasAtencion = "Lunes, Miércoles y Viernes",
                        cupoTotal = cursoEncontrado.cupo,
                        urlImagenDetalle = cursoEncontrado.urlImagenPrincipal
                    )
                } else null
            } else null
        } catch (e: Exception) {
            null
        }
    }
}