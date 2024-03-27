package Firebase;/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import com.google.cloud.firestore.Firestore;

import java.io.*;
import java.net.*;

import Database.ClientDatabase;

public class FirebaseServiceAccount {
    /**
     * 
     * @throws URISyntaxException
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public static void initFirebase() throws URISyntaxException, FileNotFoundException, IOException{
        FileInputStream serviceAccount = new FileInputStream(new FirebaseServiceAccount().getServiceAccount());
        GoogleCredentials credentials = GoogleCredentials.fromStream(serviceAccount);
        FirebaseOptions options = FirebaseOptions.builder()
                .setCredentials(credentials)
                .build();
        FirebaseApp.initializeApp(options);
        Firestore firestore = FirestoreClient.getFirestore();
        ClientDatabase.setDb(firestore);
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
}