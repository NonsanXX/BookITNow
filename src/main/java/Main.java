
import Firebase.FirebaseServiceAccount;
import Form.*;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;

import javax.swing.*;

import java.io.IOException;
import java.net.URISyntaxException;

public class Main {
    
    public static void main(String[] args) throws URISyntaxException, IOException {
        try {
            FirebaseServiceAccount.initFirebase();
            
        } catch (URISyntaxException | IOException e) {
            throw new RuntimeException(e);
        }

        try {
            UIManager.setLookAndFeel(new FlatMacDarkLaf());
            UIManager.put( "Button.arc", 999 );
            UIManager.put( "Component.arc", 999 );
            UIManager.put( "ProgressBar.arc", 999 );
            UIManager.put( "TextComponent.arc", 999 );
        } catch (Exception e) {
            e.printStackTrace();
        }
        SwingUtilities.invokeLater(() -> { new LoginGUI().setVisible(true); });

    }
}
