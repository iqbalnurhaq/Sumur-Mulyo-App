package com.nurhaq.sumurmulyo.model.request


data class TransactionRequest(
    var description: String,
    var price: String,
    var date: String,
    var time: String,
    var user_id: Int,
    var type_id: Int,
    var created_at: String,
    var type: String
)

