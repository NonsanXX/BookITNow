/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;

import Database.Dataclass.ClientData;

import Database.Exception.DatabaseGetInterrupted;

import com.google.cloud.firestore.DocumentReference;


import java.util.HashMap;
import java.util.concurrent.ExecutionException;

/**
 *
 * @author phump
 */
public class ClientDatabase extends Database{
    public static HashMap<String, Object> getClientHashMap(String clientstdID) throws DatabaseGetInterrupted{
        DocumentReference docRef = db.collection(Database.CLIENT_COLLECTION).document(clientstdID);
        try {
            return (HashMap<String, Object>) docRef.get().get().getData();
        } catch (InterruptedException | ExecutionException ex) {
            throw new DatabaseGetInterrupted();
        }
    }
    
    public static ClientData getClientObject(String clientstdID)throws DatabaseGetInterrupted{
        DocumentReference docRef = db.collection(Database.CLIENT_COLLECTION).document(clientstdID);
        try {
            return docRef.get().get().toObject(ClientData.class);
        } catch (InterruptedException | ExecutionException ex) {
            throw new DatabaseGetInterrupted();
        }
    }
    
    public static boolean updateClient(String clientstdID, String updateField, Object updateValue) throws DatabaseGetInterrupted{
        HashMap<String, Object> client = getClientHashMap(clientstdID);
        if(client.containsKey(updateField)){
            client.replace(updateField, updateValue);
            addClient(client);
            return true;
        }
        return false;
    }

    // true - register success
    // false - register failed
    public static boolean register(String name_th, String surname_th, String name_en, String surname_en, String email, String stud_id,
                                   char[] password){
        if(!checkUserExist(stud_id)){
            addClient(new ClientData(name_th, surname_th, name_en, surname_en, email, stud_id, new String(password), 0));
            return true;
        }
        return false;
    }

    // validate login credentials by checking to see if username/password pair exists in the database
    public static boolean validateLogin(String std_id, String password) {
        if(checkUserExist(std_id)){
            try {
                ClientData user = getClientObject(std_id);
                return user.comparePasscode(password);
            } catch (DatabaseGetInterrupted e) {
                return false;
            }
        }
        return false;
    }

    // check if username already exists in the database
    // false - user doesn't exist
    // true - user exists in the database
    public static boolean checkUserExist(String stud_id){
        try {
            ClientData clientobj = getClientObject(stud_id);
            return clientobj != null;
        } catch (DatabaseGetInterrupted e) {
            e.printStackTrace();
        }
        return false;
    }
    public static void addClient(ClientData clientData){
        getDb().collection(CLIENT_COLLECTION).document(clientData.getStudentID()).set(clientData.toHashMap());
    }
    
    public static void addClient(HashMap<String, Object> clientData){
        getDb().collection(CLIENT_COLLECTION).document((String) clientData.get("studentID")).set(clientData);
    }
    
    public static void deleteClient(String clientstdID){
        getDb().collection(CLIENT_COLLECTION).document(clientstdID).delete();
    }

}
