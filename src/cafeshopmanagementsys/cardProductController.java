/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cafeshopmanagementsys;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author PRO BOOK
 */
public class cardProductController implements Initializable {

    @FXML
    private AnchorPane card_form;
    @FXML
    private Button prod_addBtn;
    @FXML
    private ImageView prod_imageView;
    @FXML
    private Label prod_name;
    @FXML
    private Label prod_price;
    @FXML
    private Spinner<Integer> prod_spinner;
    private ProductData prodData;
    private Connection connect;
    private PreparedStatement prepare;
    private ResultSet result;
    private Alert alert;
    private double prodprix;
    private String prodID;
    private String prodtype;
    private String prodimage;

    //private SpinnerValueFactory<Integer> spin;
    public void setData(ProductData prodData)//524
    {
        this.prodData = prodData;
        prodimage = prodData.getImage();
        prodtype = prodData.getType();
        prodID = prodData.getProductID();
        prod_name.setText(prodData.getProductName());
        prod_price.setText('$' + String.valueOf(prodData.getPrice()));
        String path = "File:" + prodData.getImage();
        Image image = new Image(path, 203, 93, false, true);//on va voir
        prod_imageView.setImage(image);
        prodprix = prodData.getPrice();
    }
    private mainFormController mainController;

    public void setMainController(mainFormController mainController) {
        this.mainController = mainController;
    }

    public void setQuantity() {
        SpinnerValueFactory<Integer> spin = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100, 0);
        prod_spinner.setValueFactory(spin);
        //prod_spinner
    }

    public void addBtn() {
        mainFormController mForm = new mainFormController();
        mForm.customerID();//CHECLK CZ APPERANCE COSTUMER ON ORDER
        int quantity = prod_spinner.getValue();
        String check = "";//check the product is available or not
        //String checkAvailable = "SELECT status FROM product WHERE prod_name = ?";
        String checkAvailable = "SELECT status FROM product WHERE product_id = ?";
        connect = DataBase.connectDB();
        try {
            //prepare.setString(1, prod_name.getText());
            prepare = connect.prepareStatement(checkAvailable);
            prepare.setString(1, prodID);
            result = prepare.executeQuery();
            if (result.next()) {
                check = result.getString("status");
            }
            if (!check.equals("Available") || quantity == 0) {
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Something Wrong :3");
                alert.showAndWait();
            } else {
                int stock = 0;
                String checkStock = "SELECT stock from product WHERE  product_id = '"
                        + prodID + "'";
                prepare = connect.prepareStatement(checkStock);
                result = prepare.executeQuery();
                if (result.next()) {
                    stock = result.getInt("stock");
                }
                if (stock == 0) {
                    String updateStock = "UPDATE product SET status = ? WHERE product_id = ? ";
                    prepare = connect.prepareStatement(updateStock);
                    prepare.setString(1, "Unavailable");
                    prepare.setString(2, prodID);
                    prepare.executeUpdate();
                }
                if (stock < quantity) {
                    alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Invalid, This product is Out of stock");
                    alert.showAndWait();
                } else {
                    String insertData = "INSERT INTO customer "
                            + "(customer_id,product_id,product_name,type,quantity,price,date,image,employee_username)"
                            + "VALUES(?,?,?,?,?,?,?,?,?)";
                    prepare = connect.prepareStatement(insertData);
                    prepare.setString(1, String.valueOf(Data.getcID()));
                    prepare.setString(2, prodID);
                    prepare.setString(3, prod_name.getText());
                    prepare.setString(4, prodtype);
                    prepare.setInt(5, quantity);
                    prepare.setDouble(6, quantity * prodprix);
                    Date date = new Date();
                    java.sql.Date sqlDate = new java.sql.Date(date.getTime());
                    prepare.setString(7, String.valueOf(sqlDate));
                    prepare.setString(8, prodimage);
                    prepare.setString(9, Data.getUsername());
                    prepare.executeUpdate();
                    /*
                    String updateStock="UPDATE product SET product_name = '"
                            +prod_name.getText()+"', type = '"+prod_type
                            +"', stock = "+(stock-qty)+", price = '"+prod_price+"'";
                    System.out.println(stock-qty);
                     */
                    String updateStock = "UPDATE product SET stock = ? WHERE product_id = ? ";
                    prepare = connect.prepareStatement(updateStock);
                    prepare.setInt(1, stock - quantity);
                    prepare.setString(2, prodID);
                    prepare.executeUpdate();
                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText(" Product : " + prodID
                            + " with quantity : " + quantity + " is sccessfully added to order number : " + Data.getcID());
                    alert.showAndWait();
                    mainController.menuDisplayOrder();
                    mainController.menuDisplayTotal();
                    mainController.Menu_AmountetChange_updateafter_add_delete();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setQuantity();
    }

}
