package com.example.vkapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class ProductAdapter(private val mProducts: List<Product>) : RecyclerView.Adapter<ProductAdapter.ViewHolder>()
{
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val productTitleTextView = itemView.findViewById<TextView>(R.id.title_TextView)
        val productDescriptTextView = itemView.findViewById<TextView>(R.id.description_TextView)
        val productThumbnailImageView = itemView.findViewById<ImageView>(R.id.thumbnail_ImageView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductAdapter.ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val contactView = inflater.inflate(R.layout.item_product, parent, false)
        return ViewHolder(contactView)
    }

    override fun onBindViewHolder(viewHolder: ProductAdapter.ViewHolder, position: Int) {
        val product: Product = mProducts.get(position)
        val titleTextView = viewHolder.productTitleTextView
        titleTextView.setText(product.title)
        val descriptionTextView = viewHolder.productDescriptTextView
        descriptionTextView.setText(product.description)
        val imageView = viewHolder.productThumbnailImageView
        Glide.with(viewHolder.itemView).load(product.thumbnail).into(imageView)
    }

    override fun getItemCount(): Int {
        return mProducts.size
    }
}