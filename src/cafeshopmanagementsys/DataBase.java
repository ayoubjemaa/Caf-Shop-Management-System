/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cafeshopmanagementsys;
import java.sql.Connection;//Représente une connexion à une base de données. Cet objet est utilisé pour envoyer des requêtes SQL et recevoir des résultats.
import java.sql.DriverManager;//classe qui gère les pilotes JDBC (Java Database Connectivity). Elle est utilisée pour obtenir une connexion à une base de données en fournissant l'URL de la base, un nom d'utilisateur et un mot de passe.
//JDBC= Java Database Connectivity :Une API (Application Programming Interface) une interface qui permet à différents logiciels de communiquer entre eux./protocole
/**
 *
 * @author PRO BOOK
 */
public class DataBase 
{
    public static Connection connectDB()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");// charge le pilote JDBC pour MySQL en mémoire.
            Connection connect=DriverManager.getConnection("jdbc:mysql://localhost/cafe","root","");//link ur data base
            return connect;       
        }catch(Exception e ){e.printStackTrace();}
        return null;
    }
}
