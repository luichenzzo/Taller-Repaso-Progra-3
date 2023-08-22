package co.edu.uniquindio.ProyectoRepaso.model;

public class DetalleTransaccion {

	private int cantidadUnidades;
	private float subTotal;
	private Producto producto;
	private String codigoProducto;


	public DetalleTransaccion(int cantidadUnidades, float subTotal, Producto producto, String codigoProducto) {
		super();
		this.cantidadUnidades = cantidadUnidades;
		this.subTotal = subTotal;
		this.producto = producto;
		this.codigoProducto = codigoProducto;
	}

	public DetalleTransaccion() {
		super();
	}


	public String getCodigoProducto() {
		return codigoProducto;
	}

	public void setCodigoProducto(String codigoProducto) {
		this.codigoProducto = codigoProducto;
	}

	public int getCantidadUnidades() {
		return cantidadUnidades;
	}

	public void setCantidadUnidades(int cantidadUnidades) {
		this.cantidadUnidades = cantidadUnidades;
	}

	public float getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(float subTotal) {
		this.subTotal = subTotal;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	@Override
	public String toString() {
		return "DetalleTransaccion [cantidadUnidades=" + cantidadUnidades + ", subTotal=" + subTotal
				+ ", codigoProducto=" + codigoProducto + "]";
	}
}
