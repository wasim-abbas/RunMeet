package com.zat.runmeet.views.fragments.mainFragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.zat.runmeet.R
import com.zat.runmeet.base.BaseFragment
import com.zat.runmeet.utils.singleClick
import com.zat.runmeet.viewModels.BaseViewModel
import kotlinx.android.synthetic.main.fragment_me.*


class MeFragment : BaseFragment<BaseViewModel>() {
    override val layoutId: Int
        get() = R.layout.fragment_me
    override val viewModelClass: Class<BaseViewModel>
        get() = BaseViewModel::class.java

    override fun observeLiveData() {
    }

    override fun init() {

        txtPhone.singleClick {
            currentActivity().replaceMainFragment(R.id.action_meFragment_to_phoneNumberFragment)
        }
        txtWhatsapp.singleClick {
            currentActivity().replaceMainFragment(R.id.action_meFragment_to_socialInfoFragment)
        }
        txtPrivacy.singleClick {
            currentActivity().replaceMainFragment(R.id.action_meFragment_to_privacyFragment)
        }
        btnEdit.singleClick {
            currentActivity().replaceMainFragment(
                R.id.action_meFragment_to_editProfileFragment
            )
        }
    }

}