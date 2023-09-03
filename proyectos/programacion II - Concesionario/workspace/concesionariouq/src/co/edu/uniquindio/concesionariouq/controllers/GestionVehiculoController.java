package co.edu.uniquindio.concesionariouq.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class GestionVehiculoController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtVelocidad;

    @FXML
    private TextField txtModelo;

    @FXML
    private ComboBox<?> cajaCombustible;

    @FXML
    private Button btnFiltrar;

    @FXML
    private Button btnEliminar;

    @FXML
    private ComboBox<?> cajaCambios;

    @FXML
    private TextField txtCilindraje;

    @FXML
    private TextField txtMarca;

    @FXML
    private ComboBox<?> cajaEstado;

    @FXML
    void initialize() {
    }
    
}

