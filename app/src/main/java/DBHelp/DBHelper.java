package DBHelp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import zhangtao.bwie.com.lgank.gen.DaoMaster;
import zhangtao.bwie.com.lgank.gen.DaoSession;
import zhangtao.bwie.com.lgank.gen.LishiBeanDao;

/**
 * Created by ZhangTAO on 2017/12/8.
 */

public class DBHelper {
    private static volatile DBHelper instance;
    private final LishiBeanDao dao;

    private DBHelper(Context context) {
        DaoMaster.DevOpenHelper helper = new DaoMaster
                .DevOpenHelper(context, "lishi", null);
        SQLiteDatabase db = helper.getWritableDatabase();
        DaoMaster daoMaster = new DaoMaster(db);
        DaoSession daoSession = daoMaster.newSession();
        dao = daoSession.getLishiBeanDao();
    }
    public static DBHelper getInstance(Context context) {
        if(instance == null) {
            synchronized (DBHelper.class) {
                if(null == instance) {
                    instance = new DBHelper(context);
                }
            }
        }
            return instance;
    }
    public LishiBeanDao getDao() {
        return dao;
    }
}
