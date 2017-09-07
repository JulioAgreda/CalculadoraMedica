package com.critico.calculadoramedica.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.critico.calculadoramedica.R;

public class ResultadosActivity extends AppCompatActivity
{
    private TextView tmb, cmp, cbp, csp, imc, pg, mg, msg;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultados);

        tmb = (TextView)findViewById(R.id.txtTmb);
        cmp = (TextView)findViewById(R.id.txtCmp);
        cbp = (TextView)findViewById(R.id.txtCbp);
        csp = (TextView)findViewById(R.id.txtCsp);
        imc = (TextView)findViewById(R.id.txtImc);
        pg = (TextView)findViewById(R.id.txtPg);
        mg = (TextView)findViewById(R.id.txtMdg);
        msg = (TextView)findViewById(R.id.txtMsg);

        int intTmb = getIntent().getIntExtra("tmb", 0);
        int intCmp = getIntent().getIntExtra("cmp", 0);
        int intCbp = getIntent().getIntExtra("cbp", 0);
        int intCsp = getIntent().getIntExtra("csp", 0);
        int intImc = getIntent().getIntExtra("imc", 0);
        int intPg = getIntent().getIntExtra("pg", 0);
        int intMg = getIntent().getIntExtra("mg", 0);
        int intMsg = getIntent().getIntExtra("msg", 0);

        tmb.setText(""+intTmb);
        cmp.setText(""+intCmp);
        cbp.setText(""+intCbp);
        csp.setText(""+intCsp);


    }
}
