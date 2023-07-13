package com.example.shoppinglist.other

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.shoppinglist.data.db.entities.ShoppingItem
import com.example.shoppinglist.databinding.ShoppingItemBinding
import com.example.shoppinglist.ui.shoppingList.ShoppingViewModel

class ShoppingItemAdapter(
    var items : List<ShoppingItem>,
    private val viewModel: ShoppingViewModel
) : RecyclerView.Adapter<ShoppingItemAdapter.ShoppingItemViewHolder>() {

    private lateinit var binding : ShoppingItemBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingItemViewHolder {
        binding = ShoppingItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val view = binding.root
        return ShoppingItemViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ShoppingItemViewHolder, position: Int) {
        val currentShoppingItem = items[position]

        binding.itemName.text = currentShoppingItem.itemName
        binding.itemAmount.text = currentShoppingItem.itemAmount.toString()

        binding.itemDelete.setOnClickListener {
            viewModel.delete(currentShoppingItem)
        }

        binding.addAmount.setOnClickListener {
            currentShoppingItem.itemAmount++
            viewModel.upsert(currentShoppingItem)
        }

        binding.minusAmount.setOnClickListener {
            if (currentShoppingItem.itemAmount > 0) {
                currentShoppingItem.itemAmount--
                viewModel.upsert(currentShoppingItem)
            }
        }
    }

    inner class ShoppingItemViewHolder(view : View) : RecyclerView.ViewHolder(view)
}