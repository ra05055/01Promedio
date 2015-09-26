package com.example.eliseo.promedio;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    EditText nota1, nota2, nota3, promedio;
    DecimalFormat df;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        df = new DecimalFormat("0.00");

        nota1 = (EditText) findViewById(R.id.nota1);
        nota2 = (EditText) findViewById(R.id.nota2);
        nota3 = (EditText) findViewById(R.id.nota3);
        promedio = (EditText) findViewById(R.id.promedio);

        promedio.setEnabled(false);

    }

    public void btnPromedio(View v) {
        double n1, n2, n3;

        try {

            n1 = Double.valueOf(nota1.getText().toString());
            n2 = Double.valueOf(nota2.getText().toString());
            n3 = Double.valueOf(nota3.getText().toString());
            if (n1 < 0 || n1 > 10) {
                Toast.makeText(getBaseContext(), "Nota1 incorrecta", Toast.LENGTH_SHORT).show();
                nota1.setText("");
                nota1.requestFocus();
            } else if (n2 < 0 || n2 > 10) {
                Toast.makeText(getBaseContext(), "Nota2 incorrecta", Toast.LENGTH_SHORT).show();
                nota2.setText("");
                nota2.requestFocus();
            } else if (n3 < 0 || n3 > 10) {
                Toast.makeText(getBaseContext(), "Nota3 incorrecta", Toast.LENGTH_SHORT).show();
                nota3.setText("");
                nota3.requestFocus();
            } else
                promedio.setText("" + df.format((n1 + n2 + n3) / 3.0));

        } catch (Exception e) {
            Toast.makeText(getBaseContext(), "Error" + e.getMessage(), Toast.LENGTH_SHORT).show();

        }
    }

    public void btnSalir(View v) {
        msg("Desea Salir de la Aplicacion?");

    }

    public void msg(String msg1) {
        AlertDialog.Builder dialogo = new AlertDialog.Builder(this);
        dialogo.setTitle("Promedio");
        dialogo.setMessage(msg1);
        dialogo.setCancelable(false);//modal
        dialogo.setPositiveButton("Si", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();

            }
        });
        dialogo.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        dialogo.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
