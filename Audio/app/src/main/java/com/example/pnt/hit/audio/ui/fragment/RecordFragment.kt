package com.example.pnt.hit.audio.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.pnt.hit.audio.R
import com.example.pnt.hit.audio.databinding.FragmentRecordBinding

class RecordFragment : Fragment() {
    private lateinit var _binding: FragmentRecordBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRecordBinding.inflate(inflater, container, false)

        _binding.btListRecord.setOnClickListener {
            findNavController().navigate(R.id.action_recordFragment_to_audioListFragment)
        }
        return _binding.root
    }
}