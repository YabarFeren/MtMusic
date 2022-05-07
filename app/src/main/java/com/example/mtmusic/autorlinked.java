package com.example.mtmusic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;

public class autorlinked extends AppCompatActivity {

    TextView txtDescripcion;
    ImageView imgAutor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_autorlinked);

        txtDescripcion = findViewById(R.id.txtDescripcion);
        imgAutor = findViewById(R.id.imgAutor);

        //Call extras
        int opcion_genero = getIntent().getIntExtra("opciongenero",0);
        int id_autor = getIntent().getIntExtra("idCancioncita",0);


        //Llamar lista de autores con Somearray
        List<String> some;
        if (opcion_genero==1){
            some = Arrays.asList(getResources().getStringArray(R.array.imasalsa));

        }else if (opcion_genero==2){
            some = Arrays.asList(getResources().getStringArray(R.array.imabachata));
        }else if (opcion_genero==3){
            some = Arrays.asList(getResources().getStringArray(R.array.imareggeaton));
        }else if (opcion_genero==4){
            some = Arrays.asList(getResources().getStringArray(R.array.imapop));
        }else if (opcion_genero==5){
            some = Arrays.asList(getResources().getStringArray(R.array.imahuayno));
        }else if (opcion_genero==6){
            some = Arrays.asList(getResources().getStringArray(R.array.imacumbias));
        } else {
            some = Arrays.asList(getResources().getStringArray(R.array.vacio));
        }

        //Llamar lista de descripciones con Somearray
        List<String> some_array1;
        if (opcion_genero==1){
            some_array1 = Arrays.asList(getResources().getStringArray(R.array.dessalsa));

        }else if (opcion_genero==2){
            some_array1 = Arrays.asList(getResources().getStringArray(R.array.desbachata));
        }else if (opcion_genero==3){
            some_array1 = Arrays.asList(getResources().getStringArray(R.array.desreggeaton));
        }else if (opcion_genero==4){
            some_array1 = Arrays.asList(getResources().getStringArray(R.array.despop));
        }else if (opcion_genero==5){
            some_array1 = Arrays.asList(getResources().getStringArray(R.array.deshuayno));
        } else if (opcion_genero==6){
            some_array1 = Arrays.asList(getResources().getStringArray(R.array.descumbia));
        }else {
            some_array1 = Arrays.asList(getResources().getStringArray(R.array.vacio));
        }


        //get resource iamgen y ponerla en el imgView
        String uri = some.get(id_autor);
        int imageResource = getResources().getIdentifier(uri, "drawable", getPackageName());

        Drawable res = getResources().getDrawable(imageResource);
        imgAutor.setImageDrawable(res);

        String fnm = "cat"; //  this is image file name
        String PACKAGE_NAME = getApplicationContext().getPackageName();
        int imgId = getResources().getIdentifier(PACKAGE_NAME+":drawable/"+uri , null, null);
        System.out.println("IMG ID :: "+imgId);
        System.out.println("PACKAGE_NAME :: "+PACKAGE_NAME);
//    Bitmap bitmap = BitmapFactory.decodeResource(getResources(),imgId);
        imgAutor.setImageBitmap(BitmapFactory.decodeResource(getResources(),imgId));


        //
        String descp = some_array1.get(id_autor);


        txtDescripcion.setText(descp);

    }
}