package br.edu.pucpr.matheus.medicon.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UserMedication(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,
    var name: String,
    var dosage: String,
    var frequency: String,
    var clinicalIndication: String
)
