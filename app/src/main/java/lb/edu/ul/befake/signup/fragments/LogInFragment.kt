package lb.edu.ul.befake.signup.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import lb.edu.ul.befake.R
import lb.edu.ul.befake.databinding.ActivityMainBinding
import lb.edu.ul.befake.databinding.FragmentLogInBinding
import lb.edu.ul.befake.signup.viewmodels.LogInFragmentViewModel
import kotlin.math.log

class LogInFragment : Fragment() {
    //mBinding lets you access UI components directly.
    //mBinding.root is the actual View you hand back to the system to display.
    private lateinit var mBinding: FragmentLogInBinding
    private val loginViewModel: LogInFragmentViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentLogInBinding.inflate(inflater, container, false)
        return mBinding.root
    }

    override fun onStart() {
        super.onStart()
        loginViewModel.getData(requireContext())
        setObservers()
        setListeners()
    }

    private fun setObservers() {
        loginViewModel.liveIsRememberMe().observe(viewLifecycleOwner) { rememberMe ->
            mBinding.checkboxRemember.isChecked = rememberMe
        }

        loginViewModel.liveEmail().observe(viewLifecycleOwner) { email ->
            mBinding.editTextEmail.setText(email)
        }
    }

    private fun setListeners() {
        mBinding.linearLayout.setOnClickListener{
            findNavController().navigate(
                R.id.action_logInFragment_to_signUpFragment
            )
        }
        mBinding.buttonSignup.setOnClickListener {
            loginViewModel.saveData(requireContext(), mBinding.checkboxRemember.isChecked, mBinding.editTextEmail.text.toString())
        }
    }

}