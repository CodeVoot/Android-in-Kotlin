package com.example.fragments

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)


        val btn1 : Button = findViewById(R.id.display1)
        val btn2 : Button = findViewById(R.id.display2)

        btn1.setOnClickListener{
            val fragmentOne = BlankFragment()
            loadManager(fragmentOne)
        }

        btn2.setOnClickListener {
            val fragmentTwo = BlankFragment2()
            loadManager(fragmentTwo)
        }
    }

    fun loadManager(fragment:Fragment){
        // Fragment Manager: responsible for managing fragments in activity.
        // It keeps track of the fragment lifecycle and handles transactions involving fragments

        var fragmentManager = supportFragmentManager

        // Fragment transaction: used to define a set of operations to be perform on fragments.
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()

        // replacing the frameLayout with new fragment
        fragmentTransaction.replace(R.id.framelayout,fragment)
        fragmentTransaction.commit()
    }
}