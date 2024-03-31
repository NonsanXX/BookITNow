package Database;

import Database.Dataclass.ClientData;
import Database.Exception.DatabaseGetInterrupted;
import Firebase.FirebaseServiceAccount;
import Firebase.UserLoginToken;


import Database.RoomDatabase;
import Database.Dataclass.RoomData;
import Database.Dataclass.TimeRange;
import Database.Dataclass.TimeDate;
import com.google.cloud.firestore.DocumentReference;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import Database.RoomCommentDatabase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import Database.ClientHistoryDatabase;
import Database.Dataclass.HistoryData;

import javax.swing.table.DefaultTableModel;
import java.awt.*;
import javax.swing.*;
import Database.Dataclass.CommentData;

public class TestDB {
    public static void main(String[] args) throws DatabaseGetInterrupted {
        try {
            FirebaseServiceAccount.initFirebase();
            //ClientHistoryDatabase.updateHistory("66070162", ClientHistoryDatabase.createEmptyHistory());
            UserLoginToken.loginUser(ClientDatabase.getClientObject("66070305")); //bypass login session
            
            //RoomDatabase.reservingRoom(RoomDatabase.getRoomObject("IT-IT-Tutor"), new TimeDate(0.0, 1.0, TimeDate.getDateNow()));
            
//            RoomDatabase.getRoomObject("IT-IT-Tutor").report();
//            ClientDatabase.getClientObject("66070305").report();
            //RoomCommentDatabase.addComment("IT-IT-HIY", new CommentData("@null", "this room ....", 3l));
            
            for(CommentData comment : RoomCommentDatabase.readComment("IT-IT-HIY")){
                System.out.println(comment.getAuthor());
                System.out.println(comment.getComment());
                System.out.println(comment.getRating());
            }
        } catch (URISyntaxException | IOException    ex) {
            Logger.getLogger(TestDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            try {
                Database.getDb().close();
            } catch (Exception ex) {
                Logger.getLogger(TestDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}