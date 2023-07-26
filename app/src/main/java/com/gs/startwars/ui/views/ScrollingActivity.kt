package com.gs.startwars.ui.views

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.bumptech.glide.Glide
import com.gs.startwars.R
import com.gs.startwars.databinding.ActivityScrollingBinding
import com.gs.startwars.model.Person

class ScrollingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityScrollingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityScrollingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(findViewById(R.id.toolbar))

        initView()
    }

    fun initView(){
        val personsw: Person = intent.getSerializableExtra("Person") as Person


        binding.toolbarLayout.title = personsw.name
        binding.content.tvHeight.text = personsw.height.toString()
        binding.content.tvMass.text = personsw.mass.toString()
        binding.content.tvGender.text = personsw.gender
        binding.content.tvSpecies.text = personsw.species
        binding.content.tvWiki.text = personsw.wiki

        Glide.with(this)
            .load(personsw.image)
            .placeholder(R.drawable.image_24)
            .into(binding.ivImg)



    }
}