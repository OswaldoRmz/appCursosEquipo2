package com.example.appcursosequipo2.Modelo

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

//alamacena la informacion de cada curso
@Serializable
data class dataCursos(
    @SerialName("id_cursos") val id: Int = 0,
    @SerialName("nombre") val nombre: String = "",
    @SerialName("descripcion") val descripcion: String = "",
    @SerialName("espacio") val salon: String = "",
    @SerialName("horas") val horas: Int = 0,
    @SerialName("dias") val dias: String = "",
    @SerialName("cupo") val cupo: Int = 0,
    @SerialName("imagen_url") val urlImagenPrincipal: String = "",
    @SerialName("id_carrera") val carreraId: Int = 0,
    @SerialName("inscritos") val inscritosRow: Int = 0

    //datos convertidos a formato JSON
)
