/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;

import Database.Dataclass.ClientData;

import Database.Exception.ClientNotFoundException;

import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;

import java.util.HashMap;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author phump
 */
public class ClientDatabase extends Database{
    public static HashMap<String, Object> getClientHashMap(String clientstdID) throws ClientNotFoundException{
        return getClientObject(clientstdID).toHashMap();
    }
    
    public static ClientData getClientObject(String clientstdID)throws ClientNotFoundException{
        DocumentReference docRef = db.collection(Database.CLIENT_COLLECTION).document(clientstdID);
        try {
            return docRef.get().get().toObject(ClientData.class);
        } catch (InterruptedException | ExecutionException ex) {
            throw new ClientNotFoundException("client "+clientstdID+" not found in collection Database.CLIENT_COLLECTION");
        }
    }
    
    public static boolean updateClient(String clientstdID, String updateField, Object updateValue) throws ClientNotFoundException{
        HashMap<String, Object> client = getClientHashMap(clientstdID);
        if(client.containsKey(updateField)){
            client.replace(updateField, updateValue);
            addClient(client);
            return true;
        }
        return false;
    }
    
    public static void addClient(ClientData clientData){
        getDb().collection(Database.CLIENT_COLLECTION).document(clientData.getStudentID()).set(clientData.toHashMap());
    }
    
    public static void addClient(HashMap<String, Object> clientData){
        getDb().collection(Database.CLIENT_COLLECTION).document((String) clientData.get("studentID")).set(clientData);
    }
    
    public static void deleteClient(String clientstdID){
        getDb().collection(Database.CLIENT_COLLECTION).document(clientstdID).delete();
    }

}
