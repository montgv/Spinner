package com.example.spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.example.spinner.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.operacionesSpinner, R.layout.mi_spinner);
        adapter.setDropDownViewResource(R.layout.mi_spinner);
        binding.spinner.setAdapter(adapter);

        binding.spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String operacion = (String) adapterView.getItemAtPosition(i);
                int valor1;
                int valor2;

                if (operacion.equals("Suma")) {
                    valor1 = Integer.parseInt(binding.txtValor1.getText().toString());
                    valor2 = Integer.parseInt(binding.txtValor2.getText().toString());
                    binding.txtResultado.setText(String.valueOf(valor1 + valor2));
                } else if (operacion.equals("Resta")) {
                    valor1 = Integer.parseInt(binding.txtValor1.getText().toString());
                    valor2 = Integer.parseInt(binding.txtValor2.getText().toString());
                    binding.txtResultado.setText(String.valueOf(valor1 - valor2));
                } else if (operacion.equals("Multiplicación")) {
                    valor1 = Integer.parseInt(binding.txtValor1.getText().toString());
                    valor2 = Integer.parseInt(binding.txtValor2.getText().toString());
                    binding.txtResultado.setText(String.valueOf(valor1 * valor2));
                } else if (operacion.equals("División")) {
                    valor1 = Integer.parseInt(binding.txtValor1.getText().toString());
                    valor2 = Integer.parseInt(binding.txtValor2.getText().toString());
                    if (valor2 == 0) {
                        binding.txtResultado.setText("No se puede dividir por 0");
                    } else {
                        binding.txtResultado.setText(String.valueOf(valor1 / valor2));
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}