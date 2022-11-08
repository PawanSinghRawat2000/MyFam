package com.example.myfam

import android.Manifest
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val permission= arrayOf(
            Manifest.permission.ACCESS_FINE_LOCATION
        )

        askForPermission()

        val bottomBar=findViewById<BottomNavigationView>(R.id.bottom_bar)
        bottomBar.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.nav_guard -> {
                    inflatefragment(GuardFragment.newInstance())
                }
                R.id.nav_dashboard -> {
                    inflatefragment(MapsFragment())
                }
                R.id.nav_home -> {
                    inflatefragment(HomeFragment.newInstance())
                }
                R.id.nav_profile -> {
                    inflatefragment(ProfileFragment.newInstance())
                }
            }
            true
        }
        bottomBar.selectedItemId=R.id.nav_home
    }

    private fun askForPermission() {
        if(ActivityCompat.checkSelfPermission(this,Manifest.permission.ACCESS_FINE_LOCATION)!=PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),100)
        }
        if(ActivityCompat.checkSelfPermission(this,Manifest.permission.ACCESS_COARSE_LOCATION)!=PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.ACCESS_COARSE_LOCATION),100)
        }
    }

    private fun inflatefragment(newInstance: Fragment) {
        val transaction=supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container,newInstance)
        transaction.commit()
    }
}