package com.zat.runmeet.views.fragments.mainFragments

import android.app.Dialog
import android.widget.SeekBar
import com.zat.runmeet.R
import com.zat.runmeet.base.BaseFragment
import com.zat.runmeet.utils.getPopupDialog
import com.zat.runmeet.utils.gone
import com.zat.runmeet.utils.singleClick
import com.zat.runmeet.utils.visible
import com.zat.runmeet.viewModels.BaseViewModel
import com.zat.runmeet.views.activities.MainActivity
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.set_speed_dilouge.*
import kotlinx.android.synthetic.main.share_diloge.*


class HomeFragment : BaseFragment<BaseViewModel>() {
    override val layoutId: Int
        get() = R.layout.fragment_home
    override val viewModelClass: Class<BaseViewModel>
        get() = BaseViewModel::class.java
    private lateinit var dialog: Dialog


    override fun observeLiveData() {
    }

    override fun init() {
//        sideBAr.singleClick {
//            (currentActivity() as MainActivity).toggleDrawer()
//        }
        btnNotification.singleClick {
            currentActivity().replaceMainFragment(R.id.action_homeFragment_to_notificationFragment)
        }

        btnRun.singleClick {
            dialog = getPopupDialog(currentActivity(), R.layout.set_speed_dilouge)

            dialog.mySeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
                override fun onProgressChanged(
                    seekBar: SeekBar?,
                    progress: Int,
                    fromUser: Boolean
                ) {
                    val value = seekBar?.progress
                    if (value != -1) {
                        val curPos = seekBar!!.width / seekBar.max
                        dialog.txtProgress.x = (curPos * value!!).toFloat() - 20
                        dialog.txtProgress.text = progress.toString()
                    }
                    dialog.txtProgress.y = seekBar.pivotY!! - 20
                    dialog.txtKm.text = progress.toString()+" KM"

                }

                override fun onStartTrackingTouch(seekBar: SeekBar?) {
                }

                override fun onStopTrackingTouch(seekBar: SeekBar?) {

                }

            })
            dialog.txtCartoon.isActivated = true
            dialog.txtCartoon.singleClick {
                dialog.txtCartoon.isActivated = !dialog.txtCartoon.isActivated
            }

            dialog.btnBear.singleClick {
                dialog.btnBear.isActivated = !dialog.btnBear.isActivated
            }
            dialog.btntiger.singleClick {
                dialog.btntiger.isActivated = !dialog.btntiger.isActivated
            }
            dialog.btnLeopard.singleClick {
                dialog.btnLeopard.isActivated = !dialog.btnLeopard.isActivated
            }
            dialog.btnStart.singleClick {
                dialog.dismiss()
                btnStop.visible()
                btnRun.gone()
                timeing.textSize= 24f
                timeElapsed.textSize = 10f
                timeing.text = "00 :01 :32"

                btnPause.alpha = 0.9F
            }
            dialog.show()
        }

        btnStop.singleClick {
            llShare.visible()
            btnStop.gone()
            btnPause.gone()
        }

        btnShare.singleClick {
            dialog = getPopupDialog(currentActivity(), R.layout.share_diloge)

            dialog.myswitch.singleClick {
                dialog.myswitch.isActivated = !dialog.myswitch.isActivated
            }
            dialog.myswitchLocation.singleClick {
                dialog.myswitchLocation.isActivated = !dialog.myswitchLocation.isActivated
            }
            dialog.llShareDiloge.singleClick {
                dialog.dismiss()
                btnRun.visible()
                btnStop.gone()
                llShare.gone()
                btnPause.visible()
                btnPause.alpha = 0.5f
                timeing.text = "00 :00 :00"
                btnPause.isEnabled = false
            }
            dialog.show()
        }
        ImgClose.singleClick {
            btnRun.visible()
            btnStop.gone()
            llShare.gone()
            btnPause.visible()
            btnPause.alpha = 0.5f
            btnPause.isEnabled = false
            timeing.text = "00 :00 :00"
        }
    }

}