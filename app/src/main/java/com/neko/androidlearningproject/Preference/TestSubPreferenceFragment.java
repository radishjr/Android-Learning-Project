package com.neko.androidlearningproject.Preference;


import android.app.Fragment;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.preference.PreferenceScreen;

import com.neko.androidlearningproject.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class TestSubPreferenceFragment extends PreferenceFragment {
    PreferenceScreen screen;
    public TestSubPreferenceFragment() {
        // Required empty public constructor
    }

    public void setCurrentPreferenceScreen(PreferenceScreen screen){
        this.screen = screen;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setPreferenceScreen(screen);
    }
}
