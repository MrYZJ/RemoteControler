package com.zjianhao.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import com.zjianhao.entity.AirCmd;

import java.util.List;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * DAO for table "AIR_CMD".
 */
public class AirCmdDao extends AbstractDao<AirCmd, Long> {

    public static final String TABLENAME = "AIR_CMD";

    /**
     * Properties of entity AirCmd.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property Device_id = new Property(1, Integer.class, "device_id", false, "DEVICE_ID");
        public final static Property Cmd = new Property(2, String.class, "cmd", false, "CMD");
        public final static Property Temp = new Property(3, Integer.class, "temp", false, "TEMP");
        public final static Property Data = new Property(4, String.class, "data", false, "DATA");
    }

    ;


    public AirCmdDao(DaoConfig config) {
        super(config);
    }

    public AirCmdDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /**
     * Creates the underlying database table.
     */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists ? "IF NOT EXISTS " : "";
        db.execSQL("CREATE TABLE " + constraint + "\"AIR_CMD\" (" + //
                "\"_id\" INTEGER PRIMARY KEY ," + // 0: id
                "\"DEVICE_ID\" INTEGER," + // 1: device_id
                "\"CMD\" TEXT," + // 2: cmd
                "\"TEMP\" INTEGER," + // 3: temp
                "\"DATA\" TEXT);"); // 4: data
    }

    /**
     * Drops the underlying database table.
     */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"AIR_CMD\"";
        db.execSQL(sql);
    }

    /**
     * @inheritdoc
     */
    @Override
    protected void bindValues(SQLiteStatement stmt, AirCmd entity) {
        stmt.clearBindings();

        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }

        Integer device_id = entity.getDevice_id();
        if (device_id != null) {
            stmt.bindLong(2, device_id);
        }

        String cmd = entity.getCmd();
        if (cmd != null) {
            stmt.bindString(3, cmd);
        }

        Integer temp = entity.getTemp();
        if (temp != null) {
            stmt.bindLong(4, temp);
        }

        String data = entity.getData();
        if (data != null) {
            stmt.bindString(5, data);
        }
    }

    /**
     * @inheritdoc
     */
    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }

    /**
     * @inheritdoc
     */
    @Override
    public AirCmd readEntity(Cursor cursor, int offset) {
        AirCmd entity = new AirCmd( //
                cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
                cursor.isNull(offset + 1) ? null : cursor.getInt(offset + 1), // device_id
                cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // cmd
                cursor.isNull(offset + 3) ? null : cursor.getInt(offset + 3), // temp
                cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4) // data
        );
        return entity;
    }

    /**
     * @inheritdoc
     */
    @Override
    public void readEntity(Cursor cursor, AirCmd entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setDevice_id(cursor.isNull(offset + 1) ? null : cursor.getInt(offset + 1));
        entity.setCmd(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setTemp(cursor.isNull(offset + 3) ? null : cursor.getInt(offset + 3));
        entity.setData(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
    }

    /**
     * @inheritdoc
     */
    @Override
    protected Long updateKeyAfterInsert(AirCmd entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }

    /**
     * @inheritdoc
     */
    @Override
    public Long getKey(AirCmd entity) {
        if (entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    /**
     * @inheritdoc
     */
    @Override
    protected boolean isEntityUpdateable() {
        return true;
    }

    public AirCmd getAirCmd(int deviceId, String cmd, String temp) {
        List<AirCmd> list = queryBuilder().where(Properties.Device_id.eq(deviceId),
                Properties.Cmd.eq(cmd),
                Properties.Temp.eq(temp)).list();
        if (list.size() > 0)
            return list.get(0);
        return null;
    }

    public List<AirCmd> getAirCmd(int deviceId, String cmd) {
        return queryBuilder().where(Properties.Device_id.eq(deviceId),
                Properties.Cmd.eq(cmd)).list();

    }

}
