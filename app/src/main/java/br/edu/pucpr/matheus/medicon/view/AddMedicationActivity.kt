package br.edu.pucpr.matheus.medicon.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import br.edu.pucpr.matheus.medicon.R
import br.edu.pucpr.matheus.medicon.controller.BancoDao
import br.edu.pucpr.matheus.medicon.model.AppDatabase
import br.edu.pucpr.matheus.medicon.model.DataStore
import br.edu.pucpr.matheus.medicon.model.UserMedication
import kotlinx.android.synthetic.main.activity_add_medication.*

class AddMedicationActivity : AppCompatActivity() {
    private lateinit var userDao: BancoDao
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_medication)
        val db = AppDatabase.instancia(this)
        userDao = db.userMediconDao()
        botoesAction()
    }

    private fun botoesAction() {
        btnSave.setOnClickListener{
            var cadMedication = adicionar()
            Log.i("teste", "$cadMedication")
            userDao.salvaDados(cadMedication)
            DataStore.medicines = userDao.buscarDados().toMutableList()
//                DataStore.medicines = userDao.buscarDados().toMutableList()
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()

        }
        btnCancel.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
    private fun adicionar(): UserMedication {
        val txtName = txtName.text.toString()
        val txtDosage = txtDosage.text.toString()
        val txtFrequency = txtFrequency.text.toString()
        val txtClinicalIndication = txtClinicalIndication.text.toString()
        val dadosCadastrado = (UserMedication(
            name = txtName,
            dosage = txtDosage,
            frequency = txtFrequency,
            clinicalIndication = txtClinicalIndication
        ))
        return dadosCadastrado
//        if(dadosCadastrado != null){

//        }
//        return false
    }
}