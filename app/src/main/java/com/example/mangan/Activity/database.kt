package com.example.mangan.Activity

import android.content.Context
import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

public class database(context: Context) : SQLiteOpenHelper(context, "Userdata", null, 1) {
    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("CREATE TABLE IF NOT EXISTS Userdata (username TEXT PRIMARY KEY, password TEXT)")
    }
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("DROP TABLE IF EXISTS Userdata")
    }
    fun insertData(username: String, password: String): Boolean {
        val p0 = this.writableDatabase
        val cv = ContentValues()
        cv.put("username", username)
        cv.put("password", password)
        val result = p0.insert("Userdata", null, cv)
        if (result == -1L) {
            return false
        }
        return true
    }
    fun checkUserPass(username: String, password: String): Boolean {
        val p0 = this.writableDatabase
        val query = "SELECT * FROM Userdata WHERE username=?"
        val cursor = p0.rawQuery(query, arrayOf(username))
        val result = cursor.count
        cursor.close()
        return result > 0
    }


}