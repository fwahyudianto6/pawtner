package com.fwahyudianto.pawtner.ui.auth

//  Import Library
import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.fwahyudianto.pawtner.MainActivity
import com.fwahyudianto.pawtner.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.loginBtnLogin.setOnClickListener {
            if (valLogin()) {
                // Kalau validasi berhasil
                Toast.makeText(this, "Login Berhasil!", Toast.LENGTH_SHORT).show()

                // Pindah ke Beranda (MainActivity)
                val intHome = Intent(this, MainActivity::class.java)
                startActivity(intHome)
                finish()
            }
        }
    }

    private fun valLogin(): Boolean {
        val email = binding.loginEtEmail.text.toString().trim()
        val password = binding.loginEtPassword.text.toString().trim()

        // Validasi Email
        if (email.isEmpty()) {
            binding.loginTiEmail.error = "Email wajib diisi"
            return false
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            binding.loginTiEmail.error = "Format email tidak valid"
            return false
        } else {
            binding.loginTiEmail.error = null
        }

        // Validasi Password
        if (password.isEmpty()) {
            binding.loginTiPassword.error = "Password wajib diisi"
            return false
        } else if (password.length < 6) {
            binding.loginTiPassword.error = "Password minimal 6 karakter"
            return false
        } else {
            binding.loginTiPassword.error = null
        }

        if (email == "dev@fwahyudianto.id" && password == "@password") {
            return true
        } else {
            Toast.makeText(this, "Email atau password salah", Toast.LENGTH_SHORT).show()
            return false
        }
    }
}