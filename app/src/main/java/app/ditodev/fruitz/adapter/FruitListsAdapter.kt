package app.ditodev.fruitz.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import app.ditodev.fruitz.R
import app.ditodev.fruitz.data.Fruit

class FruitListsAdapter(private  val listFruits : ArrayList<Fruit>) : RecyclerView.Adapter<FruitListsAdapter.ListViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.row_fruits , parent , false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listFruits.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name , description , photo) = listFruits[position]
        holder.imagePhotos.setImageResource(photo)
        holder.fruitsName.text = name
        holder.fruitsDesc.text = description

        holder.itemView.setOnClickListener{
            Toast.makeText(holder.itemView.context , "You choose " + listFruits[holder.adapterPosition].name , Toast.LENGTH_SHORT).show()
        }
    }

    class ListViewHolder(itemView : View)  : RecyclerView.ViewHolder(itemView) {
        val imagePhotos  : ImageView = itemView.findViewById(R.id.img_item_photo)
        val fruitsName : TextView = itemView.findViewById(R.id.tv_item_name)
        val fruitsDesc : TextView = itemView.findViewById(R.id.tv_item_description)
    }
}