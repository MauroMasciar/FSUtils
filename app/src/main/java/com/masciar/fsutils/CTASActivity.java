package com.masciar.fsutils;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class CTASActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ctas);
        Button btnCalcular = (Button) findViewById(R.id.btnCalcular);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                EditText kias = (EditText) findViewById(R.id.txtKIAS);
                EditText fl = (EditText) findViewById(R.id.txtFL);
                if (kias.getText().toString() == "" && fl.getText().toString() == "") {
                    Toast t1 = Toast.makeText(getApplicationContext(), "Introduzca valores", Toast.LENGTH_LONG);
                    t1.show();
                } else {
                    int ias = Integer.parseInt(kias.getText().toString());
                    int vfl = Integer.parseInt(fl.getText().toString());

                    if(vfl > 50) {
                        int subFL = vfl / 2;
                        int total = ias + subFL;

                        TextView tvResultado = (TextView) findViewById(R.id.tvResultado);
                        tvResultado.setText("La TAS es: " + total);
                    } else if (ias < 240 && vfl < 50) {
                        int lowIasFl = vfl / 10;
                        double pIAS = ias * 1.5 / 100;
                        double total = ias + (pIAS * lowIasFl);

                        TextView tvResultado = (TextView) findViewById(R.id.tvResultado);
                        tvResultado.setText("La TAS es: " + total);
                    } else if (ias < 240 && vfl > 50) {
                        int subFL = vfl / 2;
                        int total = ias + subFL;

                        TextView tvResultado = (TextView) findViewById(R.id.tvResultado);
                        tvResultado.setText("La TAS es: " + total);
                    } else {
                        Toast t1 = Toast.makeText(getApplicationContext(), "Introduzca valores / Datos erroneos", Toast.LENGTH_LONG);
                        t1.show();
                    }
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_cta, menu);
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
