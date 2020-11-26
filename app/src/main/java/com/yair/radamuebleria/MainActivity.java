package com.yair.radamuebleria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button producto_existencia, salidaProducto, salidasRecientes, agregar_producto, clavesProducto;
    private Bundle savedInstanceState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        producto_existencia=(Button)findViewById(R.id.btnproducto_existencia);
        salidaProducto=(Button)findViewById(R.id.btnRsalidaproducto);
        salidasRecientes=(Button)findViewById(R.id.btnsalidasrecientes);
        agregar_producto=(Button)findViewById(R.id.btnagregar_producto);
        clavesProducto=(Button)findViewById(R.id.btnclavesproductos);


        producto_existencia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,consulta_producto.class));
            }
        });

        salidaProducto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,registro_salidas.class));
            }
        });

        salidasRecientes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,consulta_salidas.class));
            }
        });

        agregar_producto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,registro_producto.class));
            }
        });

        clavesProducto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,claves.class));
            }
        });
    }
}