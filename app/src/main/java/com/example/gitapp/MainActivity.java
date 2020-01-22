package com.example.gitapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    public void button(View view) {
        EditText userB = (EditText) findViewById(R.id.editText);
        EditText passB = (EditText) findViewById(R.id.editText2);
        Button login = (Button) findViewById(R.id.button);
        String username = (String) userB.getText().toString();
        String password = (String) passB.getText().toString();
        if (password.length()<8){
            Toast.makeText(this,"le mot de pass necessite 8 caractere ou plus",Toast.LENGTH_LONG).show();
        }else
            login.setText("try again");

        if ((username.equals("a") ) & ( password.equals("a"))){
            Intent myIntnt = new Intent(this,Main2Activity.class);
            Bundle b = new Bundle();
            myIntnt.putExtra("username", userB.getText().toString());
            startActivity(myIntnt);


        }





    }
}
