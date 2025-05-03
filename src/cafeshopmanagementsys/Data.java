/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cafeshopmanagementsys;
public class Data 
{
    private static String username;//name of user logged in
    private static String path;//path of imported image (dans chaque importation ce path change)
    private static String date;//date du produit maintenant séléctionné (facultatif)
    private static int id;//id du produit maintenant séléctionné.
    private static int cID;//l'id du customer actuel demandant les produits
    
    //setters
    
    public static void setcID(int cID) {
        Data.cID = cID;
    }

    public static void setUsername(String username) {
        Data.username = username;
    }
    public static void setPath(String path) {
        Data.path = path;
    }

    public static void setDate(String date) {
        Data.date = date;
    }

    public static void setId(int id) {
        Data.id = id;
    }
    //getters

    public static int getcID() {
        return cID;
    }
    
    public static String getUsername() {
        return username;
    }

    public static String getPath() {
        return path;
    }
        public static String getDate() {
        return date;
    }

    public static int getId() {
        return id;
    }
    
    
    
    
}
