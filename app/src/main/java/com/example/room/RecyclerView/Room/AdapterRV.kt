package com.example.room.RecyclerView.Room

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.room.R
import com.example.room.data.ETdata
import kotlinx.android.synthetic.main.item_grid.view.*

class AdapterRV : RecyclerView.Adapter<AdapterRV.RvViewHolder>() {

    private var data = arrayListOf<ETdata>()

    class RvViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bind(data: ETdata) {
            itemView.tv1.text = data.et_name
            itemView.tv2.text = data.et_opisanie
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RvViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_grid, parent, false)
        return RvViewHolder(view)
    }

    fun update(data:List<ETdata>) {
        this.data.clear()
        this.data.addAll(data)
        notifyDataSetChanged()
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: RvViewHolder, position: Int) {
        holder.bind(data[position])
    }
}