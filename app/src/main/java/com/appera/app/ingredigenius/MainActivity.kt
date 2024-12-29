package com.appera.app.ingredigenius

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.appera.app.ingredigenius.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val ingredients = mutableListOf<String>()
    private lateinit var adapter: IngredientsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize View Binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize RecyclerView
        adapter = IngredientsAdapter(ingredients)
        binding.ingredientsList.layoutManager = LinearLayoutManager(this)
        binding.ingredientsList.adapter = adapter

        // Add Ingredient button action
        binding.addIngredientButton.setOnClickListener {
            val ingredient = binding.ingredientInput.text.toString()
            if (ingredient.isNotEmpty()) {
                ingredients.add(ingredient)
                adapter.notifyDataSetChanged()  // Update list
                binding.ingredientInput.text?.clear()  // Clear input field
            } else {
                Toast.makeText(this, "Please enter an ingredient", Toast.LENGTH_SHORT).show()
            }
        }

        // Generate Recipe button action
        binding.generateButton.setOnClickListener {
            if (ingredients.isEmpty()) {
                Toast.makeText(this, "Add ingredients first!", Toast.LENGTH_SHORT).show()
            } else {
                // Handle recipe generation logic
                Toast.makeText(this, "Generating Recipe...", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
