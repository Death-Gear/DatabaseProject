package com.example.shakkhor.database;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class DoctorActivity extends AppCompatActivity {

    MakeDatabase helper = new MakeDatabase(this);
    ListView listView;
    ArrayAdapter<String> adapter;
    ArrayList<String> doctors;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor);

        toolbar = (Toolbar)findViewById(R.id.app_bar);
        toolbar.setTitle("Call a doctor");
        setSupportActionBar(toolbar);

        doctors = helper.getDoctor(My_Visiting_Card.expertise);
        listView = (ListView)findViewById(R.id.list_doctor);
        adapter = new ArrayAdapter<String>(this, R.layout.list_view_custom_layout, R.id.list_item, doctors);

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Intent callIntent = new Intent(Intent.ACTION_CALL);
                String number = helper.getNumber(doctors.get(position));
                //number = "tel:"+ number;
                //callIntent.setData(Uri.parse(number));
                dialContactPhone(number);
            }
        });
    }
    private void dialContactPhone(final String phoneNumber) {
        startActivity(new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phoneNumber, null)));
    }
}
