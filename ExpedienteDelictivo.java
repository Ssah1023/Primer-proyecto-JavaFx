
package expedientedelictivo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.RowConstraints;
import javafx.geometry.Insets;
import javafx.scene.layout.VBox;

/**
 *
 * @author betin
 */
public class ExpedienteDelictivo extends Application {
    
    private TextField nombreDenuncianteField;
    private TextField direccionDenuncianteField;
    private TextField nombreDenunciadoField;
    private TextField direccionDenunciadoField;
    private TextField tipoDelitoField;
    private TextField edadDenuncianteField;
    private TextField edadDenunciadoField;
    private TextField sexoDenuncianteField;
    private TextField sexoDenunciadoField;
    
    public static void main(String[] args) {
        launch(args);
    }
    
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Bienvenido al Sistema de Denuncias");
        
        Button ingresarButton = new Button("Ingresar");
        ingresarButton.setStyle("-fx-background-color: #5D9CAB; -fx-text-fill: white; -fx-font-weight: bold;"); // estilo
        ingresarButton.setOnAction(e -> mostrarFormulario(primaryStage));
        
        VBox welcomeLayout = new VBox(10);
        welcomeLayout.getChildren().addAll(ingresarButton);
        welcomeLayout.setPadding(new Insets(10));
        welcomeLayout.setStyle("-fx-padding: 100px; -fx-background-color: #9E9FA1;"); // estilo
        
        Scene welcomeScene = new Scene(welcomeLayout, 500, 200);
        
        primaryStage.setScene(welcomeScene);
        primaryStage.show();
    }
    
    private void mostrarFormulario(Stage primaryStage) {
        primaryStage.setTitle("Sistema de Denuncias");

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setStyle("-fx-padding: 70px; -fx-background-color: #9E9FA1;"); // estilo
        
        ColumnConstraints col1 = new ColumnConstraints();
        col1.setPercentWidth(30);
        ColumnConstraints col2 = new ColumnConstraints();
        col2.setPercentWidth(70);
        grid.getColumnConstraints().addAll(col1, col2);
                  
        Label nombreDenuncianteLabel = new Label("Nombre del Denunciante:");
        nombreDenuncianteLabel.setStyle("-fx-font-weight: bold;"); // estilo
        grid.add(nombreDenuncianteLabel, 0, 0); // numeracion u orden de cada label
        nombreDenuncianteField = new TextField();
        grid.add(nombreDenuncianteField, 1, 0); // numeracion u orden de cada label

        Label direccionDenuncianteLabel = new Label("Dirección del Denunciante:");
        grid.add(direccionDenuncianteLabel, 0, 1);
        direccionDenuncianteField = new TextField();
        grid.add(direccionDenuncianteField, 1, 1);
        
        Label edadDenuncianteLabel = new Label("edad del Denunciante:");
        edadDenuncianteLabel.setStyle("-fx-font-weight: bold;"); // estilo
        grid.add(edadDenuncianteLabel, 0, 2);
        edadDenuncianteField = new TextField();
        grid.add(edadDenuncianteField, 1, 2);
        
        Label sexoDenuncianteLabel = new Label("sexo del Denunciante:");
        grid.add(sexoDenuncianteLabel, 0, 3);
        sexoDenuncianteField = new TextField();
        grid.add(sexoDenuncianteField, 1, 3);

        Label nombreDenunciadoLabel = new Label("Nombre del Denunciado:");
        nombreDenunciadoLabel.setStyle("-fx-font-weight: bold;"); // estilo
        grid.add(nombreDenunciadoLabel, 0, 4);
        nombreDenunciadoField = new TextField();
        grid.add(nombreDenunciadoField, 1, 4);

        Label direccionDenunciadoLabel = new Label("Dirección del Denunciado:");
        grid.add(direccionDenunciadoLabel, 0, 5);
        direccionDenunciadoField = new TextField();
        grid.add(direccionDenunciadoField, 1, 5);
        
        Label edadDenunciadoLabel = new Label("edad del Denunciado:");
        edadDenunciadoLabel.setStyle("-fx-font-weight: bold;"); // estilo
        grid.add(edadDenunciadoLabel, 0, 6);
        edadDenunciadoField = new TextField();
        grid.add(edadDenunciadoField, 1, 6);
        
        Label sexoDenunciadoLabel = new Label("sexo del Denunciado:");
        grid.add(sexoDenunciadoLabel, 0, 7);
        sexoDenunciadoField = new TextField();
        grid.add(sexoDenunciadoField, 1, 7);

        Label tipoDelitoLabel = new Label("Tipo de Delito:");
        tipoDelitoLabel.setStyle("-fx-font-weight: bold;"); // estilo
        grid.add(tipoDelitoLabel, 0, 8);
        tipoDelitoField = new TextField();
        grid.add(tipoDelitoField, 1, 8);

        Button registrarButton = new Button("Registrar Denuncia");
        registrarButton.setStyle("-fx-background-color: #5D9CAB; -fx-text-fill: white; -fx-font-weight: bold;"); // estilo
        grid.add(registrarButton, 0, 9);

        Button limpiarButton = new Button("Limpiar Campos");
        limpiarButton.setStyle("-fx-background-color: #5D9CAB; -fx-text-fill: white; -fx-font-weight: bold;"); // estilo
        grid.add(limpiarButton, 1, 9);
        
        registrarButton.setOnAction(event -> registrarDenuncia());
        limpiarButton.setOnAction(event -> limpiarCampos());

        Scene scene = new Scene(grid, 800, 600); // ancho y alto
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void registrarDenuncia() {
        String nombreDenunciante = nombreDenuncianteField.getText();
        String direccionDenunciante = direccionDenuncianteField.getText();
        String edadDenunciante = edadDenuncianteField.getText();
        String sexoDenunciante = sexoDenuncianteField.getText();
        String nombreDenunciado = nombreDenunciadoField.getText();
        String direccionDenunciado = direccionDenunciadoField.getText();
        String edadDenunciado = edadDenunciadoField.getText();
        String sexoDenunciado = sexoDenunciadoField.getText();
        String tipoDelito = tipoDelitoField.getText();
        

        Persona denunciante = new Persona(nombreDenunciante, direccionDenunciante, edadDenunciante, sexoDenunciante);
        Persona denunciado = new Persona(nombreDenunciado, direccionDenunciado, edadDenunciado, sexoDenunciado);
        Delito delito = new Delito(tipoDelito);

        GestorDenuncias gestor = new GestorDenuncias();
        int numeroExpediente = gestor.registrarDenuncia(denunciante, denunciado, delito);
        System.out.println("Se ha registrado la denuncia con el número de expediente: " + numeroExpediente);
        
        guardarDenunciaEnBD(nombreDenunciante, direccionDenunciante, edadDenunciante, sexoDenunciante, nombreDenunciado, direccionDenunciado, tipoDelito, edadDenunciado, sexoDenunciado);
        
        limpiarCampos(); // Limpia los campos después de registrar la denuncia
    }

    private void limpiarCampos() {
        nombreDenuncianteField.clear();
        direccionDenuncianteField.clear();
        edadDenuncianteField.clear();
        sexoDenuncianteField.clear();
        nombreDenunciadoField.clear();
        direccionDenunciadoField.clear();
        edadDenunciadoField.clear();
        sexoDenunciadoField.clear();
        tipoDelitoField.clear();
    }

    private void guardarDenunciaEnBD(String nombreDenunciante, String direccionDenunciante,String edadDenunciante, String sexoDenunciante, String nombreDenunciado, String direccionDenunciado, String edadDenunciado, String sexoDenunciado, String tipoDelito) {
        try (Connection conn = ConexionBD.getConnection()) {
            String sql = "INSERT INTO expedientes (nombre_denunciante, direccion_denunciante, edad_denunciante, sexo_denunciante, nombre_denunciado, direccion_denunciado, edad_denunciado, sexo_denunciado, tipo_delito) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, nombreDenunciante);
            statement.setString(2, direccionDenunciante);
            statement.setString(3, edadDenunciante);
            statement.setString(4, sexoDenunciante);
            statement.setString(5, nombreDenunciado);
            statement.setString(6, direccionDenunciado);
            statement.setString(7, edadDenunciado);
            statement.setString(8, sexoDenunciado);
            statement.setString(9, tipoDelito);
            statement.executeUpdate();
            System.out.println("Denuncia guardada en la base de datos.");
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Error al guardar la denuncia en la base de datos: " + ex.getMessage());
        }
    }
}















/**
    public void start(Stage primaryStage) {
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });
        
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
         public static void main(String[] args) {
        launch(args);
    }
    */

