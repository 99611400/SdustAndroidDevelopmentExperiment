package haonan.tech.test.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.google.android.material.bottomnavigation.BottomNavigationView
import haonan.tech.test.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNavigationView:BottomNavigationView = findViewById(R.id.bottomNavigationView)
        val navController:NavController = Navigation.findNavController(this, R.id.fragment)
        val configuration: AppBarConfiguration = AppBarConfiguration.Builder(
                R.id.studentFragment, R.id.courseFragment).build()
        NavigationUI.setupActionBarWithNavController(this,navController,configuration)
        NavigationUI.setupWithNavController(bottomNavigationView,navController)
    }
}