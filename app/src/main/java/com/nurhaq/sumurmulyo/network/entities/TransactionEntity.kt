package com.nurhaq.sumurmulyo.network.entities

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "tb_transaction")
data class TransactionEntity(
    @PrimaryKey(autoGenerate = false)
    var id: Int,
    var description: String,
    var price: String,
    var date: String,
    var time: String,
    var user_id: Int,
    var created_at: String,
    var type: String
)

