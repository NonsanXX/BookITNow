/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;

import com.google.cloud.firestore.Firestore;
/**
 *
 * @author phump
 */
public abstract class Database {
    
    public static final String CLIENT_COLLECTION = "Clients";
    public static final String ROOM_COLLECTION = "Room";
    
    public static Firestore db = null;
    
    public static void setDb(Firestore db){
        Database.db = db;
    }
    
    public static Firestore getDb(){
        return Database.db;
    }
}
