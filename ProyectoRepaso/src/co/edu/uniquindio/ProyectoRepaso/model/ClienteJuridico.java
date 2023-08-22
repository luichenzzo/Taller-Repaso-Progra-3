package co.edu.uniquindio.ProyectoRepaso.model;

import java.util.ArrayList;

public class ClienteJuridico extends Cliente{

	private String nit;

	public ClienteJuridico(String nombre, String apellidos, String identificacion, String direccion, String telefono,
			ArrayList<Transaccion> listaTransacciones, String nit) {
		super(nombre, apellidos, identificacion, direccion, telefono, listaTransacciones);
		this.nit = nit;
	}

	public String getNit() {
		return nit;
	}

	public void setNit(String nit) {
		this.nit = nit;
	}
	
	
}
