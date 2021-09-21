package com.enesdurak.periodictable

import android.view.View
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.enesdurak.periodictable.data.model.ElementModel

class ElementListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(model: ElementModel, onItemClickListener: (ElementModel) -> Unit) {
        val tvIndex = itemView.findViewById<TextView>(R.id.tvIndex)
        val tvElementSymbol = itemView.findViewById<TextView>(R.id.tvElementSymbol)
        val tvElementName = itemView.findViewById<TextView>(R.id.tvElementName)
        val clContainer = itemView.findViewById<ConstraintLayout>(R.id.clContainer)

        tvIndex.text = model.index.toString()
        tvElementSymbol.text = model.symbol
        tvElementName.text = model.name

        itemView.findViewById<ConstraintLayout>(R.id.clContainer)
            .setBackgroundColor(ContextCompat.getColor(itemView.context, model.backgroundColor))

        tvIndex.setTextColor(ContextCompat.getColor(itemView.context, model.textColor))
        tvElementSymbol.setTextColor(ContextCompat.getColor(itemView.context, model.textColor))
        tvElementName.setTextColor(ContextCompat.getColor(itemView.context, model.textColor))

        clContainer.setOnClickListener {
            onItemClickListener.invoke(model)
        }
    }
}