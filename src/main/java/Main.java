
import Firebase.FirebaseServiceAccount;
import UserInterface.*;
import javax.swing.*;

import java.io.IOException;
import java.net.URISyntaxException;

public class Main {
    private static JFrame loginF;
    
    public static void main(String[] args) throws URISyntaxException, IOException {
        try {
            FirebaseServiceAccount.initFirebase();
            
        } catch (URISyntaxException | IOException e) {
            throw new RuntimeException(e);
        }

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        SwingUtilities.invokeLater(() -> { new LoginGUI().setVisible(true); });

    }
}
