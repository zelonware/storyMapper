package com.geekstorming.storymapper.ui.user.interactor;

import com.geekstorming.storymapper.data.pojo.User;
import com.geekstorming.storymapper.data.repos.UserRepository;
import com.geekstorming.storymapper.ui.user.contracts.RegisterContract;
import com.geekstorming.storymapper.utils.EmailChecker;

/**
 * Created by Beelzenef on 24/02/2018.
 */

public class RegisterInteractor implements RegisterContract.Interactor {

    RegisterListener listener;
    EmailChecker checkerEmail = new EmailChecker();

    public RegisterInteractor(RegisterListener listener) {
        this.listener = listener;
    }

    @Override
    public void signUp(User user) {
        if (user.getUser().isEmpty()) {
            listener.onUserEmptyError();
        }
        else if (user.getPassword().isEmpty()) {
            listener.onPasswordEmptyError();
        }
        else if (user.getEmail().isEmpty()) {
            listener.onEmailEmptyError();
        }
        else if (user.getUser().length() < 6) {
            listener.onUserError();
        }
        else if (user.getUsername().isEmpty()) {
            listener.onUsernameEmptyError();
        }
        else if (user.getPassword().length() < 6) {
            listener.onPasswordError();
        }
        else if (!checkerEmail.validate(user.getEmail())) {
            listener.onEmailError();
        }
        else if (UserRepository.getInstance().findUserExists(user.getUser())) {
            listener.onUserDuplicated();
        }
        else if (UserRepository.getInstance().findEmailExists(user.getEmail())) {
            listener.onEmailDuplicated();
        }
        else {
            UserRepository.getInstance().addUser(user);
            listener.onSuccess();
        }
    }

    public interface RegisterListener {
        void onSuccess();
        void onUserEmptyError();
        void onUsernameEmptyError();
        void onPasswordEmptyError();
        void onEmailEmptyError();
        void onPasswordError();
        void onEmailError();
        void onUserError();
        void onUserDuplicated();
        void onEmailDuplicated();
    }
}
