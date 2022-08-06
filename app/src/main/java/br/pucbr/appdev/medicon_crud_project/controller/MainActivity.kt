package br.pucbr.appdev.medicon_crud_project.controller

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.GestureDetector
import android.view.Menu
import android.view.MenuItem
import android.view.MotionEvent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.Toolbar
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.pucbr.appdev.medicon_crud_project.R
import br.pucbr.appdev.medicon_crud_project.model.DataStore
import br.pucbr.appdev.medicon_crud_project.view.MedicationAdapter
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private var adapter: MedicationAdapter? = null
    private var rcvMedicines: RecyclerView? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        val layoutMain = findViewById<CoordinatorLayout>(R.id.layoutMain)
        val fab = findViewById<FloatingActionButton>(R.id.fab)

        val resultAddLaunch = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {

            if (it.resultCode == RESULT_OK) {

                adapter?.notifyDataSetChanged()
                Snackbar.make(
                    layoutMain,
                    "Medicamento ${it.data?.getStringExtra("medicine")} adicionado com sucesso!",
                    Snackbar.LENGTH_LONG
                ).show()
                updateCollapsingToolbar()
            }

        }

        val resultEditLaunch = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {

            if (it.resultCode == RESULT_OK) {

                adapter?.notifyDataSetChanged()
                Snackbar.make(
                    layoutMain,
                    "Medicamento ${it.data?.getStringExtra("medicine")} atualizado com sucesso com sucesso!",
                    Snackbar.LENGTH_LONG
                ).show()
            }

        }

        fab.setOnClickListener {

            val intent = Intent(this@MainActivity, AddMedicationActivity1::class.java).apply {
                this.putExtra("info", 1)
            }
            resultAddLaunch.launch(intent)
        }

        rcvMedicines = findViewById<RecyclerView>(R.id.rcvMedicines)
        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation  = LinearLayoutManager.VERTICAL
        rcvMedicines?.layoutManager = layoutManager
        adapter = MedicationAdapter(DataStore.medicines)
        rcvMedicines?.adapter = adapter

        updateCollapsingToolbar()

        val gestureDetector = GestureDetector(this, object : GestureDetector.SimpleOnGestureListener() {

            override fun onSingleTapConfirmed(e: MotionEvent?): Boolean {

                e?.let {

                    val view = rcvMedicines?.findChildViewUnder(it.x, it.y)
                    view?.let {

                        val position = rcvMedicines?.getChildAdapterPosition(it)
                        position?.let {
                            val medication = DataStore.getMedication(it)

                            val intent = Intent(this@MainActivity, AddMedicationActivity1::class.java).apply {
                                this.putExtra("info", 2)
                                this.putExtra("position", position)
                            }
                            resultEditLaunch.launch(intent)
                        }
                    }
                }

                return super.onSingleTapConfirmed(e)

        }
            override fun onLongPress(e: MotionEvent?) {
                super.onLongPress(e)

                e?.let {

                    val view = rcvMedicines?.findChildViewUnder(it.x, it.y)
                    view?.let {

                        val position = rcvMedicines?.getChildAdapterPosition(it)
                        position?.let {

                            val city = DataStore.getMedication(it)

                            val dialog = AlertDialog.Builder(this@MainActivity)
                            dialog.setTitle("App de Medicamentos")
                            dialog.setMessage("Tem certeza que deseja remover este Medicamento? ")
                            dialog.setPositiveButton(
                                "Excluir",
                                DialogInterface.OnClickListener { dialogInterface, i ->

                                    DataStore.removeMedication(position)
                                    adapter?.notifyDataSetChanged()
                                    updateCollapsingToolbar()

                                    Snackbar.make(
                                        layoutMain,
                                        "Medicamento ${city.name} excluído com sucesso!!!",
                                        Snackbar.LENGTH_LONG
                                    ).show()
                                })
                            dialog.setNegativeButton("Cancelar", null)
                            dialog.show()
                        }
                    }
                }
            }
        })
        rcvMedicines?.addOnItemTouchListener(object : RecyclerView.OnItemTouchListener {

            override fun onTouchEvent(rv: RecyclerView, e: MotionEvent) {
                TODO("Not yet implemented")
            }

            override fun onInterceptTouchEvent(rv: RecyclerView, e: MotionEvent): Boolean {

                val child = rv.findChildViewUnder(e.x, e.y)

                return (child != null && gestureDetector.onTouchEvent(e))
            }

            override fun onRequestDisallowInterceptTouchEvent(disallowIntercept: Boolean) {
                TODO("Not yet implemented")
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.menu, menu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.mnuClear -> {

                DataStore.clearMedication()
                adapter?.notifyDataSetChanged()
                updateCollapsingToolbar()
            }
            R.id.mnuAbout -> {

                val dialog = AlertDialog.Builder(this@MainActivity).apply {
                    setTitle("App de Medicamentos")
                    setMessage("Desenvolvido por Matheus A. Mei")
                    setPositiveButton("Ok", null)
                    show()
                }
            }
        }

        return true
    }

    fun updateCollapsingToolbar() {

        val collapsingToolbar = findViewById<CollapsingToolbarLayout>(R.id.collapsingToolbar)

        collapsingToolbar.title = "Medicamentos: ${DataStore.medicines.size}"




}
}