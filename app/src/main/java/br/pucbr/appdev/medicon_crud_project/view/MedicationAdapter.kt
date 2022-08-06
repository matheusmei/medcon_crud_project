package br.pucbr.appdev.medicon_crud_project.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.pucbr.appdev.medicon_crud_project.R
import br.pucbr.appdev.medicon_crud_project.model.Medication

class MedicationAdapter(var medicines: MutableList<Medication>) : RecyclerView.Adapter<MedicationAdapter.MedicationHolder>() {

    inner class MedicationHolder(view: View) : RecyclerView.ViewHolder(view) {

        var txtName: TextView
        var txtDosage: TextView
        var txtFrequency: TextView
        var txtClinicalIndication: TextView
        var layCell: LinearLayout

        init {
            txtName = view.findViewById(R.id.txtName)
            txtDosage = view.findViewById(R.id.txtDosage)
            txtFrequency = view.findViewById(R.id.txtFrequency)
            txtClinicalIndication = view.findViewById(R.id.txtClinicalIndication)
            layCell = view.findViewById(R.id.layCell)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MedicationHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.rcv_medicines, parent, false)

        return MedicationHolder(view)
    }

    override fun onBindViewHolder(holder: MedicationHolder, position: Int) {
        val medicine = medicines.get(position)

        holder.txtName.text = "Medicamento: ${medicine.name}"
        holder.txtDosage.text = "Dosagem: ${medicine.dosage}"
        holder.txtFrequency.text = "Frequência: ${medicine.frequency}"
        holder.txtClinicalIndication.text = "Indicação Clínica: ${medicine.clinicalIndication}"
    }

    override fun getItemCount(): Int {
        return medicines.size
    }


}