package br.pucbr.appdev.medicon_crud_project.model

import android.content.Context

object DataStore {

    var medicines: MutableList<Medication> = arrayListOf()
        private set

    private var myContext: Context? = null

    fun setContext(value: Context){
        myContext = value
    }


    fun getMedication(position: Int): Medication {
        return medicines.get(position)
    }

    fun addMedication(medication: Medication) {
        medicines.add(medication)
    }

    fun editMedication(medication: Medication, position: Int) {
        medicines.set(position, medication)
    }

    fun removeMedication(position: Int) {
        medicines.removeAt(position)
    }

    fun clearMedication(){
        medicines.clear()
    }

}