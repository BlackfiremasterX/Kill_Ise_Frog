package com.example.killisefrog

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.preference.PreferenceManager
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity() : AppCompatActivity() {
    var Click = 0
    var Click_Size = 1
    var Priceleg = 1000
    var Price = 10
    lateinit var preference: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        preference = PreferenceManager.getDefaultSharedPreferences(this)


        var hand = 1
        var leg = 3


        Click = preference.getInt("key", 0)
        Click_Size = preference.getInt("key", 1)

        findViewById<TextView>(R.id.counter_points).setText(Click.toString())
        findViewById<TextView>(R.id.Size).setText("Ударов за клик $Click_Size")
        findViewById<TextView>(R.id.hand_price).setText("Цена $Price")
        findViewById<TextView>(R.id.leg_price).setText("Цена $Priceleg")

        findViewById<ImageButton>(R.id.ib_frog).setOnClickListener {
            Click = Click + Click_Size
            counter_points.text = Click.toString()
            when {
                Click_Size >= 10 -> {
                    findViewById<Button>(R.id.b_x2).visibility = View.VISIBLE
                }
            }
            when {
                Click_Size >= 50 -> {
                    findViewById<Button>(R.id.b_x3).visibility = View.VISIBLE
                }
            }
            when {
                Click_Size >= 200 -> {
                    findViewById<Button>(R.id.b_x5).visibility = View.VISIBLE
                }
            }
            when {
                Click_Size >= 1000 -> {
                    findViewById<Button>(R.id.b_x10).visibility = View.VISIBLE
                }
            }

        }
        findViewById<Button>(R.id.b_hand).setOnClickListener {
            if (Click < Price) {
                Toast.makeText(this, "Больше кликай!!!", Toast.LENGTH_SHORT).show()
            }
            if (Click >= Price) {
                Click = Click - Price
                Toast.makeText(this, "Ты потратил бабки!", Toast.LENGTH_SHORT).show()
                counter_points.text = Click.toString()

                Click_Size = Click_Size + hand
                Price = Price * 2
                hand_price.text = "Цена $Price"
                Size.text = "Ударов за клик $Click_Size"
            }
        }
        findViewById<Button>(R.id.b_leg).setOnClickListener {
            if (Click < Priceleg) {
                Toast.makeText(this, "Больше кликай!!!", Toast.LENGTH_SHORT).show()
            }
            if (Click >= Priceleg) {
                Click = Click - Priceleg
                Toast.makeText(this, "Ты потратил бабки!", Toast.LENGTH_SHORT).show()
                counter_points.text = Click.toString()

                Click_Size = Click_Size + leg
                Priceleg = Priceleg * 2
                leg_price.text = "Цена $Priceleg"
                Size.text = "Ударов за клик $Click_Size"
            }
        }
        findViewById<Button>(R.id.b_x2).setOnClickListener {
            if (Click_Size < 10) {
                Toast.makeText(this, "Купи больше ударов", Toast.LENGTH_SHORT).show()
            }
            if (Click_Size >= 10)
                hand = hand * 2

            textView.text = hand.toString()
            if (Click_Size >= 10)
                leg = leg * 2
            textView13.text = leg.toString()
            Toast.makeText(this, "Ты что-то можешь??", Toast.LENGTH_SHORT).show()
            b_x2.setEnabled(false)
        }
        findViewById<Button>(R.id.b_x3).setOnClickListener {
            if (Click_Size < 50) {
                Toast.makeText(this, "Купи больше ударов", Toast.LENGTH_SHORT).show()
            }
            if (Click_Size >= 50)
                hand = hand * 3

            textView.text = hand.toString()
            if (Click_Size >= 50)
                leg = leg * 3
            textView13.text = leg.toString()
            Toast.makeText(this, "Волк не тот кто волк,а тот кто волк", Toast.LENGTH_SHORT).show()
            b_x3.setEnabled(false)
            findViewById<Button>(R.id.b_x5).setOnClickListener {
                if (Click_Size < 200) {
                    Toast.makeText(this, "Купи больше ударов", Toast.LENGTH_SHORT).show()
                }
                if (Click_Size >= 200)
                    hand = hand * 5

                textView.text = hand.toString()
                if (Click_Size >= 200)
                    leg = leg * 5
                textView13.text = leg.toString()
                Toast.makeText(this, "Может удалишь??", Toast.LENGTH_SHORT).show()
                b_x5.setEnabled(false)
                findViewById<Button>(R.id.b_x10).setOnClickListener {
                    if (Click_Size < 1000) {
                        Toast.makeText(this, "Купи больше ударов", Toast.LENGTH_SHORT).show()
                    }
                    if (Click_Size >= 1000)
                        hand = hand * 10

                    textView.text = hand.toString()
                    if (Click_Size >= 1000)
                        leg = leg * 10
                    textView13.text = leg.toString()
                    Toast.makeText(this, "Да ты за***т", Toast.LENGTH_SHORT).show()
                    b_x10.setEnabled(false)
                    if (Click >= 100000000)
                        Toast.makeText(this, "ЭЭЭЭЭ ты прошёл, АСТАНАВИСЬ", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    override fun onPause() {
        super.onPause()
        var editor = preference.edit()
        editor.putInt("keyname", Click)
        editor.putInt("keynam", Click_Size)
        editor.putInt("keyna", Price)
        editor.putInt("keyn", Priceleg)
        .apply()
}

}
