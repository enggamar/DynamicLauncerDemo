package com.demo.dynamiclauncher.ui

import android.app.Activity
import android.content.ComponentName
import android.content.pm.PackageManager
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.os.RemoteException
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.demo.dynamiclauncher.databinding.ActivityMainBinding
import java.lang.Exception

open class DynamicLauncherActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val mBinding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(mBinding.root)
        mBinding.changeIcon.setOnClickListener {
            updateToNewIcon(this)
        }

        mBinding.oldIcon.setOnClickListener {
            updateToOldIcon(this)
        }
    }

    private fun updateToOldIcon(dynamicLauncherActivity: DynamicLauncherActivity) {
        packageManager.setComponentEnabledSetting(
            ComponentName(
                this@DynamicLauncherActivity,
                com.demo.dynamiclauncher.alias.OldLauncherAlias::class.java
            ), PackageManager.COMPONENT_ENABLED_STATE_ENABLED, PackageManager.DONT_KILL_APP
        )
        packageManager.setComponentEnabledSetting(
            ComponentName(
                this@DynamicLauncherActivity,
                com.demo.dynamiclauncher.alias.NewLauncherAlias::class.java
            ), PackageManager.COMPONENT_ENABLED_STATE_DISABLED, PackageManager.DONT_KILL_APP
        )
        Toast.makeText(
            this@DynamicLauncherActivity,
            "Launcher one has been applied successfully",
            Toast.LENGTH_SHORT
        ).show()
    }

    fun updateToNewIcon(context: Activity) {
        packageManager.setComponentEnabledSetting(
            ComponentName(
                this@DynamicLauncherActivity,
                com.demo.dynamiclauncher.alias.OldLauncherAlias::class.java
            ), PackageManager.COMPONENT_ENABLED_STATE_DISABLED, PackageManager.DONT_KILL_APP
        )
        packageManager.setComponentEnabledSetting(
            ComponentName(
                this@DynamicLauncherActivity,
                com.demo.dynamiclauncher.alias.NewLauncherAlias::class.java
            ), PackageManager.COMPONENT_ENABLED_STATE_ENABLED, PackageManager.DONT_KILL_APP
        )

        Toast.makeText(
            this@DynamicLauncherActivity,
            "Launcher one has been applied successfully",
            Toast.LENGTH_SHORT
        ).show()
    }

}