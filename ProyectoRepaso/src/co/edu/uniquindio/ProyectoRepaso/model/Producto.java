package co.edu.uniquindio.ProyectoRepaso.model;

import java.util.ArrayList;

public class Producto {
	private String codigo;
	private String nombre;
	private String descripcion;
	private float valor;
	private int cantidad;
	private ArrayList <DetalleTransaccion> listaDetallesProducto = new ArrayList<DetalleTransaccion>();


	public Producto(String codigo, String nombre, String descripcion, float valor, int cantidad,
			ArrayList<DetalleTransaccion> listaDetallesProducto) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.valor = valor;
		this.cantidad = cantidad;
		this.listaDetallesProducto = listaDetallesProducto;
	}
	public Producto() {
		super();
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public ArrayList<DetalleTransaccion> getListaDetallesProducto() {
		return listaDetallesProducto;
	}
	public void setListaDetallesProducto(ArrayList<DetalleTransaccion> listaDetallesProducto) {
		this.listaDetallesProducto = listaDetallesProducto;
	}



}
