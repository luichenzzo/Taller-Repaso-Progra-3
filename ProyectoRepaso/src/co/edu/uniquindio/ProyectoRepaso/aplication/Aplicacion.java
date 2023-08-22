package co.edu.uniquindio.ProyectoRepaso.aplication;

import java.io.IOException;
import java.util.ArrayList;

import co.edu.uniquindio.ProyectoRepaso.controllers.GestionAlmacenController;
import co.edu.uniquindio.ProyectoRepaso.model.Almacen;
import co.edu.uniquindio.ProyectoRepaso.model.Cliente;
import co.edu.uniquindio.ProyectoRepaso.model.ClienteJuridico;
import co.edu.uniquindio.ProyectoRepaso.model.DetalleTransaccion;
import co.edu.uniquindio.ProyectoRepaso.model.Producto;
import co.edu.uniquindio.ProyectoRepaso.model.ProductoPerecedero;
import co.edu.uniquindio.ProyectoRepaso.model.Transaccion;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Aplicacion extends Application{

	private Stage primaryStage;
	private static Almacen almacen;

	public static void main(String[] args) {
		ArrayList<Cliente> listaClientes = new ArrayList <>();
		ArrayList <Producto> listaProducto = new ArrayList<>();
		almacen = new Almacen(listaClientes, listaProducto, null);

		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		this.primaryStage = primaryStage;
		mostrarVentanaPrincipal();

	}

	private void mostrarVentanaPrincipal()   {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Aplicacion.class.getResource("/co/edu/uniquindio/ProyectoRepaso/views/GestionAlmacenView.fxml"));
			AnchorPane anchorPane = (AnchorPane) loader.load();
//			anchorPane.setPrefHeight(720);
//			anchorPane.setPrefWidth(630);
			GestionAlmacenController x = loader.getController();
			x.setAplication(this);

			Scene scene = new Scene(anchorPane);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void anadirCliente(Cliente cliente) {
		almacen.agregarCliente(cliente);
	}

	public ObservableList<Cliente> obtenerListaClientes() {
		// TODO Auto-generated method stub
		return FXCollections.observableArrayList(almacen.getListaCliente());
	}

	public void eliminarPersona(Cliente c) {
		// TODO Auto-generated method stub
		almacen.getListaCliente().remove(c);
	}

	public void anadirProducto(Producto p) {
		// TODO Auto-generated method stub
		almacen.agregarProducto(p);
	}

	public ObservableList<Producto> obtenerListaProductos() {
		// TODO Auto-generated method stub
		return FXCollections.observableArrayList(almacen.getListaProducto());
	}

	public void eliminarProducto(Producto p) {
		// TODO Auto-generated method stub
		almacen.getListaProducto().remove(p);
	}

	public Cliente buscarCliente(String idUsuario) {
		// TODO Auto-generated method stub
		return almacen.buscarCliente(idUsuario);
	}

	public Producto buscarProducto(String codigoProducto) {
		// TODO Auto-generated method stub
		return almacen.buscarProducto(codigoProducto);
	}

	public void enviarAlerta(String encabezado, String titulo, String contenido, AlertType tipoAlerta) {

		Alert alerta = new Alert(tipoAlerta);
		alerta.setHeaderText(encabezado);
		alerta.setTitle(titulo);
		alerta.setContentText(contenido);
		alerta.showAndWait();
	}

	public void reducirStockProducto(int cantidad, Producto productoSeleccionado) {
		// TODO Auto-generated method stub
		almacen.reducirStockProducto(cantidad, productoSeleccionado);
	}

	public boolean verificarTransaccion(Transaccion transaccionAux) {
		// TODO Auto-generated method stub
		return almacen.verificarTransaccion(transaccionAux);
	}

	public void eliminarTransaccion(Transaccion transaccion) {
		// TODO Auto-generated method stub
		almacen.eliminarTransaccion(transaccion);
	}

}
