package com.hopecoding.myartbooknavigation.view


import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.hopecoding.myartbooknavigation.R
import java.util.Objects


class MainActivity : AppCompatActivity() {

    private lateinit var navigationController : NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Toast.makeText(this, "Welcome to My Art Book",Toast.LENGTH_SHORT).show()


        navigationController = Navigation.findNavController(this, R.id.fragment)
        NavigationUI.setupActionBarWithNavController(this,navigationController)
    }



    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        //Inflater
        val menuInflater = menuInflater
        menuInflater.inflate(R.menu.add_art,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onResume() {
        super.onResume()
        Objects.requireNonNull<ActionBar?>((this as AppCompatActivity).supportActionBar)
            .setTitle("Fragment Art List Opened.")

    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.fragment)
        return navController.navigateUp()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (item.itemId == R.id.add_art_item) {
            val action = ArtListDirections.actionArtListToDetailFragment("new",0)
            Navigation.findNavController(this, R.id.fragment).navigate(action)

        }

        return super.onOptionsItemSelected(item)
    }




}
