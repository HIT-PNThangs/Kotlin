package com.pnt.hit.roomdatabaseguide.fragment

import android.annotation.SuppressLint
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
import androidx.navigation.fragment.navArgs
import com.pnt.hit.roomdatabaseguide.R
import com.pnt.hit.roomdatabaseguide.databinding.FragmentUpdateBinding
import com.pnt.hit.roomdatabaseguide.model.User
import com.pnt.hit.roomdatabaseguide.viewmodel.UserViewModel

class UpdateFragment : Fragment() {
    private lateinit var binding: FragmentUpdateBinding
    private val args by navArgs<UpdateFragmentArgs>()
    private lateinit var userViewModel: UserViewModel

    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentUpdateBinding.inflate(inflater, container, false)

        binding.tvIdUser.text = "User Id: ${args.currentUser.id}"
        binding.inputFirstName.setText(args.currentUser.firstName)
        binding.inputLastName.setText(args.currentUser.lastName)
        binding.inputAge.setText(args.currentUser.age.toString())

        userViewModel = ViewModelProvider(this)[UserViewModel::class.java]

        binding.back.setOnClickListener {
            findNavController().navigate(R.id.action_updateFragment_to_listFragment)
        }

        binding.btnUpdate.setOnClickListener {
            updateUser()
        }

        return binding.root
    }

    private fun updateUser() {
        val firstName = binding.inputFirstName.text.toString()
        val lastName = binding.inputLastName.text.toString()
        val age = Integer.parseInt(binding.inputAge.text.toString())

        if(inputCheck(firstName, lastName, binding.inputAge.text)) {
            val updateUser = User(args.currentUser.id, firstName, lastName, age)

            userViewModel.updateUser(updateUser)

            Toast.makeText(requireContext(), "Successfully updated!", Toast.LENGTH_LONG).show()

            findNavController().navigate(R.id.action_updateFragment_to_listFragment)
        } else {
            Toast.makeText(requireContext(), "Falsely updated!!!", Toast.LENGTH_LONG).show()
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