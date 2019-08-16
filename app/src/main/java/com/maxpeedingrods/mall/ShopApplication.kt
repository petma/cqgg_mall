package com.maxpeedingrods.mall

import android.app.Application
import android.os.StrictMode
import com.osama.firecrasher.FireCrasher
import com.tencent.bugly.crashreport.CrashReport

class ShopApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        //enabledStrictMode()
        //bugly注册
        CrashReport.initCrashReport(getApplicationContext(), "77e4d3ae78", BuildConfig.DEBUG)
        CrashReport.setIsDevelopmentDevice(getApplicationContext(), BuildConfig.DEBUG)
        //崩溃后重启
        FireCrasher.install(this)
    }

    private fun enabledStrictMode() {
        StrictMode.setThreadPolicy(
            StrictMode.ThreadPolicy.Builder()
                .detectAll()
                .penaltyLog()
                .penaltyDeath()
                .build()
        )
        StrictMode.setVmPolicy(StrictMode.VmPolicy.Builder()
            .detectLeakedSqlLiteObjects()
            .detectLeakedClosableObjects()
            .penaltyLog()
            .penaltyDeath()
            .build())

    }
}