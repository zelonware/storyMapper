package com.geekstorming.storymapper.ui.settings;

import android.preference.PreferenceActivity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.geekstorming.storymapper.R;

public class SettingsActivity extends PreferenceActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.settings);
    }
}
