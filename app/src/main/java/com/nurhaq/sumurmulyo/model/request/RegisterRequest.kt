package com.nurhaq.sumurmulyo.model.request

data class RegisterRequest(
    val name: String,
    val email: String,
    val password: String,
    val phone: String
)

fun RegisterRequest.isValid(): Boolean {
    return name.isNotBlank() && email.isNotBlank() && password.isNotBlank()
}