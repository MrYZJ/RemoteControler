package com.zjianhao.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;

import com.zjianhao.entity.Device;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * DAO for table "DEVICE".
 */
public class DeviceDao extends AbstractDao<Device, Long> {

    public static final String TABLENAME = "DEVICE";

    /**
     * Properties of entity Device.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property Type_id = new Property(1, Integer.class, "type_id", false, "TYPE_ID");
        public final static Property Brand_id = new Property(2, Integer.class, "brand_id", false, "BRAND_ID");
        public final static Property Device_id = new Property(3, Integer.class, "device_id", false, "DEVICE_ID");
        public final static Property Device_name = new Property(4, String.class, "device_name", false, "DEVICE_NAME");
    }

    ;


    public DeviceDao(DaoConfig config) {
        super(config);
    }

    public DeviceDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /**
     * Creates the underlying database table.
     */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists ? "IF NOT EXISTS " : "";
        db.execSQL("CREATE TABLE " + constraint + "\"DEVICE\" (" + //
                "\"_id\" INTEGER PRIMARY KEY ," + // 0: id
                "\"TYPE_ID\" INTEGER," + // 1: type_id
                "\"BRAND_ID\" INTEGER," + // 2: brand_id
                "\"DEVICE_ID\" INTEGER," + // 3: device_id
                "\"DEVICE_NAME\" TEXT);"); // 4: device_name
    }

    /**
     * Drops the underlying database table.
     */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"DEVICE\"";
        db.execSQL(sql);
    }

    /**
     * @inheritdoc
     */
    @Override
    protected void bindValues(SQLiteStatement stmt, Device entity) {
        stmt.clearBindings();

        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }

        Integer type_id = entity.getType_id();
        if (type_id != null) {
            stmt.bindLong(2, type_id);
        }

        Integer brand_id = entity.getBrand_id();
        if (brand_id != null) {
            stmt.bindLong(3, brand_id);
        }

        Integer device_id = entity.getDevice_id();
        if (device_id != null) {
            stmt.bindLong(4, device_id);
        }

        String device_name = entity.getDevice_name();
        if (device_name != null) {
            stmt.bindString(5, device_name);
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
    public Device readEntity(Cursor cursor, int offset) {
        Device entity = new Device( //
                cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
                cursor.isNull(offset + 1) ? null : cursor.getInt(offset + 1), // type_id
                cursor.isNull(offset + 2) ? null : cursor.getInt(offset + 2), // brand_id
                cursor.isNull(offset + 3) ? null : cursor.getInt(offset + 3), // device_id
                cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4) // device_name
        );
        return entity;
    }

    /**
     * @inheritdoc
     */
    @Override
    public void readEntity(Cursor cursor, Device entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setType_id(cursor.isNull(offset + 1) ? null : cursor.getInt(offset + 1));
        entity.setBrand_id(cursor.isNull(offset + 2) ? null : cursor.getInt(offset + 2));
        entity.setDevice_id(cursor.isNull(offset + 3) ? null : cursor.getInt(offset + 3));
        entity.setDevice_name(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
    }

    /**
     * @inheritdoc
     */
    @Override
    protected Long updateKeyAfterInsert(Device entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }

    /**
     * @inheritdoc
     */
    @Override
    public Long getKey(Device entity) {
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

}
