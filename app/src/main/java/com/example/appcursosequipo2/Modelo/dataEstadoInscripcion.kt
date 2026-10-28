package com.example.appcursosequipo2.Modelo

import kotlinx.serialization.SerialName

//agrupa la lista de cursos y su cantidad total
data class dataEstadoInscripcion(
    @SerialName("total") val total: Int = 0,
    @SerialName("cursos") val cursos: List<dataEstadoCurso> = emptyList()
)
