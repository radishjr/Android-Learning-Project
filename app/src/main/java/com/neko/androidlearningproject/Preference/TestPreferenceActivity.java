package com.neko.androidlearningproject.Preference;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.preference.PreferenceScreen;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.neko.androidlearningproject.R;

public class TestPreferenceActivity extends AppCompatActivity {
    TestPreferenceFragment fragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preference);

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);

        final FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        fragment = new TestPreferenceFragment();
        fragment.setMoveToPreferenceScreenHandler(new TestPreferenceFragment.MoveToPreferenceScreenHandler() {
            @Override
            public void onMoveToPreferenceScreen(PreferenceScreen screen) {
                FragmentTransaction ft = fm.beginTransaction();
                TestSubPreferenceFragment f = new TestSubPreferenceFragment();
                f.setCurrentPreferenceScreen(screen);

                ft.replace(R.id.preference_fragment, f)
                        .addToBackStack(null)
                        .commit();
            }
        });
        ft.replace(R.id.preference_fragment, fragment)
            .commit();
    }

    @Override
    public void onBackPressed() {
        if(getFragmentManager().getBackStackEntryCount() == 0) {
            super.onBackPressed();
        }else {
            getFragmentManager().popBackStack();
        }
    }

    @Override
    public void startActivity(Intent intent) {
        super.startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_preference, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
