package com.geekstorming.storymapper.utils;

import com.geekstorming.storymapper.data.dao.BookDAO;
import com.geekstorming.storymapper.data.pojo.Book;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import java.util.Map;

/**
 * Created by Beelzenef on 11/02/2018.
 */

public class DaoSession extends AbstractDaoSession {

    private final DaoConfig userDaoConfig;

    private final BookDAO bookDAO;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        userDaoConfig = daoConfigMap.get(BookDAO.class).clone();
        userDaoConfig.initIdentityScope(type);

        bookDAO = new BookDAO(userDaoConfig, this);

        registerDao(Book.class, bookDAO);
    }

    public void clear() {
        userDaoConfig.getIdentityScope().clear();
    }

    public BookDAO getBookDAO() {
        return bookDAO;
    }
}
