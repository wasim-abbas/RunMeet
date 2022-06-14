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
import kotlinx.android.synthetic.main.fragment_forget_pasword.*

class ForgetPasswordFragment : BaseFragment<BaseViewModel>() {
    override val layoutId: Int
        get() = R.layout.fragment_forget_pasword
    override val viewModelClass: Class<BaseViewModel>
        get() = BaseViewModel::class.java

    override fun observeLiveData() {
    }

    override fun init() {
        btnBAck.singleClick {
            currentActivity().onBackPressed()
        }
        btnProceed.singleClick {
            currentActivity().replaceFragmentInAuth(R.id.action_forgetPasswordFragment_to_verificationFragment)
        }
    }

}