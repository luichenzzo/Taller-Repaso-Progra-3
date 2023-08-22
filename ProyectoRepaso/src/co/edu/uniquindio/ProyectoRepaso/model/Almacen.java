package co.edu.uniquindio.ProyectoRepaso.model;

import java.util.ArrayList;
import java.util.Optional;

public class Almacen {
	private ArrayList <Cliente> listaCliente = new ArrayList <Cliente>();
	private ArrayList <Producto> listaProducto = new ArrayList <Producto>();
	private ArrayList<Transaccion> listaTransacciones = new ArrayList<>();



	public Almacen(ArrayList<Cliente> listaCliente, ArrayList<Producto> listaProducto,
			ArrayList<Transaccion> listaTransacciones) {
		super();
		this.listaCliente = listaCliente;
		this.listaProducto = listaProducto;
		this.listaTransacciones = listaTransacciones;
	}

	public Almacen() {
		super();
	}


	public ArrayList<Cliente> getListaCliente() {
		return listaCliente;
	}
	public void setListaCliente(ArrayList<Cliente> listaCliente) {
		this.listaCliente = listaCliente;
	}
	public ArrayList<Producto> getListaProducto() {
		return listaProducto;
	}
	public void setListaProducto(ArrayList<Producto> listaProducto) {
		this.listaProducto = listaProducto;
	}
	public ArrayList<Transaccion> getListaTransacciones() {
		return listaTransacciones;
	}
	public void setListaTransacciones(ArrayList<Transaccion> listaTransacciones) {
		this.listaTransacciones = listaTransacciones;
	}

	public void agregarCliente(Cliente cliente) {
		// TODO Auto-generated method stub
		listaCliente.add(cliente);
	}

	public void agregarProducto(Producto p) {
		// TODO Auto-generated method stub
		listaProducto.add(p);
	}

	public Cliente buscarCliente(String idUsuario) {
		Optional<Cliente> clienteEncontrado = this.listaCliente.stream().filter(cliente->cliente.getIdentificacion().equals(idUsuario)).findFirst();
		return clienteEncontrado.orElse(null);
	}

	public Producto buscarProducto(String codigoProducto) {
		Optional<Producto> productoEncontrado = this.listaProducto.stream().filter(producto->producto.getCodigo().equals(codigoProducto)).findFirst();
		return productoEncontrado.orElse(null);
	}

	public void reducirStockProducto(int cantidad, Producto ProductoSeleccionado) {
		// TODO Auto-generated method stub
		for (Producto producto : listaProducto) {
			if(producto.equals(ProductoSeleccionado)){
				producto.setCantidad(producto.getCantidad()-cantidad);
			}
		}
	}

	public boolean verificarTransaccion(Transaccion transaccionAux) {

		return this.listaTransacciones.contains(transaccionAux);
	}

	public void eliminarTransaccion(Transaccion transaccion) {
		this.listaTransacciones.remove(transaccion);

	}


}
