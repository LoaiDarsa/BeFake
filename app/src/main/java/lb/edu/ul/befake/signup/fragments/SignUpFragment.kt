package lb.edu.ul.befake.signup.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import lb.edu.ul.befake.R
import lb.edu.ul.befake.databinding.FragmentSignUpBinding
import lb.edu.ul.befake.showToast
import lb.edu.ul.befake.signup.viewmodels.SignUpFragmentViewModel

class SignUpFragment : Fragment() {
    //mBinding lets you access UI components directly.
    //mBinding.root is the actual View you hand back to the system to display.
    private lateinit var mBinding: FragmentSignUpBinding
    private val signupViewModel: SignUpFragmentViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentSignUpBinding.inflate(inflater, container, false)
        return mBinding.root
    }

    override fun onStart() {
        super.onStart()
        setListeners()
    }

    private fun setListeners() {
        mBinding.textViewLoggin.setOnClickListener{
            if (signupViewModel.emptyInput(requireContext(),
                    mBinding.editTextFirstName.text.toString(),
                    mBinding.editTextLastName.text.toString(),
                    mBinding.editTextEmail.text.toString(),
                    mBinding.editTextPassword.text.toString()) &&
                    signupViewModel.validInput(requireContext(),
                        mBinding.editTextFirstName.text.toString(),
                        mBinding.editTextLastName.text.toString(),
                        mBinding.editTextEmail.text.toString(),
                        mBinding.editTextPassword.text.toString())
                ) {
                findNavController().navigate(
                    R.id.action_signUpFragment_to_logInFragment
                )
            }
        }
    }
}