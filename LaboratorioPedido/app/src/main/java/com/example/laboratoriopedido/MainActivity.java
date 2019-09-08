package com.example.laboratoriopedido;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText edt_msj;
    Button btn_enviar;

    CheckBox check1;
    CheckBox check2;
    CheckBox check3;
    ArrayList<String> mResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mResult = new ArrayList<>();
        check1 = (CheckBox) findViewById(R.id.checkBox1);
        check2 = (CheckBox) findViewById(R.id.checkBox2);
        check3 = (CheckBox) findViewById(R.id.checkBox3);

        check1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(check1.isChecked()){
                    mResult.add(check1.getText().toString());
                }else{
                    mResult.remove(check1.getText().toString());
                }
            }
        });

        check2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(check2.isChecked()){
                    mResult.add(check2.getText().toString());
                }else{
                    mResult.remove(check2.getText().toString());
                }
            }
        });

        check3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(check3.isChecked()){
                    mResult.add(check3.getText().toString());
                }else{
                    mResult.remove(check3.getText().toString());
                }
            }
        });

        ((Button)findViewById(R.id.btn_enviar)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(mResult == null || mResult.size() == 0)
                {
                    Toast.makeText(getApplicationContext(),"Por favor seleccione una opcion o mas",Toast.LENGTH_SHORT).show();
                }else{
                    Intent sendIntent = new Intent();
                    sendIntent.setAction(Intent.ACTION_SEND);
                    sendIntent.putStringArrayListExtra(Intent.EXTRA_TEXT, mResult);
                    sendIntent.setType("text/plain");
                    if(null != sendIntent.resolveActivity(getPackageManager())){
                        startActivity(Intent.createChooser(sendIntent, "Share images to.."));
                        /*startActivity(Intent.createChooser(sendIntent,getResources().getText(R.string.send_to)));*/
                    }
                }



            }
        });

    }




}
