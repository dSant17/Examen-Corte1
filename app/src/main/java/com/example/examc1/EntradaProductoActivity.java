package com.example.examc1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class EntradaProductoActivity extends AppCompatActivity {
    private TextView producto, descripcion, cantidad;
    private EditText precioVenta, precioCompra, ganancia;
    private Button btnCalcular, btnRegresar;
    private EntradaProducto entrada = new EntradaProducto();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entrada_producto);
        iniciar();

        Bundle datos = getIntent().getExtras();
        Integer codigo = (Integer) datos.getSerializable("Codigo");
        String desc = (String) datos.getSerializable("Descripcion");
        String unidad = (String) datos.getSerializable("Unidad");
        Float pVenta = (Float) datos.getSerializable("PrecioVenta");
        Float pCompra = (Float) datos.getSerializable("PrecioCompra");
        Integer cant = (Integer) datos.getSerializable("Cantidad");

        entrada.setCodigo(codigo);
        entrada.setDescripcion(desc);
        entrada.setUnidad(unidad);
        entrada.setPrecioVenta(pVenta);
        entrada.setPrecioCompra(pCompra);
        entrada.setCantidad(cant);

        producto.setText("Producto: " + entrada.getCodigo());
        descripcion.setText("Descripción: " + entrada.getDescripcion());
        cantidad.setText("Cantidad: " + entrada.getCantidad() + " " + entrada.getUnidad());


        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                precioVenta.setText("$ " + entrada.calcularPrecioVenta());
                precioCompra.setText("$ " + entrada.calcularPrecioCompra());
                ganancia.setText("$ " + entrada.calcularGanancia());
            }
        });

        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    public void iniciar(){
        producto = (TextView) findViewById(R.id.lblProducto);
        descripcion = (TextView) findViewById(R.id.lblDescripcion);
        cantidad = (TextView) findViewById(R.id.lblCantidad);

        precioVenta = (EditText) findViewById(R.id.totalVenta);
        precioCompra = (EditText) findViewById(R.id.totalCompra);
        ganancia = (EditText) findViewById(R.id.totalGanancia);

        btnCalcular = (Button) findViewById(R.id.btnCalcular);
        btnRegresar = (Button) findViewById(R.id.btnRegresar);
    }
}