package com.example.appcursosequipo2.Modelo

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class dataCursos(
    @SerialName(value = "id_cursos")val idCursos: Int=0,
    @SerialName(value = "id_carrera")val idCarrera: Int?=null,
    @SerialName(value = "nombre")val nombre: String="",
    @SerialName(value = "descripcion")val descripcion: String?=null,
    @SerialName(value = "espacio")val espacio: String?=null,
    @SerialName(value = "horas")val horas: Int?=null,
    @SerialName(value = "dias")val dias: String?=null,
    @SerialName(value = "cupo")val cupo: Int?=null,
    @SerialName(value = "imagen_utl")val imagenurl: String?=null
)
