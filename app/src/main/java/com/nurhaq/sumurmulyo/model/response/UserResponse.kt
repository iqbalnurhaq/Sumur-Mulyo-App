package com.nurhaq.sumurmulyo.model.response

data class UserResponse(
    val access_token: String,
    val user: User
)


data class User(
    val created_at: String,
    val email: String,
    val email_verified_at: Any,
    val id: Int,
    val name: String,
    val phone: String,
    val profile_photo_path: Any,
    val two_factor_confirmed_at: Any,
    val two_factor_recovery_codes: Any,
    val two_factor_secret: Any,
    val updated_at: String
)