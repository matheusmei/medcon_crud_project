//package br.pucbr.appdev.medicon_crud_project.model
//
//import android.content.Context
//import android.database.sqlite.SQLiteOpenHelper
//
//class DataBase(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME,null,DATABASE_VERSION) {
//
//        companion object{
//
//            const val DATABASE_VERSION = 2
//            const val DATABASE_NAME = "medicines.db"
//
//            const val DB_TABLE_MEDICINES = "medicines"
//
//
//            const val DB_FIELD_NAME = "name"
//            const val DB_FIELD_DOSAGE = "dosage"
//            const val DB_FIELD_FREQUENCY = "frequency"
//            const val DB_FIELD_CLINICALINDICATION = "clinicalIndication"
//
//            const val sqlCreateMedicines = "CREATE TABLE IF NOT EXISTS $DB_TABLE_MEDICINES (" +
//                    "$DB_FIELD_NAME TEXT, " +
//                    "$DB_FIELD_DOSAGE TEXT, " +
//                    "$DB_FIELD_DOSAGE TEXT, " +
//                    "$DB_FIELD_DOSAGE TEXT, " +
//
//
//        }
//
//}