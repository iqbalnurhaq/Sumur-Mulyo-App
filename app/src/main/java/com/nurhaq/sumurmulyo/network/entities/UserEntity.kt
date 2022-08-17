package com.nurhaq.sumurmulyo.network.entities

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "tab_user")
data class UserEntity(
    @PrimaryKey
    var id: Int? = null,
    var name: String,
    var email: String,
    var phone: String,
    var email_verified_at: String?,
    var profile_photo_path: String?,
)