package com.example.priya_000.leapyear;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText text;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = (EditText) findViewById(R.id.et);
        btn = (Button) findViewById(R.id.btn);

        btn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if (text.length() < 4) {
                            Toast.makeText(MainActivity.this, "Please insert the full year", Toast.LENGTH_SHORT).show();
                        } else if (text.length() > 4) {
                            Toast.makeText(MainActivity.this, "Please insert a valid year", Toast.LENGTH_SHORT).show();
                        } else {
                            leap();
                        }
                    }

                    private void leap() {

                        int a = Integer.parseInt(text.getText().toString());
                        if (a % 4 == 0) {
                            showAlert1();
                        } else {
                            showAlert2();
                        }

                    }
                }
        );
    }

    private void showAlert1() {
        AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setTitle("The year you entered is a");
        alertDialog.setMessage("Leap Year");
        alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();
    }

    private void showAlert2() {
        AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setTitle("The year you entered is ");
        alertDialog.setMessage("Not a Leap Year");

        alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();
    }

}
