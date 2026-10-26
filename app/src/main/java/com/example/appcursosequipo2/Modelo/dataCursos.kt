package com.example.appcursosequipo2.Modelo

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class dataCursos(
    @SerialName("id_cursos") val id: Int = 0,
    @SerialName("nombre") val nombre: String = "",
    @SerialName("descripcion") val descripcion: String = "",
    @SerialName("espacio") val salon: String = "",
    @SerialName("cupo") val cupo: String = "",
    @SerialName("imagen_url") val urlImagenPrincipal: String = "",
    @SerialName("id_carrera") val carreraId: Int = 0,

)
