package com.example.appcursosequipo2.Presentador

import com.example.appcursosequipo2.Modelo.clsCursosModelo
import com.example.appcursosequipo2.Modelo.dataCursos
import com.example.appcursosequipo2.Vista.MainActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class clsCursosPresentador(private val vista: MainActivity) {
    private val modelo = clsCursosModelo()

    fun cargarCursos(idCarrera: Int) {
        CoroutineScope(Dispatchers.Main).launch {
            try {
                val cursos = modelo.obtenerCursos(idCarrera)
                vista.mostrarCursos(cursos)
            } catch (e: Exception) {
                vista.mostrarError("Error al cargar cursos: " + e.localizedMessage)
            }
        }
    }
}