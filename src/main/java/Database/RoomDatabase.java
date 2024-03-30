/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;

import static Database.Database.db;
import Database.Dataclass.RoomData;
import Database.Dataclass.TimeRange;
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
    
    public static ArrayList<RoomData> getRoomListObject() throws DatabaseGetInterrupted{
        ArrayList<RoomData> roomListObject = new ArrayList<>();
        Iterable<DocumentReference> docRef = getDb().collection(ROOM_COLLECTION).listDocuments();
        for(DocumentReference d : docRef){
            try {
                roomListObject.add(d.get().get().toObject(RoomData.class));
            } catch (InterruptedException | ExecutionException ex) {
                throw new DatabaseGetInterrupted();
            }
        }
        return roomListObject;
    }
    
    /**
     * Filter:  roomName        - Get the room if it contain desirableRoom.roomName<br>
     *          facilityList    - Get the room if it contain desirableRoom.facilityList<br>
     *          roomDescription - Get the room if it contain desirableRoom.roomDescriptio<br>
     *          openTime        - Get the room if it isSuperRange of desirableRoom.openTime<br>
     *          capacity        - Get the room if it more than or equal to desirableRoom.capacity<br><br>
     * If the Filter_FIELD is null means that condition is true.<br>
     * The absence of mention of the fields is not accountable.<br><br>
     * 
     * @param desirableRoom The room looking for
     * @return qualified - Rooms passes all qualification
     * @throws Database.Exception.DatabaseGetInterrupted 
     */
    public static ArrayList<RoomData> filter(RoomData desirableRoom) throws DatabaseGetInterrupted{
        ArrayList<RoomData> qualified = new ArrayList<>();
        for(RoomData rm : getRoomListObject()){
            boolean roomNameCheck, facilityListCheck, roomDescriptionCheck, openTimeCheck, capacityCheck;
            roomNameCheck = rm.getRoomName().contains(desirableRoom.getRoomName());
            roomDescriptionCheck = rm.getRoomDescription().contains(desirableRoom.getRoomDescription());
            capacityCheck = rm.getCapacity() >= desirableRoom.getCapacity();
            
            if(desirableRoom.getFacilityList() == null){
                facilityListCheck = true;
            } else{
                facilityListCheck = rm.getFacilityList().containsAll(desirableRoom.getFacilityList());
            }
            
            if(desirableRoom.getOpenTime() == null){
                openTimeCheck = true;
            } else{
            openTimeCheck = rm.checkOpenTimeList(desirableRoom.getOpenTime());
            }
            if(roomNameCheck && facilityListCheck && roomDescriptionCheck && openTimeCheck && capacityCheck){
                qualified.add(rm);
            }
        }
        return qualified;
    }
    
    /**
     * 
     * @param roomData Data of the room
     * @return UpdateTime 
     * @throws DatabaseGetInterrupted 
     */
    public static long addRoom(RoomData roomData) throws DatabaseGetInterrupted{
        long currentTimeMillis = System.currentTimeMillis();
        ApiFuture<WriteResult> future = getDb().collection(ROOM_COLLECTION).document((String) roomData.getRoomName()).set(roomData);
        try {
            return (Math.abs(future.get().getUpdateTime().getSeconds()*1000 - currentTimeMillis));
        } catch (InterruptedException | ExecutionException ex) {
            throw new DatabaseGetInterrupted();
        }
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
    
    public static boolean reservingRoom(RoomData room, TimeRange time){
        boolean result = room.reservingTime(time);
        room.getCurrentQueue().put(UserLoginToken.getClientID(), time);
        return result;
    }
    
}
