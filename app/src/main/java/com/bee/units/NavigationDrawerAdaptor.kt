package com.bee.units

import android.content.Context

import android.support.v7.widget.RecyclerView


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

/** Copyright 2019 Justin Bee
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
**/


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
