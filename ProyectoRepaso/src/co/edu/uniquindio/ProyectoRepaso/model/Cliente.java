package co.edu.uniquindio.ProyectoRepaso.model;

import java.util.ArrayList;

public class Cliente extends Persona {
	private String direccion;
	private String telefono;
	private ArrayList <Transaccion> listaTransacciones= new ArrayList <Transaccion>();
	public Cliente(String nombre, String apellidos, String identificacion, String direccion, String telefono,
			ArrayList<Transaccion> listaTransacciones) {
		super(nombre, apellidos, identificacion);
		this.direccion = direccion;
		this.telefono = telefono;
		this.listaTransacciones = listaTransacciones;
	}
	public Cliente(String nombre, String apellidos, String identificacion) {
		super(nombre, apellidos, identificacion);
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public ArrayList<Transaccion> getListaTransacciones() {
		return listaTransacciones;
	}
	public void setListaTransacciones(ArrayList<Transaccion> listaTransacciones) {
		this.listaTransacciones = listaTransacciones;
	}
	@Override
	public String toString() {
		return "Cliente [direccion=" + direccion + ", telefono=" + telefono + ", listaTransacciones="
				+ listaTransacciones + ", getNombre()=" + getNombre() + ", getApellidos()=" + getApellidos()
				+ ", getIdentificacion()=" + getIdentificacion() + ", toString()=" + super.toString() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((direccion == null) ? 0 : direccion.hashCode());
		result = prime * result + ((listaTransacciones == null) ? 0 : listaTransacciones.hashCode());
		result = prime * result + ((telefono == null) ? 0 : telefono.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (direccion == null) {
			if (other.direccion != null)
				return false;
		} else if (!direccion.equals(other.direccion))
			return false;
		if (listaTransacciones == null) {
			if (other.listaTransacciones != null)
				return false;
		} else if (!listaTransacciones.equals(other.listaTransacciones))
			return false;
		if (telefono == null) {
			if (other.telefono != null)
				return false;
		} else if (!telefono.equals(other.telefono))
			return false;
		return true;
	}



}
