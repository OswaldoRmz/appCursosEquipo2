package com.example.appcursosequipo2.Modelo

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

//almacena el estado de las inscripciones y el cupo de cada curso
@Serializable
data class dataEstadoCurso(
    @SerialName("id_cursos") val idCurso: Int = 0,
    @SerialName("nombre") val nombreCurso: String = "",
    @SerialName("imagen_url") val imagenUrl: String = "",
    @SerialName("inscritos") val inscritos: Int = 0,
    @SerialName("cupo") val cupoTotal: Int = 0,
    @SerialName("id_carrera") val carreraId: Int? = null
)
