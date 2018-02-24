package com.geekstorming.storymapper.ui.user.presenter;

import android.content.Context;

import com.geekstorming.storymapper.R;
import com.geekstorming.storymapper.ui.user.contracts.LoginContract;
import com.geekstorming.storymapper.ui.user.interactor.LoginInteractor;

/**
 * LoginPresenter
 */

public class LoginPresenter implements LoginContract.Presenter, LoginInteractor.LoginListener {

    private LoginContract.Interactor interactor;
    private LoginContract.View view;
    private Context context;

    public LoginPresenter(LoginContract.View view, Context context) {
        this.interactor = new LoginInteractor(this);
        this.view = view;
        this.context = context;
    }

    @Override
    public void trySignIn(String username, String password) {
        interactor.validateUser(username, password);
    }

    @Override
    public void enterInApp() {
        view.enterUser();
    }

    @Override
    public void showErrorWrongUserPassword() {
        view.showError(context.getResources().getString(R.string.errorWrongUserPassword));
    }

}
