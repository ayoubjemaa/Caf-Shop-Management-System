/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cafeshopmanagementsys;

import javafx.application.Application;
import javafx.fxml.FXMLLoader; //Classe de JavaFX utilisée pour charger des fichiers FXML.
import javafx.scene.Parent;// classe abstraite qui représente les conteneurs pouvant avoir des nœuds enfants.
import javafx.scene.Scene;//une classe qui représente la scène graphique ou le conteneur racine d'une interface utilisateur dans une application JavaFX.
import javafx.stage.Stage;//Classe représentant une fenêtre JavaFX

/**
 *
 * @author PRO BOOK
 */
public class CafeShopManagementSys extends Application {//Cela indique qu'il s'agit d'une application JavaFX, et JavaFX appellera ses méthodes définies dans le cycle de vie.
    @Override
    public void start(Stage stage) throws Exception {//Méthode principale de JavaFX, appelée automatiquement lors du démarrage de l'application. Paramètre Stage stage : Représente la fenêtre principale où l'interface sera affichée.
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));// Charger un fichier FXML et le convertir en un objet Parent
        Scene scene = new Scene(root);
        stage.setTitle("Cafe Shop Management System");
        stage.setMinHeight(400);stage.setMinWidth(600);
        //stage.setMaxHeight(500);stage.setMaxWidth(800);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
        //Appelle automatiquement le cycle de vie de JavaFX. +
        //Initialise l'application et déclenche la méthode start.
        
    }

}
