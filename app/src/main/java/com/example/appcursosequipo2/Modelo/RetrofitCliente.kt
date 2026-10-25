package com.example.appcursosequipo2.Modelo

import com.example.appcursosequipo2.interfaceAPI.ApiServicio
import kotlinx.serialization.json.Json
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory
import okhttp3.MediaType.Companion.toMediaType
import kotlin.lazy

object RetrofitCliente {
    private const val BASE_URL = "http://192.168.0.103/cursos_api/"; //aqui va la url del api

    private val jsonConfig= Json{
        ignoreUnknownKeys=true
        coerceInputValues=true
        isLenient=true
    }

    val apiService : ApiServicio by lazy{
        val contenType="application/json".toMediaType()
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(jsonConfig.asConverterFactory(contenType))
            .build()
            .create(ApiServicio::class.java)
    }

}