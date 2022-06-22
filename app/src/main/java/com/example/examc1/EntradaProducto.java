package com.example.examc1;

public class EntradaProducto {
    private int codigo;
    private String descripcion;
    private String unidad;
    private float precioCompra;
    private float precioVenta;
    private int cantidad;

    public EntradaProducto(int codigo, String descripcion, String unidad, float precioCompra, float precioVenta, int cantidad) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.unidad = unidad;
        this.precioCompra = precioCompra;
        this.precioVenta = precioVenta;
        this.cantidad = cantidad;
    }

    public EntradaProducto(){

    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public float getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(float precioCompra) {
        this.precioCompra = precioCompra;
    }

    public float getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(float precioVenta) {
        this.precioVenta = precioVenta;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public float calcularPrecioVenta(){
        return precioVenta * cantidad;
    }

    public float calcularPrecioCompra(){
        return precioCompra * cantidad;
    }

    public float calcularGanancia(){
        return calcularPrecioVenta() - calcularPrecioCompra();
    }
}
