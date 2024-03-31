/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;

import Database.Dataclass.RoomData;
import Database.Dataclass.HistoryData;
import Database.Dataclass.TimeDate;
import Database.Exception.DatabaseGetInterrupted;
import Firebase.UserLoginToken;


import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.WriteResult;
import com.google.api.core.ApiFuture;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;


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
     *          building        - Get the room if it contain desirableRoom.building<br>
     *          floor           - Get the room if it equal to desirableRoom.floor<br>
     *          openTime        - Get the room if it isSuperRange of desirableRoom.openTime<br>
     *          capacity        - Get the room if it more than or equal to desirableRoom.capacity<br><br>
     * If the Filter_FIELD is null or empty String means that condition is true.<br>
     * The absence of mention of the fields is not accountable.<br><br>
     * 
     * @param desirableRoom The room looking for
     * @return qualified - Rooms passes all qualification
     * @throws Database.Exception.DatabaseGetInterrupted 
     */
    public static ArrayList<RoomData> filter(RoomData desirableRoom) throws DatabaseGetInterrupted{
        ArrayList<RoomData> qualified = new ArrayList<>();
        for(RoomData rm : getRoomListObject()){
            boolean roomNameCheck, buildingCheck, floorCheck, facilityListCheck, openTimeCheck, capacityCheck;
            roomNameCheck = rm.getRoomName().contains(desirableRoom.getRoomName());
            buildingCheck = rm.getBuilding().contains(desirableRoom.getBuilding());
            floorCheck = rm.getFloor().equals(desirableRoom.getFloor());
            capacityCheck = rm.getCapacity() >= desirableRoom.getCapacity();
            facilityListCheck = (desirableRoom.getFacilityList() == null) ? true : rm.getFacilityList().containsAll(desirableRoom.getFacilityList());
            openTimeCheck = (desirableRoom.getOpenTime() == null) ? true : rm.checkOpenTimeList(desirableRoom.getOpenTime());

            if(roomNameCheck && buildingCheck && floorCheck && facilityListCheck && openTimeCheck && capacityCheck){
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
        ApiFuture<WriteResult> future1 = getDb().collection(ROOM_COLLECTION).document((String) roomData.getRoomName()).set(roomData);
        BuildingDatabase.addReference(roomData);
        try {
            long updateTime = (Math.abs(future1.get().getUpdateTime().getSeconds()*1000 - currentTimeMillis));
            return updateTime;
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
    
    public static void updateRoom(RoomData roomData) throws DatabaseGetInterrupted{
        getDb().collection(ROOM_COLLECTION).document(roomData.getRoomName()).set(roomData);
    }
    
    public static void deleteRoom(String roomName) throws DatabaseGetInterrupted{
        getDb().collection(ROOM_COLLECTION).document(roomName).delete();
        BuildingDatabase.deleteReference(getRoomObject(roomName));
    }
    
    public static RoomData loadRoom(DocumentReference docRef) throws DatabaseGetInterrupted{
        try {
            return docRef.get().get().toObject(RoomData.class);
        } catch (InterruptedException | ExecutionException ex) {
            throw new DatabaseGetInterrupted();
        }
    }
    

    
    public static boolean reservingRoom(RoomData room, TimeDate time) throws DatabaseGetInterrupted{
        boolean result = room.checkReservingTime(time);
        if(result){
            room.reservingTime(time);
            room.getCurrentQueue().put(UserLoginToken.getClientID(), time);
            ClientHistoryDatabase.addHistory(UserLoginToken.getClientID(), new HistoryData<RoomData>(TimeDate.getTimeStamp(), time, room));
            updateRoom(room);
        }
        return result;
    }
    
    public static DocumentReference getReference(RoomData roomData){
        return getDb().collection(ROOM_COLLECTION).document(roomData.getRoomName());
    }
}
