package com.gystry.greendaoupdate

import android.app.Application
import android.util.Log
import com.gystry.greendaoupdate.database.greenDao.db.DaoMaster
import com.gystry.greendaoupdate.database.greenDao.db.DaoSession
import com.gystry.greendaoupdate.greendarutil.MyDaoMaster

class MyApp : Application() {
    var newSession: DaoSession? = null
        private set

    override fun onCreate() {
        super.onCreate()
        instance = this
        initGreenDao()
    }

    private fun initGreenDao() {
        val helper = MyDaoMaster(this, "gystry.db")
        val db = helper.writableDatabase
        val daoMaster = DaoMaster(db)
        newSession = daoMaster.newSession()
        Log.e("MyApp", "initGreenDao:" + newSession)
    }

    public fun getDaoSession(): DaoSession? {
        Log.e("MyApp", "" + newSession)
        return newSession
    }

    companion object {
        var instance: MyApp? = null
            private set
    }
}
