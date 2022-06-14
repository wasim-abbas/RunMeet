package com.zat.runmeet.views.adapters

import android.content.Context
import android.view.View
import com.zat.runmeet.R
import com.zat.runmeet.base.BaseAdapter
import com.zat.runmeet.base.BaseViewHolder
import com.zat.runmeet.utils.singleClick
import kotlinx.android.synthetic.main.item_view_nearby.view.*

class ChatAdapter(
    var context: Context,
    var onClick: (String) -> Unit,
   // var reportClick: (String) -> Unit,
) :
    BaseAdapter<ChatAdapter.ChatViewHolder, String>() {
    class ChatViewHolder(itemView: View) : BaseViewHolder(itemView) {}

    override val layoutId: Int
        get() = R.layout.item_view_nearby

    override fun setData(holder: ChatViewHolder, model: String, position: Int) {

        var view = holder.itemView

        view.singleClick {
            onClick(model)
        }
//        view.txtReport.singleClick {
//            reportClick(model)
//        }
    }
}