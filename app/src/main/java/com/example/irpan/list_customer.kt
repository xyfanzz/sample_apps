package com.example.rzz

import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.irpan.R

class costumer : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_customer) // Pastikan layout ini benar

        val mainView = findViewById<android.view.View>(R.id.main)

        ViewCompat.setOnApplyWindowInsetsListener(mainView) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Ganti dengan ID yang benar dari layout
        val deleteButton = findViewById<ImageView>(R.id.btndelete)

        deleteButton.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Konfirmasi Hapus")
            builder.setMessage("Apakah kamu yakin ingin menghapus data ini?")

            builder.setPositiveButton("Ya") { dialog, _ ->
                // Hapus tampilan atau lakukan aksi
                val item = findViewById<android.view.View>(R.id.item1)
                item.visibility = android.view.View.GONE
                Toast.makeText(this, "Data dihapus", Toast.LENGTH_SHORT).show()
                dialog.dismiss()
            }

            builder.setNegativeButton("Tidak") { dialog, _ ->
                dialog.dismiss()
            }

            builder.create().show()
        }
    }
}