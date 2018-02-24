package com.geekstorming.storymapper.base.daos;

import com.geekstorming.storymapper.data.pojo.User;

/**
 * Users DAO
 */

public interface UserDAO {

    boolean checkUser(String user, String password);
    void registerUser (User user);
    boolean checkUserExists(String user);
    boolean checkEmailExists(String email);
}
