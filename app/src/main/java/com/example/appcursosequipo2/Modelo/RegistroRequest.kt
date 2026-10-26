package com.example.appcursosequipo2.Modelo

import kotlinx.serialization.SerialName

data class RegistroRequest(
    @SerialName("matricula") val matricula: Int,
    @SerialName("id_cursos") val idCurso: Int
)
