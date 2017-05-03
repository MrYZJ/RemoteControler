package com.zjianhao.dao;

import android.database.sqlite.SQLiteDatabase;

import com.zjianhao.entity.AirCmd;
import com.zjianhao.entity.Device;
import com.zjianhao.entity.Keyas;

import java.util.Map;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.AbstractDaoSession;
import de.greenrobot.dao.identityscope.IdentityScopeType;
import de.greenrobot.dao.internal.DaoConfig;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 *
 * @see de.greenrobot.dao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig deviceDaoConfig;
    private final DaoConfig keyasDaoConfig;
    private final DaoConfig airCmdDaoConfig;

    private final DeviceDao deviceDao;
    private final KeyasDao keyasDao;
    private final AirCmdDao airCmdDao;

    public DaoSession(SQLiteDatabase db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        deviceDaoConfig = daoConfigMap.get(DeviceDao.class).clone();
        deviceDaoConfig.initIdentityScope(type);

        keyasDaoConfig = daoConfigMap.get(KeyasDao.class).clone();
        keyasDaoConfig.initIdentityScope(type);

        airCmdDaoConfig = daoConfigMap.get(AirCmdDao.class).clone();
        airCmdDaoConfig.initIdentityScope(type);

        deviceDao = new DeviceDao(deviceDaoConfig, this);
        keyasDao = new KeyasDao(keyasDaoConfig, this);
        airCmdDao = new AirCmdDao(airCmdDaoConfig, this);

        registerDao(Device.class, deviceDao);
        registerDao(Keyas.class, keyasDao);
        registerDao(AirCmd.class, airCmdDao);
    }

    public void clear() {
        deviceDaoConfig.getIdentityScope().clear();
        keyasDaoConfig.getIdentityScope().clear();
        airCmdDaoConfig.getIdentityScope().clear();
    }

    public DeviceDao getDeviceDao() {
        return deviceDao;
    }

    public KeyasDao getKeyasDao() {
        return keyasDao;
    }


    public AirCmdDao getAirCmdDao() {
        return airCmdDao;
    }

}
