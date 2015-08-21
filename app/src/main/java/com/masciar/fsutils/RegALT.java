package com.masciar.fsutils;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class RegALT extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg_alt);
    }

    public void Calcular(View v) {
        EditText txtHDG = (EditText) findViewById(R.id.txtHDG);
        TextView lblResultado = (TextView) findViewById(R.id.lblResultado);

        try {
            int hdg = Integer.parseInt((txtHDG.getText().toString()));
            if(hdg > 360) {
                Toast t = Toast.makeText(this, "HDG entre 1 y 360", Toast.LENGTH_LONG);
                t.show();
            } else {
                if(hdg < 180) {
                    lblResultado.setText("IMPAR");
                } else {
                    lblResultado.setText("PAR");
                }
            }
        } catch (NumberFormatException ex) {
            Toast t = Toast.makeText(this, "Sólo números", Toast.LENGTH_LONG);
            t.show();
        } catch (Exception ex) {
            Toast t = Toast.makeText(this, "Error", Toast.LENGTH_LONG);
            t.show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_reg_alt, menu);
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
