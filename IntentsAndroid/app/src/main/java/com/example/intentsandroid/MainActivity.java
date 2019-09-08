package com.example.intentsandroid;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static int CAMERA_PIC_REQUEST = 100;

    private ListView listview;
    private ArrayList<String> mResult;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        String action = intent.getAction();
        String type = intent.getType();

        if(Intent.ACTION_SEND.equals(action) && type != null){
            if("text/plain".equals(type)){
                manipulartexto(intent);
            }
        }

        final int [] imagenes = new int[] {R.drawable.hel_chocolate,R.drawable.hel_fresa,R.drawable.hel_vainilla};
        listview = (ListView)findViewById(R.id.listaHelados);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, mResult);
        listview.setAdapter(arrayAdapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                String name = adapterView.getItemAtPosition(position).toString();
                if(name.equals("Helado de Chocolate")){

                    TextView titulo=(TextView)findViewById(R.id.textTitulo);
                    TextView ingredientes=(TextView)findViewById(R.id.textIngredientes);
                    TextView cuerpo=(TextView)findViewById(R.id.textDescripcion);
                    ImageView imagen=(ImageView)findViewById(R.id.imageHelado);

                    titulo.setText("Helado de Chocolate");
                    ingredientes.setText("Ingredientes \n" +
                            "250 ml de crema para batir Parve \n"+
                            "3/4 taza de azúcar \n"+
                            "3 huevos separados \n"+
                            "1 cucharadita de vainilla \n"+
                            "50 gs de chocolate parve rallado \n");
                    cuerpo.setText("Descripcion \n" +
                            "Batir la crema hasta que se formen picos" +
                            "Agregar las yemas, vainilla y azúcar y chocolate, batir bien" +
                            "Batir las claras a punto de nieve" +
                            "Combinar las claras con la mezcla anterior" +
                            "Congelar tapado de plastico");
                    imagen.setImageResource(imagenes[0]);
                }
                if(name.equals("Helado de Fresa")){
                    TextView titulo=(TextView)findViewById(R.id.textTitulo);
                    TextView ingredientes=(TextView)findViewById(R.id.textIngredientes);
                    TextView cuerpo=(TextView)findViewById(R.id.textDescripcion);
                    ImageView imagen=(ImageView)findViewById(R.id.imageHelado);

                    titulo.setText("Helado de Fresa");
                    ingredientes.setText("Ingredientes \n" +
                            "4 tazas de fresas \n"+
                            "1 taza de azúcar \n"+
                            "3 claras de huevo \n"+
                            "2 cucharadas de jugo de limón o de naranja \n");
                    cuerpo.setText("Descripcion \n" +
                            "Se lavan bien las fresas, se les quita el pedúnculo y las hojitas, se cortan bien pequeñitas, no deshechas y se les agrega el azúcar por encima y el jugo de limón o de naranja, se deja reposar." +
                            "Aparte se baten las claras a punto de nieve y se echan de forma envolvente a las fresas ya molidas y se congela es bueno ponerlo primero en un tazón, después de unas horas en el freezer se saca, se vuelve a batir y se vuelve a congelar, otra hora mas se saca y se vuelve a batir y congelar.....y luego se deja en un pyrex tapado hasta la hora de servir ");
                    imagen.setImageResource(imagenes[1]);
                }
                if(name.equals("Helado de Vainilla")){
                    TextView titulo=(TextView)findViewById(R.id.textTitulo);
                    TextView ingredientes=(TextView)findViewById(R.id.textIngredientes);
                    TextView cuerpo=(TextView)findViewById(R.id.textDescripcion);
                    ImageView imagen=(ImageView)findViewById(R.id.imageHelado);

                    titulo.setText("Helado de Vainilla");
                    ingredientes.setText("Ingredientes \n" +
                            "16 onzas de crema para batir parve \n"+
                            "4 huevos \n"+
                            "1/2 taza de azúcar \n"+
                            "2 cucharaditas de vainilla \n");
                    cuerpo.setText("Descripcion \n" +
                            "Batir la crema hasta que se formen picos "+
                            "Agregar los huevos, azúcar y vainilla, batir bien "+
                            "Congelar tapado con plastico ");
                    imagen.setImageResource(imagenes[2]);
                }
            }
        });
    }

    public void manipulartexto(Intent intent){
        mResult = intent.getStringArrayListExtra(Intent.EXTRA_TEXT);
        if (mResult != null) {
            StringBuilder stringBuilder = new StringBuilder();
            for (String a : mResult){
                stringBuilder.append(a).append("\n");
            }

        }

    }

}
