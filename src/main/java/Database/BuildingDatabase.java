/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;

import static Database.Database.BUILDING_COLLECTION;
import static Database.Database.getDb;
import Database.Exception.DatabaseGetInterrupted;
import Database.Dataclass.RoomData;
import Database.Exception.DatabaseGetInterrupted;

import com.google.cloud.firestore.DocumentReference;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

/**
 *
 * @author phump
 */
public class BuildingDatabase extends Database{
    public static final String BUILDING_FIELD_NAME = "ref";
    public static ArrayList<DocumentReference> getReferenceList(String buildingName) throws DatabaseGetInterrupted{
        try {
            HashMap<String, Object> map = (HashMap<String, Object>) getDb().collection(BUILDING_COLLECTION).document(buildingName).get().get().getData();
            if(map == null){
                return new ArrayList<>();
            }
            return (ArrayList<DocumentReference>) map.getOrDefault(BUILDING_FIELD_NAME, new ArrayList<>());
        } catch (InterruptedException | ExecutionException ex) {
            throw new DatabaseGetInterrupted();
        }
    }
    
    public static void addReference(RoomData roomData) throws DatabaseGetInterrupted{
        HashMap<String, Object> push = new HashMap<>();
        ArrayList<DocumentReference> array = getReferenceList(roomData.getBuilding());
        DocumentReference docRef = RoomDatabase.getReference(roomData);
        
        array.add(docRef);
        
        push.put(BUILDING_FIELD_NAME, array);
        
        getDb().collection(BUILDING_COLLECTION).document(roomData.getBuilding()).set(push);
    }
    
    public static void deleteReference(RoomData roomData) throws DatabaseGetInterrupted{
        HashMap<String, Object> push = new HashMap<>();
        ArrayList<DocumentReference> array = getReferenceList(roomData.getBuilding());
        DocumentReference docRef = RoomDatabase.getReference(roomData);
        
        array.remove(docRef);
        
        push.put(BUILDING_FIELD_NAME, array);
        
        getDb().collection(BUILDING_COLLECTION).document(roomData.getBuilding()).set(push);
        
        if(array.isEmpty()){
            getDb().collection(BUILDING_COLLECTION).document(roomData.getBuilding()).delete();
        }
    }
}
