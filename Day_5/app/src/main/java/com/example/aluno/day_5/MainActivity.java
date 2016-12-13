package com.example.aluno.day_5;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;

import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnTime = (Button) findViewById(R.id.btn_time);
        btnTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar time = Calendar.getInstance();

                int hora = time.get(Calendar.HOUR_OF_DAY);
                int minuto = time.get(Calendar.MINUTE);

                TimePickerDialog timePickerDialog;
                timePickerDialog = new TimePickerDialog(MainActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

                    }
                }, hora, minuto, true);
                timePickerDialog.setTitle("Escolha a hora");
                timePickerDialog.show();
            }
        });

        Button btnDate = (Button) findViewById(R.id.btn_date);
        btnDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int day = calendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this, new mDateSetListener(), year, month, day);
                datePickerDialog.show();
            }
        });

        Button btnProgress = (Button) findViewById(R.id.btn_progress);
        btnProgress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProgressDialog progressDialog = ProgressDialog.show(MainActivity.this, "Carregando", "Carregando o app...");
                progressDialog.setCancelable(true);
            }
        });

        Button btnAlert = (Button) findViewById(R.id.btn_alert);
        btnAlert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Hello World")
                        .setMessage("Ola Mundo")
                        .setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        })
                        .setNegativeButton("Nao", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        })
                        .setCancelable(false)
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();
            }
        });
    }

    class mDateSetListener implements DatePickerDialog.OnDateSetListener{
        @Override
        public void onDateSet(DatePicker datePicker, int i, int i1, int i2){
            Log.e("gustavo", i + " " + i1 + " " + i2);
        }
    }



}
