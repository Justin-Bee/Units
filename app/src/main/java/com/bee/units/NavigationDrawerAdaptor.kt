package com.bee.units

import android.content.Context

import android.support.v7.widget.RecyclerView


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView


class NavigationDrawerAdaptor(private val context: Context, data: MutableList<NavDrawerItem>) :
    RecyclerView.Adapter<NavigationDrawerAdaptor.MyViewHolder>() {
    internal var data: MutableList<NavDrawerItem>
    private val inflater: LayoutInflater

    init {
        inflater = LayoutInflater.from(context)
        this.data = data
    }

    fun delete(position: Int) {
        data.removeAt(position)
        notifyItemRemoved(position)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = inflater.inflate(R.layout.nav_drawer_row, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val current = data[position]
        holder.title.setText(current.title)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var title: TextView

        init {
            title = itemView.findViewById(R.id.title) as TextView
        }
    }
}