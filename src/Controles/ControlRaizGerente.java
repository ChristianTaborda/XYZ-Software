package Controles;

import java.io.IOException;
import java.util.Optional;

import com.jfoenix.controls.JFXButton;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.Alert.AlertType;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.util.Duration;
public class ControlRaizGerente {
	private Stage escenario;
	private double x, y;

    @FXML private Button cerrar;
    @FXML private Button minimizar;

    @FXML private BorderPane panelRaiz;    
    @FXML private Pane panelCentral;
    @FXML private Text nombreGerente;
 
    @FXML private JFXButton botonRegistroPersonal;
    @FXML private JFXButton botonRegistroSedes;
    @FXML private JFXButton botonActualizarPersonal;
    @FXML private JFXButton botonActualizarSede;
    @FXML private JFXButton botonActualizaritems;
    @FXML private JFXButton botonConsultarPersonal;    
    @FXML private JFXButton botonConsultarSedes;


    
	public void initialize(String nombre){
		nombreGerente.setText(nombre);
	}
	
    public void setStage(Stage escenario) {
    	this.escenario = escenario;
    }
    
    public void efectoCambio(FXMLLoader cargador) {
		try {
			Parent gui = (Parent)cargador.load();
			panelCentral.getChildren().clear();
			panelCentral.getChildren().add(gui);
			Scene scene = gui.getScene();						
			gui.translateXProperty().set(scene.getWidth());		
			Timeline timeline = new Timeline();
			KeyValue rango = new KeyValue(gui.translateXProperty(), 0, Interpolator.EASE_IN);
			KeyFrame duracion = new KeyFrame(Duration.seconds(0.4), rango);
			timeline.getKeyFrames().add(duracion);
			timeline.play();
		} catch (IOException e) {
			System.out.println("Se presento un problema con la carga del modulo: " + e.getMessage());
		}		
    }
       
    @FXML
    void registrarPersonal(ActionEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("/Vistas/gerente_registro_personal.fxml"));
		efectoCambio(loader);		
    }

    @FXML

//Carga la pantalla de registro de items cuando el boton "registrarItems" es pulsado.
    void registrarItems(ActionEvent event) {
    FXMLLoader reg_itm = new FXMLLoader();
    registrarItems.setLocation(getClass().getResource("/Vistas/gerente_registro_items.fxml"));
       efectoCambio(loader);
    }	

    void registroSedes(ActionEvent event) {		

		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("/Vistas/gerente_registro_sedes.fxml"));
		efectoCambio(loader);
    }
    
    @FXML
    void actualizarSede(ActionEvent event) {
    	FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("/Vistas/gerente_actualizar_sede1.fxml"));
		efectoCambio(loader);
    }
    
    @FXML
    void cargarInterfazAP1(ActionEvent event) {
    	FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(getClass().getResource("/Vistas/gerente_actualizar_personal1.fxml"));
		efectoCambio(loader);  	
    }
    
    @FXML
    void actualizarItems(ActionEvent event) {
    	FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(getClass().getResource("/Vistas/gerente_actualizar_items_prueba.fxml"));
		efectoCambio(loader); 
    }

    @FXML
    void consultarPersonal(ActionEvent event) {		
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("/Vistas/gerente_consultar_personal.fxml"));
		efectoCambio(loader);
    }
    
    @FXML
    void consultarSedes(ActionEvent event) {		
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("/Vistas/gerente_consultar_sedes.fxml"));
		efectoCambio(loader);
    }
    
    @FXML
    void copiarCoordenadas(MouseEvent event) {
    	x = event.getSceneX();
    	y = event.getSceneY();
    }
    @FXML
    void moverPanel(MouseEvent event) {
    	escenario.setX(event.getScreenX() - x);
    	escenario.setY(event.getScreenY() - y);
    }
    
    //Para Cerrar la ventana raiz
    @FXML
    void cerrarAplicacion(ActionEvent event) {
    	Alert alert = new Alert(AlertType.CONFIRMATION);
    	alert.setHeaderText("Est� a punto de cerrar la aplicaci�n");
    	alert.setContentText("�Est� seguro de que desea salir?");

    	Optional<ButtonType> result = alert.showAndWait();
    	if (result.get() == ButtonType.OK){
    	    System.exit(1);
    	}
    }

    //Para minimizar la ventana raiz
    @FXML
    void minimizarAplicacion(ActionEvent event) {
    	Stage stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        stage.setIconified(true);
    }
}
