package com.example.bperez2210.bryanperezlq04;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

public class Activity1 extends AppCompatActivity {
    ArrayList<String> listaadjunta = new ArrayList<>();
    ArrayList<String> listaadjunta2 = new ArrayList<>();
    int pregunta = 0;
    int contadorP = 0;
    int contadorB = 0;
    float puntuacion = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);

        final EditText editPuntuacion = findViewById(R.id.editText4);
        editPuntuacion.setText(" " +puntuacion);

        RadioGroup radioGroup = findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rb1 = findViewById(R.id.radioButton);
                RadioButton rb2 = findViewById(R.id.radioButton2);
                if (rb1.isChecked()) {
                    contadorB+=1;
                }
                if (rb2.isChecked()) {
                }
                Button MiButton2 = findViewById(R.id.button2);
                MiButton2.setVisibility(View.GONE);

                EditText editPuntaje = findViewById(R.id.editText3);
                puntuacion = (contadorB/contadorP) * 100;
                editPuntaje.setText( " " + puntuacion);
            }
        });

        Button MiButton2 = findViewById(R.id.button2);
        MiButton2.setVisibility(View.GONE);

        ArchivoTextoAdjuntoALista();
        ArchivoTextoAdjuntoALista2();

        Button MiButton = findViewById(R.id.button);
        final EditText editPregunta = findViewById(R.id.editText);
        final EditText editRespuesta = findViewById(R.id.editText2);



        MiButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0) {
                Random rand = new Random();
                pregunta = rand.nextInt(50) + 1;
                contadorP += 1;
                editPregunta.setText(listaadjunta.get(pregunta));
                Button MiButton2 = findViewById(R.id.button2);
                MiButton2.setVisibility(View.VISIBLE);
            }
        });

        MiButton2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0) {
                editRespuesta.setText(listaadjunta2.get(pregunta));
            }
        });




    }

    private void ArchivoTextoAdjuntoALista() {
        InputStream miarchivo = getResources().openRawResource(R.raw.preguntas);
        listaadjunta.clear();
        BufferedReader br = null;
        String line;
        try {
            br = new BufferedReader(new InputStreamReader(miarchivo));
            while ((line = br.readLine()) != null) {
                listaadjunta.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {br.close();}
                catch (IOException e)
                {e.printStackTrace();}
            }
        }
        return ;
    }

    private void ArchivoTextoAdjuntoALista2() {
        InputStream miarchivo = getResources().openRawResource(R.raw.respuestas);
        listaadjunta2.clear();
        BufferedReader br = null;
        String line;
        try {
            br = new BufferedReader(new InputStreamReader(miarchivo));
            while ((line = br.readLine()) != null) {
                listaadjunta2.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {br.close();}
                catch (IOException e)
                {e.printStackTrace();}
            }
        }
        return ;
    }




}
