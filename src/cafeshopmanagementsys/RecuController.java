package cafeshopmanagementsys;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.print.PrinterJob;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class RecuController implements Initializable {
    
    @FXML
    private Label time_now;
    @FXML
    private TableColumn<ProductData, Double> recu_col_price;
    @FXML
    private TableColumn<ProductData, String> recu_col_productName;
    @FXML
    private TableColumn<ProductData, Integer> recu_col_quantity;
    @FXML
    private TableColumn<ProductData, String> recu_col_type;
    @FXML
    private Label recu_cutsomerID;
    @FXML
    private TableView<ProductData> recu_tableView;
    @FXML
    private Label recu_total;
    @FXML
    private Button recu_Btn;

    private Connection connect;
    private PreparedStatement prepare;
    private ResultSet result;

    public ObservableList<ProductData> RecuDataList() {
        ObservableList<ProductData> listData = FXCollections.observableArrayList();
        String sql = "SELECT product_name,type,quantity,price FROM customer WHERE customer_id = ? ";
        connect = DataBase.connectDB();
        try {
            prepare = connect.prepareStatement(sql);
            prepare.setInt(1, (Data.getcID() - 1));
            result = prepare.executeQuery();
            ProductData prodData;
            while (result.next()) {
                prodData = new ProductData(result.getString("product_name"),
                        result.getString("type"), result.getInt("quantity"), result.getDouble("price"));
                listData.add(prodData);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;
    }

    public void RecuShowData() {
        recu_col_productName.setCellValueFactory(new PropertyValueFactory<>("productName"));
        recu_col_type.setCellValueFactory(new PropertyValueFactory<>("type"));
        recu_col_quantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        recu_col_price.setCellValueFactory(new PropertyValueFactory<>("price"));
        ObservableList<ProductData> recuListData = RecuDataList();
        recu_tableView.setItems(recuListData);
    }

    public void RecuTotal() {
        String sql = "SELECT total FROM receipt WHERE customer_id = ? ";      
        connect = DataBase.connectDB();
        try {
            prepare = connect.prepareStatement(sql);
            prepare.setInt(1, Data.getcID() - 1);
            result = prepare.executeQuery();
            if (result.next()) {
                recu_total.setText("$" + String.valueOf(result.getDouble("total")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void printReceipt() {
        javafx.scene.Node rootNode = recu_tableView.getScene().getRoot();
        recu_Btn.setVisible(false);
        PrinterJob printerJob = PrinterJob.createPrinterJob();
        if (printerJob != null && printerJob.showPrintDialog(recu_tableView.getScene().getWindow())) {
            boolean success = printerJob.printPage(rootNode);
            if (success) {
                printerJob.endJob();
                System.out.println("Reçu imprimé avec succès !");
            } else {
                System.out.println("Erreur lors de l'impression.");
            }
        }recu_Btn.setVisible(true);
    }
    public void displayCurrentTime() {
    // Formatter pour afficher la date et l'heure actuelles
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss - dd/MM/yyyy");
    // Obtenir la date et l'heure actuelles
    LocalDateTime now = LocalDateTime.now();
    // Afficher la date et l'heure dans le label
    time_now.setText(now.format(formatter));
}

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        RecuShowData();
        recu_cutsomerID.setText(String.valueOf(Data.getcID() - 1));
        RecuTotal();
        displayCurrentTime();
    }
}
