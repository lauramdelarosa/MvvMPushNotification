package com.delarosa.pushnotificationmvvm.view

import android.arch.lifecycle.Observer
import android.content.Context
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.delarosa.pushnotificationmvvm.databinding.ActivityTimeBinding
import com.delarosa.pushnotificationmvvm.viewModel.TimeViewModel
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_time.*
import javax.inject.Inject


class TimeActivity : AppCompatActivity() {

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

        viewModel.showNotificationPanelCompletion.observe(this, Observer {
            startActivity(Intent(this, MainActivity::class.java))
        })

    }
}
