package com.fiap.projetoemail

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class SQLiteHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    // Definições das colunas da tabela de emails
    object EmailEntry {
        const val TABLE_NAME = "emails"
        const val COLUMN_ID = "id"
        const val COLUMN_FROM = "from_email"
        const val COLUMN_TO = "to_email"
        const val COLUMN_SUBJECT = "subject"
    }
    override fun onCreate(db: SQLiteDatabase) {
        // Define o esquema da tabela de emails
        val SQL_CREATE_ENTRIES =
            "CREATE TABLE ${SQLiteHelper.EmailEntry.TABLE_NAME} (" +
                    "${SQLiteHelper.EmailEntry.COLUMN_ID} INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "${SQLiteHelper.EmailEntry.COLUMN_FROM} TEXT," +
                    "${SQLiteHelper.EmailEntry.COLUMN_TO} TEXT," +
                    "${SQLiteHelper.EmailEntry.COLUMN_SUBJECT} TEXT)"

        db.execSQL(SQL_CREATE_ENTRIES)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        // Aqui você pode implementar a lógica para atualizar o esquema do banco de dados
        val SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS ${SQLiteHelper.EmailEntry.TABLE_NAME}"
        db.execSQL(SQL_DELETE_ENTRIES)
        onCreate(db)
    }

    companion object {
        const val DATABASE_VERSION = 1
        const val DATABASE_NAME = "Email.db"


    }
}
