package com.yair.radamuebleria;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class registro_producto extends AppCompatActivity {
    private Spinner lineas, claves;
    private Button enviar,regresar;
    EditText cantidad, autoriza;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.agregar_producto);

        lineas = (Spinner) findViewById(R.id.spnlinea);
        claves = (Spinner) findViewById(R.id.spnclaveproducto);
        enviar = (Button) findViewById(R.id.btnregistroentrada);
        regresar = (Button) findViewById(R.id.btnregresohome);
        cantidad = (EditText) findViewById(R.id.CantidadEntra);
        autoriza = (EditText) findViewById(R.id.nombreautoriza);

        ArrayAdapter spinAdap = ArrayAdapter.createFromResource(this, R.array.tipolinea, android.R.layout.simple_spinner_item);

        lineas.setAdapter(spinAdap);

        lineas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> lista, View view, int pos, long id) {
                if (lista.getItemAtPosition(pos).equals("Colchones")) {
                    ArrayAdapter listaadapter = ArrayAdapter.createFromResource(registro_producto.this, R.array.Colchones, android.R.layout.simple_list_item_1);
                    claves.setAdapter(listaadapter);
                }
                if (lista.getItemAtPosition(pos).equals("Camas")) {
                    ArrayAdapter listaadapter = ArrayAdapter.createFromResource(registro_producto.this, R.array.Camas, android.R.layout.simple_list_item_1);
                    claves.setAdapter(listaadapter);

                }
                if (lista.getItemAtPosition(pos).equals("Bicicletas")) {
                    ArrayAdapter listaadapter = ArrayAdapter.createFromResource(registro_producto.this, R.array.Bicicletas, android.R.layout.simple_list_item_1);
                    claves.setAdapter(listaadapter);

                }
                if (lista.getItemAtPosition(pos).equals("Enseres")) {
                    ArrayAdapter listaadapter = ArrayAdapter.createFromResource(registro_producto.this, R.array.Enseres, android.R.layout.simple_list_item_1);
                    claves.setAdapter(listaadapter);

                }
                if (lista.getItemAtPosition(pos).equals("Electronica")) {
                    ArrayAdapter listaadapter = ArrayAdapter.createFromResource(registro_producto.this, R.array.Electronica, android.R.layout.simple_list_item_1);
                    claves.setAdapter(listaadapter);

                }
                if (lista.getItemAtPosition(pos).equals("Linea blanca")) {
                    ArrayAdapter listaadapter = ArrayAdapter.createFromResource(registro_producto.this, R.array.LineaBlanca, android.R.layout.simple_list_item_1);
                    claves.setAdapter(listaadapter);

                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }


        });
    }
}
