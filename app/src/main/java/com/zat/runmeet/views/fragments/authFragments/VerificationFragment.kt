package com.zat.runmeet.views.fragments.authFragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.zat.runmeet.R
import com.zat.runmeet.base.BaseFragment
import com.zat.runmeet.utils.singleClick
import com.zat.runmeet.viewModels.BaseViewModel
import kotlinx.android.synthetic.main.fragment_verification.*


class VerificationFragment : BaseFragment<BaseViewModel>() {
    override val layoutId: Int
        get() = R.layout.fragment_verification
    override val viewModelClass: Class<BaseViewModel>
        get() = BaseViewModel::class.java

    override fun observeLiveData() {
    }

    override fun init() {
        btnBAck.singleClick {
            currentActivity().onBackPressed()
        }
        btnProceed.singleClick {
            currentActivity().replaceFragmentInAuth(R.id.action_verificationFragment_to_resetPasswordFragment)
        }
    }

}