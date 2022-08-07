package br.edu.pucpr.matheus.medicon.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import br.edu.pucpr.matheus.medicon.R
import br.edu.pucpr.matheus.medicon.controller.BancoDao
import br.edu.pucpr.matheus.medicon.model.AppDatabase
import br.edu.pucpr.matheus.medicon.model.DataStore
import br.edu.pucpr.matheus.medicon.model.UserMedication
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.card_medication_view.*

class MainActivity : AppCompatActivity() {
    private lateinit var userDao: BancoDao
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val db = AppDatabase.instancia(this)

        userDao = db.userMediconDao()
        DataStore.medicines = userDao.buscarDados().toMutableList()

        val layoutMain = findViewById<ConstraintLayout>(R.id.layoutMain)

//      val toolbar = findViewById<Toolbar>(R.id.toolbar)
//        toolbar.title = "MEDICON"
        fab.setOnClickListener {
            val intent = Intent(this, AddMedicationActivity::class.java)
            startActivity(intent)
            finish()
//            resultAddLaunch.launch(intent)



        }
    }
}