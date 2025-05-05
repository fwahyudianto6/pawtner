package com.fwahyudianto.pawtner.ui.account

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.fwahyudianto.pawtner.MainActivity
import com.fwahyudianto.pawtner.R
import com.fwahyudianto.pawtner.databinding.FragmentAccountBinding
import com.fwahyudianto.pawtner.ui.started.StartedActivity

class AccountFragment : Fragment() {
    private var mAccountBinding: FragmentAccountBinding? = null
    private val oBinding get() = mAccountBinding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        mAccountBinding = FragmentAccountBinding.inflate(inflater, container, false)

        mAccountBinding?.let {
            val urlUserPhoto = getString(R.string.developer_photo)
            Glide.with(this).load(urlUserPhoto).into(it.accountCivAccount)
        }

        return oBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Set title ActionBar
        (activity as AppCompatActivity).supportActionBar?.title = getString(R.string.menu_account)

        mAccountBinding?.accountCardFavoritePets?.setOnClickListener {
            (activity as? MainActivity)?.navigateToFavorite()
        }
        mAccountBinding?.accountCardLogout?.setOnClickListener {
            showLogoutConfirmationDialog()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        mAccountBinding = null
    }

    private fun showLogoutConfirmationDialog() {
        val builder = AlertDialog.Builder(requireContext())
        builder.setTitle("Konfirmasi Keluar")
        builder.setIcon(R.drawable.ic_logout)
        builder.setMessage("Apakah Anda yakin ingin keluar dari akun?")
        builder.setPositiveButton("Ya") { dialog, _ ->
            dialog.dismiss()
            val intStarted = Intent(activity, StartedActivity::class.java)
            startActivity(intStarted)
            activity?.finish()
        }
        builder.setNegativeButton("Batal") { dialog, _ ->
            dialog.dismiss()
        }
        builder.create().show()
    }
}