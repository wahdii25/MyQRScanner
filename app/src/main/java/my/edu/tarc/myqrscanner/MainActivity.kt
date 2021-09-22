package my.edu.tarc.myqrscanner

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.zxing.integration.android.IntentIntegrator
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn : Button = findViewById(R.id.btnScan)

        btn.setOnClickListener(){
            val qrScan = IntentIntegrator(this)

            qrScan.initiateScan()
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        val result = IntentIntegrator.parseActivityResult(requestCode,resultCode,data)

        val obj = JSONObject(result.contents)

        val productCode = result.contents

        //findViewById<TextView>(R.id.tvResult).text = productCode
         findViewById<TextView>(R.id.tvResult).text = obj.getString("id") + " " + obj.getString("name")

    }
}