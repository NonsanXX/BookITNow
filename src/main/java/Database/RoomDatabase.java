/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;

import static Database.Database.db;
import Database.Dataclass.RoomData;
import Database.Dataclass.timeRange;
import Database.Exception.DatabaseGetInterrupted;
import Firebase.UserLoginToken;


import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.WriteResult;
import com.google.api.core.ApiFuture;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author phump
 */
public class RoomDatabase extends Database{
    public static ArrayList<String> getRoomList(){
        ArrayList<String> roomList = new ArrayList<>();
        Iterable<DocumentReference> docRef = getDb().collection(ROOM_COLLECTION).listDocuments();
        
        for(DocumentReference dr : docRef){
            roomList.add(dr.getId());
        }
        return roomList;
    }
    
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
    
    public static void deleteRoom(String roomName){
        getDb().collection(ROOM_COLLECTION).document(roomName).delete();
    }
    
    public static boolean reservingRoom(RoomData room, timeRange time){
        boolean result = room.reservingTime(time);
        room.getCurrentQueue().put(UserLoginToken.getClientID(), time);
        return result;
    }
    
    public static void sleepForUpdateTime(ApiFuture<WriteResult> writeResult){
        try {
            Thread.sleep(0);
        } catch (InterruptedException ex) {
            Logger.getLogger(RoomDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
