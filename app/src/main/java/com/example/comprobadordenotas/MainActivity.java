package com.example.comprobadordenotas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Creamos variables para EditText, TextView y CheckBox
    private TextView result;
    private EditText editTextNota;
    private CheckBox checkJamon;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Buscamos por ID y asignamos a variables
        result = this.findViewById(R.id.textResultado);
        editTextNota = this.findViewById(R.id.editTextNota);
        checkJamon = this.findViewById(R.id.checkBox);

    }

    public void btnResultado(View v){ //Importante View para que aparezca en el onClick del boton.

        if(editTextNota.getText().toString().length() == 0) {
            //Si se pulsa el boton sin introducir un valor en el campo de texto.
            Toast.makeText(this, "Introduzca una nota para continuar.", Toast.LENGTH_SHORT).show();
        }else{
            float nota = Float.parseFloat(editTextNota.getText().toString());

            //Comprobar nota es menor que 10 y mayor que 0.
            if (nota < 0 || nota > 10) {
                Toast.makeText(this, "Introduzca una nota real.", Toast.LENGTH_SHORT).show();
                result.setText("");
            } else if (nota < 5 && !checkJamon.isChecked()) //Comprobar nota menor que 5 sin jamon.
                result.setText("Suspenso.");
            else if (nota < 4 && checkJamon.isChecked()) //Comprobar menor que 4 con jamon.
                result.setText("Suspenso.");
            else
                result.setText("Aprobado.");
        }
    }
}