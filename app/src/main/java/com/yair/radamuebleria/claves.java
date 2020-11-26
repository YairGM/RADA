package com.yair.radamuebleria;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

public class claves extends Activity {
    private Spinner lineas;
    private ListView codigos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.claves);

        lineas=(Spinner)findViewById(R.id.linea);
        codigos=(ListView)findViewById(R.id.list_view_codigos);

        ArrayAdapter spinAdap=ArrayAdapter.createFromResource(this,R.array.tipolinea, android.R.layout.simple_spinner_item);

        lineas.setAdapter(spinAdap);

        lineas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> lista, View view, int pos, long id) {
                if(lista.getItemAtPosition(pos).equals("Colchones")){
                    ArrayAdapter listaadapter = ArrayAdapter.createFromResource(claves.this, R.array.Colchones, android.R.layout.simple_list_item_1);
                    codigos.setAdapter(listaadapter);
                }
                if(lista.getItemAtPosition(pos).equals("Camas")){
                    ArrayAdapter listaadapter = ArrayAdapter.createFromResource(claves.this, R.array.Camas, android.R.layout.simple_list_item_1);
                    codigos.setAdapter(listaadapter);

                }
                if(lista.getItemAtPosition(pos).equals("Bicicletas")){
                    ArrayAdapter listaadapter = ArrayAdapter.createFromResource(claves.this, R.array.Bicicletas, android.R.layout.simple_list_item_1);
                    codigos.setAdapter(listaadapter);

                }
                if(lista.getItemAtPosition(pos).equals("Enseres")){
                    ArrayAdapter listaadapter = ArrayAdapter.createFromResource(claves.this, R.array.Enseres, android.R.layout.simple_list_item_1);
                    codigos.setAdapter(listaadapter);

                }
                if(lista.getItemAtPosition(pos).equals("Electronica")){
                    ArrayAdapter listaadapter = ArrayAdapter.createFromResource(claves.this, R.array.Electronica, android.R.layout.simple_list_item_1);
                    codigos.setAdapter(listaadapter);

                }
                if(lista.getItemAtPosition(pos).equals("Linea blanca")){
                    ArrayAdapter listaadapter = ArrayAdapter.createFromResource(claves.this, R.array.LineaBlanca, android.R.layout.simple_list_item_1);
                    codigos.setAdapter(listaadapter);

                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}
