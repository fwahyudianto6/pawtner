package com.fwahyudianto.pawtner.ui.pets

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.fwahyudianto.pawtner.databinding.FragmentPetsBinding

class PetsFragment : Fragment() {

    private var _binding: FragmentPetsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPetsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Set title ActionBar
        (activity as AppCompatActivity).supportActionBar?.title = "Pets"

//        binding.tvContent.text = "Ini halaman Pets"
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}