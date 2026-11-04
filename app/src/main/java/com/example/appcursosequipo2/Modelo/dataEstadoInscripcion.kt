package com.example.appcursosequipo2.Modelo

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class dataEstadoInscripcion(
    @SerialName("total") val total: Int = 0,
    @SerialName("cursos") val cursos: List<dataEstadoCurso> = emptyList()
)
