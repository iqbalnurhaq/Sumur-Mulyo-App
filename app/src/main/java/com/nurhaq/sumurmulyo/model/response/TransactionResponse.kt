package com.nurhaq.sumurmulyo.model.response

import com.nurhaq.sumurmulyo.network.entities.TransactionEntity

data class TransactionResponse(
    val id: Int,
    val description: String,
    val price: String,
    val date: String,
    val time: String,
    val user_id: Int,
    val created_at: String,
    val type: typeResponse
)

data class typeResponse(
    val id : Int,
    val name: String
)

fun TransactionResponse.toEntity() = TransactionEntity(
    id = id,
    description = description,
    price = price,
    date = date,
    time = time,
    user_id = user_id,
    created_at = created_at,
    type = type.name
)
