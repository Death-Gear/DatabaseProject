package com.example.shakkhor.database;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

public class Search extends AppCompatActivity {

    MakeDatabase helper = new MakeDatabase(this);
    Toolbar toolbar;
    ListView listView;
    ArrayAdapter<String> adapter;
    ArrayList<String> drugs;
    SearchView searchView;
    static String drug_name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        toolbar = (Toolbar)findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        //Toast.makeText(Search.this, "Search Activity", Toast.LENGTH_LONG).show();
        searchView = (SearchView) findViewById(R.id.search_view);

        drugs = helper.getDrugs();
        Collections.sort(drugs);

        listView = (ListView)findViewById(R.id.list_drug);
        adapter = new ArrayAdapter<String>(this, R.layout.list_view_custom_layout, R.id.list_item, drugs);

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                setDrug_name(listView.getItemAtPosition(position).toString());
                Intent intent = new Intent(Search.this, Drug_Activity.class);
                intent.putExtra("caller", "Search");
                startActivity(intent);
            }
        });

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String text) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String text) {
                adapter.getFilter().filter(text);

                return false;
            }
        });
    }

    public static String getDrug_name() {
        return drug_name;
    }

    public void setDrug_name(String drug_name) {
        this.drug_name = drug_name;
    }
}
