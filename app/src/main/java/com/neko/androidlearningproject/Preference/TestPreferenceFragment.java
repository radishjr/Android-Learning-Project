package com.neko.androidlearningproject.Preference;


import android.app.Dialog;
import android.os.Build;
import android.os.Bundle;
import android.app.Fragment;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.preference.PreferenceScreen;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.neko.androidlearningproject.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class TestPreferenceFragment extends PreferenceFragment {

    public TestPreferenceFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);

    }

    MoveToPreferenceScreenHandler handler;
    interface MoveToPreferenceScreenHandler{
        void onMoveToPreferenceScreen(PreferenceScreen screen);
    }

    public void setMoveToPreferenceScreenHandler(MoveToPreferenceScreenHandler handler){
        this.handler = handler;
    }

    @Override
    public boolean onPreferenceTreeClick(PreferenceScreen preferenceScreen, Preference preference) {
        //boolean res = super.onPreferenceTreeClick(preferenceScreen, preference);
        boolean res = false;
        if(preference instanceof PreferenceScreen){
            /*if(handler!=null) {
                handler.onMoveToPreferenceScreen((PreferenceScreen) preference);
            }
            */
            setUpNestedScreen((PreferenceScreen) preference);
        }else{
            res = super.onPreferenceTreeClick(preferenceScreen, preference);
        }
        return res;
    }

    //Great answer: http://stackoverflow.com/questions/26509180/no-actionbar-in-preferenceactivity-after-upgrade-to-support-library-v21/27455363#27455363
    //The nested preference screen is a dialog.
    public void setUpNestedScreen(PreferenceScreen preferenceScreen) {
        final Dialog dialog = preferenceScreen.getDialog();

        Toolbar bar;

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH) {
            LinearLayout root = (LinearLayout) dialog.findViewById(android.R.id.list).getParent();
            bar = (Toolbar) LayoutInflater.from(getActivity()).inflate(R.layout.toolbar, root, false);
            root.addView(bar, 0); // insert at top
        } else {
            ViewGroup root = (ViewGroup) dialog.findViewById(android.R.id.content);
            ListView content = (ListView) root.getChildAt(0);

            root.removeAllViews();

            bar = (Toolbar) LayoutInflater.from(getActivity()).inflate(R.layout.toolbar, root, false);

            int height;
            TypedValue tv = new TypedValue();
            if (getActivity().getTheme().resolveAttribute(R.attr.actionBarSize, tv, true)) {
                height = TypedValue.complexToDimensionPixelSize(tv.data, getResources().getDisplayMetrics());
            }else{
                height = bar.getHeight();
            }

            content.setPadding(0, height, 0, 0);

            root.addView(content);
            root.addView(bar);
        }
        bar.setTitle(preferenceScreen.getTitle());

        bar.setNavigationIcon(R.drawable.ic_arrow_back_white_24dp);
        bar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
    }

}
