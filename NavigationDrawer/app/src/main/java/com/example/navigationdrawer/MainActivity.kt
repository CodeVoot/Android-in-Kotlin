package com.example.navigationdrawer

import android.os.Bundle
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    lateinit  var toggle: ActionBarDrawerToggle
    lateinit var drawerLayout:DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        drawerLayout = findViewById(R.id.nav_view)

        // drawer layout will be open close on the click
        toggle = ActionBarDrawerToggle(
            this@MainActivity,drawerLayout,R.string.open,R.string.close
        )

        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayUseLogoEnabled(true)

        // functionality for the nav drawer items
        val navView: NavigationView = findViewById(R.id.nav_view)
        navView.setNavigationItemSelectedListener {
            it.isChecked = true
            when(it.itemId){
                R.id.home -> {
                    replaceFragment(HomeFragment(),it.title.toString())
                }
                R.id.settings -> {
                    replaceFragment(SettingFragment(),it.title.toString())
                }
                R.id.login -> {
                    replaceFragment(LoginFragment(),it.title.toString())
                }
                R.id.message -> {
                    replaceFragment(MessageFragment(),it.title.toString())
                }
            }
            true
        }


    }

    private fun replaceFragment(fragment: Fragment,title:String){
        val fragmentmanager = supportFragmentManager
        val fragtrans = fragmentmanager.beginTransaction()
        fragtrans.replace(R.id.frame_layout_1,fragment)
        fragtrans.commit()
        drawerLayout.closeDrawers()
        setTitle(title)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}