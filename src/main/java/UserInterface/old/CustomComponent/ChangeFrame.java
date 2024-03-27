package UserInterface.old.CustomComponent;

import javax.swing.JFrame;

public class ChangeFrame {
    
    public ChangeFrame(JFrame frame1, JFrame frame2) {
        frame1.setVisible(false);
        frame1.dispose();
        frame2.setVisible(true);
    }
}
