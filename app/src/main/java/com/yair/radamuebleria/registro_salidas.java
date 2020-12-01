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

public class registro_salidas extends AppCompatActivity {
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    private Spinner lineass, clavess,motivo;
    private Button enviaar,regresarS;
    EditText cantidad, autoriza;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.agregar_salida);

        lineass = (Spinner) findViewById(R.id.linea);
        clavess = (Spinner) findViewById(R.id.claveproducto);
        enviaar = (Button) findViewById(R.id.btnregistrosalida);
        regresarS = (Button) findViewById(R.id.btnregresohomeSalidas);
        motivo = (Spinner) findViewById(R.id.tipo_de_salida);
        cantidad = (EditText) findViewById(R.id.CantidadEntra);
        autoriza = (EditText) findViewById(R.id.nombreautoriza);

        enviaar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                enviaSalida();
            }
        });

        regresarS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(registro_salidas.this,MainActivity.class));
            }
        });


        ArrayAdapter spinAdap = ArrayAdapter.createFromResource(this, R.array.tipolinea, android.R.layout.simple_spinner_item);

        lineass.setAdapter(spinAdap);

        lineass.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> lista, View view, int pos, long id) {
                if (lista.getItemAtPosition(pos).equals("Colchones")) {
                    ArrayAdapter listaadapter = ArrayAdapter.createFromResource(registro_salidas.this, R.array.Colchones, android.R.layout.simple_list_item_1);
                    clavess.setAdapter(listaadapter);
                }
                if (lista.getItemAtPosition(pos).equals("Camas")) {
                    ArrayAdapter listaadapter = ArrayAdapter.createFromResource(registro_salidas.this, R.array.Camas, android.R.layout.simple_list_item_1);
                    clavess.setAdapter(listaadapter);

                }
                if (lista.getItemAtPosition(pos).equals("Bicicletas")) {
                    ArrayAdapter listaadapter = ArrayAdapter.createFromResource(registro_salidas.this, R.array.Bicicletas, android.R.layout.simple_list_item_1);
                    clavess.setAdapter(listaadapter);

                }
                if (lista.getItemAtPosition(pos).equals("Enseres")) {
                    ArrayAdapter listaadapter = ArrayAdapter.createFromResource(registro_salidas.this, R.array.Enseres, android.R.layout.simple_list_item_1);
                    clavess.setAdapter(listaadapter);

                }
                if (lista.getItemAtPosition(pos).equals("Electronica")) {
                    ArrayAdapter listaadapter = ArrayAdapter.createFromResource(registro_salidas.this, R.array.Electronica, android.R.layout.simple_list_item_1);
                    clavess.setAdapter(listaadapter);

                }
                if (lista.getItemAtPosition(pos).equals("Linea blanca")) {
                    ArrayAdapter listaadapter = ArrayAdapter.createFromResource(registro_salidas.this, R.array.LineaBlanca, android.R.layout.simple_list_item_1);
                    clavess.setAdapter(listaadapter);

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
        firebaseDatabase.setPersistenceEnabled(true);
        databaseReference = firebaseDatabase.getReference();
    }

    private void enviaSalida() {
        String Lineas = lineass.getSelectedItem().toString();
        String Claves = clavess.getSelectedItem().toString();
        String Motivo = motivo.getSelectedItem().toString();
        String Autoriza = autoriza.getText().toString();

        if (lineass.equals("")||clavess.equals("")||motivo.equals("")||autoriza.equals("")){
            validacion();
        }
        else {
            Salidas p = new Salidas();
            p.setUid(UUID.randomUUID().toString());
            p.setlinea(Lineas);
            p.setclaveproducto(Claves);
            p.setmotivoSalida(Motivo);
            p.setautoriza(Autoriza);
            databaseReference.child("Salidas").child(p.getUid()).setValue(p);
            Toast.makeText(this, "Salida de producto", Toast.LENGTH_LONG).show();
            limpiarCajas();
        }

    }

    private void limpiarCajas() {
        lineass.setSelection(0);
        clavess.setSelection(0);
        motivo.setSelection(0);
        autoriza.setText("");
    }

    private void validacion() {
        String Cantidad = cantidad.getText().toString();
        String Autoriza = autoriza.getText().toString();

        if (Autoriza.equals("")){
            autoriza.setError("Ingresar nombre de quien autoriza");
        }
    }

}
