/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cafeshopmanagementsys;
import java.sql.Date;
public class ProductData 
{
    private int id;
    private String productID;
    private String productName;
    private String type;
    private int stock;
    private Double price;
    private String status;
    private String image;
    private Date date;
    private int quantity;
    //product
    public ProductData(int id, String productID, String productName,String type ,int stock,
            Double price,String status, String image, Date date) {
        this.id = id;this.productID = productID;this.productName = productName;
        this.type=type;this.stock = stock;this.status = status;this.price=price;
        this.image = image;this.date = date;
    }
    //card
    public ProductData(int id, String productID, String productName,String type,Double price, String image) {
        this.id = id;
        this.productID = productID;
        this.productName = productName;
        this.type=type;
        this.price = price;
        this.image = image;
    }
    //customer table
    public ProductData(int id, String productID, String productName, String type, int quantity, Double price,Date date) {
        this.id = id;
        this.productID = productID;
        this.productName = productName;
        this.type = type;
        this.price = price;
        this.date = date;
        this.quantity = quantity;
    }
    //recu_table

    public ProductData(String productName, String type, int quantity, Double price) {
        this.productName = productName;
        this.type = type;
        this.price = price;
        this.quantity = quantity;
    }
    
    

    public int getId(){return id;}
    public String getProductID() {return productID;}
    public String getProductName() {return productName;}
    public String getType(){return type;}
    public int getStock() {return stock;}
    public Double getPrice() {return price;}
    public String getStatus() {return status;}
    public String getImage() {return image;}
    public Date getDate() {return date;}

    public int getQuantity() {
        return quantity;
    }
    
}
