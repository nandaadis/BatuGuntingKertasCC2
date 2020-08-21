package com.example.batuguntingkertas.ROOM

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [EntityMemo::class], version = 1)
abstract class DatabaseMemo: RoomDatabase() {
    abstract fun DaoMemo(): DaoMemo

    companion object{
        private var INSTANCE: DatabaseMemo? = null

        fun getInstance(context: Context): DatabaseMemo? {
            if(INSTANCE == null){

                INSTANCE = Room.databaseBuilder(context.applicationContext,
                    DatabaseMemo::class.java,"Memon.db").build()

            }
            return INSTANCE
        }
        fun destroyInstance(){
            INSTANCE = null
        }
    }
}