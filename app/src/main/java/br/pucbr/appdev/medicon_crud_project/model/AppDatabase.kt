package br.pucbr.appdev.medicon_crud_project.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


import br.pucbr.appdev.medicon_crud_project.controller.BancoDao

@Database(entities = [Medication::class], version = 1)
abstract class AppDatabase : RoomDatabase(){
    abstract fun userDao(): BancoDao
    companion object {
        fun instancia(context: Context): AppDatabase {
            return Room.databaseBuilder(
                context,
                AppDatabase::class.java,
                "medicon.db"
            ).allowMainThreadQueries()
                .build()
        }
    }
}