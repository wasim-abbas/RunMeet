package com.zat.runmeet.views.adapters

import android.content.Context
import android.view.View
import com.zat.runmeet.R
import com.zat.runmeet.base.BaseAdapter
import com.zat.runmeet.base.BaseViewHolder
import com.zat.runmeet.utils.singleClick

class NotificationAdapter(var context: Context, var onClick: (String) -> Unit) :
    BaseAdapter<NotificationAdapter.NotificationViewHolder, String>() {
    class NotificationViewHolder(itemView: View) : BaseViewHolder(itemView) {}

    override val layoutId: Int
        get() = R.layout.item_view_notification

    override fun setData(holder: NotificationViewHolder, model: String, position: Int) {
        var view = holder.itemView

        view.singleClick {
            onClick(model)
        }
    }
}