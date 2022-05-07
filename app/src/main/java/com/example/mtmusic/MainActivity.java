package com.example.mtmusic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    String titulo=" ";
    Button btnSalsa, btnBachata, btnReggeaton, btnPop, btnHuayno, btnCumbia;
    int opcion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSalsa = (Button) findViewById(R.id.btnSalsa);
        btnBachata = (Button) findViewById(R.id.btnBachata);
        btnReggeaton = (Button) findViewById(R.id.btnReggeaton);
        btnPop = (Button) findViewById(R.id.btnPop);
        btnHuayno = (Button) findViewById(R.id.btnHuayno);
        btnCumbia = findViewById(R.id.btnCumbia);

        btnSalsa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                titulo = "Salsa";
                opcion = 1;
                Intent intent = new Intent(MainActivity.this,seleccion_genero.class);
                intent.putExtra("titulo",titulo);
                intent.putExtra("opcion", opcion);
                startActivity(intent);
            }
        });

        btnBachata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                titulo = "Bachata";
                opcion = 2;
                Intent intent = new Intent(MainActivity.this,seleccion_genero.class);
                intent.putExtra("titulo",titulo);
                intent.putExtra("opcion", opcion);
                startActivity(intent);
            }
        });

        btnReggeaton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                titulo = "Reggeaton";
                opcion = 3;
                Intent intent = new Intent(MainActivity.this,seleccion_genero.class);
                intent.putExtra("titulo",titulo);
                intent.putExtra("opcion", opcion);
                startActivity(intent);
            }
        });


        btnPop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                titulo = "Pop";
                opcion = 4;
                Intent intent = new Intent(MainActivity.this,seleccion_genero.class);
                intent.putExtra("titulo",titulo);
                intent.putExtra("opcion", opcion);
                startActivity(intent);
            }
        });


        btnHuayno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                titulo = "Huayno";
                opcion = 5;
                Intent intent = new Intent(MainActivity.this,seleccion_genero.class);
                intent.putExtra("titulo",titulo);
                intent.putExtra("opcion", opcion);
                startActivity(intent);
            }
        });

        btnCumbia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                titulo = "Cumbia";
                opcion = 6;
                Intent intent = new Intent(MainActivity.this,seleccion_genero.class);
                intent.putExtra("titulo",titulo);
                intent.putExtra("opcion", opcion);
                startActivity(intent);
            }
        });

    }


}