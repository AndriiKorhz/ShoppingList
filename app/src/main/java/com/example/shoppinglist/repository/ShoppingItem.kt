package com.example.shoppinglist.repository

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "shopping_item")
data class ShoppingItem(
    @ColumnInfo(name = "item_name")
    var itemName : String,
    @ColumnInfo(name = "item_amount")
    var itemAmount : Int
) {
    @PrimaryKey (autoGenerate = true)
    var id : Int? = null
}
