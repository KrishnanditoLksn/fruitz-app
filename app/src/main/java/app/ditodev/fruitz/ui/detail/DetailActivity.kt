package app.ditodev.fruitz.ui.detail

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import app.ditodev.fruitz.R
import app.ditodev.fruitz.data.Fruit
import app.ditodev.fruitz.databinding.ActivityDetailBinding
import app.ditodev.fruitz.utils.Utils

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val datas = intent.getParcelableExtra<Fruit>(Utils.EXTRA_DATA)
        Log.d("Detail : ", datas?.name.toString())
        Log.d("Desc : ", datas?.description.toString())

        Utils.changeStatusBarColor(window, "#3498db")
        supportActionBar!!.setBackgroundDrawable(ColorDrawable(Color.rgb(255, 99, 71)))
        binding.tvDetailName.text = datas?.name.toString()
        binding.tvArticle.text = datas?.description.toString()
        datas?.photo?.let { binding.ivImage.setImageResource(it) }
    }
}