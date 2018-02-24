package com.geekstorming.storymapper.ui.user.contracts;

/**
 * Created by Beelzenef on 24/02/2018.
 */

public interface LoginContract {
    interface View{
        void enterUser();
        void showError(String error);
    }

    interface Presenter{
        void trySignIn(String user, String passw);
    }

    interface Interactor
    {
        void validateUser(String user, String passw);
    }

}
