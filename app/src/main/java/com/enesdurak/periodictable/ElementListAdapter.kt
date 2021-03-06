package com.enesdurak.periodictable

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.recyclerview.widget.RecyclerView
import com.enesdurak.periodictable.data.model.ElementModel
import com.enesdurak.periodictable.data.model.EmptyModel
import com.enesdurak.periodictable.data.model.PeriodicTableModel

class ElementListAdapter(private val onItemClickListener: (ElementModel) -> Unit) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var elementList : List<PeriodicTableModel> = arrayListOf()
    set(value){
        field = value
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when(viewType){
            PeriodicTableViewType.ELEMENT_TYPE.value -> {
                val itemView = LayoutInflater.from(parent.context)
                    .inflate(R.layout.adapter_item_element, parent, false)
                ElementListViewHolder(itemView)
            }

            PeriodicTableViewType.EMPTY_TYPE.value -> {
                val itemView = LayoutInflater.from(parent.context)
                    .inflate(R.layout.adapter_item_empty, parent, false)
                EmptyListViewHolder(itemView)
            }

            else -> {
                val itemView = LayoutInflater.from(parent.context)
                    .inflate(R.layout.adapter_item_empty, parent, false)
                ElementListViewHolder(itemView)
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(elementList[position]){
            is ElementModel -> {
                (holder as ElementListViewHolder).bind(elementList[position] as ElementModel,
                onItemClickListener)
            }

            is EmptyModel -> {
                (holder as EmptyListViewHolder)
            }

            else -> {
                (holder as ElementListViewHolder).bind(elementList[position] as ElementModel,
                onItemClickListener )
            }
        }
    }

    override fun getItemCount(): Int = elementList.size

    override fun getItemViewType(position: Int): Int {
        return when(elementList[position]){
            is ElementModel -> {
                PeriodicTableViewType.ELEMENT_TYPE.value
            }

            is EmptyModel -> {
                PeriodicTableViewType.EMPTY_TYPE.value
            }

            else -> {
                PeriodicTableViewType.ELEMENT_TYPE.value
            }
        }
    }
}