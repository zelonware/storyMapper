package com.geekstorming.storymapper.ui.user;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.geekstorming.storymapper.R;
import com.geekstorming.storymapper.data.pojo.User;
import com.geekstorming.storymapper.ui.books.BookActivity;
import com.geekstorming.storymapper.ui.user.contracts.LoginContract;
import com.geekstorming.storymapper.ui.user.presenter.LoginPresenter;

/**
 * Login Activity
 * @author Elena Guzman Blanco (Beelzenef) - 3d10Mundos
 */
public class LoginActivity extends AppCompatActivity implements LoginContract.View {

    private EditText edT_User;
    private EditText edT_Password;

    LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edT_User = (EditText) findViewById(R.id.edT_User);
        edT_Password = (EditText) findViewById(R.id.edT_Passw);

        presenter = new LoginPresenter(this, this);
    }

    public void onClick_EnterApp(View v) {

        switch (v.getId()) {
            case R.id.btn_SignIn:
                presenter.trySignIn(edT_User.getText().toString(), edT_Password.getText().toString());
                break;
            case R.id.btn_SignUp:
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
                break;
        }
    }

    @Override
    public void enterUser() {
        Bundle b = new Bundle();
        b.putString(User.TAG, edT_User.getText().toString());
        Intent toLogin = new Intent(LoginActivity.this, BookActivity.class);
        toLogin.putExtras(b);
        startActivity(toLogin);
    }

    @Override
    public void showError(String error) {
        Toast.makeText(LoginActivity.this, error, Toast.LENGTH_SHORT).show();
    }
}
