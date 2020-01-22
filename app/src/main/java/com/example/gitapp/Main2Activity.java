package com.example.gitapp;

import androidx.appcompat.app.AppCompatActivity;
import java.util.Date;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Spinner ine ;
    Spinner filliere ;
    Spinner vacation ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        TextView userB = (TextView) findViewById(R.id.user);
        Bundle B = getIntent().getExtras();
        String user = B.getString("username");
        userB.setText(user);

        //date show
        Date date = new Date();
        TextView d = (TextView) findViewById(R.id.date);
        d.setText(date.toString());


        ine = (Spinner) findViewById(R.id.spinner1);
        filliere = (Spinner) findViewById(R.id.spinner2);
        vacation = (Spinner) findViewById(R.id.spinner3);
        //ine spinner
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this, R.array.ine,android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ine.setAdapter(adapter1);
        ine.setOnItemSelectedListener(this);


        //filliere spinner
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.filliere,android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        filliere.setAdapter(adapter2);
        filliere.setOnItemSelectedListener(this);


        //vacation spinner
        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(this, R.array.vacation,android.R.layout.simple_spinner_item);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        vacation.setAdapter(adapter3);
        vacation.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(),text, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void recherche(View view) {
        Intent myIntnt2 = new Intent(this, Main3Activity.class);
        Bundle B = new Bundle();
        myIntnt2.putExtra("ine", ine.getItemAtPosition(ine.getSelectedItemPosition()).toString());
        myIntnt2.putExtra("fillier", filliere.getItemAtPosition(filliere.getSelectedItemPosition()).toString());
        myIntnt2.putExtra("vacation", vacation.getItemAtPosition(vacation.getSelectedItemPosition()).toString());
        startActivity(myIntnt2);

    }
}
