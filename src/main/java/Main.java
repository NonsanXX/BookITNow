import Database.*;
import Database.Dataclass.ClientData;
import Database.Exception.ClientDataConstructureException;
import Database.Exception.ClientNotFoundException;
import Firebase.FirebaseServiceAccount;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) throws ClientNotFoundException, ClientDataConstructureException {
        try {
            FirebaseServiceAccount.initFirebase();
            ClientDatabase.addClient(new ClientData("thai_Phum", "thai_Wong", "Phum", "Wong", "phumphumwongwong@wongchan.phum", "66070162", "easypasscode", 0));
            System.out.println(new ClientData(ClientDatabase.getClient("66070162")).toHashMap());
        } catch (URISyntaxException | IOException | InterruptedException | ExecutionException  ex) {
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