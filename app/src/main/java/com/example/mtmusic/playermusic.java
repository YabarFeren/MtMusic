package com.example.mtmusic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

import java.util.Arrays;
import java.util.List;

public class playermusic extends AppCompatActivity {

    Button btnCentral, btnNext, btnBefore, btnAutor;
    SeekBar progressSong;

    MediaPlayer mdPlayer;
    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playermusic);

        btnAutor = findViewById(R.id.btnAutor);

        int id = getIntent().getIntExtra("position",0);
        int opcion = getIntent().getIntExtra("opcion1", 0);

        List<String>some_array;
        if (opcion==1){
            some_array = Arrays.asList(getResources().getStringArray(R.array.salsita));

        }else if (opcion==2){
            some_array = Arrays.asList(getResources().getStringArray(R.array.bachatitas));
        }else if (opcion==3){
            some_array = Arrays.asList(getResources().getStringArray(R.array.reggeatoncitos));
        }else if (opcion==4){
            some_array = Arrays.asList(getResources().getStringArray(R.array.popcitos));
        }else if (opcion==5){
            some_array = Arrays.asList(getResources().getStringArray(R.array.huaynitos));
        } else if (opcion==6){
            some_array = Arrays.asList(getResources().getStringArray(R.array.cumbion));
        }else {
            some_array = Arrays.asList(getResources().getStringArray(R.array.vacio));
        }
        Resources res = getResources();

        String music = some_array.get(id);
        int sound = res.getIdentifier(music, "raw", getPackageName());
        mdPlayer = MediaPlayer.create(this, sound);

        mdPlayer.start();

        btnCentral = findViewById(R.id.btnCentral);
        btnNext = findViewById(R.id.btnNext);
        btnBefore = findViewById(R.id.btnBefore);
        progressSong = findViewById(R.id.skSong);

        btnCentral.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mdPlayer.isPlaying()) {
                    mdPlayer.pause();
                    btnCentral.setBackground(getResources().getDrawable(R.drawable.playo));
                } else {
                    mdPlayer.start();
                    btnCentral.setBackground(getResources().getDrawable(R.drawable.pause));
                }

            }
        });



        btnAutor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent itnt = new Intent(playermusic.this, autorlinked.class );
                itnt.putExtra("opciongenero", opcion);
                itnt.putExtra("idCancioncita", id);
                startActivity(itnt);
            }
        });

    }



    public void run() {
            int currentPosition = mdPlayer.getCurrentPosition();
            int total = mdPlayer.getDuration();
            while (mdPlayer != null && mdPlayer.isPlaying() && currentPosition < total) {
                try {
                    Thread.sleep(1000);
                    currentPosition = mdPlayer.getCurrentPosition();
                } catch (InterruptedException e) {
                    return;
                } catch (Exception e) {
                    return;
                }

                progressSong.setProgress(currentPosition);

        }
    };

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        mdPlayer.stop();
    }
}