package br.com.zup.desafirickmorth.ui.home.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.zup.desafirickmorth.R
import br.com.zup.desafirickmorth.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}