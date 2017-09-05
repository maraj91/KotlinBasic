package com.example.maraj.kotlinbasic

import android.app.ProgressDialog
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //init the edittext
        val etMessage = findViewById(R.id.et_message) as EditText
        //init the button
        val btnClick = findViewById(R.id.btn_click) as Button
        btnClick.setOnClickListener{
            val msg: String = etMessage.text.toString()
            if(msg.trim().length>0) {
                Toast.makeText(applicationContext, "Message : "+msg, Toast.LENGTH_SHORT).show()
            }else{
                etMessage.setError("Please enter some message!")
//                Toast.makeText(applicationContext, "Please enter some message! ", Toast.LENGTH_SHORT).show()
            }
        }

        //init the next button
        val btnNext = findViewById(R.id.btn_next) as Button
        btnNext.setOnClickListener{
            val intent = Intent(this@MainActivity, Main2Activity::class.java)
            startActivity(intent)
        }

        //init the alert button
        val btnAlert = findViewById(R.id.btn_alert1) as Button
        btnAlert.setOnClickListener{
            showSimpleAlert()
        }
        //init the alert button
        val btnAlert2 = findViewById(R.id.btn_alert2) as Button
        btnAlert2.setOnClickListener{
            showSimpleAlertWithTwoButton()
        }
        //init the alert button
        val btnAlert3 = findViewById(R.id.btn_alert3) as Button
        btnAlert3.setOnClickListener{
            showSimpleAlertWithThreeButton()
        }
        //init the alert button
        val btnAlert4 = findViewById(R.id.btn_alert4) as Button
        btnAlert4.setOnClickListener{
            showProgress()
        }
    }

    //simple alert dialog
    private fun showSimpleAlert() {
        val simpleAlert = AlertDialog.Builder(this@MainActivity).create()
        simpleAlert.setTitle("Alert")
        simpleAlert.setMessage("Show Simple Alert")
        simpleAlert.setButton(AlertDialog.BUTTON_POSITIVE, "OK", {
            dialogInterface, i ->
            Toast.makeText(applicationContext, "You clicked on OK", Toast.LENGTH_SHORT).show()
        })
        simpleAlert.show()
    }

    //simple alert dialog with two button
    private fun showSimpleAlertWithTwoButton() {
        val simpleAlert = AlertDialog.Builder(this@MainActivity).create()
        simpleAlert.setTitle("Alert")
        simpleAlert.setMessage("Show Simple Alert With Two Button")
        simpleAlert.setButton(AlertDialog.BUTTON_POSITIVE, "OK", {
            dialogInterface, i ->
            Toast.makeText(applicationContext, "You clicked on OK", Toast.LENGTH_SHORT).show()
        })
        simpleAlert.setButton(AlertDialog.BUTTON_NEGATIVE,"Cancel",{
            dialogInterface, i ->
            Toast.makeText(applicationContext, "You clicked on Cancel", Toast.LENGTH_SHORT).show()
        })
        simpleAlert.show()
    }

    //simple alert dialog with three button
    private fun showSimpleAlertWithThreeButton() {
        val simpleAlert = AlertDialog.Builder(this@MainActivity).create()
        simpleAlert.setTitle("Alert")
        simpleAlert.setMessage("Show Simple Alert With Three Button")
        simpleAlert.setButton(AlertDialog.BUTTON_POSITIVE, "POSITIVE", {
            dialogInterface, i ->
            Toast.makeText(applicationContext, "You clicked on POSITIVE", Toast.LENGTH_SHORT).show()
        })
        simpleAlert.setButton(AlertDialog.BUTTON_NEGATIVE,"NEGATIVE",{
            dialogInterface, i ->
            Toast.makeText(applicationContext, "You clicked on NEGATIVE", Toast.LENGTH_SHORT).show()
        })
        simpleAlert.setButton(AlertDialog.BUTTON_NEUTRAL,"NEUTRAL",{
            dialogInterface, i ->
            Toast.makeText(applicationContext, "You clicked on NEUTRAL", Toast.LENGTH_SHORT).show()
        })
        simpleAlert.show()
    }


    //simple progress dialog
    private fun showProgress() {
        val dialog= ProgressDialog(this)
        dialog.setMessage("Please wait")
        dialog.setTitle("Loading")
        dialog.setCancelable(true)
        dialog.isIndeterminate=true
        dialog.show()
    }
}
