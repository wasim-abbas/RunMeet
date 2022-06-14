package com.zat.runmeet.views.activities

import android.os.Bundle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.zat.runmeet.R
import com.zat.runmeet.base.BaseActivity
import com.zat.runmeet.utils.gone
import com.zat.runmeet.utils.singleClick
import com.zat.runmeet.utils.visible
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.bootom_nav_layout.*
import kotlinx.android.synthetic.main.side_bar.*

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navController = Navigation.findNavController(
            this,
            R.id.navMainHomeFrag // name of nav graph
        )


        navController.addOnDestinationChangedListener { _, destination, _ ->
            if (destination.id == R.id.homeFragment ||
                destination.id == R.id.meFragment ||
                destination.id == R.id.meetFragment ||
                destination.id == R.id.privacyFragment ||
                destination.id == R.id.phoneNumberFragment ||
                destination.id == R.id.editProfileFragment

            ) {
                bottom_Navigation.visible()
            } else {

                bottom_Navigation.gone()
            }
        }

        NavigationUI.setupWithNavController(bottom_Navigation, navController)

        sideDrawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED)

        btnBack.singleClick {
            sideDrawer.closeDrawer(GravityCompat.START)
        }

        btnAboutUS.singleClick {
            sideDrawer.closeDrawer(GravityCompat.START)
            replaceMainFragment(R.id.aboutUsFragment)
        }
        btnPrivacyPolicy.singleClick {
            sideDrawer.closeDrawer(GravityCompat.START)
            replaceMainFragment(R.id.privacyPolicyFragment)
        }
        btnTermsAndCondition.singleClick {
            sideDrawer.closeDrawer(GravityCompat.START)
            replaceMainFragment(R.id.termsAndConditionsFragment)
        }

    }

    override fun attachViewMode() {
    }

    fun toggleDrawer() {
        if (sideDrawer.isDrawerOpen(GravityCompat.START)) {
            sideDrawer.closeDrawer(GravityCompat.START)

        } else {
            sideDrawer.openDrawer(GravityCompat.START)
        }
    }
}