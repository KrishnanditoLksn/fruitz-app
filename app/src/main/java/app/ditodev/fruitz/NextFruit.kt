package app.ditodev.fruitz

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class NextFruit : AppCompatActivity(), View.OnClickListener {
    private lateinit var btnBack: Button
    private lateinit var btnConstraintApple: Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_next_fruit)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        btnBack = findViewById(R.id.btnHomeBack)
        btnBack.setOnClickListener(this)

        btnConstraintApple = findViewById(R.id.btnConstraintApple)
        btnConstraintApple.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        if (p0?.id != null) {
            when (p0.id) {
                R.id.btnHomeBack -> {
                    val backs = Intent(this@NextFruit, MainActivity::class.java)
                    startActivity(backs)
                }

                R.id.btnConstraintApple -> {
                    val nextApple = Intent(this@NextFruit, AppleFruitActivity::class.java)
                    startActivity(nextApple)
                }
            }
        }
    }
}