package com.example.passwordvalidator

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.passwordvalidator.databinding.FragmentPasswordBinding

class PasswordFragment : Fragment() {

    private var _binding: FragmentPasswordBinding? = null
    private val binding: FragmentPasswordBinding get() = _binding!!

    private lateinit var viewModel: PasswordViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPasswordBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[PasswordViewModel::class.java]
        with(binding) {
            passwordEt.editText?.addTextChangedListener { input ->
                viewModel.isInputValid(input.toString())
            }

            viewModel.isValid.observe(viewLifecycleOwner) { result ->
                val isValid =
                    result.validLength && result.hasCapital && result.noSpaces && result.hasNumber

                validBtn.isEnabled = isValid
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}