package com.geekstorming.storymapper.ui.user.presenter;

import com.geekstorming.storymapper.data.pojo.User;
import com.geekstorming.storymapper.ui.user.contracts.RegisterContract;
import com.geekstorming.storymapper.ui.user.interactor.RegisterInteractor;

/**
 * Created by Beelzenef on 24/02/2018.
 */

public class RegisterPresenter implements RegisterContract.Presenter, RegisterInteractor.RegisterListener {

    RegisterContract.Interactor interactor;
    RegisterContract.View view;

    public RegisterPresenter(RegisterContract.View view) {
        this.interactor = new RegisterInteractor(this);
        this.view = view;
    }

    @Override
    public void validateCredentials(User user) {
        interactor.signUp(user);
    }

    @Override
    public void onSuccess() {
        view.onSuccess();
    }

    @Override
    public void onUserEmptyError() {
        view.onUserEmptyError();
    }

    @Override
    public void onUsernameEmptyError() {
        view.onUsernameEmptyError();
    }

    @Override
    public void onPasswordEmptyError() {
        view.onPasswordEmptyError();
    }

    @Override
    public void onEmailEmptyError() {
        view.onEmailEmptyError();
    }

    @Override
    public void onPasswordError() {
        view.onPasswordError();
    }

    @Override
    public void onEmailError() {
        view.onEmailError();
    }

    @Override
    public void onUserError() {
        view.onUserError();
    }


    @Override
    public void onUserDuplicated() {
        view.onUserDuplicated();
    }

    @Override
    public void onEmailDuplicated() {
        view.onEmailDuplicated();
    }
}
