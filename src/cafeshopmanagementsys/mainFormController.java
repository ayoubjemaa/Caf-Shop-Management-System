/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cafeshopmanagementsys;

import java.util.Date;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;//permettre à des écouteurs d'être informés automatiquement des changements qui surviennent dans la liste
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import static javafx.scene.control.ButtonType.OK;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author PRO BOOK
 */
public class mainFormController implements Initializable {

    @FXML
    private AnchorPane menu_recette;

    @FXML
    private AnchorPane menu_form;
    @FXML
    private AnchorPane dashboard_form;
    @FXML
    private Button customers_btn;
    @FXML
    private Button dashboard_btn;
    @FXML
    private Button inventory_addBtn;
    @FXML
    private Button inventory_btn;
    @FXML
    private Button inventory_clearBtn;
    @FXML
    private TableColumn<ProductData, String> inventory_col_date;
    @FXML
    private TableColumn<ProductData, Double> inventory_col_price;
    @FXML
    private TableColumn<ProductData, Integer> inventory_col_productID;
    @FXML
    private TableColumn<ProductData, String> inventory_col_productName;
    @FXML
    private TableColumn<ProductData, String> inventory_col_status;
    @FXML
    private TableColumn<ProductData, Integer> inventory_col_stock;
    @FXML
    private TableColumn<ProductData, String> inventory_col_type;
    @FXML
    private Button inventory_deleteBtn;
    @FXML
    private AnchorPane inventory_form;
    @FXML
    private ImageView inventory_imageView;
    @FXML
    private Button inventory_importBtn;
    @FXML
    private TableView<ProductData> inventory_tableView;
    @FXML
    private Button inventory_updateBtn;
    @FXML
    private Button logout_btn;
    @FXML
    private AnchorPane main_form;
    @FXML
    private Label username;
    @FXML
    private TextField inventory_price;
    @FXML
    private TextField inventory_productID;
    @FXML
    private TextField inventory_productName;
    @FXML
    private ComboBox<String> inventory_status;
    @FXML
    private TextField inventory_stock;
    @FXML
    private ComboBox<String> inventory_type;
    @FXML
    private TextField menu_amount;
    @FXML
    private Button menu_btn;
    @FXML
    private Label menu_change;
    @FXML
    private TableColumn<ProductData, Double> menu_col_price;
    @FXML
    private TableColumn<ProductData, String> menu_col_productName;
    @FXML
    private TableColumn<ProductData, Integer> menu_col_quantity;
    @FXML
    private GridPane menu_gridPane;
    @FXML
    private Button menu_payBtn;
    @FXML
    private Button menu_receiptBtn;
    @FXML
    private Button menu_removeBtn;
    @FXML
    private ScrollPane menu_scrollPane;
    @FXML
    private TableView<ProductData> menu_tableView;
    @FXML
    private Label menu_total;
    @FXML
    private TableColumn<CustomersData, String> customers_col_cashier;
    @FXML
    private TableColumn<CustomersData, Integer> customers_col_customerID;
    @FXML
    private TableColumn<CustomersData, Date> customers_col_date;
    @FXML
    private TableColumn<CustomersData, Double> customers_col_total;
    @FXML
    private AnchorPane customers_form;
    @FXML
    private TableView<CustomersData> customers_tableView;
    @FXML
    private BarChart<?, ?> dashboard_CustomerChart;
    @FXML
    private AreaChart<?, ?> dashboard_IncomeChart;
    @FXML
    private Label dashboard_NC;
    @FXML
    private Label dashboard_NSP;
    @FXML
    private Label dashboard_TI;
    @FXML
    private Label dashboard_TotalI;
    @FXML
    private TextField product_search;

    private Alert alert;
    private Connection connect;
    private PreparedStatement prepare;
    private ResultSet result;
    private Image image;
    @FXML
    private Label time_label;

    private void displayTime() {
        // Formatter pour afficher l'heure, les minutes, les secondes et la date
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss - dd/MM/yyyy");

        // Timeline pour mettre à jour l'heure toutes les secondes
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), event -> {
            LocalDateTime now = LocalDateTime.now();
            time_label.setText(now.format(formatter));
        }));

        // Répéter indéfiniment
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    public void dashboardDisplayNC() {
        String sql = "SELECT COUNT(id) FROM receipt";
        connect = DataBase.connectDB();
        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            if (result.next()) {
                dashboard_NC.setText(String.valueOf(result.getInt("COUNT(id)")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void dashboardDisplayTI() {
        Date date = new Date();
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        String sql = "SELECT SUM(total) FROM receipt WHERE date = ?";
        connect = DataBase.connectDB();
        try {
            prepare = connect.prepareStatement(sql);
            prepare.setDate(1, sqlDate);
            result = prepare.executeQuery();
            if (result.next()) {
                dashboard_TI.setText(String.valueOf("$" + result.getDouble("SUM(total)")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void dashboardDisplayTotalI() {
        String sql = "SELECT SUM(total) FROM receipt ";
        connect = DataBase.connectDB();
        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            if (result.next()) {
                dashboard_TotalI.setText(String.valueOf("$" + result.getDouble("SUM(total)")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void dashboardDisplayNSP() {
        String sql = "SELECT COUNT(quantity) FROM customer";
        connect = DataBase.connectDB();
        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            if (result.next()) {
                dashboard_NSP.setText(String.valueOf(result.getInt("COUNT(quantity)")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void dashboardIncomeChart() {
        dashboard_IncomeChart.getData().clear();
        String sql = "SELECT date, SUM(total) FROM receipt GROUP BY date ORDER BY TIMESTAMP(date)";
        connect = DataBase.connectDB();
        XYChart.Series chart = new XYChart.Series();
        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            while (result.next()) {
                chart.getData().add(new XYChart.Data<>(result.getString(1), result.getFloat(2)));
            }
            dashboard_IncomeChart.getData().add(chart);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void dashboardCustomerChart() {
        dashboard_CustomerChart.getData().clear();
        String sql = "SELECT date, COUNT(id) FROM receipt GROUP BY date ORDER BY TIMESTAMP(date)";
        connect = DataBase.connectDB();
        XYChart.Series chart = new XYChart.Series();
        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            while (result.next()) {
                chart.getData().add(new XYChart.Data<>(result.getString(1), result.getInt(2)));
            }
            dashboard_CustomerChart.getData().add(chart);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void iventoryimportBtn() {
        // Crée un objet FileChooser
        FileChooser openFile = new FileChooser();
        // Ajouter un filtre d'extension pour ne sélectionner que des fichiers PNG ou JPG
        openFile.getExtensionFilters().add(new ExtensionFilter("Open Image File", "*.png", "*.jpg"));
        openFile.setTitle("Select an Image File");
        // Ouvrir la fenêtre de sélection de fichiers et récupérer le fichier sélectionné
        File file = openFile.showOpenDialog(inventory_importBtn.getScene().getWindow());//main_form
        if (file != null) {
            //System.out.println(file.getAbsolutePath());
            Data.setPath(file.getAbsolutePath());
            image = new Image(file.toURI().toString(), 165, 142, false, true);
            inventory_imageView.setImage(image);
        }

    }

    public void inventoryAddBtn() {
        if (inventory_productID.getText().isEmpty() || inventory_productName.getText().isEmpty() || Data.getPath() == null
                || inventory_type.getSelectionModel().getSelectedItem() == null || inventory_stock.getText().isEmpty()
                || inventory_price.getText().isEmpty() || inventory_status.getSelectionModel().getSelectedItem() == null) {
            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Please fill all blank fields");
            alert.showAndWait();
        } else {
            String checkProdID = "SELECT product_id  FROM product WHERE product_id = ?";//l'unicité de produit est en product_id in java
            connect = DataBase.connectDB();
            try {
                prepare = connect.prepareStatement(checkProdID);
                prepare.setString(1, inventory_productID.getText());
                result = prepare.executeQuery();
                if (result.next()) {
                    alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText(inventory_productID.getText() + "is already taken");
                    alert.showAndWait();

                } else {
                    String insertData = "INSERT INTO product(product_id,product_name,type,stock,price,status,image,date)"
                            + "VALUES(?,?,?,?,?,?,?,?)";
                    prepare = connect.prepareStatement(insertData);
                    prepare.setString(1, inventory_productID.getText());
                    prepare.setString(2, inventory_productName.getText());
                    prepare.setString(3, (String) inventory_type.getSelectionModel().getSelectedItem());
                    prepare.setString(4, inventory_stock.getText());
                    prepare.setString(5, inventory_price.getText());
                    prepare.setString(6, (String) inventory_status.getSelectionModel().getSelectedItem());
                    String path = Data.getPath();
                    path = path.replace("\\", "\\\\");
                    prepare.setString(7, path);
                    //to get current date
                    Date date = new Date();
                    java.sql.Date sqlDate = new java.sql.Date(date.getTime());
                    prepare.setString(8, String.valueOf(sqlDate));
                    prepare.executeUpdate();
                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Added!");
                    alert.showAndWait();
                    //to update our table view
                    inventoryShowData();
                    inventoryClearBtn();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void inventoryUpdateBtn() {
        if (inventory_productID.getText().isEmpty() || inventory_productName.getText().isEmpty()
                || inventory_type.getSelectionModel().getSelectedItem() == null || inventory_stock.getText().isEmpty()
                || inventory_price.getText().isEmpty() || inventory_status.getSelectionModel().getSelectedItem() == null
                || Data.getPath() == null || Data.getId() == 0) {
            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Please fill all blank fields");
            alert.showAndWait();
        } else {
            String updateData = "UPDATE product SET product_id = ? ,product_name = ?,"
                    + "type = ? ,stock = ? ,price = ?,status = ?,image= ? ,date = ? WHERE id = ?";//kont najem nal3eb keb 3al product_id
            connect = DataBase.connectDB();
            try {
                prepare = connect.prepareStatement(updateData);
                prepare.setString(1, inventory_productID.getText());
                prepare.setString(2, inventory_productName.getText());
                prepare.setString(3, (String) inventory_type.getSelectionModel().getSelectedItem());
                prepare.setString(4, inventory_stock.getText());
                prepare.setString(5, inventory_price.getText());
                prepare.setString(6, (String) inventory_status.getSelectionModel().getSelectedItem());
                prepare.setString(7, Data.getPath());
                prepare.setString(8, Data.getDate());//ZEYDA
                prepare.setString(9, String.valueOf(Data.getId()));
                alert = new Alert(AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Message");
                alert.setHeaderText(null);
                alert.setContentText("Are u sure do u want to update Product Id : " + inventory_productID.getText() + '?');
                Optional<ButtonType> option = alert.showAndWait();
                if (option.get().equals(ButtonType.OK)) {
                    prepare.executeUpdate();
                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Updated!");
                    alert.showAndWait();
                    //to update ur tableView
                    inventoryShowData();
                    inventoryClearBtn();
                } else {
                    prepare.close();
                    alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Cancelled.");
                    alert.showAndWait();
                    inventoryClearBtn();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void inventoryDeleteBtn() {
        /*
        if (inventory_productID.getText().isEmpty() || inventory_productName.getText().isEmpty()
                || inventory_type.getSelectionModel().getSelectedItem() == null || inventory_stock.getText().isEmpty()
                || inventory_price.getText().isEmpty() || inventory_status.getSelectionModel().getSelectedItem() == null) {
            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Please fill all blank fields");
            alert.showAndWait();
        } else {
            System.out.println(Data.getPath());
            connect = DataBase.connectDB();
            String SelectData = "SELECT * FROM product WHERE product_id = ? ,product_name = ?,"
                    + "type = ? ,stock = ? ,price = ?,status = ?,image= ?";
            try {
                prepare = connect.prepareStatement(SelectData);
                prepare.setString(1, inventory_productID.getText());
                prepare.setString(2, inventory_productName.getText());
                prepare.setString(3, (String)inventory_type.getSelectionModel().getSelectedItem());
                String stock_string =inventory_stock.getText();
                int stock = Integer.parseInt(stock_string);
                prepare.setInt(4, stock);
                //prepare.setString(5,inventory_price.getText()); erreur
                String prix_string =inventory_price.getText();
                Double prix = Double.parseDouble(prix_string);
                prepare.setDouble(5, prix);
                prepare.setString(6,(String)inventory_status.getSelectionModel().getSelectedItem());
                prepare.setString(7, Data.getPath());
                result = prepare.executeQuery();
                if (result.next()) {
                    prepare.close();
                    String deleteString="DELETE FROM product WHERE product_id = ? ,product_name = ?,"
                    + "type = ? ,stock = ? ,price = ?,status = ?,image= ?";
                    alert = new Alert(AlertType.CONFIRMATION);
                    alert.setTitle("Confirmation Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Are u sure do u want to delete Product Id : " + inventory_productID.getText() + '?');
                    Optional<ButtonType> option = alert.showAndWait();
                    if (option.get().equals(ButtonType.OK)) {
                        alert = new Alert(AlertType.INFORMATION);
                        alert.setTitle("Information Message");
                        alert.setHeaderText(null);
                        alert.setContentText("Successfully Deleted!");
                        alert.showAndWait();
                        //to update ur tableView
                        inventoryShowData();
                        inventoryClearBtn();
                    } else {
                        alert = new Alert(AlertType.ERROR);
                        alert.setTitle("Error Message");
                        alert.setHeaderText(null);
                        alert.setContentText("Cancelled.");
                        alert.showAndWait();
                        inventoryClearBtn();
                    }
                } else {
                    alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Product properties don't exist!");
                    alert.showAndWait();
                    inventoryClearBtn();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }*/
        if (inventory_productID.getText().isEmpty() || inventory_productName.getText().isEmpty()
                || inventory_type.getSelectionModel().getSelectedItem() == null || inventory_stock.getText().isEmpty()
                || inventory_price.getText().isEmpty() || inventory_status.getSelectionModel().getSelectedItem() == null
                || Data.getPath() == null || Data.getId() == 0) {
            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Please fill all blank fields");
            alert.showAndWait();
        } else {
            alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Message");
            alert.setHeaderText(null);
            alert.setContentText("Are u sure do u want to delete Product Id : " + inventory_productID.getText() + '?');
            Optional<ButtonType> option = alert.showAndWait();
            if (option.get().equals(ButtonType.OK)) {
                String deleteData = "DELETE FROM product where id=" + Data.getId();
                connect = DataBase.connectDB();
                try {
                    prepare = connect.prepareStatement(deleteData);
                    prepare.executeUpdate();
                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Deleted!");
                    alert.showAndWait();
                    //to update ur tableView
                    inventoryShowData();
                    inventoryClearBtn();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Cancelled.");
                alert.showAndWait();
                inventoryClearBtn();

            }

        }
    }

    public void inventoryClearBtn() {
        inventory_productID.setText("");
        inventory_productName.setText("");
        inventory_type.getSelectionModel().clearSelection();
        inventory_price.setText("");
        inventory_stock.setText("");
        inventory_status.getSelectionModel().clearSelection();
        Data.setPath("");//le path de l'image importé devient vide aprés la clic sur clear
        Data.setId(0);
        inventory_imageView.setImage(null);

    }

    //merge all data 
    public ObservableList<ProductData> inventoryDataList() {
//ObservableList est une interface de javafx qui étend l'interface standard List deJava(dans le package java.util).
        //role : A list that allows listeners to track changes when they occur.

        ObservableList<ProductData> listData = FXCollections.observableArrayList();
        String sql = "SELECT * FROM product";
        connect = DataBase.connectDB();
        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            ProductData prodData;
            while (result.next()) {
                prodData = new ProductData(result.getInt("id"), result.getString("product_id"), result.getString("product_name"),
                        result.getString("type"), result.getInt("stock"), result.getDouble("price"), result.getString("status"),
                        result.getString("image"), result.getDate("date"));
                listData.add(prodData);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;
    }

    //to show on our table
    public void inventoryShowData() {

        // Liaison des colonnes aux propriétés de la classe ProductData
        inventory_col_productID.setCellValueFactory(new PropertyValueFactory<>("productID"));//<>type générique et (arg) arg est nom de propriéte sous forme de String
        /*PropertyValueFactory classe générique utilise la réflexion de Java 
        pour rechercher dynamiquement les getters correspondants dans la classe des objets.
        2éme méthode : inventory_col_productID.setCellValueFactory(cellData -> 
        new SimpleStringProperty(cellData.getValue().getProductID()));*/
        inventory_col_productName.setCellValueFactory(new PropertyValueFactory<>("productName"));
        inventory_col_type.setCellValueFactory(new PropertyValueFactory<>("type"));
        inventory_col_stock.setCellValueFactory(new PropertyValueFactory<>("stock"));
        inventory_col_price.setCellValueFactory(new PropertyValueFactory<>("price"));
        inventory_col_status.setCellValueFactory(new PropertyValueFactory<>("status"));
        inventory_col_date.setCellValueFactory(new PropertyValueFactory<>("date"));

        // Ajouter des données au tableau
        ObservableList<ProductData> inventoryListData = inventoryDataList();
        inventory_tableView.setItems(inventoryListData);
    }

    public void inventory_Search_data() {
        ObservableList<ProductData> inventoryListData = inventoryDataList();
        FilteredList<ProductData> filter = new FilteredList<>(inventoryListData, p -> true);

        product_search.textProperty().addListener((observable, oldValue, newValue) -> {
            filter.setPredicate(product -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();

                if (product.getProductID().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                } else if (product.getProductName().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                } else if (product.getType().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                } else if (product.getPrice() != null && product.getPrice().toString().contains(lowerCaseFilter)) {
                    return true;
                } else if (String.valueOf(product.getStock()).contains(lowerCaseFilter)) {
                    return true;
                } else if (product.getStatus() != null && product.getStatus().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                } else if (product.getDate() != null && product.getDate().toString().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                }
                return false;
            });
        });
        SortedList<ProductData> sortedList = new SortedList<>(filter);
        sortedList.comparatorProperty().bind(inventory_tableView.comparatorProperty());
        inventory_tableView.setItems(sortedList);
    }

    /*
public void inventory_Search_data() {
        ObservableList<ProductData> inventoryListData = inventoryDataList();
        FilteredList<ProductData> filter = new FilteredList<>(inventoryListData, e -> true);

        product_search.textProperty().addListener((observabl, newValue, oldValue) -> {
            filter.setPredicate(predicateCategories -> {
                if (newValue.isEmpty() || newValue == null) {
                    return true;
                }
                String searchKey = newValue.toLowerCase();

                if (predicateCategories.getProductID().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateCategories.getProductName().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateCategories.getType().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateCategories.getPrice().toString().contains(searchKey)) {
                    return true;
                } else if (predicateCategories.getStatus().toLowerCase().contains(searchKey)) {
                    return true;
                } else {
                    return false;
                }
            });
        });

        SortedList<ProductData> sortList = new SortedList<>(filter);
        sortList.comparatorProperty().bind(inventory_tableView.comparatorProperty());
        inventory_tableView.setItems(sortList);
    }*/
    public void inventorySelectData()//clic de souris d'un elemet dans notre tableau ->au dessous qcq propriétés 
    {
        ProductData prodData = inventory_tableView.getSelectionModel().getSelectedItem();//l'élément de la ligne actuellement sélectionnée dans le TableView.
        int num = inventory_tableView.getSelectionModel().getSelectedIndex();//retourne l'index de la ligne actuellement sélectionnée dans le TableView.
        if (num != -1) {
            inventory_productID.setText(prodData.getProductID());
            inventory_productName.setText(prodData.getProductName());
            inventory_stock.setText(String.valueOf(prodData.getStock()));
            inventory_price.setText(String.valueOf(prodData.getPrice()));
            inventory_status.setValue(prodData.getStatus());
            inventory_type.setValue(prodData.getType());
            String path = "File:" + prodData.getImage();
            //System.out.println(path);
            Data.setDate(String.valueOf(prodData.getDate()));//zeyda
            Data.setId(prodData.getId());
            image = new Image(path, 165, 142, false, true);
            inventory_imageView.setImage(image);
            Data.setPath(prodData.getImage());
        }
    }

    public void inventoryTypeList() {
        List<String> typeList = new ArrayList<>();
        typeList.add("Meals");
        typeList.add("Drinks");
        ObservableList listData = FXCollections.observableArrayList(typeList);
        inventory_type.setItems(listData);
    }

    public void inventoryStatusList() {
        List<String> StatusList = new ArrayList<>();
        StatusList.add("Available");
        StatusList.add("Unavailable");
        ObservableList listData = FXCollections.observableArrayList(StatusList);
        inventory_status.setItems(listData);
    }
    //merge Data on Menu Form

    //private ObservableList<ProductData>menuCardData = FXCollections.observableArrayList();
    public ObservableList<ProductData> menuGetData() {
        ObservableList<ProductData> ListData = FXCollections.observableArrayList();
        String sql = "SELECT * FROM product";
        connect = DataBase.connectDB();
        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            ProductData prodData;
            while (result.next()) {
                prodData = new ProductData(result.getInt("id"), result.getString("product_id"), result.getString("product_name"),
                        result.getString("type"), result.getDouble("price"), result.getString("image"));
                ListData.add(prodData);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ListData;
    }

    //Show Products on Menu Form
    public void menuDisplayCard() {
        //menuCardData.clear();menuCardData.addAll(menuGetData());
        int row = 0;
        int column = 0;
        menu_gridPane.getChildren().clear();
        menu_gridPane.getRowConstraints().clear();
        menu_gridPane.getColumnConstraints().clear();
        for (int i = 0; i < menuGetData().size(); i++) {
            try {
                /*               
    FXMLLoader load=new FXMLLoader();//pour charger un fichier FXML
load.getClass().getResource("cardProduct.fxml");//créer l'interface utilisateur de chaque carte de produit.*/
                //FXMLLoader lit le fichier FXML, instancie les objets définis dans le fichier (les contrôleurs, etc.)
                //getClass().getResource()->renvoie simplement l'url du fichier xml 
                //.load()->charge le fichier xml dans la scéne javafx
                FXMLLoader load = new FXMLLoader(getClass().getResource("cardProduct.fxml"));// Charger le FXML et le contrôleur
                AnchorPane pane = load.load();/*charge effectivement le fichier FXML en un objet 
                
                 */
 /*AnchorPane, qui représente le conteneur graphique de la carte produit.*/
                cardProductController card = load.getController();//récupère le contrôleur de l'élément FXML, ici un cardProductController
                card.setData(menuGetData().get(i));
                if (column == 3)//chaque ligne de gridPane posséde 3 articles produits
                {
                    column = 0;
                    row += 1;
                }
                menu_gridPane.add(pane, column++, row);
                GridPane.setMargin(pane, new Insets(10));
                card.setMainController(this);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public ObservableList<ProductData> menuGetOrder() {
        customerID();//to usual clear menu table view after payement ---*******--
        ObservableList<ProductData> ListData = FXCollections.observableArrayList();
        String sql = "SELECT * FROM customer WHERE  customer_id  = ? ";
        connect = DataBase.connectDB();
        try {
            prepare = connect.prepareStatement(sql);
            prepare.setInt(1, cID);
            result = prepare.executeQuery();
            ProductData prod;
            while (result.next()) {
                prod = new ProductData(result.getInt("id"), result.getString("product_id"),
                        result.getString("product_name"), result.getString("type"), result.getInt("quantity"),
                        result.getDouble("price"), result.getDate("date"));
                ListData.add(prod);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ListData;
    }

    public void menuDisplayOrder() {
        ObservableList<ProductData> orderList;
        orderList = menuGetOrder();
        menu_col_productName.setCellValueFactory(new PropertyValueFactory<>("productName"));
        menu_col_quantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        menu_col_price.setCellValueFactory(new PropertyValueFactory<>("price"));
        menu_tableView.setItems(orderList);
    }
    private double totalP = 0;

    public void menuDisplayTotal() {
        customerID();//ZEYDA
        String total = "SELECT SUM(price) FROM customer WHERE customer_id = ? ";
        connect = DataBase.connectDB();
        try {
            prepare = connect.prepareStatement(total);
            prepare.setInt(1, cID);
            result = prepare.executeQuery();
            if (result.next()) {
                totalP = result.getDouble("SUM(price)");
                menu_total.setText("$" + result.getDouble("SUM(price)"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private double amount;
    private double change;
    public int cnd = 0;

    public void menuAmount() {
        if (menu_amount.getText().isEmpty() || totalP == 0) {
            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("invalid :3");
            alert.showAndWait();
        } else {
            amount = Double.parseDouble(menu_amount.getText());
            change = 0;
            if (amount < totalP) {
                menu_amount.setText("");
                menu_change.setText("$0.0");
            } else {
                change = amount - totalP;
                menu_change.setText("$" + change);
            }
        }
    }

    public void MenuPayBtn() {
        if (totalP == 0) {
            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message : ");
            alert.setHeaderText(null);
            alert.setContentText("Please chosse your order first !");
            alert.showAndWait();
        } else {
            String insertPay = "INSERT INTO receipt (customer_id,total,date,employee_username)"
                    + "VALUES(?,?,?,?)";
            connect = DataBase.connectDB();
            try {
                if (amount == 0) {
                    alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Error Message : ");
                    alert.setHeaderText(null);
                    alert.setContentText("Something Wrong :3");
                    alert.showAndWait();
                } else {
                    alert = new Alert(AlertType.CONFIRMATION);
                    alert.setTitle("Confirmation Message : ");
                    alert.setHeaderText(null);
                    alert.setContentText("Are you sure ?");
                    Optional<ButtonType> option = alert.showAndWait();
                    if (option.get().equals(OK)) {
                        customerID();//CHECK CUSTOMER ID INCREMENT AFTER PAY ++
                        prepare = connect.prepareStatement(insertPay);
                        prepare.setInt(1, cID);
                        prepare.setDouble(2, totalP);
                        Date date = new Date();
                        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
                        prepare.setDate(3, sqlDate);
                        prepare.setString(4, Data.getUsername());

                        prepare.executeUpdate();
                        alert = new Alert(AlertType.INFORMATION);
                        alert.setTitle("Information Message : ");
                        alert.setHeaderText(null);
                        alert.setContentText("Order number : " + cID + " Payed Successful!");
                        alert.showAndWait();
                        menuDisplayOrder();
                        //menu_restart
                        totalP = 0;
                        change = 0;
                        amount = 0;
                        menu_total.setText("$0.0");
                        menu_change.setText("$0.0");
                        menu_amount.setText("");
                        //menu_tableView.getItems().clear();

                    } else {
                        alert = new Alert(AlertType.WARNING);
                        alert.setTitle("Information Message");
                        alert.setHeaderText(null);
                        alert.setContentText("Cancelled.");
                        alert.showAndWait();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    private int getid;
    private int getquantity;
    private String getproductname;

    public void menuSelectOrder() {
        ProductData prod = menu_tableView.getSelectionModel().getSelectedItem();
        int num = menu_tableView.getSelectionModel().getSelectedIndex();
        if (num != -1) {
            //TO GET THE ID PER 
            getid = prod.getId();
            getquantity = prod.getQuantity();
            System.out.println(getquantity);
            System.out.println(getid);
            getproductname = prod.getProductName();
            System.out.println(getproductname);

        }
    }

    public void menuRemoveBtn() {
        if (menu_tableView.getItems().isEmpty()) {
            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setContentText("the Menu Order Table is Empty !");
            alert.setHeaderText(null);
            alert.showAndWait();
        } else if (getid == 0) {
            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setContentText("Please selecct the product you want to remove from this order : " + (cID + 1));
            alert.setHeaderText(null);
            alert.showAndWait();
        } else {
            alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Message : ");
            alert.setHeaderText(null);
            alert.setContentText("Are you sure ?Do u want to delete this product from the order number : " + cID);
            Optional<ButtonType> option = alert.showAndWait();
            if (option.get().equals(ButtonType.OK)) {
                String deleteData = "DELETE FROM customer WHERE id = ?";
                String updateData = "UPDATE product SET stock = stock + ? WHERE product_name = ?";
                connect = DataBase.connectDB();
                try {
                    prepare = connect.prepareStatement(deleteData);
                    prepare.setInt(1, getid);
                    prepare.executeUpdate();
                    prepare = connect.prepareStatement(updateData);
                    prepare.setInt(1, getquantity);
                    prepare.setString(2, getproductname);
                    prepare.executeUpdate();
                    menuDisplayOrder();
                    menuDisplayTotal();
                    Menu_AmountetChange_updateafter_add_delete();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void Menu_AmountetChange_updateafter_add_delete()
    {
        change = 0;
        if (menu_tableView.getItems().isEmpty()) {
            menu_amount.setText("");
            menu_change.setText("$0.0");
        } else if (amount < totalP) {
            menu_amount.setText("");
            menu_change.setText("$0.0");
        } else {
            change = amount - totalP;
            menu_change.setText("$" + change);
        }
    }

    public void mennuReceiptBtn() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("recu.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setTitle("Receipt of the Customer");
        stage.setMaxHeight(700);
        stage.setMaxWidth(500);
        stage.setMinHeight(600);
        stage.setMinWidth(400);
        stage.setScene(scene);
        stage.show();
    }
    /*
    public void mennuReceiptBtn() {
        HashMap map = new HashMap();
        map.put("getReceipt", (cID - 1));
        connect = DataBase.connectDB();
        try {
            JasperDesign jDesign = JRXmlLoader.load("C:\\Users\\PRO BOOK\\Documents\\NetBeansProjects\\CafeShopManagementSystem\\src\\cafeshopmanagementsystem\\report.jrxml");
            JasperReport jReport = JasperCompileManager.compileReport(jDesign);
            JasperPrint jPrint = JasperFillManager.fillReport(jReport, map, connect);
            JasperViewer.viewReport(jPrint, false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/
    private int cID;

    //increment customerId after each pay of a receipe
    public void customerID() {
        String sql = "SELECT MAX(customer_id) FROM customer";
        connect = DataBase.connectDB();
        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            if (result.next()) {
                cID = result.getInt("Max(customer_id)");
            }
            String checkCID = "SELECT MAX(customer_id)FROM receipt";
            prepare = connect.prepareStatement(checkCID);
            result = prepare.executeQuery();
            int checkID = 0;
            if (result.next()) {
                checkID = result.getInt("Max(customer_id)");
            }
            if (cID == 0) {
                cID += 1;
            } else if (cID == checkID) {
                cID += 1;
            }
            Data.setcID(cID);//System.out.println(Data.getcID());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ObservableList<CustomersData> customersDataList() {
        ObservableList<CustomersData> ListData = FXCollections.observableArrayList();
        String sql = "SELECT * FROM receipt";
        connect = DataBase.connectDB();
        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            while (result.next()) {
                CustomersData Data = new CustomersData(result.getInt("id"), result.getInt("customer_id"),
                        result.getDouble("total"), result.getDate("date"), result.getString("employee_username"));
                ListData.add(Data);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ListData;
    }

    public void customersShowData() {
        customers_col_customerID.setCellValueFactory(new PropertyValueFactory<>("customerID"));
        customers_col_total.setCellValueFactory(new PropertyValueFactory<>("total"));
        customers_col_date.setCellValueFactory(new PropertyValueFactory<>("date"));
        customers_col_cashier.setCellValueFactory(new PropertyValueFactory<>("employee_username"));
        customers_tableView.setItems(customersDataList());

    }

    public void switchForm(ActionEvent event) {
        if (event.getSource() == dashboard_btn) {
            dashboardIncomeChart();
            dashboardCustomerChart();
            menu_recette.setVisible(false);
            dashboard_form.setVisible(true);
            menu_form.setVisible(false);
            inventory_form.setVisible(false);
            customers_form.setVisible(false);
            dashboardDisplayNSP();
            dashboardDisplayTotalI();
            dashboardDisplayTI();
            dashboardDisplayNC();

        } else if (event.getSource() == inventory_btn) {
            menu_recette.setVisible(false);
            dashboard_form.setVisible(false);
            menu_form.setVisible(false);
            customers_form.setVisible(false);
            inventory_form.setVisible(true);
            inventoryTypeList();
            inventoryStatusList();
            inventoryShowData();
        } else if (event.getSource() == menu_btn) {
            menu_recette.setVisible(true);
            dashboard_form.setVisible(false);
            customers_form.setVisible(false);
            menu_form.setVisible(true);
            inventory_form.setVisible(false);

            menuDisplayCard();
            menuDisplayOrder();
            menuDisplayTotal();
        } else if (event.getSource() == customers_btn) {
            menu_recette.setVisible(false);
            dashboard_form.setVisible(false);
            menu_form.setVisible(false);
            inventory_form.setVisible(false);
            customers_form.setVisible(true);
            customersShowData();
        }
    }

    public void logout() //sign out boutton
    {
        try {
            alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Message");
            alert.setContentText("Are u sure to logout ?");
            Optional<ButtonType> option = alert.showAndWait();
            if (option.get().equals(ButtonType.OK)) {
                //to hide main form 
                logout_btn.getScene().getWindow().hide();
                //link ur login form and show it 
                Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setTitle("Cafe Shop Management System");
                stage.setScene(scene);
                stage.show();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void displayUsername() {
        String user = Data.getUsername();
        user = user.substring(0, 1).toUpperCase() + user.substring(1);
        username.setText(user);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        displayUsername();
        displayTime();

        dashboardDisplayNSP();
        dashboardDisplayTotalI();
        dashboardDisplayTI();
        dashboardDisplayNC();
        dashboardIncomeChart();
        dashboardCustomerChart();

        inventoryTypeList();
        inventoryStatusList();
        inventoryShowData();

        menuDisplayCard();
        menuDisplayTotal();
        menuDisplayOrder();

        customersShowData();
    }
}
