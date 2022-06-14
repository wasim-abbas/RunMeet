package com.zat.runmeet.views.fragments.mainFragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.zat.runmeet.R
import com.zat.runmeet.base.BaseFragment
import com.zat.runmeet.utils.FRAGMENT_NAME
import com.zat.runmeet.utils.singleClick
import com.zat.runmeet.viewModels.BaseViewModel
import kotlinx.android.synthetic.main.fragment_edit_profile.*


class EditProfileFragment : BaseFragment<BaseViewModel>() {
    override val layoutId: Int
        get() = R.layout.fragment_edit_profile
    override val viewModelClass: Class<BaseViewModel>
        get() = BaseViewModel::class.java

    override fun observeLiveData() {
    }

    override fun init() {
        btnBack.singleClick {
            currentActivity().onBackPressed()
        }
        btnSave.singleClick {
            currentActivity().onBackPressed()
        }
    }

}