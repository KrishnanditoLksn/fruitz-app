package app.ditodev.fruitz.ui.detail

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import app.ditodev.fruitz.R
import app.ditodev.fruitz.data.Fruit
import app.ditodev.fruitz.databinding.ActivityDetailBinding
import app.ditodev.fruitz.utils.Utils

class DetailActivity : AppCompatActivity(), View.OnClickListener {
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
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        binding.tvDetailName.text = datas?.name.toString()
        binding.tvArticle.text = datas?.description.toString()
        datas?.photo?.let { binding.ivImage.setImageResource(it) }

        binding.actionShare.setOnClickListener(this)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return true
    }

    override fun onClick(p0: View?) {
        val datas = intent.getParcelableExtra<Fruit>(Utils.EXTRA_DATA)
        if (p0?.id != null) {
            val share: Intent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, datas?.name.toString())
                type = "text/plain"
            }
            startActivity(Intent.createChooser(share, "Shareable"))
        }
    }
}