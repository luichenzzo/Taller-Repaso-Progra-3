package co.edu.uniquindio.ProyectoRepaso.model;

import java.util.ArrayList;

public class ClienteNatural extends Cliente{

	private String email;
	private String fechaNacimiento;
	public ClienteNatural(String nombre, String apellidos, String identificacion, String direccion, String telefono,
			ArrayList<Transaccion> listaTransacciones, String email, String fechaNacimiento) {
		super(nombre, apellidos, identificacion, direccion, telefono, listaTransacciones);
		this.email = email;
		this.fechaNacimiento = fechaNacimiento;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}


}
