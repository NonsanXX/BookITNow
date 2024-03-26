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
/**
 *
 * @author phump
 */
public class ClientDatabase extends Database{
    public static HashMap<String, Object> getClient(String clientstdID) throws ClientNotFoundException{
        DocumentReference docRef = db.collection(Database.CLIENT_COLLECTION).document(clientstdID);
        DocumentSnapshot document;
        try {
            document = docRef.get().get();
        } catch (InterruptedException | ExecutionException ex) {
            throw new ClientNotFoundException("client "+clientstdID+" not found in collection Database.CLIENT_COLLECTION");
        }
        return (HashMap<String, Object>) document.getData();
    }
    
    public static boolean updateClient(String clientstdID, String updateField, Object updateValue) throws ClientNotFoundException{
        HashMap<String, Object> client = getClient(clientstdID);
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
