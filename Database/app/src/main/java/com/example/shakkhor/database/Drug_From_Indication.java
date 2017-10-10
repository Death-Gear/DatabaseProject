package com.example.shakkhor.database;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Drug_From_Indication extends AppCompatActivity {


    MakeDatabase helper = new MakeDatabase(this);
    Toolbar toolbar;
    ListView listView;
    ArrayAdapter<String> adapter;
    ArrayList<String> drugs;
    int indication_id;
    static String drug_name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drug__from__indication);

        toolbar = (Toolbar)findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);

        indication_id = Drug_By_Indication.getIndication_id();
        drugs = helper.getDrugByIndication(indication_id);
        listView = (ListView)findViewById(R.id.list_drug_by_indication);

        adapter = new ArrayAdapter<String>(this, R.layout.list_view_custom_layout, R.id.list_item, drugs);

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                setDrug_name(listView.getItemAtPosition(position).toString());
                Intent intent = new Intent(Drug_From_Indication.this, Drug_Activity.class);
                intent.putExtra("caller", "DrugFromIndication");
                startActivity(intent);
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
