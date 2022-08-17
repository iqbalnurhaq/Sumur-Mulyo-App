package com.nurhaq.sumurmulyo.data.local.room

import androidx.room.*
import com.nurhaq.sumurmulyo.network.entities.UserEntity

@SuppressWarnings(RoomWarnings.CURSOR_MISMATCH)
@Dao
interface UserDao {

    @Query("SELECT * FROM tab_user")
    suspend fun getUser(): UserEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(user: UserEntity)
}