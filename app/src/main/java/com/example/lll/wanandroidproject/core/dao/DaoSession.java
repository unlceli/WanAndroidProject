package com.example.lll.wanandroidproject.core.dao;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import java.util.Map;

public class DaoSession extends AbstractDaoSession {

    private final DaoConfig historyDataDaoConfig;
    private final HistoryDataDao histroyDataDao;
    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?,?>>,DaoConfig> daoConfigMap) {
        super(db);
        historyDataDaoConfig =daoConfigMap.get(HistoryDataDao.class).clone();
        historyDataDaoConfig.initIdentityScope(type);
        histroyDataDao =new HistoryDataDao(historyDataDaoConfig,this);
        new HistoryDataDao(historyDataDaoConfig,this);
    }
}
