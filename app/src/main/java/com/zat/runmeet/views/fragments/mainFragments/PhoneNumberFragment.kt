package com.zat.runmeet.views.fragments.mainFragments


import android.app.Dialog
import android.os.Bundle
import com.zat.runmeet.R
import com.zat.runmeet.base.BaseFragment
import com.zat.runmeet.utils.FRAGMENT_NAME
import com.zat.runmeet.utils.getPopupDialog
import com.zat.runmeet.utils.singleClick
import com.zat.runmeet.viewModels.BaseViewModel
import kotlinx.android.synthetic.main.fragment_phone_number.*
import kotlinx.android.synthetic.main.verify_phone_number_dilouge.*


class PhoneNumberFragment : BaseFragment<BaseViewModel>() {
    override val layoutId: Int
        get() = R.layout.fragment_phone_number
    override val viewModelClass: Class<BaseViewModel>
        get() = BaseViewModel::class.java

    private lateinit var dialog: Dialog

    override fun observeLiveData() {
    }

    override fun init() {
        btnBack.singleClick {
           currentActivity().onBackPressed()
        }

        btnVerifyNow.singleClick {
            dialog = getPopupDialog(currentActivity(), R.layout.verify_phone_number_dilouge)
            dialog.btnContinue.singleClick {
                dialog.dismiss()
            }
            dialog.show()
        }
    }

}