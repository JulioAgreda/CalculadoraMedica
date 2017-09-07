package com.critico.calculadoramedica;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;

import com.critico.calculadoramedica.activity.ResultadosActivity;

public class MainActivity extends AppCompatActivity
{

    private Spinner listaActividades;
    private ArrayAdapter sp;

    private Button calendario;
    private Button calculadora;
    private Button calcular;
    private EditText peso;
    private EditText estatura;
    private EditText edad;
    private RadioButton rgbHombre;
    private RadioButton rgbMujer;

    private int mb;
    private int cmp;
    private int cb;
    private int cs;

    private int varEstatura;
    private int varPeso;
    private int varEdad;
    private String actividad;



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Agregando la lista al Spinner
        listaActividades = (Spinner) findViewById(R.id.spActividad);
        sp = ArrayAdapter.createFromResource(this, R.array.actividades, android.R.layout.simple_spinner_item);
        sp.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        listaActividades.setAdapter(sp);

        calcular = (Button) findViewById(R.id.btnCalcular);

        calcular.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                peso = (EditText) findViewById(R.id.txtPeso);
                estatura = (EditText) findViewById(R.id.txtEstatura);
                // Aca va el Valor de Edad
                rgbHombre = (RadioButton) findViewById(R.id.rbHombre);
                rgbMujer = (RadioButton) findViewById(R.id.rbMujer);

                varPeso = Integer.valueOf(peso.getText().toString());
                varEstatura = Integer.valueOf(estatura.getText().toString());
                //varEdad = Integer.valueOf(edad.getText().toString());
                varEdad = 31;

                actividad = listaActividades.getSelectedItem().toString();

                if (rgbHombre.isChecked())
                {
                    double db;
                    //  Obteniendo el Metabolismo Basal
                    db = (10 * varPeso) + (6.25 * varEstatura) - (5 * varEdad) + 5;
                    mb = (int) db;

                    actividadSeleccionada();

                    bajarSubirCalorias(mb);

                    enviarDatos();

                    //Toast.makeText(MainActivity.this, selec, Toast.LENGTH_SHORT).show();
                }

                if (rgbMujer.isChecked())
                {
                    double db;
                    //  Obteniendo el Metabolismo Basal
                    db = (10 * varPeso) + (6.25 * varEstatura) - (5 * varEdad) - 161;
                    mb = (int) db;

                    actividadSeleccionada();

                    bajarSubirCalorias(mb);

                    enviarDatos();
                }
            }
        });
    }

    public void actividadSeleccionada()
    {
        switch(actividad)
        {
            // Calorias para mantener el peso
            case "Sedentario":
                double c = mb * 1.2;
                cmp = (int)c;
                break;

            case "Actividad Moderada":
                double d = mb * 1.375;
                cmp = (int) d;
                break;

            case "Actividad Intensa":
                double a = mb * 1.55;
                cmp = (int) a;
                break;

            case "Actividad Muy Intensa":
                double b = mb * 1.725;
                cmp = (int) b;
                break;
        }
    }

    public void bajarSubirCalorias(int mb)
    {
        // Calorias para bajar de peso
        cb = (int)cmp - (cmp*15/100);
        // Calorias para subir de peso
        cs = (int)cmp + (cmp*15/100);
    }


    public void enviarDatos()
    {
        Intent intent = new Intent(getApplicationContext(), ResultadosActivity.class);

        intent.putExtra("tmb", mb);
        intent.putExtra("cmp", cmp);
        intent.putExtra("cbp", cb);
        intent.putExtra("csp", cs);

        startActivity(intent);
    }
}
