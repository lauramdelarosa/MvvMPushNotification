package com.delarosa.pushnotificationmvvm.view

import android.content.Context
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.delarosa.pushnotificationmvvm.databinding.ActivityTimeBinding
import com.delarosa.pushnotificationmvvm.viewModel.TimeViewModel
import dagger.android.AndroidInjection
import javax.inject.Inject


class TimeActivity : AppCompatActivity(), TimeNavigator {

    @Inject
    lateinit var viewModel: TimeViewModel

/*    @Inject
    lateinit var context: Context*/

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        val dataBinding = DataBindingUtil.setContentView<ActivityTimeBinding>(
            this,
            com.delarosa.pushnotificationmvvm.R.layout.activity_time
        )

        dataBinding.let {
            it.setLifecycleOwner(this)
            it.viewModel = viewModel
        }

    }

    override fun openPushNotification() {
        //     startActivity(Intent(context, MainActivity::class.java))
     startActivity(Intent(this@TimeActivity, MainActivity::class.java))
    }
}
