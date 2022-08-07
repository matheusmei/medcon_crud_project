package br.edu.pucpr.matheus.medicon.controller

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import br.edu.pucpr.matheus.medicon.model.UserMedication
@Dao
interface BancoDao {

    @Query("SELECT * FROM UserMedication")
    fun buscarDados(): List<UserMedication>

    @Insert
    fun salvaDados(vararg UserMedication: UserMedication)
//
    @Delete
    fun deleteDados(vararg UserMedication: UserMedication)
//
//    @Update
//    fun alterarDados(dadosUser: Medication)
//
//    @Query("SELECT * FROM Medication WHERE id = :id")
//    fun buscarPorID(id: Int): Medication?
}