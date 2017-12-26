package zhangtao.bwie.com.lgank.gen;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import Bean.LishiBean;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "LISHI_BEAN".
*/
public class LishiBeanDao extends AbstractDao<LishiBean, Long> {

    public static final String TABLENAME = "LISHI_BEAN";

    /**
     * Properties of entity LishiBean.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Cid = new Property(0, Long.class, "cid", true, "_id");
        public final static Property Edittext = new Property(1, String.class, "edittext", false, "EDITTEXT");
    };


    public LishiBeanDao(DaoConfig config) {
        super(config);
    }
    
    public LishiBeanDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"LISHI_BEAN\" (" + //
                "\"_id\" INTEGER PRIMARY KEY ," + // 0: cid
                "\"EDITTEXT\" TEXT);"); // 1: edittext
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"LISHI_BEAN\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, LishiBean entity) {
        stmt.clearBindings();
 
        Long cid = entity.getCid();
        if (cid != null) {
            stmt.bindLong(1, cid);
        }
 
        String edittext = entity.getEdittext();
        if (edittext != null) {
            stmt.bindString(2, edittext);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, LishiBean entity) {
        stmt.clearBindings();
 
        Long cid = entity.getCid();
        if (cid != null) {
            stmt.bindLong(1, cid);
        }
 
        String edittext = entity.getEdittext();
        if (edittext != null) {
            stmt.bindString(2, edittext);
        }
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public LishiBean readEntity(Cursor cursor, int offset) {
        LishiBean entity = new LishiBean( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // cid
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1) // edittext
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, LishiBean entity, int offset) {
        entity.setCid(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setEdittext(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(LishiBean entity, long rowId) {
        entity.setCid(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(LishiBean entity) {
        if(entity != null) {
            return entity.getCid();
        } else {
            return null;
        }
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}