package com.neko.androidlearningproject.Search;

import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.neko.androidlearningproject.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by neko on 2/26/2016.
 */
public class SearchResultActivity extends AppCompatActivity {
    ListView listView;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_result);

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        listView = (ListView)findViewById(R.id.result_list);

        parseIntent(getIntent());


    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        parseIntent(intent);
    }

    void parseIntent(Intent intent){
        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query = intent.getStringExtra(SearchManager.QUERY);
            doMySearch(query);
        }
    }

    void doMySearch(String query){
        String[] strList = getResources().getStringArray(R.array.sample_search_texts);
        List<String> result = new ArrayList<>();
        for(String str : strList) {
            if(str.contains(query)){
                result.add(str);
            }
        }

        listView.setAdapter(new ArrayAdapter<String>(this, R.layout.listitem_entrence, result));

    }

    @Override
    public boolean onSearchRequested() {
        return super.onSearchRequested();
    }
}
