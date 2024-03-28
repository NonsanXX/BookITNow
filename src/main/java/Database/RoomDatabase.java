/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;

import static Database.Database.db;
import Database.Dataclass.ClientData;
import Database.Dataclass.RoomData;
import Database.Exception.DatabaseGetInterrupted;
import com.google.cloud.firestore.DocumentReference;
import java.util.HashMap;
import java.util.concurrent.ExecutionException;
/**
 *
 * @author phump
 */
public class RoomDatabase extends Database{
    public static void addRoom(RoomData roomData){
        getDb().collection(ROOM_COLLECTION).document((String) roomData.getRoomName()).set(roomData);
    }
    
    public static HashMap<String, Object> getRoomHashMap(String roomName) throws DatabaseGetInterrupted{
        DocumentReference docRef = db.collection(Database.ROOM_COLLECTION).document(roomName);
        try {
            return (HashMap<String, Object>) docRef.get().get().getData();
        } catch (InterruptedException | ExecutionException ex) {
            throw new DatabaseGetInterrupted();
        }
    }
    
    public static RoomData getRoomObject(String roomName)throws DatabaseGetInterrupted{
        DocumentReference docRef = db.collection(Database.ROOM_COLLECTION).document(roomName);
        try {
            return docRef.get().get().toObject(RoomData.class);
        } catch (InterruptedException | ExecutionException ex) {
            throw new DatabaseGetInterrupted();
        }
    }
}
