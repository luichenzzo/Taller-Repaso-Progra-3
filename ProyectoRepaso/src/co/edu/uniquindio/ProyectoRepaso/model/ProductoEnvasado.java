package co.edu.uniquindio.ProyectoRepaso.model;

import java.util.ArrayList;

public class ProductoEnvasado extends Producto {

	private String fechaEnvasado;
	private int pesoEnvase;
	private PaisOrigen paisOrigen;
	public ProductoEnvasado(String codigo, String nombre, String descripcion, float valor, int cantidad,
			ArrayList<DetalleTransaccion> listaDetallesProducto, String fechaEnvasado, int pesoEnvase,
			PaisOrigen paisOrigen) {
		super(codigo, nombre, descripcion, valor, cantidad, listaDetallesProducto);
		this.fechaEnvasado = fechaEnvasado;
		this.pesoEnvase = pesoEnvase;
		this.paisOrigen = paisOrigen;
	}
	public ProductoEnvasado(String codigo, String nombre, String descripcion, float valor, int cantidad,
			ArrayList<DetalleTransaccion> listaDetallesProducto) {
		super(codigo, nombre, descripcion, valor, cantidad, listaDetallesProducto);
	}
	public String getFechaEnvasado() {
		return fechaEnvasado;
	}
	public void setFechaEnvasado(String fechaEnvasado) {
		this.fechaEnvasado = fechaEnvasado;
	}
	public int getPesoEnvase() {
		return pesoEnvase;
	}
	public void setPesoEnvase(int pesoEnvase) {
		this.pesoEnvase = pesoEnvase;
	}
	public PaisOrigen getPaisOrigen() {
		return paisOrigen;
	}
	public void setPaisOrigen(PaisOrigen paisOrigen) {
		this.paisOrigen = paisOrigen;
	}


}
