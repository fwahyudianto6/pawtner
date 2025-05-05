package com.fwahyudianto.pawtner.ui.auth

//  Import Library
import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.fwahyudianto.pawtner.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.registerBtnRegister.setOnClickListener {
            if (valRegister()) {

                // Notifikasi
                Toast.makeText(this, "Registrasi berhasil!", Toast.LENGTH_SHORT).show()

                val intLogin = Intent(this, LoginActivity::class.java)
                startActivity(intLogin)
//                finish()
            }
        }
    }

    private fun valRegister(): Boolean {
        val fullName = binding.registerEtUsername.text.toString().trim()
        val email = binding.registerEtEmail.text.toString().trim()
        val password = binding.registerEtPassword.text.toString().trim()
        val confirmPassword = binding.registerEtConfirmPassword.text.toString().trim()

        // Validasi Nama
        if (fullName.isEmpty()) {
            binding.registerTiUsername.error = "Nama lengkap wajib diisi"
            return false
        } else {
            binding.registerTiUsername.error = null
        }

        // Validasi Email
        if (email.isEmpty()) {
            binding.registerTiEmail.error = "Email wajib diisi"
            return false
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            binding.registerTiEmail.error = "Format email tidak valid"
            return false
        } else {
            binding.registerTiEmail.error = null
        }

        // Validasi Password
        if (password.isEmpty()) {
            binding.registerTiPassword.error = "Password wajib diisi"
            return false
        } else if (password.length < 6) {
            binding.registerTiPassword.error = "Password minimal 6 karakter"
            return false
        } else {
            binding.registerTiPassword.error = null
        }

        // Validasi Konfirmasi Password
        if (confirmPassword.isEmpty()) {
            binding.registerTiConfirmPassword.error = "Konfirmasi password wajib diisi"
            return false
        } else if (confirmPassword != password) {
            binding.registerTiConfirmPassword.error = "Password tidak cocok"
            return false
        } else {
            binding.registerTiConfirmPassword.error = null
        }

        return true
    }
}