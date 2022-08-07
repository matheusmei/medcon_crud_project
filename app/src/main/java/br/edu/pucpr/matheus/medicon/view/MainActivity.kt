package br.edu.pucpr.matheus.medicon.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import br.edu.pucpr.matheus.medicon.R
import br.edu.pucpr.matheus.medicon.controller.BancoDao
import br.edu.pucpr.matheus.medicon.model.AppDatabase
import br.edu.pucpr.matheus.medicon.model.DataStore
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var userDao: BancoDao
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val db = AppDatabase.instancia(this)
        userDao = db.userMediconDao()
        DataStore.medicines = userDao.buscarDados().toMutableList()
//        val toolbar = findViewById<Toolbar>(R.id.toolbar)
//        toolbar.title = "MEDICON"
        fab.setOnClickListener {
            val intent = Intent(this, AddMedicationActivity::class.java)
            startActivity(intent)
            finish()
//            resultAddLaunch.launch(intent)
        }
    }
}