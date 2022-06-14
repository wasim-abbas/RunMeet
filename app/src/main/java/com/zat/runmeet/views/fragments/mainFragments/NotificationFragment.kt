package com.zat.runmeet.views.fragments.mainFragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.zat.runmeet.R
import com.zat.runmeet.base.BaseFragment
import com.zat.runmeet.utils.dummyList2
import com.zat.runmeet.utils.singleClick
import com.zat.runmeet.viewModels.BaseViewModel
import com.zat.runmeet.views.adapters.NotificationAdapter
import kotlinx.android.synthetic.main.fragment_notification.*

class NotificationFragment : BaseFragment<BaseViewModel>() {
    override val layoutId: Int
        get() = R.layout.fragment_notification
    override val viewModelClass: Class<BaseViewModel>
        get() = BaseViewModel::class.java

    private lateinit var notificationAdapter: NotificationAdapter

    override fun observeLiveData() {
    }

    override fun init() {
        btnBack.singleClick {
            currentActivity().onBackPressed()
        }

        notificationAdapter = NotificationAdapter(currentActivity(), {})
        notificationAdapter.updateData(dummyList2)

        rvNotification.let {
            it.adapter = notificationAdapter
        }

    }

}