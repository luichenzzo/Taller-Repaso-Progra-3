package co.edu.uniquindio.ProyectoRepaso.model;

import java.util.ArrayList;

public class ProductoPerecedero extends Producto{

	private String fechaVencimiento;

	public ProductoPerecedero(String codigo, String nombre, String descripcion, float valor, int cantidad,
			ArrayList<DetalleTransaccion> listaDetallesProducto, String fechaVencimiento) {
		super(codigo, nombre, descripcion, valor, cantidad, listaDetallesProducto);
		this.fechaVencimiento = fechaVencimiento;
	}

	public ProductoPerecedero(String codigo, String nombre, String descripcion, float valor, int cantidad,
			ArrayList<DetalleTransaccion> listaDetallesProducto) {
		super(codigo, nombre, descripcion, valor, cantidad, listaDetallesProducto);
	}

	public String getFechaVencimiento() {
		return fechaVencimiento;
	}

	public void setFechaVencimiento(String fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}


}
