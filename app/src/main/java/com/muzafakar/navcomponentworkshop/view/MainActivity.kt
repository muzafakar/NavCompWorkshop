package com.muzafakar.navcomponentworkshop.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.muzafakar.navcomponentworkshop.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    // object declaration
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // object initialization
        navController = findNavController(R.id.mainFragment)
        // hooking the Bnv with the navController
        mainBnv.setupWithNavController(navController)
    }
}
