package com.example.pnt.hit.navigationcomponent.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.pnt.hit.navigationcomponent.R
import com.example.pnt.hit.navigationcomponent.databinding.FragmentConfirmationBinding
import com.example.pnt.hit.navigationcomponent.model.Money

class ConfirmationFragment : Fragment() {
    private lateinit var navController: NavController
    private lateinit var binding: FragmentConfirmationBinding

    private lateinit var recipient: String
    private lateinit var money: Money

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        recipient = arguments?.getString("recipient").toString()
        money = arguments?.getParcelable("amount")!!
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =  FragmentConfirmationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)

        val amount = money.amount
        val confirmationMessage = "You have send $$amount to $recipient"

        binding.confirmationMessage.text = confirmationMessage
    }
}