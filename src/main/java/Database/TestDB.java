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

public class TestDB {
    public static void main(String[] args) throws DatabaseGetInterrupted {
        try {
            FirebaseServiceAccount.initFirebase();
            //ClientHistoryDatabase.updateHistory("66070162", ClientHistoryDatabase.createEmptyHistory());
            UserLoginToken.loginUser(ClientDatabase.getClientObject("66070162")); //bypass login session
            ArrayList<HistoryData> readData = ClientHistoryDatabase.readHistory("66070162");
            
            JFrame frame = new JFrame();
            JTable table = new JTable(ClientHistoryDatabase.createDefaultTableModel(readData));
            JScrollPane scrollPane = new JScrollPane(table);
            frame.add(scrollPane);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setVisible(true);
//            TimeDate reserveTime = new TimeDate(0.5, 1.5, TimeDate.getDateNow());
//            RoomDatabase.reservingRoom(RoomDatabase.getRoomObject("IT-Peer"), reserveTime);
            
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