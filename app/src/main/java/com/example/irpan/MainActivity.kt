package com.example.irfan

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.irpan.R
import com.example.irpan.UserDatabaseHelper
import com.example.irpan.home

class MainActivity : AppCompatActivity() {
    private lateinit var usernameView: EditText
    private lateinit var passwordView: EditText
    private lateinit var loginButton: Button
    private lateinit var dbHelper: UserDatabaseHelper


    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        usernameView = findViewById(R.id.txtuser)
        passwordView = findViewById(R.id.txtpass)
        loginButton = findViewById(R.id.klik)

        dbHelper = UserDatabaseHelper(this)


        loginButton.setOnClickListener {
            val username = usernameView.text.toString()
            val password = passwordView.text.toString()
            if (dbHelper.checkUser(username, password)) {
                val intent = Intent(this,home::class.java)
                startActivity(intent)
            } else {
                usernameView.error = "Username salah"
            }
        }

    }
}