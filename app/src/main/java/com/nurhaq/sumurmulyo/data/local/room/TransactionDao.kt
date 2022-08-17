package com.nurhaq.sumurmulyo.data.local.room

import androidx.room.*
import com.nurhaq.sumurmulyo.network.entities.TransactionEntity

@SuppressWarnings(RoomWarnings.CURSOR_MISMATCH)
@Dao
interface TransactionDao {
    @Query("SELECT * FROM tb_transaction")
    suspend fun getListTransaction(): List<TransactionEntity>

    @Query("SELECT * FROM tb_transaction WHERE id=:id")
    suspend fun getTransaction(id: Int): TransactionEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(transaction: TransactionEntity?)

    @Update
    suspend fun update(transaction: TransactionEntity?)

    @androidx.room.Transaction
    suspend fun saveBatch(data: List<TransactionEntity>){
        data.forEach { item ->
            insert(item)
        }
    }

    @Delete
    suspend fun delete(transaction: TransactionEntity?)

    @Query("SELECT * FROM tb_transaction WHERE id=:id")
    suspend fun getDataExist(id: Int): TransactionEntity
}