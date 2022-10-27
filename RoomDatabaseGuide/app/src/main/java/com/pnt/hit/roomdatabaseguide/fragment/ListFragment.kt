package com.pnt.hit.roomdatabaseguide.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.pnt.hit.roomdatabaseguide.R
import com.pnt.hit.roomdatabaseguide.adapter.UserAdapter
import com.pnt.hit.roomdatabaseguide.databinding.FragmentListBinding
import com.pnt.hit.roomdatabaseguide.viewmodel.UserViewModel

class ListFragment : Fragment() {
    private lateinit var binding: FragmentListBinding
    private lateinit var userViewModel: UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentListBinding.inflate(inflater, container, false)

        binding.floatButtonAdd.setOnClickListener {
            findNavController().navigate(R.id.action_listFragment_to_addFragment)
        }

        val mAdapter = UserAdapter()

        // Recycle View
        binding.recycleView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = mAdapter
        }

        userViewModel = ViewModelProvider(this)[UserViewModel::class.java]

        userViewModel.list.observe(viewLifecycleOwner) {
            mAdapter.setData(it)
        }

        return binding.root
    }
}