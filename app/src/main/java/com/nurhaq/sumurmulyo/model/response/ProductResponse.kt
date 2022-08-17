package com.nurhaq.sumurmulyo.model.response

data class ProductResponse(
    val id: Int,
    val name: String,
    val price: String,
    val stock: Int,
    val unit: String,
    val image: String?,
    val description: String,
    val created_at: String,
    val type: typeResponse
)
