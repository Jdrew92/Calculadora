package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText num1, num2;
    private TextView result;
    private Spinner ops;
    private String options[];
    private ArrayAdapter <String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Se le asignan los elementos en la interfaz a las variables
        num1 = findViewById(R.id.txtNmbrOne);
        num2 = findViewById(R.id.txtNmbrTwo);
        result = findViewById(R.id.lblResult);
        ops = findViewById(R.id.cmbOp);

        //Se traen las opciones del array en strings
        options = getResources().getStringArray(R.array.operations);

        //para tener acceso a cosas que son propias de android usamos android.R
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, options);

        ops.setAdapter(adapter);
    }

    public void calculate (View v){
        double n1, n2, total = 0;
        int op;
        op = ops.getSelectedItemPosition();
        if(validate(op)) {
            n1 = Double.parseDouble(num1.getText().toString());
            n2 = Double.parseDouble((num2.getText().toString()));
            switch (op){
                case 0:
                    total = addition(n1, n2);
                    break;
                case 1:
                    total = subtraction(n1, n2);
                    break;
                case 2:
                    total = multiplication(n1, n2);
                    break;
                case 3:
                    total = division(n1, n2);
                    break;
            }
            result.setText(String.format("%.2f", total));
        }
    }

    public boolean validate (int i){
        double n2 = Double.parseDouble(num2.getText().toString());
        /*Log.i("Variable op", Integer.toString(i));
        Log.i("Variable num2", num2.getText().toString());*/
        if(num1.getText().toString().isEmpty()){
            num1.setError(getString(R.string.input_error));
            num1.requestFocus(); //Coloca el cursor en ese campo
            return false;
        }
        if(num2.getText().toString().isEmpty()){
            num2.setError(getString(R.string.input_error));
            num2.requestFocus();
            return false;
        }
        if( n2 == 0 && i == 3){
            num2.setError(getString(R.string.divide_zero_error));
            num2.requestFocus();
            return false;
        }
        else {
            return true;
        }
    }

    public void clean(View v){
        num1.setText("");
        num2.setText("");
        result.setText("0");
        num1.requestFocus();
        ops.setSelection(0);
    }

    public double addition(double d1, double d2){
        double add = d1 + d2;
        //Es necesario pasarle el resultado como String

        return add;
    }
    public double subtraction(double d1, double d2){
        double subs = d1 - d2;
        return subs;
    }
    public double multiplication(double d1, double d2){
        double mult = d1 * d2;
        return mult;
    }
    public double division(double d1, double d2){
        double div = d1 / d2;
        return div;
    }
}