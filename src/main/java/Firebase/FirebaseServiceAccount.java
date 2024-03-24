package Firebase;/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteBatch;

import java.io.*;
import java.net.*;
import java.util.HashMap;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FirebaseServiceAccount {
    public static void initFirebase() throws URISyntaxException, FileNotFoundException, IOException, InterruptedException, ExecutionException{
        FileInputStream serviceAccount = new FileInputStream(new FirebaseServiceAccount().getServiceAccount());
        GoogleCredentials credentials = GoogleCredentials.fromStream(serviceAccount);
        FirebaseOptions options = FirebaseOptions.builder()
                .setCredentials(credentials)
                .build();
        FirebaseApp.initializeApp(options);
        Firestore firestore = FirestoreClient.getFirestore();
        
        // Write test
        WriteBatch batch = firestore.batch();
        HashMap<String, String> data = new HashMap<>();
        data.put("key1", "value1");
        batch.set(firestore.collection("dataTest").document("data1"), data);
        batch.commit().get();
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
        } catch (URISyntaxException | IOException | InterruptedException | ExecutionException ex) {
            Logger.getLogger(FirebaseServiceAccount.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}