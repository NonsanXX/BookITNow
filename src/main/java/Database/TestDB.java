package Database;

import Database.Dataclass.ClientData;
import Database.Exception.ClientNotFoundException;
import Firebase.FirebaseServiceAccount;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TestDB {
    public static void main(String[] args) throws ClientNotFoundException {
        try {
            FirebaseServiceAccount.initFirebase();
            
            ClientData user1 = new ClientData();
            user1.setStudentID("100");
            ClientData user2 = new ClientData();
            user2.setStudentID("101");
            ClientData user3 = new ClientData();
            user3.setStudentID("102");
            
            
        } catch (URISyntaxException | IOException  ex) {
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