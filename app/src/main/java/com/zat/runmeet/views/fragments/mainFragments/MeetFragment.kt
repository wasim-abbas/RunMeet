package com.zat.runmeet.views.fragments.mainFragments

import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.zat.runmeet.R
import com.zat.runmeet.base.BaseFragment
import com.zat.runmeet.utils.*
import com.zat.runmeet.viewModels.BaseViewModel
import com.zat.runmeet.views.adapters.ChatAdapter
import kotlinx.android.synthetic.main.fragment_meet.*
import kotlinx.android.synthetic.main.login_diloge.*
import kotlinx.android.synthetic.main.profile_detail_diloge.*


class MeetFragment : BaseFragment<BaseViewModel>() {
    override val layoutId: Int
        get() = R.layout.fragment_meet
    override val viewModelClass: Class<BaseViewModel>
        get() = BaseViewModel::class.java
    private lateinit var dialog: Dialog
    private lateinit var dialog2: Dialog


    private lateinit var chatAdapter: ChatAdapter

    override fun observeLiveData() {
    }

    override fun init() {
        chatAdapter = ChatAdapter(currentActivity(),{})
        chatAdapter.updateData(dummyList2)
        rvChat.let {
            it.adapter = chatAdapter
        }

        llNearby.singleClick {
            llChat.visible()
            llNearby.gone()
        }
        llChat.singleClick {
            llNearby.visible()
            llChat.gone()
        }
        edChatt.singleClick {
            dialog = getPopupDialog(currentActivity(),R.layout.login_diloge)

            dialog.llLogin.singleClick {

                dialog2 = getPopupDialog(currentActivity(),R.layout.profile_detail_diloge)
                dialog2.btnMale.isActivated = true
                dialog2.btnMale.singleClick {
                    dialog2.btnMale.isActivated =!dialog2.btnMale.isActivated
                }
                dialog2.btnFemale.singleClick {
                    dialog2.btnFemale.isActivated =!dialog2.btnFemale.isActivated
                }
                dialog2.llProfileDetal.singleClick {
                    dialog2.dismiss()
                    dialog.dismiss()
                }
                dialog2.show()
            }


            dialog.show()
        }
    }

}