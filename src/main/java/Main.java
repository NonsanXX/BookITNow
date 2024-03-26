import Database.*;
import Database.Dataclass.ClientData;
import Database.Exception.ClientNotFoundException;
import Firebase.FirebaseServiceAccount;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) throws ClientNotFoundException {
        try {
            FirebaseServiceAccount.initFirebase();
            
            ClientData user1 = new ClientData();
            user1.setStudentID("100");
            ClientData user2 = new ClientData();
            user2.setStudentID("101");
            ClientData user3 = new ClientData();
            user3.setStudentID("102");
            
            ClientDatabase.addClient(user1);
            ClientDatabase.addClient(user2);
            ClientDatabase.addClient(user3);
            
            ClientDatabase.updateClient("100", ClientData.FIELD_ACCESS_LEVEL, 1000000);
            ClientDatabase.updateClient("101", ClientData.FIELD_THAI_NAME, "Normal Client");
            ClientDatabase.updateClient("102", ClientData.FIELD_ENGLISH_NAME, "New");
            
//            ClientDatabase.deleteClient("100");
//            ClientDatabase.deleteClient("101");
//            ClientDatabase.deleteClient("102");
        } catch (URISyntaxException | IOException  ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            try {
                Database.getDb().close();
            } catch (Exception ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}