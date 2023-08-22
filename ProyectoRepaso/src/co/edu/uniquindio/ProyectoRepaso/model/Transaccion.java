package co.edu.uniquindio.ProyectoRepaso.model;

import java.util.ArrayList;

public class Transaccion {

	private String codigo;
	private String fechaTransaccion;
	private float totalVenta;
	private float iva;
	private ArrayList <DetalleTransaccion> listaDetallesTransaccion = new ArrayList <DetalleTransaccion>();
	private Cliente cliente;


	public Transaccion(String codigo, String fechaTransaccion, float totalVenta, float iva,
			ArrayList<DetalleTransaccion> listaDetallesTransaccion, Cliente cliente) {
		super();
		this.codigo = codigo;
		this.fechaTransaccion = fechaTransaccion;
		this.totalVenta = totalVenta;
		this.iva = iva;
		this.listaDetallesTransaccion = listaDetallesTransaccion;
		this.cliente = cliente;
	}


	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	public ArrayList<DetalleTransaccion> getListaDetallesTransaccion() {
		return listaDetallesTransaccion;
	}

	public void setListaDetallesTransaccion(ArrayList<DetalleTransaccion> listaDetallesTransaccion) {
		this.listaDetallesTransaccion = listaDetallesTransaccion;
	}

	public Transaccion() {
		super();
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getFechaTransaccion() {
		return fechaTransaccion;
	}
	public void setFechaTransaccion(String fechaTransaccion) {
		this.fechaTransaccion = fechaTransaccion;
	}
	public float getTotalVenta() {
		return totalVenta;
	}
	public void setTotalVenta(float totalVenta) {
		this.totalVenta = totalVenta;
	}
	public float getIva() {
		return iva;
	}
	public void setIva(float iva) {
		this.iva = iva;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cliente == null) ? 0 : cliente.hashCode());
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((fechaTransaccion == null) ? 0 : fechaTransaccion.hashCode());
		result = prime * result + Float.floatToIntBits(iva);
		result = prime * result + ((listaDetallesTransaccion == null) ? 0 : listaDetallesTransaccion.hashCode());
		result = prime * result + Float.floatToIntBits(totalVenta);
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transaccion other = (Transaccion) obj;
		if (cliente == null) {
			if (other.cliente != null)
				return false;
		} else if (!cliente.equals(other.cliente))
			return false;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (fechaTransaccion == null) {
			if (other.fechaTransaccion != null)
				return false;
		} else if (!fechaTransaccion.equals(other.fechaTransaccion))
			return false;
		if (Float.floatToIntBits(iva) != Float.floatToIntBits(other.iva))
			return false;
		if (listaDetallesTransaccion == null) {
			if (other.listaDetallesTransaccion != null)
				return false;
		} else if (!listaDetallesTransaccion.equals(other.listaDetallesTransaccion))
			return false;
		if (Float.floatToIntBits(totalVenta) != Float.floatToIntBits(other.totalVenta))
			return false;
		return true;
	}

}
