package Firebase;/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;

import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FirebaseServiceAccount {
    public File getServiceAccount() throws URISyntaxException {
        ClassLoader classLoader = getClass().getClassLoader();
        URL resource = classLoader.getResource("firebase-token/bookitnow-firestore-firebase-adminsdk-g9exh-9d7b7a5989.json");
        if (resource == null) {
            throw new IllegalArgumentException("File not found!" + resource.toURI());
        } else {
            return new File(resource.toURI());
        }
    }
    
    public static void main(String[] args) {
        try {
            System.out.println(new FirebaseServiceAccount().getServiceAccount());
        } catch (URISyntaxException ex) {
            Logger.getLogger(FirebaseServiceAccount.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}