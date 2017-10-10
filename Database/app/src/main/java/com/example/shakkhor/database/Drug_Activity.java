package com.example.shakkhor.database;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;
import android.widget.Toast;

public class Drug_Activity extends AppCompatActivity {


    Toolbar toolbar;
    String name;
    TextView drug_name;
    String parent;
    MakeDatabase helper = new MakeDatabase(this);
    String company,form,strength,indication,classs;
    TextView drug_company, drug_form, drug_strength, drug_indication, drug_class;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drug);

        toolbar = (Toolbar)findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);

        parent = getIntent().getStringExtra("caller").toString();
        if(parent.equals("DrugFromIndication")){
            name = Drug_From_Indication.getDrug_name();
        }
        else if(parent.equals("DrugFromClass")){
            name = Drug_From_Class.getDrug_name();
        }
        else if(parent.equals("Search")){
            name = Search.getDrug_name();
        }

        company = helper.getCompany(name);
        form = helper.getForm(name);
        strength = helper.getStrength(name);
        indication = helper.getIndication(name);
        classs = helper.getClass(name);

        //Toast.makeText(Drug_Activity.this, parent, Toast.LENGTH_LONG).show();
        drug_company = (TextView)findViewById(R.id.drug_company);
        drug_company.setText(company, null);
        drug_name = (TextView) findViewById(R.id.drug_name);
        drug_name.setText(name, null);
        drug_form = (TextView) findViewById(R.id.drug_form);
        drug_form.setText(form, null);
        drug_strength = (TextView) findViewById(R.id.drug_strength);
        drug_strength.setText(strength, null);
        drug_indication = (TextView) findViewById(R.id.indicaion);
        drug_indication.setText("Indication: "+indication, null);
        drug_class = (TextView)findViewById(R.id.drug_class);
        drug_class.setText("Class: " + classs, null);
    }
}
