package com.demo.dynamiclauncherdemo.utils

import android.app.Activity
import android.content.ComponentName
import android.content.pm.PackageManager
import com.demo.dynamiclauncher.alias.NewLauncherAlias
import com.demo.dynamiclauncher.alias.OldLauncherAlias

object DynamicLauncherUtils {

    fun updateToNewIcon(context: Activity) {
        context.packageManager.setComponentEnabledSetting(
            ComponentName(
                context,
                NewLauncherAlias::class.java
            ), PackageManager.COMPONENT_ENABLED_STATE_ENABLED, PackageManager.DONT_KILL_APP
        )
        context.packageManager.setComponentEnabledSetting(
            ComponentName(
                context,
                OldLauncherAlias::class.java
            ), PackageManager.COMPONENT_ENABLED_STATE_DISABLED, PackageManager.DONT_KILL_APP
        )
    }

    fun updateToOldIcon(context: Activity) {
        context.packageManager.setComponentEnabledSetting(
            ComponentName(
                context,
                OldLauncherAlias::class.java
            ), PackageManager.COMPONENT_ENABLED_STATE_ENABLED, PackageManager.DONT_KILL_APP
        )
        context.packageManager.setComponentEnabledSetting(
            ComponentName(
                context,
                NewLauncherAlias::class.java
            ), PackageManager.COMPONENT_ENABLED_STATE_DISABLED, PackageManager.DONT_KILL_APP
        )

    }
}