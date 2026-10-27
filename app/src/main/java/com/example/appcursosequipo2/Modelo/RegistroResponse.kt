package com.example.appcursosequipo2.Modelo

import kotlinx.serialization.SerialName

data class RegistroResponse(
    @SerialName("ok") val ok: Boolean = false,
    @SerialName("mensaje") val mensaje: String = ""
)
