package com.example.gitapp;

import android.os.StrictMode;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UtilisateurDAO {
    private PreparedStatement statement;
    public static final String url="jdbc:mysql://localhost:3306/absence?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC";
    public static final String utilisateur = "inpt";
    public static final String motDePass = "inpt";
    public static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";

    public ResultSet getrs(String annee,String filliere) throws  SQLException {

        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Connection conex = DriverManager.getConnection(url, utilisateur, motDePass);
        statement = conex.prepareStatement("SELECT * FROM etudiant where annee=? and  filliere=? ");
        statement.setString(1, annee);
        statement.setString(2, filliere);
        ResultSet rs  = statement.executeQuery();

        return rs;
    }
}