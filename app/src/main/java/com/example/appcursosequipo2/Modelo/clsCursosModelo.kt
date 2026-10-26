package com.example.appcursosequipo2.Modelo

class clsCursosModelo {

    // Función suspendida para obtener la lista de cursos desde la API 🌐
    suspend fun obtenerCursos(idCarrera: Int): List<dataCursos> {
        return RetrofitCliente.apiService.obtenerCursos(idCarrera)
    }
}