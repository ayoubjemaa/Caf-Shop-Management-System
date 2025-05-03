/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cafeshopmanagementsys;

import java.sql.Date;

/**
 *
 * @author PRO BOOK
 */
public class CustomersData {
    private int id;
    private int customerID;
    private double total;
    private Date date;
    private String employee_username;

    public CustomersData(int id, int customerID, double total, Date date, String employee_username) {
        this.id = id;
        this.customerID = customerID;
        this.total = total;
        this.date = date;
        this.employee_username = employee_username;
    }
    public int getId() {
        return id;
    }
    public int getCustomerID() {
        return customerID;
    }
    public double getTotal() {
        return total;
    }
    public Date getDate() {
        return date;
    }
    public String getEmployee_username() {
        return employee_username;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }
    public void setTotal(double total) {
        this.total = total;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public void setEmployee_username(String employee_username) {
        this.employee_username = employee_username;
    }
}

