package br.pucbr.appdev.medicon_crud_project.controller

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import br.pucbr.appdev.medicon_crud_project.R
import br.pucbr.appdev.medicon_crud_project.model.DataStore
import br.pucbr.appdev.medicon_crud_project.model.Medication

class AddMedicationActivity1 : AppCompatActivity() {
    var position = -1
    var medicine = Medication("","", "","")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_medication1)

        val txtName = findViewById<EditText>(R.id.txtName)
        val txtDosage = findViewById<EditText>(R.id.txtDosage)
        val txtFrequency = findViewById<EditText>(R.id.txtFrequency)
        val txtClinicalIndication = findViewById<EditText>(R.id.txtClinicalIndication)
        val btnSave = findViewById<Button>(R.id.btnSave)
        val btnCancel = findViewById<Button>(R.id.btnCancel)

        val info = intent.getIntExtra("info", 0)
        if (info == 2) {

            position = intent.getIntExtra("position", 0)
            medicine = DataStore.getMedication(position)

            txtName.setText(medicine.name)
            txtDosage.setText(medicine.dosage)
            txtFrequency.setText(medicine.frequency)
            txtClinicalIndication.setText(medicine.clinicalIndication)
        }

        btnSave.setOnClickListener {

            medicine.name = txtName.text.toString()
            medicine.dosage = txtDosage.text.toString()

            if (position == -1) {

                DataStore.addMedication(medicine)
            }
            else {

                DataStore.editMedication(medicine, position)
            }
            val intent = Intent().apply {
                putExtra("Medicamento", medicine.name)
            }
            setResult(RESULT_OK, intent)
            finish()
        }




    }
}