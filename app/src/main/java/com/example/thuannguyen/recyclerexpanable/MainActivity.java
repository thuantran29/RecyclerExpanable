package com.example.thuannguyen.recyclerexpanable;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ExpanalbeAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(getClass().getSimpleName());

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        // RecyclerView has some built in animations to it, using the DefaultItemAnimator.
        // Specifically when you call notifyItemChanged() it does a fade animation for the changing
        // of the data in the ViewHolder. If you would like to disable this you can use the following:
        RecyclerView.ItemAnimator animator = recyclerView.getItemAnimator();
        if (animator instanceof DefaultItemAnimator) {
            ((DefaultItemAnimator) animator).setSupportsChangeAnimations(false);
        }

        adapter = new ExpanalbeAdapter(makeGenres());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        Button clear = (Button) findViewById(R.id.toggle_button);
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter.toggleGroup(makeClassicGenre());
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        adapter.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        adapter.onRestoreInstanceState(savedInstanceState);
    }

    public static Genre makeClassicGenre() {
        return new Genre("Classic", makeClassicArtists(), R.drawable.ic_violin);
    }

    public static List<Artist> makeClassicArtists() {
        Artist beethoven = new Artist("Ludwig van Beethoven", false);
        Artist bach = new Artist("Johann Sebastian Bach", true);
        Artist brahms = new Artist("Johannes Brahms", false);
        Artist puccini = new Artist("Giacomo Puccini", false);

        return Arrays.asList(beethoven, bach, brahms, puccini);
    }

    public static List<Genre> makeGenres() {
        return Arrays.asList(
                makeJazzGenre(),
                makeClassicGenre());
    }

    public static Genre makeJazzGenre() {
        return new Genre("Jazz", makeSalsaArtists(), R.drawable.ic_saxaphone);
    }

    public static List<Artist> makeSalsaArtists() {
        Artist hectorLavoe = new Artist("Hector Lavoe", true);
        Artist celiaCruz = new Artist("Celia Cruz", false);
        Artist willieColon = new Artist("Willie Colon", false);
        Artist marcAnthony = new Artist("Marc Anthony", false);

        return Arrays.asList(hectorLavoe, celiaCruz, willieColon, marcAnthony);
    }

}
