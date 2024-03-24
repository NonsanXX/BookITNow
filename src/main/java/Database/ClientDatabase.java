/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;

import Database.Dataclass.ClientData;
import Database.Exception.ClientNotFoundException;

import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;

import com.google.cloud.firestore.WriteBatch;

import java.util.HashMap;
import java.util.concurrent.ExecutionException;
/**
 *
 * @author phump
 */
public class ClientDatabase extends Database{
    public static HashMap<String, Object> getClient(String ClientstdID) throws ClientNotFoundException{
        DocumentReference docRef = db.collection(Database.CLIENT_COLLECTION).document(ClientstdID);
        DocumentSnapshot document;
        try {
            document = docRef.get().get();
        } catch (InterruptedException | ExecutionException ex) {
            throw new ClientNotFoundException("client "+ClientstdID+" not found in collection Database.CLIENT_COLLECTION");
        }
        return (HashMap<String, Object>) document.getData();
    }
    
    public static void addClient(ClientData clientData) throws InterruptedException, ExecutionException{
        String ClientstdID = clientData.getStudentID();
        WriteBatch batch = db.batch();
        batch.set(db.collection(Database.CLIENT_COLLECTION).document(ClientstdID), clientData.toHashMap());
        batch.commit().get();
    }
}
