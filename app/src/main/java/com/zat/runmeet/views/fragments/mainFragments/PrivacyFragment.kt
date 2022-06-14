package com.zat.runmeet.views.fragments.mainFragments


import com.zat.runmeet.R
import com.zat.runmeet.base.BaseFragment
import com.zat.runmeet.utils.singleClick
import com.zat.runmeet.viewModels.BaseViewModel
import kotlinx.android.synthetic.main.fragment_privacy.*


class PrivacyFragment : BaseFragment<BaseViewModel>() {
    override val layoutId: Int
        get() = R.layout.fragment_privacy
    override val viewModelClass: Class<BaseViewModel>
        get() = BaseViewModel::class.java

    override fun observeLiveData() {
    }

    override fun init() {
        btnBack.singleClick { currentActivity().onBackPressed() }

        myswitch1.singleClick {
            myswitch1.isActivated=!myswitch1.isActivated
        }
        myswitch2.singleClick {
            myswitch2.isActivated=!myswitch2.isActivated
        }


        myswitch3.singleClick {
            myswitch3.isActivated=!myswitch3.isActivated
        }
        myswitc4.singleClick {
            myswitc4.isActivated=!myswitc4.isActivated
        }


    }

}