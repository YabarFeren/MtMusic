package com.example.mtmusic;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class seleccion_genero extends AppCompatActivity {

    TextView tituloGenero, cancion1txt, cancion2txt, cancion3txt, cancion4txt, cancion5txt;
    ListView vista;
    int opcion;

    String tituloG;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccion_genero);

        tituloGenero=findViewById(R.id.tituloGenero);
        vista = findViewById(R.id.list_songs);


        tituloG = getIntent().getStringExtra("titulo");
        opcion = getIntent().getIntExtra("opcion",0);
        tituloGenero.setText(tituloG);
        List<String>some_array;

        if (opcion==1){
            some_array = Arrays.asList(getResources().getStringArray(R.array.salsa));

        }else if (opcion==2){
            some_array = Arrays.asList(getResources().getStringArray(R.array.bachata));
        }else if (opcion==3){
            some_array = Arrays.asList(getResources().getStringArray(R.array.reggeaton));
        }else if (opcion==4){
            some_array = Arrays.asList(getResources().getStringArray(R.array.pop));
        }else if (opcion==5){
            some_array = Arrays.asList(getResources().getStringArray(R.array.huayno));
        } else if (opcion==6){
            some_array = Arrays.asList(getResources().getStringArray(R.array.cumbia));
        } else {
            some_array = Arrays.asList(getResources().getStringArray(R.array.vacio));
        }

        ArrayAdapter<CharSequence> adapter;
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, some_array);

        vista.setAdapter(adapter);

        vista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Intent intent = new Intent(seleccion_genero.this,playermusic.class);
                intent.putExtra("position", position);
                intent.putExtra("opcion1", opcion);
                startActivity(intent);
            }
        });



    }
}