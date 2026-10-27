package com.example.appcursosequipo2.Adapatdor

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.example.appcursosequipo2.R
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.appcursosequipo2.Modelo.dataCursos
import com.example.appcursosequipo2.Vista.MainActivity
class CursosAdaptador(
    private val activity: MainActivity,
    private var listaCursos: List<dataCursos>
) : RecyclerView.Adapter<CursosAdaptador.CursoViewHolder>() {

    class CursoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgCurso: ImageView = itemView.findViewById(R.id.imgCurso)
        val txtNombreCurso: TextView = itemView.findViewById(R.id.txtNombreCurso)
        val txtSalonCurso: TextView = itemView.findViewById(R.id.txtSalonCurso)
        val btnVerDetalle: Button = itemView.findViewById(R.id.btnVerDetalle)
        val btnRegistrarse: Button = itemView.findViewById(R.id.btnRegistrarse)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CursoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_cursos, parent, false)
        return CursoViewHolder(view)
    }

    override fun onBindViewHolder(holder: CursoViewHolder, position: Int) {
        val curso = listaCursos[position]

        holder.txtNombreCurso.text = curso.nombre.uppercase()
        holder.txtSalonCurso.text = if (curso.salon.isNotEmpty()) "Salón: ${curso.salon}" else "Salón: Por asignar"

        if (curso.urlImagenPrincipal.isNotEmpty()) {
            Glide.with(holder.itemView.context)
                .load(curso.urlImagenPrincipal)
                .into(holder.imgCurso)
        }

        holder.btnVerDetalle.setOnClickListener {
            activity.seleccionarCurso(curso)
        }

        holder.btnRegistrarse.setOnClickListener {
            activity.registrarseCurso(curso)
        }
    }

    override fun getItemCount(): Int = listaCursos.size

    fun actualizarLista(nuevaLista: List<dataCursos>) {
        listaCursos = nuevaLista
        notifyDataSetChanged()
    }
}