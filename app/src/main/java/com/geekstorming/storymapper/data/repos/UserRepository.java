package com.geekstorming.storymapper.data.repos;

import com.geekstorming.storymapper.data.dao.UserDAOImpl;
import com.geekstorming.storymapper.data.pojo.User;

import java.util.ArrayList;

/**
 * Repository for users!
 */

public class UserRepository {

    // Atts
    private ArrayList<User> users;
    private static UserRepository userRepository;

    private UserDAOImpl userDAO;

    // Constructor
    static {
        userRepository = new UserRepository();
    }

    private UserRepository() {
        this.userDAO = new UserDAOImpl();
    }

    // Methods

    public static UserRepository getInstance() {
        return userRepository;
    }

    public boolean checkUser(String user, String password) {
        return userDAO.checkUser(user, password);
    }

    public void addUser (User user) {
        userDAO.registerUser(user);
    }

    public boolean findEmailExists(String email) {
        return userDAO.checkEmailExists(email);
    }

    public boolean findUserExists(String user) {
        return userDAO.checkUserExists(user);
    }
}
