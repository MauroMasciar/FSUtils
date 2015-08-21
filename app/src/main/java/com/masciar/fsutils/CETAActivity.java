package com.masciar.fsutils;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class CETAActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ceta);

        Button btnCalcular = (Button) findViewById(R.id.btnCalcular);
        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView MN = (TextView) findViewById(R.id.txtMN);
                TextView GS = (TextView) findViewById(R.id.txtGS);
                TextView resultado = (TextView) findViewById(R.id.txtResultado);
                try {
                    if (GS.getText().toString() == "" || MN.getText().toString() == "") {
                        Toast t = Toast.makeText(getApplicationContext(), "Introduzca valores", Toast.LENGTH_LONG);
                        t.show();
                    } else {
                        double mnRestantes = Integer.parseInt(MN.getText().toString());
                        double velGS = Integer.parseInt(GS.getText().toString());
                        double gsPM;
                        double subTotal;
                        double total;
                        gsPM = velGS / 60;
                        subTotal = mnRestantes / gsPM;
                        total = subTotal / 60;

                        resultado.setText(subTotal + " minutos aproximadamente.\n" + total + " horas aproximadamente");
                    }
                } catch(Exception ex) {
                    Toast t = Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG);
                    t.show();
                }
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_ceta, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
