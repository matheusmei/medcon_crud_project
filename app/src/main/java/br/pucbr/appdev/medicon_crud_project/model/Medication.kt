package br.pucbr.appdev.medicon_crud_project.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Medication(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    var name: String,
    var dosage: String,
    var frequency: String,
    var clinicalIndication: String
        )






