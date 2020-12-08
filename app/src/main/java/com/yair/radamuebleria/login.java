package com.yair.radamuebleria;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class login extends AppCompatActivity {
    private static final String TAG = " ";
    private EditText usuario,contraseña;
    private Button entrar;
    private ProgressDialog progressDialog;
    private FirebaseAuth.AuthStateListener mAuthListener;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        mAuth = FirebaseAuth.getInstance();

        entrar = (Button) findViewById(R.id.btnenvia);
        usuario = (EditText) findViewById(R.id.txtusu);
        contraseña = (EditText) findViewById(R.id.txtcontra);

        entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                iniciar();
            }
        });

    }

    private void iniciar() {
        String email, password;
        email= usuario.getText().toString();
        password=contraseña.getText().toString();
        if(TextUtils.isEmpty(email)){
            Toast.makeText(login.this, "El campo correo no puede estar vacio",
                    Toast.LENGTH_SHORT).show();

            return;
        }
        if(TextUtils.isEmpty(password)){
            Toast.makeText(login.this, "El campo contraseña no puede estar vacio",
                    Toast.LENGTH_SHORT).show();

            return;
        }
        if (password.length()<=5){
            Toast.makeText(login.this, "Contraseña incorrecta",
                    Toast.LENGTH_SHORT).show();
            contraseña.setText("");
            return;
        }

        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>()
                {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()) {

                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithEmail:success");
                            startActivity(new Intent(login.this,MainActivity.class));
                            FirebaseUser user = mAuth.getCurrentUser();
                            updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithEmail:failure", task.getException());
                            startActivity(new Intent(login.this,login.class));

                            Toast.makeText(login.this, "Autentificacion fallida.",
                                    Toast.LENGTH_SHORT).show();
                            updateUI(null);
                        }
                    }
                });
    }

    private void updateUI(FirebaseUser user) {
        if(user !=null){
            Intent intent = new Intent(login.this, MainActivity.class);
            startActivity(intent);
            Toast.makeText(login.this, "Ya iniciaste sesion",
                    Toast.LENGTH_SHORT).show();
            finish();
        }
    }


}
