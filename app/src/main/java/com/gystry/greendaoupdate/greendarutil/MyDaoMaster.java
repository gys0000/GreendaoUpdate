package com.gystry.greendaoupdate.greendarutil;


import android.content.Context;
import com.gystry.greendaoupdate.database.greenDao.db.DaoMaster;
import com.gystry.greendaoupdate.database.greenDao.db.StudentDao;
import org.greenrobot.greendao.database.Database;

public class MyDaoMaster extends DaoMaster.OpenHelper {
    public MyDaoMaster(Context context, String name) {
        super(context, name);
    }

    @Override
    public void onUpgrade(Database db, int oldVersion, int newVersion) {
        super.onUpgrade(db, oldVersion, newVersion);
        MigrationHelper.migrate(db, new MigrationHelper.ReCreateAllTableListener() {
            @Override
            public void onCreateAllTables(Database db, boolean ifNotExists) {
                DaoMaster.createAllTables(db, ifNotExists);
            }

            @Override
            public void onDropAllTables(Database db, boolean ifExists) {
                DaoMaster.dropAllTables(db, ifExists);
            }
        }, StudentDao.class);
    }

}
