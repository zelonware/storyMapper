package com.geekstorming.storymapper;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

/**
 * @author Elena Guzman Blanco (Beelzenef) - 3d10Mundos
 */
public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
    }

    public void onClick_EnterApp (View v) {

        Intent unIntent = null;

        switch (v.getId()) {
            case R.id.btn_SignIn:
                unIntent = new Intent(LoginActivity.this, BooksActivity.class);
                break;
        }

        startActivity(unIntent);
    }
}
