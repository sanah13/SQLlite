package uk.ac.solent.sqllite

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
class MainActivity : AppCompatActivity() {
    lateinit var helper: MyHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        helper = MyHelper(this)
        btn1.setOnClickListener {
            val Title = Edt2.text.toString()
            val Artist = Edt3.text.toString()
            val Year = Edt4.text.toString().toLong()
            val id = helper.addSong(Title,Artist,Year)
            // Set the text of the ID field to the return value of addSong()
            Edt1.setText("$id")

        }

    }

}
