package com.example.batuguntingkertas.ROOM

import androidx.room.*

@Dao
interface DaoMemo {
    @Query("SELECT * FROM EntityMemo")
    fun getAll(): List<EntityMemo>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(belanjaan: EntityMemo):Long

    @Update
    fun update(belanjaan: EntityMemo):Int

    @Delete
    fun delete(belanjaan: EntityMemo):Int
}