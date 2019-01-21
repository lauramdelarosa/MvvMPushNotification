package com.delarosa.pushnotificationmvvm.view

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.support.v4.content.LocalBroadcastManager
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.widget.LinearLayout
import com.delarosa.pushnotificationmvvm.R
import com.delarosa.pushnotificationmvvm.model.database.DataBaseHandler
import com.delarosa.pushnotificationmvvm.model.services.REFRESH_UI
import com.delarosa.pushnotificationmvvm.viewModel.NotificationAdapter
import com.google.firebase.messaging.FirebaseMessaging
import dagger.android.AndroidInjection

class MainActivity : AppCompatActivity() {
    private var TAG = "MyFirebase"
    lateinit var recyclerView: RecyclerView
    lateinit var db: DataBaseHandler

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.notification_recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, true)

        db = DataBaseHandler(this)

        getFirebaseInstance()
        buildNotificationList()


        val localBroadcastManager = LocalBroadcastManager.getInstance(this)
        localBroadcastManager.registerReceiver(object : BroadcastReceiver() {
            override fun onReceive(context: Context, intent: Intent) {
                buildNotificationList()
            }

        }, IntentFilter(REFRESH_UI))
    }

    private fun buildNotificationList() {
        val adapter = NotificationAdapter(db.readData())

        recyclerView.adapter = adapter
    }

    private fun getFirebaseInstance() {

        FirebaseMessaging.getInstance().isAutoInitEnabled = true
        if (intent.extras != null) {
            Log.d(com.delarosa.pushnotificationmvvm.model.services.TAG, "intent : " + intent.extras)
        }
    }
}
