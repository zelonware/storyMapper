package com.geekstorming.storymapper.ui.user;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.geekstorming.storymapper.R;
import com.geekstorming.storymapper.data.pojo.User;
import com.geekstorming.storymapper.ui.user.contracts.RegisterContract;
import com.geekstorming.storymapper.ui.user.presenter.RegisterPresenter;

public class RegisterActivity extends AppCompatActivity implements RegisterContract.View {

    Button btn_SignUp;

    EditText edT_User;
    EditText edT_Username;
    EditText edT_Pasword;
    EditText edT_Email;

    RegisterPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        edT_Email = (EditText) findViewById(R.id.edT_EmailSignUp);
        edT_User = (EditText) findViewById(R.id.edT_UserSignUp);
        edT_Username = (EditText) findViewById(R.id.edT_UsernameSignUp);
        edT_Pasword = (EditText) findViewById(R.id.edT_PasswordSignUp);

        presenter = new RegisterPresenter(this);

        btn_SignUp = (Button) findViewById(R.id.btn_SignUp);
        btn_SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.validateCredentials(new User(edT_Username.getText().toString(),
                        edT_User.getText().toString(),
                        edT_Email.getText().toString(),
                        edT_Pasword.getText().toString()));
            }
        });
    }

    @Override
    public void onSuccess() {
        finish();
    }

    @Override
    public void onUserEmptyError() {
        Toast.makeText(this,getResources().getString(R.string.userEmptyError),Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUsernameEmptyError() {
        Toast.makeText(this,getResources().getString(R.string.usernameEmptyError),Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPasswordEmptyError() {
        Toast.makeText(this,getResources().getString(R.string.passwordEmptyError),Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onEmailEmptyError() {
        Toast.makeText(this,getResources().getString(R.string.emailEmptyError),Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPasswordError() {
        Toast.makeText(this,getResources().getString(R.string.passwordError),Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onEmailError() {
        Toast.makeText(this,getResources().getString(R.string.emailError),Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUserDuplicated() {
        Toast.makeText(this,getResources().getString(R.string.userAlreadyExits),Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onEmailDuplicated() {
        Toast.makeText(this,getResources().getString(R.string.emailAlreadyExits),Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUserError() {
        Toast.makeText(this,getResources().getString(R.string.userError),Toast.LENGTH_SHORT).show();
    }
}
