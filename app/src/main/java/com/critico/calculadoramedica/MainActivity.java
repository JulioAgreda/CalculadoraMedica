package com.critico.calculadoramedica;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity
{

    private Spinner listaActividades;
    private ArrayAdapter sp;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        listaActividades = (Spinner)findViewById(R.id.spActividad);
        sp = ArrayAdapter.createFromResource(this, R.array.actividades , android.R.layout.simple_spinner_item);
        sp.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        listaActividades.setAdapter(sp);

    }
}
