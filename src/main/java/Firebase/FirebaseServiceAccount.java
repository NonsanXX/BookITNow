package Firebase;/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import com.google.api.core.ApiFuture;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import com.google.cloud.firestore.Firestore;

import java.io.*;
import java.net.*;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;

import Database.ClientDatabase;
import Database.Dataclass.ClientData;

public class FirebaseServiceAccount {
    public static void initFirebase() throws URISyntaxException, FileNotFoundException, IOException, InterruptedException, ExecutionException, Exception{
        FileInputStream serviceAccount = new FileInputStream(new FirebaseServiceAccount().getServiceAccount());
        GoogleCredentials credentials = GoogleCredentials.fromStream(serviceAccount);
        FirebaseOptions options = FirebaseOptions.builder()
                .setCredentials(credentials)
                .build();
        FirebaseApp.initializeApp(options);
        Firestore firestore = FirestoreClient.getFirestore();
        ClientDatabase.setDb(firestore);
        ClientDatabase.addClient(new ClientData("Thai_Phum", "Thai_Wong", "Phum", "Wong", "PhumphumWongWong@gmail.com", "66070162", "easyPasscode"));
        
        firestore.close();
    }
    
    public File getServiceAccount() throws URISyntaxException {
        ClassLoader classLoader = getClass().getClassLoader();
        URL resource = classLoader.getResource("firebase-token/bookitnow-firestore-firebase-adminsdk-g9exh-9d7b7a5989.json");
        if (resource == null) {
            throw new IllegalArgumentException("File not found!");
        } else {
            return new File(resource.toURI());
        }
    }
    
    public static void main(String[] args) {
        try {
            initFirebase();
        } catch (IOException ex) {
            Logger.getLogger(FirebaseServiceAccount.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException | ExecutionException ex) {
            Logger.getLogger(FirebaseServiceAccount.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(FirebaseServiceAccount.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}