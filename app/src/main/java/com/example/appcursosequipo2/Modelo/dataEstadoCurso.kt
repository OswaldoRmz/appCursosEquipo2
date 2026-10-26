package com.example.appcursosequipo2.Modelo

import kotlinx.serialization.SerialName

data class dataEstadoCurso(
    @SerialName("id") val id: Int = 0,
    @SerialName("codigo") val codigo: String = "",
    @SerialName("nombre") val nombre: String = "",
    @SerialName("url_imagen_principal") val urlImagenPrincipal: String = "",
    @SerialName("inscritos") val inscritos: Int = 0,
    @SerialName("cupo_total") val cupoTotal: Int = 0
)
