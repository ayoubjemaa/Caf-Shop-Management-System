/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cafeshopmanagementsys;

import java.net.URL;
import java.sql.Connection;// Pour la connexion à la base de données
import java.sql.PreparedStatement;//PreparedStatement est une interface utilisé pour préparer une requête SQL, puis pour la remplir avec des valeurs (paramètres) avant d'exécuter la requête.
import java.sql.ResultSet;//pour récupérer les résultats de la requête SELECT
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
//import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/* javafx.scene.control :
Un package contenant des classes pour créer des contrôles utilisateur 
(widgets ou composants d'interface),tels que les boutons, les champs de texte, ou les barres de défilement.
javafx.scene.layout : 
Un package contenant des classes pour organiser les composants graphiques 
(contrôles) dans une interface graphique, cad des conteneurs (layouts).*/
/**
 *
 * @author PRO BOOK
 */
public class FXMLDocumentController implements Initializable {//Fournit la méthode initialize() pour les contrôleurs JavaFX.

    @FXML
    private AnchorPane rootAnchorPane; // Correspond à l'ID défini dans le FXML
    @FXML
    private AnchorPane si_loginForm;
    @FXML
    private TextField si_username;
    @FXML
    private PasswordField si_password;
    @FXML
    private TextField si_password_show;
    @FXML
    private CheckBox login_show_password;

    @FXML
    private Hyperlink si_forgotPass;
    @FXML
    private Button si_loginBtn;
    @FXML
    private AnchorPane su_signupForm;
    @FXML
    private TextField su_username;
    @FXML
    private PasswordField su_password;
    @FXML
    private ComboBox<?> su_question;
    @FXML
    private TextField su_answer;
    @FXML
    private Button su_signupBtn;
    @FXML
    private AnchorPane side_form;
    @FXML
    private Button side_CreateBtn;
    @FXML
    private Button side_alreadyHave;
    @FXML
    private AnchorPane fp_question_form;
    @FXML
    private TextField fp_username;
    @FXML
    private ComboBox<?> fp_question;
    @FXML
    private PasswordField fp_answer;
    @FXML
    private Button fp_proceedBtn;
    @FXML
    private Button fp_backBtn;
    @FXML
    private AnchorPane np_newPassForm;
    @FXML
    private PasswordField np_newPassword;
    @FXML
    private PasswordField np_confirmPassword;
    @FXML
    private Button np_changePassBtn;
    @FXML
    private Button np_backBtn;
    private Connection connect;
    private PreparedStatement prepare;//une interface dans l'API JDBC (Java Database Connectivity).
    private ResultSet result;
    private Alert alert;

    public void loginBtn()//boutton login
    {
        if (login_show_password.isSelected()) {
            si_password.setText(si_password_show.getText());
        }
        if (si_username.getText().isEmpty() || si_password.getText().isEmpty()) {
            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Please fill all blank fields");
            alert.showAndWait();
            si_username.setText("");
            si_password.setText("");
            si_password_show.setText("");
        } else {
            String selectData = "SELECT username,password FROM employee where username= ? AND password=?";
            connect = DataBase.connectDB();
            try {
                prepare = connect.prepareStatement(selectData);
                prepare.setString(1, si_username.getText());
                prepare.setString(2, si_password.getText());
                result = prepare.executeQuery();
                //if successfully login,then proceeed to another from which is our main form
                if (result.next()) {
                    //to get the username that user used
                    Data.setUsername(si_username.getText());
                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Login !");
                    alert.showAndWait();
                    si_username.setText("");
                    si_password.setText("");
                    si_password_show.setText("");

                    //open the main form off the app link ur main form 
                    Parent root = FXMLLoader.load(getClass().getResource("mainForm.fxml"));
                    Scene scene = new Scene(root);
                    Stage stage = new Stage();
                    stage.setTitle("Cafe Shop System Manager");
                    stage.setMinHeight(1100);
                    stage.setMinHeight(600);
                    stage.setScene(scene);
                    stage.show();
                    si_loginBtn.getScene().getWindow().hide();//kill login Page
                } else // if not the error message will appear
                {
                    alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Incorrect Username/Password");
                    alert.showAndWait();
                    si_username.setText("");
                    si_password.setText("");
                    si_password_show.setText("");

                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void loginShowPassword() {
        if (login_show_password.isSelected()) {
            si_password_show.setText(si_password.getText());
            si_password.setVisible(false);
            si_password_show.setVisible(true);
        } else {
            si_password.setText(si_password_show.getText());
            si_password_show.setVisible(false);
            si_password.setVisible(true);
        }
    }

    public void regBtn()//button sign up 
    { //boutton sign up clique
        if (su_username.getText().isEmpty() || su_password.getText().isEmpty()
                || su_question.getSelectionModel().getSelectedItem() == null
                || su_answer.getText().isEmpty()) {
            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Please fill all blank fields");
            alert.showAndWait();
            su_username.setText("");
            su_password.setText("");
            su_question.getSelectionModel().clearSelection();
            su_answer.setText("");
        } else {
            String regData = "INSERT INTO employee(username,password,question,answer,date)"
                    + "VALUES(?,?,?,?,?)";//// Crée une requête SQL avec des paramètres (?)
            connect = DataBase.connectDB();//appelle la méthode connectDB() de la classe DataBase pour établir une connexion à la base de données MySQL. 
            try {
                //check if the username is already recorded
                String checkUsername = "SELECT username FROM employee WHERE username='" + su_username.getText() + "'";
                prepare = connect.prepareStatement(checkUsername);
                result = prepare.executeQuery();//executeQuery() est une méthode utilisée pour exécuter des requêtes SQL qui retournent des résultats sous forme de données, telles que des requêtes SELECT.
                if (result.next()) {
                    alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText(su_username.getText() + " is already taken");
                    alert.showAndWait();
                    su_username.setText("");
                    su_password.setText("");
                    su_question.getSelectionModel().clearSelection();
                    su_answer.setText("");
                } else if (su_password.getText().length() < 5) {
                    alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("invalid password, atleast 5 characters are needed");
                    alert.showAndWait();
                    su_username.setText("");
                    su_password.setText("");
                    su_question.getSelectionModel().clearSelection();
                    su_answer.setText("");
                } else {
                    prepare = connect.prepareStatement(regData);//prépare la requête SQL à l'aide de la connexion établie. 
                    // Remplir les paramètres avec des valeurs spécifiques
                    prepare.setString(1, su_username.getText());
                    prepare.setString(2, su_password.getText());
                    prepare.setString(3, (String) su_question.getSelectionModel().getSelectedItem());
                    prepare.setString(4, su_answer.getText());
                    Date date = new Date();
                    java.sql.Date sqlDate = new java.sql.Date(date.getTime());
                    prepare.setString(5, String.valueOf(sqlDate));
                    prepare.executeUpdate();//exécute la requête SQL d'insertion(insert,upadate..)   dans la base de données. 

                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully registered Account !");
                    alert.showAndWait();

                    su_username.setText("");
                    su_password.setText("");
                    su_question.getSelectionModel().clearSelection();
                    su_answer.setText("");

                    TranslateTransition slider = new TranslateTransition();
                    slider.setNode(side_form);
                    slider.setToX(0);
                    slider.setDuration(javafx.util.Duration.seconds(0.5));
                    slider.setOnFinished(e -> {
                        side_alreadyHave.setVisible(false);
                        side_CreateBtn.setVisible(true);
                    });
                    slider.play(); // Play the animation
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
    private String[] questionTable = {"What is your favourite color ?", "What is your favourite food?", "What is your birthdate?"};

    public void questionList()//questions combox dans su_signup_form su_question
    {
        List<String> listQ = new ArrayList<>();
        for (String data : questionTable) {
            listQ.add(data);
        }
        ObservableList listData = FXCollections.observableArrayList(listQ);//Une ObservableList est une liste qui peut être observée par les composants graphiques (comme un ComboBox)
        su_question.setItems(listData); //argument est de tyoe obsevableList<?>
    }

    public void forgotPassQuestionList()//questions combox dans fp_question_form fp_question
    {
        List<String> listQ = new ArrayList<>();
        for (String data : questionTable) {
            listQ.add(data);
        }
        ObservableList listData = FXCollections.observableArrayList(listQ);
        fp_question.setItems(listData);
    }

    public void switchForgotPass()//hyperlink forgot password
    {
        fp_question_form.setVisible(true);
        si_loginForm.setVisible(false);
        forgotPassQuestionList();
    }

    public void proceedBtn() {//proceedbtn on fp_question_form
        if (fp_username.getText().isEmpty() || fp_question.getSelectionModel().getSelectedItem() == null
                || fp_answer.getText().isEmpty()) {
            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Please fill all blank fields");
            alert.showAndWait();
            fp_username.setText("");
            fp_question.getSelectionModel().clearSelection();
            fp_answer.setText("");
        } else {
            String selectData = "SELECT username,question,answer FROM employee where username = ? AND question = ? AND answer = ?";
            connect = DataBase.connectDB();
            try {
                prepare = connect.prepareStatement(selectData);
                prepare.setString(1, fp_username.getText());
                prepare.setString(2, (String) fp_question.getSelectionModel().getSelectedItem());
                prepare.setString(3, fp_answer.getText());
                result = prepare.executeQuery();
                if (result.next()) {
                    np_newPassForm.setVisible(true);
                    fp_question_form.setVisible(false);

                } else {
                    alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Incorrect Information");
                    alert.showAndWait();
                    fp_username.setText("");
                    fp_question.getSelectionModel().clearSelection();
                    fp_answer.setText("");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public void backtoLoginForm()// "fp_backBtn" back button on fp_question_form
    {
        si_loginForm.setVisible(true);
        fp_question_form.setVisible(false);
        si_username.setText("");
        si_password.setText("");
        si_password_show.setText("");

    }

    public void BacktoQuesionForm()//"np_backBtn" back button on np_newPassForm
    {
        fp_question_form.setVisible(true);
        np_newPassForm.setVisible(false);
        fp_question.getSelectionModel().clearSelection();
        fp_answer.setText("");
        fp_username.setText("");
    }

    public void changePassBtn() {//changepassword button on np_newPassForm
        if (np_newPassword.getText().isEmpty() || np_confirmPassword.getText().isEmpty()) {
            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Please fill all blank fields");
            alert.showAndWait();
            np_newPassword.setText("");
            np_confirmPassword.setText("");
            //np_newPassword.setText("");np_confirmPassword.setText("");
        } else {
            if (np_newPassword.getText().equals(np_confirmPassword.getText())) {
                connect = DataBase.connectDB();
                String updatePass = "UPDATE employee SET password = ? WHERE username=? AND question=? AND answer = ?";
                try {
                    prepare = connect.prepareStatement(updatePass);
                    prepare.setString(1, np_newPassword.getText());
                    prepare.setString(2, fp_username.getText());
                    prepare.setString(3, (String) fp_question.getSelectionModel().getSelectedItem());
                    prepare.setString(4, fp_answer.getText());
                    prepare.executeUpdate();
                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully changed Password!");
                    alert.showAndWait();
                    si_loginForm.setVisible(true);
                    np_newPassForm.setVisible(false);

                    //to clear fields
                    np_newPassword.setText("");
                    np_confirmPassword.setText("");
                    fp_question.getSelectionModel().clearSelection();
                    fp_answer.setText("");
                    fp_username.setText("");
                } catch (Exception e) {
                    e.printStackTrace();
                }

            } else {
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Not match");
                alert.showAndWait();
                np_newPassword.setText("");
                np_confirmPassword.setText("");

                //np_newPassword.setText("");np_confirmPassword.setText("");
            }

        }
    }

    public void switchForm(ActionEvent event) {//create new account and already have account buttons
        TranslateTransition slider = new TranslateTransition();
        if (event.getSource() == side_CreateBtn) {
            su_username.setText("");
            su_password.setText("");
            su_answer.setText("");
            su_question.getSelectionModel().clearSelection();

            slider.setNode(side_form); // Set the node to animate
            slider.setToX(300); // Move the panel 300 units along the X-axis
            slider.setDuration(javafx.util.Duration.seconds(0.5)); // Set the duration to 0.5 seconds
            // Set an action to perform after the animation finishes
            slider.setOnFinished(e -> {
                side_alreadyHave.setVisible(true); // Show the "Already Have Account" button
                side_CreateBtn.setVisible(false); // Hide the "Create Account" button
                fp_question_form.setVisible(false);
                si_loginForm.setVisible(true);
                np_newPassForm.setVisible(false);
                questionList();
            });
            slider.play(); // Play the animation
        } else if (event.getSource() == side_alreadyHave) {
            si_username.setText("");
            si_password.setText("");
            si_password_show.setText("");
            slider.setNode(side_form);
            slider.setToX(0);
            slider.setDuration(javafx.util.Duration.seconds(0.5));
            slider.setOnFinished(e -> {
                side_alreadyHave.setVisible(false);
                side_CreateBtn.setVisible(true);
                /*
                fp_question_form.setVisible(false);
                si_loginForm.setVisible(true);
                np_newPassForm.setVisible(false);*/
            });
            slider.play(); // Play the animation

        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) { // effectuer toute initialisation ou toute action que vous souhaitez réaliser avant que l'interface graphique soit affichée à l'utilisateur.
        //si_username.setText("Nom d'utilisateur");
        // TODO 
        //questionList();
        si_loginForm.setVisible(true);

    }//est appelée automatiquement par le framework JavaFX après le chargement du fichier FXML.

}
