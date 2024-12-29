package com.appera.app.ingredigenius

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.appera.app.ingredigenius.databinding.IngredientItemBinding

class IngredientsAdapter(private val ingredients: List<String>) : RecyclerView.Adapter<IngredientsAdapter.IngredientViewHolder>() {

    // ViewHolder class to hold the item view
    class IngredientViewHolder(private val binding: IngredientItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(ingredient: String) {
            binding.ingredientName.text = ingredient
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IngredientViewHolder {
        val binding = IngredientItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return IngredientViewHolder(binding)
    }

    override fun onBindViewHolder(holder: IngredientViewHolder, position: Int) {
        holder.bind(ingredients[position])
    }

    override fun getItemCount(): Int {
        return ingredients.size
    }
}
