package com.critico.calculadoramedica.activity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.icu.util.Calendar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import com.critico.calculadoramedica.MainActivity;
import com.critico.calculadoramedica.R;

public class CalendarioActivity extends AppCompatActivity
{
    private DatePicker dp;
    Button bfecha;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendario);

        dp = (DatePicker)findViewById(R.id.dpDia);
        bfecha=(Button)findViewById(R.id.btnCalendario);

        bfecha.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                /*
                dia = ""+dp.getDayOfMonth();
                mes = ""+dp.getMonth();
                ano = ""+dp.getYear();
                 */
                String fecha ="Dia/Mes/Año";

                Intent intent = new Intent(getApplicationContext(), MainActivity.class);

                /*
                intent.putExtra("Dia", dia);
                intent.putExtra("Mes", mes);
                intent.putExtra("Ano", ano);
                */
                intent.putExtra("Fecha", fecha);
                startActivity(intent);
            }
        });

    }


}
