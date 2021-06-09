package com.itzikpich.culturetrip

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import com.itzikpich.culturetrip.databinding.ActivityMainBinding
import com.itzikpich.culturetrip.di.components.MainActivitySubComponent
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    lateinit var mainActivitySybComponent: MainActivitySubComponent
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        mainActivitySybComponent = (applicationContext as App).appComponent.mainActivitySubComponent().create()
        mainActivitySybComponent.inject(this)
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.mainButton.setOnClickListener {
            startActivity(Intent(this, ArticlesActivity::class.java))
        }
    }
}