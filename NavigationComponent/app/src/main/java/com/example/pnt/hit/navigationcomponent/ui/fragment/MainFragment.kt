package com.example.pnt.hit.navigationcomponent.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.pnt.hit.navigationcomponent.R
import com.example.pnt.hit.navigationcomponent.databinding.FragmentMainBinding

class MainFragment : Fragment() {
    private lateinit var navController: NavController
    private lateinit var binding: FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)

        binding.viewTransactionsBtn.setOnClickListener {
            navController.navigate(R.id.action_mainFragment_to_viewTransactionFragment)
        }

        binding.viewBalanceBtn.setOnClickListener {
            navController.navigate(R.id.action_mainFragment_to_viewBalanceFragment)
        }

        binding.sendMoneyBtn.setOnClickListener {
            navController.navigate(R.id.action_mainFragment_to_chooserRecipientFragment2)
        }
    }
}