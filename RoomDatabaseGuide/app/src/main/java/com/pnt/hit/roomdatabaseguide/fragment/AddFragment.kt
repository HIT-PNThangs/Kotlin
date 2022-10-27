package com.pnt.hit.roomdatabaseguide.fragment

import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.pnt.hit.roomdatabaseguide.R
import com.pnt.hit.roomdatabaseguide.databinding.FragmentAddBinding
import com.pnt.hit.roomdatabaseguide.model.User
import com.pnt.hit.roomdatabaseguide.viewmodel.UserViewModel

class AddFragment : Fragment() {
    private lateinit var binding: FragmentAddBinding
    private lateinit var userViewModel: UserViewModel

//    private val userViewModel : UserViewModel by viewModels {
//        UserViewModel(requireActivity().application)
//    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddBinding.inflate(inflater, container, false)

        userViewModel = ViewModelProvider(this)[UserViewModel::class.java]

        binding.btnAdd.setOnClickListener {
            insertDataToDatabase()
        }

        binding.back.setOnClickListener {
            findNavController().navigate(R.id.action_addFragment_to_listFragment)
        }

        return binding.root
    }

    private fun insertDataToDatabase() {
        val firstName = binding.inputFirstName.text.toString()
        val lastName = binding.inputLastName.text.toString()
        val age = binding.inputAge.text

        if (inputCheck(firstName, lastName, age)) {
            val user = User(0, firstName, lastName, Integer.parseInt(age.toString()))

            userViewModel.addUser(user)

            Toast.makeText(requireContext(), "Successfully added!", Toast.LENGTH_LONG).show()

            findNavController().navigate(R.id.action_addFragment_to_listFragment)
        } else {
            Toast.makeText(requireContext(), "Falsely added!!!", Toast.LENGTH_LONG).show()
        }
    }

    private fun inputCheck(
        firstName: String,
        lastName: String,
        age: Editable
    ): Boolean {
        return !(TextUtils.isEmpty(firstName) && TextUtils.isEmpty(lastName) && age.isEmpty())
    }
}