package com.geekstorming.storymapper.ui.user.contracts;

import com.geekstorming.storymapper.data.pojo.User;

/**
 * Created by Beelzenef on 24/02/2018.
 */

public interface RegisterContract {

    interface View {
        void onSuccess();
        void onUserEmptyError();
        void onUsernameEmptyError();
        void onPasswordEmptyError();
        void onEmailEmptyError();
        void onPasswordError();
        void onEmailError();
        void onUserDuplicated();
        void onEmailDuplicated();
        void onUserError();
    }

    interface Presenter {
        void validateCredentials(User user);
    }

    interface Interactor
    {
        void signUp(User user);
    }
}
