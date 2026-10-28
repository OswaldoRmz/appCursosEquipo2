package com.example.appcursosequipo2.interfaceAPI

import com.example.appcursosequipo2.Modelo.RegistroRequest
import com.example.appcursosequipo2.Modelo.RegistroResponse
import com.example.appcursosequipo2.Modelo.dataBuscarAlumno
import com.example.appcursosequipo2.Modelo.dataCarreras
import com.example.appcursosequipo2.Modelo.dataCursos
import com.example.appcursosequipo2.Modelo.dataEstadoInscripcion
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query


interface ApiServicio {
    @GET("obtener_carreras.php")
    fun getCarreras(): Call<List<dataCarreras>>

    @GET("obtener_cursos.php")
    fun getCursos(@Query("id_carrera") idCarrera: Int? = null): Call<List<dataCursos>>

    // Buscar alumno por matrícula (GET)
    @GET("inscribir_alumno.php")
    fun buscarAlumnoByMatricula(@Query("matricula") matricula: Int): Call<dataBuscarAlumno>

    // Registrar inscripción (POST)
    @POST("inscribir_alumno.php")
    fun registrarInscripcion(@Body request: RegistroRequest): Call<RegistroResponse>

}