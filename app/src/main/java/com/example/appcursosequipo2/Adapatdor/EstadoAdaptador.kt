package com.example.appcursosequipo2.Adapatdor

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.appcursosequipo2.Modelo.dataEstadoCurso
import com.example.appcursosequipo2.R

class EstadoAdaptador(private var lista: List<dataEstadoCurso>) : RecyclerView.Adapter<EstadoAdaptador.ViewHolder>() {
        class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val imgCurso: ImageView = itemView.findViewById(R.id.imgEstadoCurso)
            val txtNombre: TextView = itemView.findViewById(R.id.txtNombreEstado)
            val txtInscritos: TextView = itemView.findViewById(R.id.txtInscritosConteo)
            val pbCupo: ProgressBar = itemView.findViewById(R.id.pbCupo)
            val txtCupoTotal: TextView = itemView.findViewById(R.id.txtCupoTotal)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_registro_curso, parent, false)
            return ViewHolder(view)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val item = lista[position]

            holder.txtNombre.text = item.nombreCurso.uppercase()
            holder.txtInscritos.text = "${item.inscritos} inscritos"
            holder.txtCupoTotal.text = "/ ${item.cupoTotal} total"

            holder.pbCupo.max = (if (item.cupoTotal > 0) item.cupoTotal else 1) as Int
            holder.pbCupo.progress = item.inscritos

            if (item.imagenUrl.isNotEmpty()) {
                Glide.with(holder.itemView.context)
                    .load(item.imagenUrl)
                    .into(holder.imgCurso)
            }
        }

        override fun getItemCount(): Int = lista.size

        fun actualizarLista(nuevaLista: List<dataEstadoCurso>) {
            lista = nuevaLista
            notifyDataSetChanged()
        }
}
