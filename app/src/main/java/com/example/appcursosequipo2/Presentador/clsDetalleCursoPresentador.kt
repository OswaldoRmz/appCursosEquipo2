package com.example.appcursosequipo2.Presentador

import com.example.appcursosequipo2.Modelo.clsCursosModelo
import com.example.appcursosequipo2.Modelo.clsDetalleCursoModelo
import com.example.appcursosequipo2.Vista.MainActivity
import com.example.appcursosequipo2.Vista.detalleCursoActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class clsDetalleCursoPresentador(private val vista: detalleCursoActivity) {
    private val modelo = clsDetalleCursoModelo()

    fun cargarDetalle(cursoId: Int) {
        CoroutineScope(Dispatchers.Main).launch {
            try {
                val detalle = modelo.obtenerDetalleCurso(cursoId)
                if (detalle != null) {
                    vista.mostrarDetalle(detalle)
                } else {
                    vista.mostrarError("No se encontró información del curso.")
                }
            } catch (e: Exception) {
                vista.mostrarError("Error al cargar detalle: " + e.localizedMessage)
            }
        }
    }
}