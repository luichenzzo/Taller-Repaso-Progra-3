package co.edu.uniquindio.ProyectoRepaso.controllers;

import java.awt.List;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ResourceBundle;

import co.edu.uniquindio.ProyectoRepaso.aplication.Aplicacion;
import co.edu.uniquindio.ProyectoRepaso.model.Cliente;
import co.edu.uniquindio.ProyectoRepaso.model.ClienteJuridico;
import co.edu.uniquindio.ProyectoRepaso.model.ClienteNatural;
import co.edu.uniquindio.ProyectoRepaso.model.DetalleTransaccion;
import co.edu.uniquindio.ProyectoRepaso.model.PaisOrigen;
import co.edu.uniquindio.ProyectoRepaso.model.Producto;
import co.edu.uniquindio.ProyectoRepaso.model.ProductoEnvasado;
import co.edu.uniquindio.ProyectoRepaso.model.ProductoPerecedero;
import co.edu.uniquindio.ProyectoRepaso.model.ProductoRefrigerado;
import co.edu.uniquindio.ProyectoRepaso.model.Transaccion;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

public class GestionAlmacenController implements Initializable {

	private Aplicacion aplicacion;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnActualizarCliente;

    @FXML
    private Button btnActualizarProducto;

    @FXML
    private Button btnActualizarTransaccion;

    @FXML
    private Button btnAgregarCliente;

    @FXML
    private Button btnAgregarProducto;

    @FXML
    private Button btnAgregarProductoCompra;

    @FXML
    private Button btnEliminarCliente;

    @FXML
    private Button btnEliminarProducto;

    @FXML
    private Button btnEliminarProductoFactura;

    @FXML
    private Button btnEliminarTransaccion;

    @FXML
    private Button btnFinalizarTransaccion;

    @FXML
    private Button btnVaciarCamposCliente;

    @FXML
    private Button btnVaciarCamposProducto;

    @FXML
    private ComboBox<PaisOrigen> cmbboxPaisOrigen;

    @FXML
    private ComboBox<String> cmbboxTIpoProducto;

    @FXML
    private ComboBox<String> cmbboxTipoCliente;


    @FXML
    private TextField lblApellidoCliente;

    @FXML
    private TextField lblCantidadProducto;

    @FXML
    private TextField lblClienteTransaccion;

    @FXML
    private TextField lblCodigoAprobacion;

    @FXML
    private TextField lblCodigoCliente;

    @FXML
    private TextField lblCodigoProductoCompra;

    @FXML
    private TextField lblCodigoTransaccion;

    @FXML
    private TextArea lblDescripcionCliente;

    @FXML
    private TextField lblDireccion;

    @FXML
    private TextField lblEmailCliente;

    @FXML
    private TextField lblFechaEnvasado;

    @FXML
    private TextField lblFechaNacimiento;

    @FXML
    private TextField lblFechaTransaccion;

    @FXML
    private TextField lblFechaVencimiento;

    @FXML
    private TextField lblIDCliente;
    @FXML
    private TextField lblIDClienteCompra;

    @FXML
    private TextField lblNIT;

    @FXML
    private TextField lblNombreCliente;

    @FXML
    private TextField lblNombreProducto;

    @FXML
    private TextField lblPesoEnvase;

    @FXML
    private TextField lblTel;

    @FXML
    private TextField lblTempRefri;

    @FXML
    private TextField lblTotalTransaccion;

    @FXML
    private TextField lblValorProducto;

    @FXML
    private Spinner<Integer> spinnerCantProducto;

    @FXML
    private TableView<Cliente> tblClientesRegistrados;

    @FXML
    private TableView<DetalleTransaccion> tblFactura;

    @FXML
    private TableView<Producto> tblProductos;

    @FXML
    private TableColumn<?, ?> clmCodigoProducto;

    @FXML
    private TableColumn<?, ?> clmNombreProducto;

    @FXML
    private TableColumn<?, ?> clmValorUnitario;

    @FXML
    private TableColumn<?, ?> clmCantidadesProducto;

    @FXML
    private TableView<Transaccion> tblTransacciones;

    @FXML
    private TableColumn<?, ?> clmIDCliente;

    @FXML
    private TableColumn<?, ?> clmNombreCliente;

    @FXML
    private TableColumn<?, ?> clmTelCliente;

    @FXML
    private TableColumn<?, ?> clmCodigoProductoTransaccion;

    @FXML
    private TableColumn<?, ?> clmCantidadTransaccion;

    @FXML
    private TableColumn<?, ?> clmSubTotalTransaccion;

    @FXML
    private TableColumn<?, ?> clmCodigoTransaccion;

    @FXML
    private TableColumn<?, ?> clmFechaTrasaccion;

    @FXML
    private TableColumn<?, ?> clmTotalTransaccion;

    private ObservableList<DetalleTransaccion> ObservableListDetalles = FXCollections.observableArrayList();

    private ObservableList<Transaccion> ObservablelistTransaccion = FXCollections.observableArrayList();

    @FXML
    void actualizarCliente(ActionEvent event) {
    	Cliente c = this.tblClientesRegistrados.getSelectionModel().getSelectedItem();
    	if(c != null){
    		String nombre = lblNombreCliente.getText();
        	String apellido = lblApellidoCliente.getText();
        	String id = lblIDCliente.getText();

        	String direccion = lblDireccion.getText();
        	String telefono = lblTel.getText();
        	if(cmbboxTipoCliente.getSelectionModel().getSelectedItem().equals("Persona Juridica")){
        		String nit = lblNIT.getText();
        		ClienteJuridico clienteJur = new ClienteJuridico(nombre, apellido, id, direccion, telefono, null, nit);
        		System.out.println(!aplicacion.obtenerListaClientes().contains(clienteJur));
        		if(!aplicacion.obtenerListaClientes().contains(clienteJur)){
        			aplicacion.eliminarPersona(c);
        			c.setNombre(clienteJur.getNombre());
        			c.setApellidos(clienteJur.getApellidos());
        			c.setDireccion(clienteJur.getDireccion());
        			c.setIdentificacion(clienteJur.getIdentificacion());
        			c.setTelefono(clienteJur.getTelefono());
        			((ClienteJuridico)c).setNit(clienteJur.getNit());
        			aplicacion.anadirCliente(c);
        			this.tblClientesRegistrados.refresh();
        			this.tblClientesRegistrados.setItems(aplicacion.obtenerListaClientes());
        		}
        		else{
        			aplicacion.enviarAlerta("Error", "Error", "La Persona ya existe", Alert.AlertType.ERROR);
        		}
        	}
        	else{
        		if(cmbboxTipoCliente.getSelectionModel().getSelectedItem().equals("Persona Natural")){
        			String 	email = lblEmailCliente.getText();
        			String fechaNacimiento = lblFechaNacimiento.getText();
        			ClienteNatural clienteNat = new ClienteNatural(nombre, apellido, id, direccion, telefono, null, email, fechaNacimiento);
        			if(!aplicacion.obtenerListaClientes().contains(clienteNat)){
        				c.setNombre(clienteNat.getNombre());
            			c.setApellidos(clienteNat.getApellidos());
            			c.setDireccion(clienteNat.getDireccion());
            			c.setIdentificacion(clienteNat.getIdentificacion());
            			c.setTelefono(clienteNat.getTelefono());
            			((ClienteNatural)c).setEmail(clienteNat.getEmail());
            			((ClienteNatural)c).setFechaNacimiento(clienteNat.getFechaNacimiento());
            			this.tblClientesRegistrados.refresh();
        			}
        			else{
        				aplicacion.enviarAlerta("Error", "Error", "La Persona ya existe", Alert.AlertType.ERROR);
        			}
        		}
        	}
    	}
    	else{
    		aplicacion.enviarAlerta("Error", "Error", "Elija Persona a Actualizar", Alert.AlertType.ERROR);
    	}

    }

    @FXML
    void actualizarTransaccion(ActionEvent event) {

    	Transaccion transaccion = tblTransacciones.getSelectionModel().getSelectedItem();

		if(transaccion==null){
			aplicacion.enviarAlerta("Alerta","Error","Debe seleccionar una transacción",AlertType.ERROR);
		}else{

			try{

				String codigoTransaccion = lblCodigoTransaccion.getText();
		    	String fechaTransaccion = lblFechaTransaccion.getText();
		    	String idCliente = lblIDClienteCompra.getText();
		    	float totalTrasaccion = Float.valueOf(lblTotalTransaccion.getText());
		    	Cliente cliente = aplicacion.buscarCliente(idCliente);
				ArrayList<DetalleTransaccion>listaAux = new ArrayList<>(ObservableListDetalles);

				Transaccion transaccionAux = new Transaccion(codigoTransaccion, fechaTransaccion, totalTrasaccion, 0, listaAux, cliente);
				if(aplicacion.verificarTransaccion(transaccionAux)==false){
					transaccion.setCodigo(transaccionAux.getCodigo());
					transaccion.setFechaTransaccion(transaccionAux.getFechaTransaccion());
					transaccion.setCliente(transaccionAux.getCliente());
					transaccion.setTotalVenta(transaccionAux.getTotalVenta());
					transaccion.setListaDetallesTransaccion(transaccionAux.getListaDetallesTransaccion());

					refrescarTabla();
					ObservableListDetalles.clear();
	 				vaciarCamposTransaccion();
				}
				else{
					aplicacion.enviarAlerta("Alerta","Error","La transacción ya se encunetra registrada",AlertType.ERROR);

				}
			}catch (NumberFormatException e) {
				// TODO: handle exception
			}
		}

    }

    @FXML
    void agregarCliente(ActionEvent event) {

    	String nombre = lblNombreCliente.getText();
    	String apellido = lblApellidoCliente.getText();
    	String id = lblIDCliente.getText();

    	String direccion = lblDireccion.getText();
    	String telefono = lblTel.getText();
    	if(cmbboxTipoCliente.getSelectionModel().getSelectedItem().equals("Persona Juridica")){
    		String nit = lblNIT.getText();
    		ClienteJuridico clienteJur = new ClienteJuridico(nombre, apellido, id, direccion, telefono, null, nit);
    		System.out.println(!aplicacion.obtenerListaClientes().contains(clienteJur));
    		if(!aplicacion.obtenerListaClientes().contains(clienteJur)){
    			System.out.println();
    			aplicacion.anadirCliente(clienteJur);
    			this.tblClientesRegistrados.setItems(aplicacion.obtenerListaClientes());
    		}
    		else{
    			aplicacion.enviarAlerta("Error", "Error", "La Persona ya existe", Alert.AlertType.ERROR);
    		}
    	}
    	else{
    		if(cmbboxTipoCliente.getSelectionModel().getSelectedItem().equals("Persona Natural")){
    			String 	email = lblEmailCliente.getText();
    			String fechaNacimiento = lblFechaNacimiento.getText();
    			ClienteNatural clienteNat = new ClienteNatural(nombre, apellido, id, direccion, telefono, null, email, fechaNacimiento);
    			if(!aplicacion.obtenerListaClientes().contains(clienteNat)){
    				aplicacion.anadirCliente(clienteNat);
    				this.tblClientesRegistrados.setItems(aplicacion.obtenerListaClientes());
    			}
    			else{
    				aplicacion.enviarAlerta("Error", "Error", "La Persona ya existe", Alert.AlertType.ERROR);
    			}
    		}
    	}

    }

    @FXML
    void seleccionarCliente(MouseEvent event) {
    	Cliente c = this.tblClientesRegistrados.getSelectionModel().getSelectedItem();
    	if(c != null){
    		this.lblNombreCliente.setText(c.getNombre());
    		this.lblApellidoCliente.setText(c.getApellidos());
    		this.lblIDCliente.setText(c.getIdentificacion());
    		this.lblDireccion.setText(c.getDireccion());
    		this.lblTel.setText(c.getTelefono());
    		if(c instanceof ClienteJuridico){
    			cmbboxTipoCliente.setValue("Cliente Juridico");
    			this.lblNIT.setText(((ClienteJuridico) c).getNit());
    		}
    		else{
    			cmbboxTipoCliente.setValue("Cliente Natural");
    			this.lblEmailCliente.setText(((ClienteNatural)c).getEmail());
    			this.lblFechaNacimiento.setText(((ClienteNatural)c).getFechaNacimiento());
    		}
    	}
    }

    @FXML
    void agregarProducto(ActionEvent event) {
    	try{
    	if(cmbboxTIpoProducto.getSelectionModel().getSelectedItem().equals("Producto Envasado")){
    		agregarProductoEnvasado();
    	}
    	else{
    		if(cmbboxTIpoProducto.getSelectionModel().getSelectedItem().equals("Producto Refrigerado")){
    			agregarProductoRefrigerado();
    		}
    		else{
    			if(cmbboxTIpoProducto.getSelectionModel().getSelectedItem().equals("Producto Perecedero")){
    				agregarProductoPerecedero();
    			}
    			else{
    				aplicacion.enviarAlerta("Error", "Error", "No seleccionaste el tipo de producto", Alert.AlertType.ERROR);
    			}
    		}
    	}
    	} catch (NumberFormatException e){
    		aplicacion.enviarAlerta("Error", "Error", "Los campos: Valor y cantidad solo pueden tener numeros", Alert.AlertType.ERROR);
    	}

    }


    private boolean validarCamposProductoPerecedero() {

    	if(lblNombreProducto.getText().equals("")||lblCodigoCliente.getText().equals("")||lblDescripcionCliente.getText().equals("")
    		|| lblValorProducto.getText().equals("") || lblCantidadProducto.getText().equals("")|| lblFechaVencimiento.getText().equals("")){
    		return false;
    	}

		return true;
	}

	private void agregarProductoPerecedero() {
		if(validarCamposProductoPerecedero()){
		String nombre = lblNombreProducto.getText();
		String codigo = lblCodigoCliente.getText();
		float valor = Float.parseFloat(lblValorProducto.getText());
		int cantidad = Integer.parseInt(lblCantidadProducto.getText());
		String descripcion = lblDescripcionCliente.getText();

		String fechaVencimiento = lblFechaVencimiento.getText();

		ProductoPerecedero p = new ProductoPerecedero(codigo, nombre, descripcion, valor, cantidad, null,fechaVencimiento);
		aplicacion.anadirProducto(p);
		this.tblProductos.setItems(aplicacion.obtenerListaProductos());
		}
		else{
			aplicacion.enviarAlerta("Error", "Error", "Asegurese de llenar todos los campos", Alert.AlertType.ERROR);
		}

	}


	private boolean validarCamposProductoRefrigerado(){
		if(lblNombreProducto.getText().equals("")||lblCodigoCliente.getText().equals("")||lblDescripcionCliente.getText().equals("")
	    		|| lblValorProducto.getText().equals("") || lblCantidadProducto.getText().equals("")|| lblCodigoAprobacion.getText().equals("")
	    		|| lblTempRefri.getText().equals("")){
			return false;
		}
		return true;
	}
	private void agregarProductoRefrigerado() {
		// TODO Auto-generated method stub
		if(validarCamposProductoRefrigerado()){
		String nombre = lblNombreProducto.getText();
		String codigo = lblCodigoCliente.getText();
		float valor = Float.parseFloat(lblValorProducto.getText());
		int cantidad = Integer.parseInt(lblCantidadProducto.getText());
		String descripcion = lblDescripcionCliente.getText();

		String codigoAprobacion = lblCodigoAprobacion.getText();
		int tempRefri = Integer.parseInt(lblTempRefri.getText());

		ProductoRefrigerado p = new ProductoRefrigerado(codigo, nombre, descripcion, valor, cantidad, null, codigoAprobacion, tempRefri);
		aplicacion.anadirProducto(p);
		this.tblProductos.setItems(aplicacion.obtenerListaProductos());
		}
		else{
			aplicacion.enviarAlerta("Error", "Error", "Asegurese de llenar todos los campos", Alert.AlertType.ERROR);
		}

	}

	private boolean validarCamposProductoEnvasado(){
		if(lblNombreProducto.getText().equals("")||lblCodigoCliente.getText().equals("")||lblDescripcionCliente.getText().equals("")
	    		|| lblValorProducto.getText().equals("") || lblCantidadProducto.getText().equals("")||
	    		lblFechaEnvasado.getText().equals("") || lblPesoEnvase.getText().equals("")){
			return false;
		}
		return true;
	}
	private void agregarProductoEnvasado() {

		if(validarCamposProductoEnvasado()){
		String nombre = lblNombreProducto.getText();
		String codigo = lblCodigoCliente.getText();
		float valor = Float.parseFloat(lblValorProducto.getText());
		int cantidad = Integer.parseInt(lblCantidadProducto.getText());
		String descripcion = lblDescripcionCliente.getText();

		String fechaEnvase = lblFechaEnvasado.getText();
		int pesoEnvase = Integer.parseInt(lblPesoEnvase.getText());
		PaisOrigen paisOrigen = cmbboxPaisOrigen.getValue();
		ProductoEnvasado p = new ProductoEnvasado(codigo, nombre, descripcion, valor, cantidad, null, fechaEnvase, pesoEnvase, paisOrigen);
		aplicacion.anadirProducto(p);
		this.tblProductos.setItems(aplicacion.obtenerListaProductos());
		}
		else{
			aplicacion.enviarAlerta("Error", "Error", "Asegurese de llenar todos los campos", Alert.AlertType.ERROR);
		}


	}

	@FXML
    void seleccionarProducto(MouseEvent event) {
		Producto c = this.tblProductos.getSelectionModel().getSelectedItem();
		this.lblCodigoCliente.setText(c.getCodigo());
		this.lblNombreProducto.setText(c.getNombre());
		this.lblValorProducto.setText(c.getValor()+"");
		this.lblCantidadProducto.setText(c.getCantidad()+"");
		this.lblDescripcionCliente.setText(c.getDescripcion());
		if(c instanceof ProductoPerecedero){
			cmbboxTIpoProducto.setValue("Producto Perecedero");
			this.lblFechaVencimiento.setText(((ProductoPerecedero) c).getFechaVencimiento());
		}
		else{
			if(c instanceof ProductoRefrigerado){
				cmbboxTIpoProducto.setValue("Producto Refrigerado");
				this.lblCodigoAprobacion.setText(((ProductoRefrigerado) c).getCodigoAprobacion());
				this.lblTempRefri.setText(((ProductoRefrigerado) c).getTemperaturaRefrigeracion()+"");
			}
			else{
				cmbboxTIpoProducto.setValue("Producto Envasado");
				this.lblFechaEnvasado.setText(((ProductoEnvasado)c).getFechaEnvasado());
				this.lblPesoEnvase.setText(((ProductoEnvasado) c).getPesoEnvase()+"");
			}
		}
    }
	@FXML
    void eliminarTransaccion(ActionEvent event) {

		Transaccion transaccion = tblTransacciones.getSelectionModel().getSelectedItem();

		if(transaccion == null){
			aplicacion.enviarAlerta("Alerta","Error","Seleccione una transacción",AlertType.ERROR);;
		}else{
			aplicacion.eliminarTransaccion(transaccion);
			ObservablelistTransaccion.remove(transaccion);
			refrescarTabla();
			vaciarCamposTransaccion();
		}

    }

	@FXML
    void eliminarProducto(ActionEvent event) {
		Producto p = this.tblProductos.getSelectionModel().getSelectedItem();
		aplicacion.eliminarProducto(p);
		this.tblProductos.refresh();
		this.tblProductos.setItems(aplicacion.obtenerListaProductos());


    }
    @FXML
    void eliminarCliente(ActionEvent event) {
    	Cliente c = this.tblClientesRegistrados.getSelectionModel().getSelectedItem();
    	aplicacion.eliminarPersona(c);
    	this.tblClientesRegistrados.refresh();
    	this.tblClientesRegistrados.setItems(aplicacion.obtenerListaClientes());
    }
    @FXML
    void finalizarTransaccion(ActionEvent event) {

    	String codigoTransaccion = lblCodigoTransaccion.getText();
    	String fechaTransaccion = lblFechaTransaccion.getText();
    	String idCliente = lblIDClienteCompra.getText();
    	float totalTrasaccion = Float.valueOf(lblTotalTransaccion.getText());
    	Cliente cliente = aplicacion.buscarCliente(idCliente);

    	if(codigoTransaccion==null || fechaTransaccion==null||idCliente==null){
    		aplicacion.enviarAlerta("Alerta", "Error","Asegúrese de llenar todos los campos de texto", AlertType.ERROR);
    	}
    	else{
    		if(cliente == null){
    			aplicacion.enviarAlerta("Alerta", "Error","No se ha encontrado ningún cliente registrado con el número de identificación asignado", AlertType.ERROR);
    		}
    		else{
    			if(totalTrasaccion == 0){
    				aplicacion.enviarAlerta("Alerta","Error","Debe registrar por lo menos 1 producto",AlertType.ERROR);
    			}
    			else{
    				ArrayList<DetalleTransaccion>listaAux = new ArrayList<>(ObservableListDetalles);
    				Transaccion transaccion = new Transaccion(codigoTransaccion, fechaTransaccion, totalTrasaccion,0,listaAux, cliente);
    				ObservablelistTransaccion.add(transaccion);
    				refrescarTabla();
    				ObservableListDetalles.clear();
    				vaciarCamposTransaccion();
    			}
    		}
    	}

    }

    private void vaciarCamposTransaccion() {

    	lblCodigoTransaccion.setText("");
    	lblFechaTransaccion.setText("");
    	lblIDClienteCompra.setText("");
    	lblClienteTransaccion.setText("");
    	lblCodigoProductoCompra.setText("");
    	spinnerCantProducto.getValueFactory().setValue(1);

	}

	@FXML
    void habilitarLabelProductos(ActionEvent event) {
    	if(cmbboxTIpoProducto.getSelectionModel().getSelectedItem().equals("Producto Perecedero")){
    		this.lblFechaVencimiento.setEditable(true);
    		this.lblCodigoAprobacion.setEditable(false);
    		this.lblTempRefri.setEditable(false);
    		this.lblFechaEnvasado.setEditable(false);
    		this.lblPesoEnvase.setEditable(false);
    		cmbboxPaisOrigen.setDisable(true);
    		this.lblFechaVencimiento.setText("");
    		this.lblCodigoAprobacion.setText("");
    		this.lblTempRefri.setText("");
    		this.lblFechaEnvasado.setText("");
    		this.lblPesoEnvase.setText("");

    	}
    	else{
    		if(cmbboxTIpoProducto.getSelectionModel().getSelectedItem().equals("Producto Refrigerado")){
    			this.lblFechaVencimiento.setEditable(false);
        		this.lblCodigoAprobacion.setEditable(true);
        		this.lblTempRefri.setEditable(true);
        		this.lblFechaEnvasado.setEditable(false);
        		this.lblPesoEnvase.setEditable(false);
        		cmbboxPaisOrigen.setDisable(true);
        		this.lblFechaVencimiento.setText("");
        		this.lblCodigoAprobacion.setText("");
        		this.lblTempRefri.setText("");
        		this.lblFechaEnvasado.setText("");
        		this.lblPesoEnvase.setText("");
    		}
    		else{
    			this.lblFechaVencimiento.setEditable(false);
        		this.lblCodigoAprobacion.setEditable(false);
        		this.lblTempRefri.setEditable(false);
        		this.lblFechaEnvasado.setEditable(true);
        		this.lblPesoEnvase.setEditable(true);
        		cmbboxPaisOrigen.setDisable(false);
        		this.lblFechaVencimiento.setText("");
        		this.lblCodigoAprobacion.setText("");
        		this.lblTempRefri.setText("");
        		this.lblFechaEnvasado.setText("");
        		this.lblPesoEnvase.setText("");
    		}
    	}
    }

    @FXML
    void llenarNombreCliente(ActionEvent event) {

    }

    @FXML
    void habilitarPaneles(ActionEvent event) {
    	Object evt = event.getSource();
    	if(cmbboxTipoCliente.getSelectionModel().getSelectedItem().equals("Persona Juridica")){
    		lblNIT.setEditable(true);
    		lblEmailCliente.setEditable(false);
    		lblFechaNacimiento.setEditable(false);
    		lblNIT.setText("");
    		lblEmailCliente.setText("");
    		lblFechaNacimiento.setText("");
    	}
    	else{
    		lblNIT.setEditable(false);
    		lblEmailCliente.setEditable(true);
    		lblFechaNacimiento.setEditable(true);
    		lblNIT.setText("");
    		lblEmailCliente.setText("");
    		lblFechaNacimiento.setText("");
    	}

    }

   @FXML
    void vaciarCampos(ActionEvent event) {
    	lblNombreCliente.setText("");
    	lblApellidoCliente.setText("");
    	lblIDCliente.setText("");
    	lblDireccion.setText("");
    	lblTel.setText("");
    	lblEmailCliente.setText("");
    	lblFechaNacimiento.setText("");
    	lblNIT.setText("");
    }

    @FXML
    void vaciarCamposProducto(ActionEvent event) {
    	this.lblFechaVencimiento.setText("");
		this.lblCodigoAprobacion.setText("");
		this.lblTempRefri.setText("");
		this.lblFechaEnvasado.setText("");
		this.lblPesoEnvase.setText("");
		this.lblCodigoCliente.setText("");
		this.lblNombreProducto.setText("");
		this.lblValorProducto.setText("");
		this.lblDescripcionCliente.setText("");
		this.lblCantidadProducto.setText("");
    }

    @FXML
    void vaciarCamposProductos(ActionEvent event) {

    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		this.clmNombreCliente.setCellValueFactory(new PropertyValueFactory("nombre"));
		this.clmIDCliente.setCellValueFactory(new PropertyValueFactory("identificacion"));
		this.clmTelCliente.setCellValueFactory(new PropertyValueFactory("telefono"));
		this.clmCodigoProducto.setCellValueFactory(new PropertyValueFactory("codigo"));
		this.clmNombreProducto.setCellValueFactory(new PropertyValueFactory("nombre"));
		this.clmValorUnitario.setCellValueFactory(new PropertyValueFactory("valor"));
		this.clmCantidadesProducto.setCellValueFactory(new PropertyValueFactory("cantidad"));
		this.clmCodigoProductoTransaccion.setCellValueFactory(new PropertyValueFactory<>("codigoProducto"));
		this.clmCantidadTransaccion.setCellValueFactory(new PropertyValueFactory<>("cantidadUnidades"));
		this.clmSubTotalTransaccion.setCellValueFactory(new PropertyValueFactory<>("subTotal"));
		this.clmCodigoTransaccion.setCellValueFactory(new PropertyValueFactory<>("codigo"));
		this.clmFechaTrasaccion.setCellValueFactory(new PropertyValueFactory<>("fechaTransaccion"));
		this.clmTotalTransaccion.setCellValueFactory(new PropertyValueFactory<>("totalVenta"));

		lblTotalTransaccion.setText(0+"");


		llenarComboboxClientes();
		llenarComboboxProductos();
		llenarSpinnerCantProducto();

	}

	@FXML
    void seleccionarTransaccion(MouseEvent event) {
		Transaccion transaccion = tblTransacciones.getSelectionModel().getSelectedItem();

		if(transaccion!=null){

			this.lblCodigoTransaccion.setText(transaccion.getCodigo());
			this.lblFechaTransaccion.setText(transaccion.getFechaTransaccion());
			this.lblIDClienteCompra.setText(transaccion.getCliente().getIdentificacion());
			this.ObservableListDetalles.addAll(transaccion.getListaDetallesTransaccion());
			refrescarTabla();
		}

    }


	@FXML
    void eliminarProductoFactura(ActionEvent event) {
		DetalleTransaccion detalleAuxiliar = this.tblFactura.getSelectionModel().getSelectedItem();

		if (detalleAuxiliar != null){
			this.ObservableListDetalles.remove(detalleAuxiliar);
			refrescarTabla();
			lblTotalTransaccion.setText(Float.valueOf(lblTotalTransaccion.getText())-detalleAuxiliar.getSubTotal()+"");

		}
		else{
			aplicacion.enviarAlerta("Alerta","Error","No ha seleccionado ningun producto", AlertType.ERROR);
		}
	}

	@FXML
    void agregarProductoTransaccion(ActionEvent event) {

		String codigoProducto = lblCodigoProductoCompra.getText();
		int cantidad = spinnerCantProducto.getValue();
		Producto productoSeleccionado = aplicacion.buscarProducto(codigoProducto);

		if(productoSeleccionado!=null){

			if(cantidad<= productoSeleccionado.getCantidad()){
				DetalleTransaccion detalleAuxiliar = new DetalleTransaccion(cantidad,(productoSeleccionado.getValor()*cantidad), productoSeleccionado, codigoProducto);
				this.ObservableListDetalles.add(detalleAuxiliar);
				refrescarTabla();
				aplicacion.reducirStockProducto(cantidad, productoSeleccionado);
				lblTotalTransaccion.setText(Float.valueOf(lblTotalTransaccion.getText())+(productoSeleccionado.getValor()*cantidad)+"");
				vaciarCamposDetalle();
			}
			else{
				aplicacion.enviarAlerta("Alerta","Error","La cantidad Seleccionada no se encunetra en Stock", AlertType.ERROR);
			}
		}
		else{
			aplicacion.enviarAlerta("Alerta","Error","No se encontro  ningun producto registrado con ese codigo", AlertType.ERROR);
		}
    }

	private void vaciarCamposDetalle() {
		lblCodigoProductoCompra.setText("");
		spinnerCantProducto.getValueFactory().setValue(1);

	}

	private void refrescarTabla() {
		tblTransacciones.setItems(ObservablelistTransaccion);
		tblFactura.setItems(ObservableListDetalles);
	}

	private void llenarSpinnerCantProducto() {
		SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1,10,1);
        valueFactory.setValue(1);
        this.spinnerCantProducto.setValueFactory(valueFactory);
	}

	@FXML
    void confirmarUsuario(MouseEvent event) {
		String idUsuario = this.lblIDClienteCompra.getText();
		Cliente clienteSeleccionado = aplicacion.buscarCliente(idUsuario);
		this.lblClienteTransaccion.setText(clienteSeleccionado.getNombre()+clienteSeleccionado.getApellidos());

    }


	private void llenarComboboxProductos() {
		// TODO Auto-generated method stub
		ArrayList<String>list = new ArrayList<>();
		Collections.addAll(list, "Producto Envasado","Producto Perecedero", "Producto Refrigerado");
		cmbboxTIpoProducto.getItems().addAll(list);
		cmbboxPaisOrigen.getItems().addAll(PaisOrigen.values());
		cmbboxPaisOrigen.setDisable(true);
	}

	private void llenarComboboxClientes() {
		// TODO Auto-generated method stub
		ArrayList<String>list = new ArrayList<>();
		Collections.addAll(list, "Persona Juridica","Persona Natural");
		cmbboxTipoCliente.getItems().addAll(list);


	}

	public void setAplication(Aplicacion aplicacion) {
		this.aplicacion = aplicacion;


	}

}
