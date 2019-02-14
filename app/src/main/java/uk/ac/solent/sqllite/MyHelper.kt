package uk.ac.solent.sqllite
import android.database.sqlite.SQLiteOpenHelper
import android.database.sqlite.SQLiteDatabase
import android.content.Context

class MyHelper(ctx:Context): SQLiteOpenHelper(ctx,"MusicDB",null,1) {
    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL("CREATE TABLE IF NOT EXISTS Hits (Id INTEGER PRIMARY KEY, TITLE VARCHAR(255), ARTIST VARCHAR(255), YEAR INTEGER)")
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS Hits")
        onCreate(db)
    }

    fun addSong(Title: String, Artist: String, Year: Long): Long {
        val db = getWritableDatabase()
        val stmt = db.compileStatement("INSERT INTO Hits(Title,Artist,Year) VALUES (?, ?, ?)")
        stmt.bindString(1, Title)
        stmt.bindString(2, Artist)
        stmt.bindLong(3, Year)
        val id = stmt.executeInsert()
        return id
    }
    fun findSong(id: Long): Song? {
        val name = " "
        val db = getReadableDatabase()
        val cursor = db.rawQuery("SELECT * FROM Hits WHERE id=?", arrayOf<String>(name))
        if (cursor.moveToFirst())

    }
    cursor.close()
    return people

}

