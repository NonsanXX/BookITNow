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

public class TestDB {
    public static void main(String[] args) throws DatabaseGetInterrupted {
        try {
            FirebaseServiceAccount.initFirebase();
            
//            ArrayList<String> facilityList = new ArrayList<>(){{
//                add("Computer");
//                add("Chair");
//                add("Person");
//            }};
//            
//            ArrayList<timeRange> availableTime = new ArrayList<>(){{
//                add(new timeRange(1l, 2l));
//                add(new timeRange(4l, 12l));
//            }};
//            
//            RoomData rm1 = new RoomData("testRoom", facilityList, "This is test room", availableTime);
//            RoomDatabase.addRoom(rm1);
            System.out.println(Database.getDb().collection(Database.ROOM_COLLECTION).document("testRoom").get().get().getData());
            
        } catch (URISyntaxException | IOException | InterruptedException | ExecutionException  ex) {
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