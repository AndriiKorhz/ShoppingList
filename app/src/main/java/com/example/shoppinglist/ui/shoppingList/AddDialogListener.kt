package com.example.shoppinglist.ui.shoppingList

import com.example.shoppinglist.data.db.entities.ShoppingItem

interface AddDialogListener {
    fun onButtonAddClicked(item: ShoppingItem)
}