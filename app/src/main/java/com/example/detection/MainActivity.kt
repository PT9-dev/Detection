package com.example.detection

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.example.detection.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var drawable: DrawerLayout
    lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this , R.layout.activity_main)
        drawable = binding.Drawable
        val navController = this.findNavController(R.id.myNavHostFragment)
        NavigationUI.setupActionBarWithNavController(this, navController, drawable)
        appBarConfiguration = AppBarConfiguration(navController.graph, drawable)
        NavigationUI.setupWithNavController(binding.navView, navController)

        navController.addOnDestinationChangedListener{nc : NavController, nd: NavDestination, args: Bundle? ->
            if(nd.id == nc.graph.startDestination)
                drawable.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED)
            else
                drawable.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED)
        }


    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.myNavHostFragment)
        return NavigationUI.navigateUp(navController, drawable)
    }
}