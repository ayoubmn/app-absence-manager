package com.example.gitapp;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.WindowManager;
import android.widget.TextView;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main3Activity extends AppCompatActivity {
    UtilisateurDAO dao= new UtilisateurDAO();
    ResultSet rs  ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);


        //get bundel

        Bundle C = getIntent().getExtras();
        String annee = C.getString("ine");
        String filliere = C.getString("fillier");
        String vacation = C.getString("vacation");



        // initialiser les variable
        TextView[]  noms = new TextView[40];
        TextView[]  prenoms = new TextView[40];

        for (int j = 0; j < 40; j++) {
            String viewnom = "nom" + (j + 1);
            String viewprenom = "prenom" + (j + 1);
            int resnom = getResources().getIdentifier(viewnom, "id", getPackageName());
            int resprenom = getResources().getIdentifier(viewprenom, "id", getPackageName());

            noms[j] = ((TextView) findViewById(resnom));
            prenoms[j] = ((TextView) findViewById(resprenom));
        }

        //application de requette
        try {
            rs = dao.getrs(annee,filliere);
            int a =0;
            while(rs.next()) {
                a++;
                String nom = rs.getString("nom");
                String prenom = rs.getString("prenom");
                noms[a].setText(nom);
                prenoms[a].setText(prenom);
            }
            Statement l = rs.getStatement();
            Connection n = l.getConnection();
            rs.close();
            l.close();
            n.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }



    }


}
