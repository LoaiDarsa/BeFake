package lb.edu.ul.befake.signup.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import lb.edu.ul.befake.R
import lb.edu.ul.befake.databinding.ActivityMainBinding
import lb.edu.ul.befake.databinding.FragmentLogInBinding

class LogInFragment : Fragment() {
    //mBinding lets you access UI components directly.
    //mBinding.root is the actual View you hand back to the system to display.
    private lateinit var mBinding: FragmentLogInBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentLogInBinding.inflate(inflater, container, false)
        return mBinding.root
    }

    override fun onStart() {
        super.onStart()
        setListeners()
    }

    private fun setListeners() {
        mBinding.buttonSignup.setOnClickListener{
            findNavController().navigate(
                R.id.action_logInFragment_to_signUpFragment
            )
        }
    }

}