package br.pucbr.appdev.medicon_crud_project.controller

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import br.pucbr.appdev.medicon_crud_project.model.Medication

interface InterfaceDao {

    @Query("SELECT * FROM Medication")
    fun buscarDados(): List<Medication>

    @Insert
    fun salvaDados(vararg dadosUser: Medication)

    @Delete
    fun delete(vararg dadosUser: Medication)

    @Update
    fun alterarDados(dadosUser: Medication)

    @Query("SELECT * FROM Medication WHERE id = :id")
    fun buscarPorID(id: Int): Medication?
}