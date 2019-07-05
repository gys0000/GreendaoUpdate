package com.gystry.greendaoupdate

import android.app.Application
import android.database.sqlite.SQLiteDatabase
import com.gystry.greendaoupdate.database.greenDao.db.DaoMaster
import com.gystry.greendaoupdate.database.greenDao.db.DaoSession

class MyAppli : Application() {

    var daoSession: DaoSession? = null
        private set

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    /**
     * 初始化GreenDao,直接在Application中进行初始化操作
     */
    private fun initGreenDao() {
        val helper = DaoMaster.DevOpenHelper(this, "suipao.db")
        val db = helper.writableDatabase
        val daoMaster = DaoMaster(db)
        daoSession = daoMaster.newSession()
    }

    companion object {
        var instance: MyAppli? = null
            private set
    }
}
