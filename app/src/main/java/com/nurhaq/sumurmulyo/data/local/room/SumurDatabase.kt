package com.nurhaq.sumurmulyo.data.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.nurhaq.sumurmulyo.network.entities.TransactionEntity
import com.nurhaq.sumurmulyo.network.entities.UserEntity


@Database(
    entities = [
        TransactionEntity::class,
        UserEntity::class
    ],
    version = 2,
    exportSchema = false
)
abstract class SumurDatabase: RoomDatabase() {
    abstract fun transactionDao(): TransactionDao
    abstract fun userDao(): UserDao

    companion object {
        const val DATABASE_NAME = "sumur_db"
    }
}