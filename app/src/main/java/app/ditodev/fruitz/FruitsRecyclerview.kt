package app.ditodev.fruitz

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import app.ditodev.fruitz.adapter.FruitListsAdapter
import app.ditodev.fruitz.data.Fruit

class FruitsRecyclerview : AppCompatActivity() {
    private lateinit var fruitRv: RecyclerView
    private var list = ArrayList<Fruit>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_fruits_recyler_view)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        fruitRv = findViewById(R.id.rv_fruits)
//        Log.d("MainActivity", fruitRv.toString())
        fruitRv.setHasFixedSize(true)

        Utils.changeStatusBarColor(window, "#3498db")
        supportActionBar!!.setBackgroundDrawable(ColorDrawable(Color.rgb(225, 99, 50)))
        supportActionBar!!.title = "Fruits List"
        list.addAll(getFruitLists())
        showLists()
    }

    @SuppressLint("Recycle")
    private fun getFruitLists(): ArrayList<Fruit> {
        val datasName = resources.getStringArray(R.array.data_name)
        val datasDescription = resources.getStringArray(R.array.data_description)
        val datasPhotos = resources.obtainTypedArray(R.array.data_photos)
        val listsFruits = ArrayList<Fruit>()

        for (i in datasName.indices) {
            val fruits =
                Fruit(datasName[i], datasDescription[i], datasPhotos.getResourceId(i, i - 1))
            listsFruits.add(fruits)
        }

        return listsFruits
    }

    private fun showLists() {
        fruitRv.layoutManager = LinearLayoutManager(this)
        val listAdapter = FruitListsAdapter(list)
        fruitRv.adapter = listAdapter

        listAdapter.setOnItemClickCallback(object : FruitListsAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Fruit) {
                showSelectedFruits(data)
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_list -> {
                val linkToAbout = Intent(this@FruitsRecyclerview, AboutActivity::class.java)
                startActivity(linkToAbout)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun showSelectedFruits(fruits: Fruit) {
        Toast.makeText(this, "You Selected " + fruits.name, Toast.LENGTH_SHORT).show()
    }
}