package com.fwahyudianto.pawtner.ui.mypets

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.fwahyudianto.pawtner.databinding.FragmentMyPetsBinding

class MyPetsFragment : Fragment() {

    private var _binding: FragmentMyPetsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMyPetsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Set title ActionBar
        (activity as AppCompatActivity).supportActionBar?.title = "My Pets"

//        binding.tvContent.text = "Ini halaman My Pets"
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
