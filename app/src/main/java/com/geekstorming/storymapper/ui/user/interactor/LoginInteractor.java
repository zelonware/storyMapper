package com.geekstorming.storymapper.ui.user.interactor;

import com.geekstorming.storymapper.data.repos.UserRepository;
import com.geekstorming.storymapper.ui.user.contracts.LoginContract;

/**
 * Created by Beelzenef on 24/02/2018.
 */

public class LoginInteractor implements LoginContract.Interactor {

    private LoginListener listener;

    public LoginInteractor(LoginListener listener) {
        this.listener = listener;
    }

    @Override
    public void validateUser(String username, String password) {
        if (UserRepository.getInstance().checkUser(username, password)) {
            listener.enterInApp();
        } else {
            listener.showErrorWrongUserPassword();
        }
    }

    public interface LoginListener {
        void enterInApp();
        void showErrorWrongUserPassword();
    }
}
