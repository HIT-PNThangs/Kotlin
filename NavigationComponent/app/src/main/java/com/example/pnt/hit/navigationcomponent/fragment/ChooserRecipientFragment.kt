package com.example.pnt.hit.navigationcomponent.fragment

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.pnt.hit.navigationcomponent.R
import com.example.pnt.hit.navigationcomponent.databinding.FragmentChooserRecipientBinding
import com.example.pnt.hit.navigationcomponent.databinding.FragmentConfirmationBinding

class ChooserRecipientFragment : Fragment() {
    private lateinit var navController: NavController
    private lateinit var binding: FragmentChooserRecipientBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentChooserRecipientBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)

        binding.nextBtn.setOnClickListener {
            if(!TextUtils.isEmpty(binding.inputRecipient.text.toString())) {
                val bundle = bundleOf("recipient" to binding.inputRecipient.text.toString())
                navController.navigate(
                    R.id.action_chooserRecipientFragment_to_specifyAmountFragment,
                    bundle
                )
            } else {
                Toast.makeText(activity, "Enter a recipient", Toast.LENGTH_LONG).show()
            }
        }

        binding.cancelBtn.setOnClickListener {
            requireActivity().onBackPressed()
        }
    }
}