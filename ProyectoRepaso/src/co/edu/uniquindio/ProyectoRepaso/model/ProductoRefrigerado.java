package co.edu.uniquindio.ProyectoRepaso.model;

import java.util.ArrayList;

public class ProductoRefrigerado extends Producto {

	private String codigoAprobacion;
	private int temperaturaRefrigeracion;


	public ProductoRefrigerado(String codigo, String nombre, String descripcion, float valor, int cantidad,
			ArrayList<DetalleTransaccion> listaDetallesProducto, String codigoAprobacion,
			int temperaturaRefrigeracion) {
		super(codigo, nombre, descripcion, valor, cantidad, listaDetallesProducto);
		this.codigoAprobacion = codigoAprobacion;
		this.temperaturaRefrigeracion = temperaturaRefrigeracion;
	}
	public ProductoRefrigerado(String codigo, String nombre, String descripcion, float valor, int cantidad,
			ArrayList<DetalleTransaccion> listaDetallesProducto) {
		super(codigo, nombre, descripcion, valor, cantidad, listaDetallesProducto);
	}
	public String getCodigoAprobacion() {
		return codigoAprobacion;
	}
	public void setCodigoAprobacion(String codigoAprobacion) {
		this.codigoAprobacion = codigoAprobacion;
	}
	public int getTemperaturaRefrigeracion() {
		return temperaturaRefrigeracion;
	}
	public void setTemperaturaRefrigeracion(int temperaturaRefrigeracion) {
		this.temperaturaRefrigeracion = temperaturaRefrigeracion;
	}


}
