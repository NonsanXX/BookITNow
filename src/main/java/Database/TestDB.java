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

import java.awt.event.*;

public class TestDB{
    private static RoomSearcher rs = new RoomSearcher();
    public static void main(String[] args) throws DatabaseGetInterrupted {
        rs.roomName.setText("IT");
        try {
            FirebaseServiceAccount.initFirebase();
            //ClientHistoryDatabase.updateHistory("66070162", ClientHistoryDatabase.createEmptyHistory());
            UserLoginToken.loginUser(ClientDatabase.getClientObject("66070305")); //bypass login session
            
//            RoomData rm = RoomDatabase.getRoomObject("IT-IT-HIY");
//            RoomDatabase.reservingRoom(rm, new TimeDate(0.0, 1.0, TimeDate.getDateNow()));
            TimeDate t1 = new TimeDate(0.0, 1.0, "01/04/2024");
            TimeDate t2 = new TimeDate(0.0, 1.0, "01/05/2024");
            
            System.out.println(t1.isOverlap(t2));
//            for(String feedback : FeedbackDatabase.getFeedback()){
//                System.out.println(feedback);
//            }
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