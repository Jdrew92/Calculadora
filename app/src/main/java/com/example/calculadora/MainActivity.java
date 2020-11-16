package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText num1, num2;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Se le asignan los elementos en la interfaz a las variables
        num1 = findViewById(R.id.txtNmbrOne);
        num2 = findViewById(R.id.txtNmbrTwo);
        result = findViewById(R.id.lblResult);

    }

    public void calcular (View v){
        double n1, n2, suma;
        n1 = Double.parseDouble(num1.getText().toString());
        n2 = Double.parseDouble((num2.getText().toString()));
        suma = n1+n2;
        //Es necesario pasarle el resultado como String
        result.setText(String.valueOf(suma));
    }
}