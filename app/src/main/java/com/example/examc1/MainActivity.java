package com.example.examc1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText codigo, descripcion, unidad, precioVenta, precioCompra, cantidad;
    private Button btnEnviar, btnLimpiar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iniciar();

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (codigo.getText().toString().matches("") || descripcion.getText().toString().matches("") ||
                    unidad.getText().toString().matches("") || precioVenta.getText().toString().matches("") ||
                    precioCompra.getText().toString().matches("") || cantidad.getText().toString().matches("")) {
                    Toast.makeText(MainActivity.this, "Faltan algunos campos por llenar.", Toast.LENGTH_SHORT).show();
                } else {
                    int code = Integer.parseInt(codigo.getText().toString());
                    String desc = descripcion.getText().toString();
                    String unit = unidad.getText().toString();
                    Float pVenta = Float.parseFloat(precioVenta.getText().toString());
                    Float pCompra = Float.parseFloat(precioCompra.getText().toString());
                    int cant = Integer.parseInt(cantidad.getText().toString());

                    Intent intento = new Intent(MainActivity.this, EntradaProductoActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("Codigo", code);
                    bundle.putSerializable("Descripcion", desc);
                    bundle.putSerializable("Unidad", unit);
                    bundle.putSerializable("PrecioVenta", pVenta);
                    bundle.putSerializable("PrecioCompra", pCompra);
                    bundle.putSerializable("Cantidad", cant);
                    intento.putExtras(bundle);
                    startActivity(intento);
                }
            }
        });

        btnLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                codigo.setText("");
                descripcion.setText("");
                unidad.setText("");
                precioVenta.setText("");
                precioCompra.setText("");
                cantidad.setText("");
            }
        });
    }

    public void iniciar(){
        codigo = (EditText) findViewById(R.id.codigo);
        descripcion = (EditText) findViewById(R.id.descripcion);
        unidad = (EditText) findViewById(R.id.unidad);
        precioVenta = (EditText) findViewById(R.id.precioVenta);
        precioCompra = (EditText) findViewById(R.id.precioCompra);
        cantidad = (EditText) findViewById(R.id.cantidad);

        btnEnviar = (Button) findViewById(R.id.btnEnviar);
        btnLimpiar = (Button) findViewById(R.id.btnLimpiar);
    }
}