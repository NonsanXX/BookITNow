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

import java.util.Collections;

import java.awt.event.*;

public class TestDB{
    private static RoomSearcher rs = new RoomSearcher();
    public static void main(String[] args) throws DatabaseGetInterrupted {
        rs.roomName.setText("IT");
        try {
            FirebaseServiceAccount.initFirebase();
            //ClientHistoryDatabase.updateHistory("66070162", ClientHistoryDatabase.createEmptyHistory());
            TimeDate t1 = new TimeDate(9.0, 11.0, "02/04/2024");
            TimeDate t2 = new TimeDate(19.0, 21.0, "02/04/2024");
            TimeDate t3 = new TimeDate(12.0, 13.0, "02/04/2024");
            ArrayList<TimeDate> f = new ArrayList<>();
            f.add(t1);
            f.add(t2);
            f.add(t3);
            Collections.sort(f);
            System.out.println(f);
//            System.out.println(t1.compareTo(t3));
//            System.out.println(t2.compareTo(t3));
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