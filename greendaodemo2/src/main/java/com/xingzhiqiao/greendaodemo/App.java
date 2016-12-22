package com.xingzhiqiao.greendaodemo;

import android.app.Application;

import com.xingzhiqiao.dao.gen.DaoMaster;
import com.xingzhiqiao.dao.gen.DaoSession;

import org.greenrobot.greendao.database.Database;

/**
 * Created by xingzhiqiao on 2016/12/22.
 */

public class App extends Application {


    /**
     * A flag to show how easily you can switch from standard SQLite to the encrypted SQLCipher.
     */
    public static final boolean ENCRYPTED = false;

    private DaoSession daoSession;

    public static App mInstace;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstace = this;

        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, ENCRYPTED ? "notes-db-encrypted" : "notes-db");
        Database db = ENCRYPTED ? helper.getEncryptedWritableDb("super-secret") : helper.getWritableDb();
        daoSession = new DaoMaster(db).newSession();
    }

    public DaoSession getDaoSession() {
        return daoSession;
    }

    public static App getInstace() {
        return mInstace;
    }
}
