package com.nurhaq.sumurmulyo.model.response

data class TransactionResponse(
    val description: String,
    val price: String,
    val date: String,
    val time: String,
    val user_id: Int,
    val type_id: Int,
    val type:typeResponse
)

data class typeResponse(
    val name: String
)
