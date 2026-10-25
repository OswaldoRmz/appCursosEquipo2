package com.example.appcursosequipo2.interfaceAPI

import com.example.appcursosequipo2.Modelo.dataCarreras
import com.example.appcursosequipo2.Modelo.dataCursos


import retrofit2.http.GET
import retrofit2.http.Query

interface ApiServicio {
    //obtenemos los cursos
    @GET(value = "obtener_carreras.php")
    suspend fun obtenerCarreras(): List<dataCarreras>

    @GET(value = "obtener_cursos.php")
    suspend fun obtenerCursos(@Query(value = "id_carrera")idCarrera: Int): List<dataCursos>
}