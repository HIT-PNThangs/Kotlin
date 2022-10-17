package com.example.pnt.hit.navigationcomponent.ui.fragment

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
import com.example.pnt.hit.navigationcomponent.databinding.FragmentSpecifyAmountBinding
import com.example.pnt.hit.navigationcomponent.model.Money
import kotlinx.android.synthetic.main.fragment_specify_amount.*
import java.math.BigDecimal

class SpecifyAmountFragment : Fragment() {
    private lateinit var navController: NavController
    private lateinit var binding: FragmentSpecifyAmountBinding

    private lateinit var recipient: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        recipient = arguments?.getString("recipient").toString()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSpecifyAmountBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)

        val messages = "Sending menry to $recipient"
        binding.recipient.text = messages

        binding.sendBtn.setOnClickListener {
            if(!TextUtils.isEmpty(binding.inputAmount.text.toString())) {
                val amount = Money(BigDecimal(binding.inputAmount.text.toString()))
                val bundle = bundleOf(
                    "recipient" to recipient,
                    "amount" to amount
                )
                navController.navigate(
                    R.id.action_specifyAmountFragment_to_confirmationFragment,
                    bundle
                )
            } else {
                Toast.makeText(activity, "Enter a amount", Toast.LENGTH_LONG).show()
            }
        }

        binding.cancelBtn.setOnClickListener {
            requireActivity().onBackPressed()
        }
    }
}