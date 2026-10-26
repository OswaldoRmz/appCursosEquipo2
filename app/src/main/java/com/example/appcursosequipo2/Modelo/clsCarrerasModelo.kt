package com.example.appcursosequipo2.Modelo

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class clsCarrerasModelo {
    suspend fun obtenerCarreras(): List<dataCarreras> = withContext(Dispatchers.IO) {
        try {
            val response = RetrofitCliente.apiService.getCarreras().execute()
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