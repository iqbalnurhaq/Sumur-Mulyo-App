package com.nurhaq.sumurmulyo.model.response

data class UserResponse(
    val access_token: String,
    val user: User
)


data class User(
    val email: String,
    val email_verified_at: Any,
    val id: Int,
    val name: String,
    val phone: String,
    val profile_photo_path: Any,
){
    override fun toString(): String {
        return "User [email: ${this.email}, email_verified_at: ${this.email_verified_at}, id: ${this.id}, name: ${this.name}, phone: ${this.phone}, profile_photo_path: ${this.profile_photo_path}]"
    }
}

