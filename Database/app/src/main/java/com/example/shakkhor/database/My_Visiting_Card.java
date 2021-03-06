package com.example.shakkhor.database;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class My_Visiting_Card extends AppCompatActivity {

    MakeDatabase helper = new MakeDatabase(this);
    ListView listView;
    ArrayAdapter<String> adapter;
    ArrayList<String> expertises;
    Toolbar toolbar;
    public static int expertise_id;
    public static String expertise;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my__visiting__card);
        //Toast.makeText(My_Visiting_Card.this, "My Visiting Card Activity", Toast.LENGTH_LONG).show();

        toolbar = (Toolbar)findViewById(R.id.app_bar);
        toolbar.setTitle("Choose An Area Of Expertise");
        setSupportActionBar(toolbar);

        expertises = helper.getExpertise();
        listView = (ListView)findViewById(R.id.list_expertise);
        adapter = new ArrayAdapter<String>(this, R.layout.list_view_custom_layout, R.id.list_item, expertises);

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                expertise_id = position;
                expertise = expertises.get(expertise_id);
                Intent intent = new Intent(My_Visiting_Card.this, DoctorActivity.class);
                startActivity(intent);
            }
        });
    }
}
