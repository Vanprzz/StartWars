package com.gs.startwars.ui.views

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.view.Menu
import android.view.MenuItem
import com.gs.startwars.R
import com.gs.startwars.databinding.ActivityMainBinding
import com.gs.startwars.repository.TestApiManager
import com.gs.startwars.ui.common.SWAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(findViewById(R.id.mtoolbar))

        binding.rvPersons.layoutManager =  GridLayoutManager(this,3)

        TestApiManager.getPersonSW {
            if(it!=null){
                binding.rvPersons.adapter = SWAdapter(this, it)
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_search -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}