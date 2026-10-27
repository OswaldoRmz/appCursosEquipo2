package com.example.appcursosequipo2.Modelo

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RegistroRequest(
    @SerialName("matricula") val matricula: Int,
    @SerialName("id_cursos") val idCurso: Int
)
