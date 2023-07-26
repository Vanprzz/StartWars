package com.gs.startwars.ui.common

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.support.constraint.ConstraintLayout
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.gs.startwars.R
import com.gs.startwars.model.Person
import com.gs.startwars.ui.views.ScrollingActivity

class SWAdapter(var context: Context, private val dataSet: List<Person?>) :
    RecyclerView.Adapter<SWAdapter.ViewHolder>() {

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name: TextView = view.findViewById(R.id.tvName)
        val img: ImageView = view.findViewById(R.id.ivImg)
        val content: ConstraintLayout = view.findViewById(R.id.content)
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_person, viewGroup, false)

        return ViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.name.text = dataSet[position]?.name

        Glide.with(context)
            .load(dataSet[position]?.image)
            .centerCrop()
            .placeholder(R.drawable.image_24)
            .into(viewHolder.img)


        viewHolder.content.setOnClickListener {
            val intent = Intent(context, ScrollingActivity::class.java)
            intent.putExtra("Person",dataSet[position])
            context.startActivity(intent)
        }
    }

    override fun getItemCount() = dataSet.size

}