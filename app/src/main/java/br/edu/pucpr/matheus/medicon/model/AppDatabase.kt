package br.edu.pucpr.matheus.medicon.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.edu.pucpr.matheus.medicon.controller.BancoDao


@Database(entities = [UserMedication::class], version = 2)
abstract class AppDatabase : RoomDatabase(){
    abstract fun userMediconDao(): BancoDao
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