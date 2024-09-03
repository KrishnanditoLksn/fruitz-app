package app.ditodev.fruitz

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding: View
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        binding = findViewById(R.id.button)
    }

    fun onNextPage(view :View) {
        binding.setOnClickListener {
            Intent(this, NextFruit::class.java).also {
                startActivity(it)
            }
        }
    }

}