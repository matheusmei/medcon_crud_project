package br.pucbr.appdev.medicon_crud_project.model.banco

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


import br.pucbr.appdev.medicon_crud_project.controller.InterfaceDao
import br.pucbr.appdev.medicon_crud_project.model.Medication

@Database(entities = [Medication::class], version = 1)
abstract class AppDatabase : RoomDatabase(){
    abstract fun userDao(): InterfaceDao
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