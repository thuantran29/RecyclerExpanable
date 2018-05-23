package com.example.thuannguyen.recyclerexpanable.custome;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;

import com.example.thuannguyen.recyclerexpanable.R;

public class RecyclerActivity extends AppCompatActivity {
    RecyclerView recycler;
    PeopleAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);

        recycler = (RecyclerView) findViewById(R.id.main_recycler);

        adapter = new PeopleAdapter(this);
        adapter.setMode(ExpandableRecyclerAdapter.MODE_ACCORDION);
        recycler.setLayoutManager(new LinearLayoutManager(this));
        recycler.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);

        getMenuInflater().inflate(R.menu.menu_main, menu);

        return true;
    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()) {
//            case R.id.action_expand_all:
//                adapter.expandAll();
//                return true;
//            case R.id.action_collapse_all:
//                adapter.collapseAll();
//                return true;
//            default:
//                return super.onOptionsItemSelected(item);
//        }
//    }
}
