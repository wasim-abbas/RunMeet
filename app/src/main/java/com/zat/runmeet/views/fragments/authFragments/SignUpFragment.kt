package com.zat.runmeet.views.fragments.authFragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.zat.runmeet.R
import com.zat.runmeet.base.BaseFragment
import com.zat.runmeet.utils.singleClick
import com.zat.runmeet.viewModels.BaseViewModel
import com.zat.runmeet.views.activities.MainActivity
import kotlinx.android.synthetic.main.fragment_sign_up.*

class SignUpFragment : BaseFragment<BaseViewModel>() {
    override val layoutId: Int
        get() = R.layout.fragment_sign_up
    override val viewModelClass: Class<BaseViewModel>
        get() = BaseViewModel::class.java

    override fun observeLiveData() {
    }

    override fun init() {
        btnSignUp.singleClick {
            currentActivity().replaceFragmentInAuth(R.id.action_signUpFragment_to_OTPVerificationFragment)
        }
        txtSignIn.singleClick {
            currentActivity().replaceFragmentInAuth(R.id.action_signUpFragment_to_signInFragment)
        }
        btnViewSkip.singleClick {
            startActivity(Intent(currentActivity(),MainActivity::class.java))
            currentActivity().finish()
        }
    }

}