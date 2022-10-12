package com.example.utsprakandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText emailInput = (EditText) findViewById(R.id.emailInput);
        EditText passwordInput = (EditText) findViewById(R.id.inputPassword);
        Button loginButton = (Button) findViewById(R.id.buttonLogin);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String password = String.valueOf(passwordInput.getText());
                String email = String.valueOf(emailInput.getText());

                if ((email.equals("mike@email.com")) && (password.equals("abc123"))) {
                    //make a new intent and go to the next activity
                    Intent intent = new Intent(getApplicationContext(), FindHotel.class);

                    Toast.makeText(getApplicationContext(), "Welcome!, mike@email.com!", Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                }
                else {
                    //show alert button
                    AlertDialog.Builder someAlert = new AlertDialog.Builder(MainActivity.this);

                    someAlert.setTitle("Login Failed!");
                    someAlert.setMessage("Username atau Password Salah!, Silahkan mencoba untuk login lagi");

                    someAlert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            // User clicked OK button.
                        }
                    });

                    someAlert.show();
                }
            }
        });

    }
}
