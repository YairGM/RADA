package com.yair.radamuebleria;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.UUID;

import androidx.appcompat.app.AppCompatActivity;

public class registro_producto extends AppCompatActivity {
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

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
        regresar = (Button) findViewById(R.id.btnregresohomeAgregar);
        cantidad = (EditText) findViewById(R.id.CantidadEntra);
        autoriza = (EditText) findViewById(R.id.nombreautoriza);
        regresar = (Button) findViewById(R.id.btnregresohomeAgregar);

        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                enviarRegistro();
            }
        });

        regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(registro_producto.this,MainActivity.class));
            }
        });

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
        inicializarFirebase();

    }

    private void inicializarFirebase() {
        FirebaseApp.initializeApp(this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        //firebaseDatabase.setPersistenceEnabled(true);
        databaseReference = firebaseDatabase.getReference();
    }

    private void enviarRegistro() {
        String Lineas = lineas.getSelectedItem().toString();
        String Claves = claves.getSelectedItem().toString();
        String Cantidad = cantidad.getText().toString();
        String Autoriza = autoriza.getText().toString();

        if (lineas.equals("")||claves.equals("")||cantidad.equals("")||autoriza.equals("")){
            validacion();
        }
        else {
            entrada p = new entrada();
            p.setUid(UUID.randomUUID().toString());
            p.setlinea(Lineas);
            p.setclaveproducto(Claves);
            p.setcantidadproducto(Cantidad);
            p.setautoriza(Autoriza);
            databaseReference.child("Entrada").child(p.getUid()).setValue(p);
            Toast.makeText(this, "Producto agregado", Toast.LENGTH_LONG).show();
            limpiarCajas();
        }
    }

    private void limpiarCajas() {
        lineas.setSelection(0);
        claves.setSelection(0);
        cantidad.setText("");
        autoriza.setText("");
    }

    private void validacion() {
        String Lineas = lineas.getSelectedItem().toString();
        String Claves = claves.getSelectedItem().toString();
        String Cantidad = cantidad.getText().toString();
        String Autoriza = autoriza.getText().toString();

        if (Cantidad.equals("")){
            cantidad.setError("Ingresar cantidad");
        }
        else if (Autoriza.equals("")){
            autoriza.setError("Ingresar nombre de quien autoriza");
        }
    }

}
