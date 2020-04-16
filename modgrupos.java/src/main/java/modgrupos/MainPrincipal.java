package main.java.modgrupos;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainPrincipal extends Application implements Initializable {
    public static void main( String[] args ) { launch(args); }
    @FXML
    public ListView<String> listagrupos;
    @FXML private TextField txtName;
    ObservableList<String> list = FXCollections.observableArrayList("ITI-2456","ITI-2214","ITI-5722","ITI-2323");

    //String groupname;


    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/Principal.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Grupos UPV");
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        listagrupos.setItems(list);
    }

    public void addgrupo(ActionEvent event) throws IOException {

        if(txtName.getText()!=null){
            listagrupos.getItems().addAll(txtName.getText());
        }

    }

    public void editgrupo(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/editargrupo.fxml"));
        Scene scene = new Scene(root);
        Stage primaryStage = new Stage();
        primaryStage.setScene(scene);
        primaryStage.setTitle("Editar");
        primaryStage.setResizable(false);
        primaryStage.show();

        String groupnames;
        groupnames = listagrupos.getSelectionModel().getSelectedItem();
        System.out.println(groupnames);
    }

    public void delgrupo(ActionEvent event) {
        final int selectedIdx = listagrupos.getSelectionModel().getSelectedIndex();
        listagrupos.getItems().remove(selectedIdx);
    }


    public void visgrupo(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/visualizargrupo.fxml"));
        Scene scene = new Scene(root);
        Stage primaryStage = new Stage();
        primaryStage.setScene(scene);
        primaryStage.setTitle("Grupos UPV");
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}