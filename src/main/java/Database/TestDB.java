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

public class TestDB {
    public static void main(String[] args) throws DatabaseGetInterrupted {
        try {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/YYYY");
            
            FirebaseServiceAccount.initFirebase();
            
//            UserLoginToken.loginUser(ClientDatabase.getClientObject("66070305"));
//            
//            String date = dtf.format(LocalDateTime.now());
//            
//            TimeDate res = new TimeDate(12.0, 20.0, date);
            RoomData rm = RoomDatabase.getRoomObject("reservative");
//            System.out.println(rm.getReservedTime().size());
            rm.updateReservedTime("05/04/2024", 0.0);
            RoomDatabase.updateRoom(rm);
//            System.out.println(rm.getReservedTime().size());
            //RoomDatabase.updateRoom(rm);
//            RoomDatabase.reservingRoom(RoomDatabase.getRoomObject("reservative"), res);
//            ArrayList<String> facilityList = new ArrayList<>(){{
//                add("Sooksan");
//                add("Whiteboard");
//                add("Grade");
//            }};
//            ArrayList<TimeRange> openTime = new ArrayList<>(){{
//                add(new TimeRange(0.0, 4.0));
//                add(new TimeRange(12.0, 15.0));
//                add(new TimeRange(16.5, 22.45));
//            }};
//            ArrayList<TimeDate> reservedTime = new ArrayList<>();
//            HashMap<String, TimeDate> currentQueue = new HashMap<>();
//            RoomData rm = new RoomData("reservative", "IT", "-100", facilityList, openTime, reservedTime, currentQueue, 100, true);
//            RoomDatabase.addRoom(rm);
//            
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