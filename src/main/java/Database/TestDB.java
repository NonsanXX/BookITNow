package Database;

import Database.Dataclass.ClientData;
import Database.Exception.DatabaseGetInterrupted;
import Firebase.FirebaseServiceAccount;

import Database.RoomDatabase;
import Database.Dataclass.RoomData;
import Database.Dataclass.timeRange;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.util.ArrayList;
import java.util.HashMap;

public class TestDB {
    public static void main(String[] args) throws DatabaseGetInterrupted {
        try {
            FirebaseServiceAccount.initFirebase();
            ArrayList<String> facilityList = new ArrayList<>(){{
                add("table");
                add("body");
            }};
            ArrayList<timeRange> openTime = new ArrayList<>(){{
                add(new timeRange(0, 12));
                add(new timeRange(15, 20));
            }};
            ArrayList<timeRange> reservedTime = new ArrayList<>();
            HashMap<String, timeRange> currentQueue = new HashMap<>();
            RoomData rm1 = new RoomData("testRoom", facilityList, "testRoom", openTime, reservedTime, currentQueue);
            RoomDatabase.addRoom(rm1);
            
        } catch (URISyntaxException | IOException   ex) {
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