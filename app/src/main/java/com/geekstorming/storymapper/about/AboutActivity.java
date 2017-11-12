package com.geekstorming.storymapper.about;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.geekstorming.storymapper.R;

import mehdi.sakout.aboutpage.AboutPage;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        View view = new AboutPage(this)
                .isRTL(false)
                .setImage(R.drawable.user)
                .addGroup("¡Conecta conmigo!")
                .addEmail("elena.guzbla@gmail.com")
                .addWebsite("https://about.me/Beelzenef/")
                .addTwitter("beelzenef_")
                .addGitHub("Beelzenef")
                .addInstagram("beelzenef_")
                .create();

        setContentView(view);
    }
}
