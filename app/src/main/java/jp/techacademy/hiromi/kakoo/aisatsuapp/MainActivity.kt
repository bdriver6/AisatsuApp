package jp.techacademy.hiromi.kakoo.aisatsuapp

import android.app.TimePickerDialog
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() ,View.OnClickListener{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button1.setOnClickListener(this)

    }

    override fun onClick(v: View) {
        if (v.id == R.id.button1){
            showTimePickerDialog()
        }
    }

    private fun showTimePickerDialog() {
        val timePickerDialog = TimePickerDialog(
            this,
            TimePickerDialog.OnTimeSetListener { view, hour, minute ->
                Log.d("UI_PARTS", "$hour:$minute")
                if ( 2 <= hour && 10 > hour){
                    Aisatsu.text=getString(R.string.goodMornig_text)
                }
                else if ( 10 <= hour && 18 > hour){
                    Aisatsu.text=getString(R.string.goodAfternoon_text)
                }
                else{
                    Aisatsu.text=getString(R.string.goodEvening_text)
                }

            },
            13, 0, true)
        timePickerDialog.show()
    }

}
