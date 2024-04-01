package Form.User;/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

import Database.ClientHistoryDatabase;
import Database.Dataclass.HistoryData;
import Database.Dataclass.RoomData;
import Database.Exception.DatabaseGetInterrupted;
import Database.RoomDatabase;
import Firebase.UserLoginToken;
import Form.Admin.AdminLanding;
import Form.LoginGUI;
import Form.RoomPanel.RoomPanel;
import org.checkerframework.checker.units.qual.A;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;
import java.awt.*;
import java.awt.event.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author acer
 */

public class UserLanding extends JFrame implements MouseListener, DocumentListener {
    ArrayList<RoomData> roomdata;

    {
        try {
            roomdata = RoomDatabase.getRoomListObject();
        } catch (DatabaseGetInterrupted e) {
            e.printStackTrace();
        }
    }

    int showroom_rows = Math.max(3, (int) Math.ceil((double)roomdata.size() / 4));
    /**
     * Creates new form landing
     */
    public UserLanding() {
        initComponents();
        Document doc = search_textfield.getDocument();
        doc.addDocumentListener(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        showroomPanel = new javax.swing.JPanel();
        loading = new javax.swing.JLabel();
        ref_btn = new javax.swing.JButton();
        search_textfield = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        clear_button = new javax.swing.JLabel();
        view_queue = new javax.swing.JButton();
        upcoming_text = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        user_menu = new javax.swing.JMenu();
        change_pass_item = new javax.swing.JMenuItem();
        book_history = new javax.swing.JMenuItem();
        switch_to_admin = new javax.swing.JMenuItem();
        logout_item = new javax.swing.JMenuItem();
        about_menu = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("BookITNow");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(51, 51, 51));

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        showroomPanel.setBackground(new java.awt.Color(102, 102, 102));
        showroomPanel.setPreferredSize( new Dimension(800, Math.max(250*showroom_rows, 600)));

        loading.setFont(new java.awt.Font("FreesiaUPC", 1, 90)); // NOI18N
        loading.setText("กำลังโหลดข้อมูล...");

        javax.swing.GroupLayout showroomPanelLayout = new javax.swing.GroupLayout(showroomPanel);
        showroomPanel.setLayout(showroomPanelLayout);
        showroomPanelLayout.setHorizontalGroup(
            showroomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(showroomPanelLayout.createSequentialGroup()
                .addGap(340, 340, 340)
                .addComponent(loading)
                .addContainerGap(367, Short.MAX_VALUE))
        );
        showroomPanelLayout.setVerticalGroup(
            showroomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(showroomPanelLayout.createSequentialGroup()
                .addGap(168, 168, 168)
                .addComponent(loading, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(204, Short.MAX_VALUE))
        );

        jScrollPane2.setViewportView(showroomPanel);

        ref_btn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        ref_btn.setText("Refresh");
        ref_btn.setMaximumSize(new java.awt.Dimension(33, 28));
        ref_btn.setMinimumSize(new java.awt.Dimension(33, 28));
        ref_btn.setPreferredSize(new java.awt.Dimension(33, 28));
        ref_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ref_btnActionPerformed(evt);
            }
        });

        search_textfield.setFont(new java.awt.Font("FreesiaUPC", 0, 24)); // NOI18N

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/search.png"))); // NOI18N

        clear_button.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/xbutton.png")).getImage().getScaledInstance(16, 16, Image.SCALE_SMOOTH)));
        clear_button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        clear_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clear_buttonMouseClicked(evt);
            }
        });

        view_queue.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        view_queue.setText("What's Next?");
        view_queue.setMaximumSize(new java.awt.Dimension(33, 28));
        view_queue.setMinimumSize(new java.awt.Dimension(33, 28));
        view_queue.setPreferredSize(new java.awt.Dimension(33, 28));
        view_queue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                view_queueActionPerformed(evt);
            }
        });

        upcoming_text.setFont(new java.awt.Font("FreesiaUPC", 0, 24)); // NOI18N
        upcoming_text.setForeground(new java.awt.Color(255, 255, 255));
        upcoming_text.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(search_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(clear_button, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(upcoming_text, javax.swing.GroupLayout.DEFAULT_SIZE, 471, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(view_queue, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ref_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jScrollPane2)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1)
                    .addComponent(search_textfield, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(upcoming_text, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(ref_btn, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                        .addComponent(view_queue, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
                    .addComponent(clear_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 546, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jScrollPane2.getVerticalScrollBar().setUnitIncrement(16);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        user_menu.setText("Hello, "+ UserLoginToken.getClient().getEnglishName() +" "+ UserLoginToken.getClient().getEnglishSurname());

        change_pass_item.setText("Change Password");
        change_pass_item.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                change_pass_itemActionPerformed(evt);
            }
        });
        user_menu.add(change_pass_item);

        book_history.setText("Booking History");
        book_history.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                book_historyActionPerformed(evt);
            }
        });
        user_menu.add(book_history);

        switch_to_admin.setText("Switch to Admin Mode");
        switch_to_admin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                switch_to_adminActionPerformed(evt);
            }
        });
        if (UserLoginToken.getClient().getAccessLevel() == 1){
            user_menu.add(switch_to_admin);
        }

        logout_item.setText("Logout");
        logout_item.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logout_itemActionPerformed(evt);
            }
        });
        user_menu.add(logout_item);

        jMenuBar1.add(user_menu);

        about_menu.setText("About");
        about_menu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                about_menuActionPerformed(evt);
            }
        });
        jMenuBar1.add(about_menu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(1220, 620));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void ref_btnActionPerformed(ActionEvent evt) {
        search_textfield.setText("");
        showLoadingIndicator();
        new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground(){
                refreshShowroom();
                return null;
            }
        }.execute();
    }                                       
    private void showLoadingIndicator() {
        showroomPanel.removeAll();
        showroomPanel.setLayout(new GroupLayout(showroomPanel));
        showroomPanel.add(loading);
        loading.setVisible(true);
        showroomPanel.revalidate();
        showroomPanel.repaint();
    }
    private void formWindowOpened(WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        refreshShowroom();
    }//GEN-LAST:event_formWindowOpened

    private void logout_itemActionPerformed(ActionEvent evt) {//GEN-FIRST:event_logout_itemActionPerformed
        int choice = JOptionPane.showConfirmDialog(UserLanding.this,
                "Do you want to logout?", "Logout",
                JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);

        if (choice == JOptionPane.YES_OPTION) {
            UserLoginToken.logoutUser();
            this.dispose();
            new LoginGUI().setVisible(true);
        }

    }//GEN-LAST:event_logout_itemActionPerformed

    private void change_pass_itemActionPerformed(ActionEvent evt) {//GEN-FIRST:event_change_pass_itemActionPerformed
       new UserAccountManagement().setVisible(true);
    }//GEN-LAST:event_change_pass_itemActionPerformed

    private void clear_buttonMouseClicked(MouseEvent evt) {//GEN-FIRST:event_clear_buttonMouseClicked
        search_textfield.setText("");
        search_textfield.setFocusable(false);
        search_textfield.setFocusable(true);
        refreshShowroom();
    }//GEN-LAST:event_clear_buttonMouseClicked

    private void book_historyActionPerformed(ActionEvent evt) {//GEN-FIRST:event_book_historyActionPerformed
        new HistoryFrame().setVisible(true);
    }//GEN-LAST:event_book_historyActionPerformed

    private void view_queueActionPerformed(ActionEvent evt) {//GEN-FIRST:event_view_queueActionPerformed
        new BookingQueue().setVisible(true);
    }//GEN-LAST:event_view_queueActionPerformed

    private void switch_to_adminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_switch_to_adminActionPerformed
        new AdminLanding().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_switch_to_adminActionPerformed

    private void about_menuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_about_menuActionPerformed
        new AboutDeveloper().setVisible(true);
    }//GEN-LAST:event_about_menuActionPerformed
    private void refreshShowroom() {
        ref_btn.setEnabled(false);
        jScrollPane2.getVerticalScrollBar().setValue(jScrollPane2.getVerticalScrollBar().getMinimum());
        try {
            roomdata = RoomDatabase.getRoomListObject(); // get new room data from database
        } catch (DatabaseGetInterrupted e) {
            e.printStackTrace();
        }
        showroom_rows = Math.max(3, (int) Math.ceil((double)roomdata.size() / 4));
        showroomPanel.removeAll();
        System.out.println("Loading...");
        for (RoomData room : roomdata) {
            RoomPanel rp = new RoomPanel(room);
            rp.addMouseListener(this);
            showroomPanel.add(rp);
            System.out.println("Room : "+room.getRoomName());
        }
        while (showroomPanel.getComponentCount() < 12){
            showroomPanel.add(new JLabel());
        }
        showroomPanel.setLayout(new GridLayout(showroom_rows, 4, 5, 5));
        showroomPanel.setPreferredSize( new Dimension(800, Math.max(250*showroom_rows, 600)));
        ArrayList<HistoryData> historyDataArrayList = new ArrayList<>();
        try {
            historyDataArrayList = ClientHistoryDatabase.getIncomingReservation(UserLoginToken.getClientID());
        } catch (DatabaseGetInterrupted e) {
            JOptionPane.showMessageDialog(UserLanding.this, e.getMessage());
        }
        if (!historyDataArrayList.isEmpty()){
            HistoryData upcoming = historyDataArrayList.get(0);
            RoomData upcomingRoom = new RoomData();
            try {
                upcomingRoom = RoomDatabase.getRoomObject(upcoming.getRecorded());
            } catch (DatabaseGetInterrupted e) {
                JOptionPane.showMessageDialog(UserLanding.this, e.getMessage());
            }
            if (upcomingRoom != null){
                upcoming_text.setText("<html>Upcoming reservation for " + upcoming.getRecorded() + "<html><br> Floor <html>" +
                        upcomingRoom.getFloor() + ", " + upcomingRoom.getBuilding() + " at " + upcoming.getTimeDate().toString());
            } else {
                upcoming_text.setText("<html>Hello!<br>You currently have no upcoming reservations scheduled.<html>");
            }
        } else {
            upcoming_text.setText("<html>Hello!<br>You currently have no upcoming reservations scheduled.<html>");
        }
        showroomPanel.revalidate();
        showroomPanel.repaint();
        ref_btn.setEnabled(true);
        ref_btn.requestFocus();
    }
    private void searchRefreshShowroom(ArrayList<RoomData> roomdata) {
        ref_btn.setEnabled(false);
        jScrollPane2.getVerticalScrollBar().setValue(jScrollPane2.getVerticalScrollBar().getMinimum());
        showroom_rows = Math.max(3, (int) Math.ceil((double)roomdata.size() / 4));
        showroomPanel.removeAll();
        System.out.println("Loading...");
        for (RoomData room : roomdata) {
            RoomPanel rp = new RoomPanel(room);
            rp.addMouseListener(this);
            showroomPanel.add(rp);
            System.out.println("Room : "+room.getRoomName());
        }
        while (showroomPanel.getComponentCount() < 12){
            showroomPanel.add(new JLabel());
        }
        showroomPanel.setLayout(new GridLayout(showroom_rows, 4, 5, 5));
        showroomPanel.setPreferredSize( new Dimension(800, Math.max(250*showroom_rows, 600)));
        showroomPanel.revalidate();
        showroomPanel.repaint();
        ref_btn.setEnabled(true);
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserLanding.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(UserLanding.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(UserLanding.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(UserLanding.class.getName()).log(Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserLanding().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu about_menu;
    private javax.swing.JMenuItem book_history;
    private javax.swing.JMenuItem change_pass_item;
    private javax.swing.JLabel clear_button;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel loading;
    private javax.swing.JMenuItem logout_item;
    private javax.swing.JButton ref_btn;
    private javax.swing.JTextField search_textfield;
    private javax.swing.JPanel showroomPanel;
    private javax.swing.JMenuItem switch_to_admin;
    private javax.swing.JLabel upcoming_text;
    private javax.swing.JMenu user_menu;
    private javax.swing.JButton view_queue;
    // End of variables declaration//GEN-END:variables

    @Override
    public void mouseClicked(MouseEvent e) {
        RoomPanel source = (RoomPanel) e.getComponent();
        System.out.println(source.getRoomName());
        RoomBooking roomBooking;
        try {
            System.out.println("Checking...");
            if (RoomDatabase.getRoomObject(source.getRealroomname()) != null){
                roomBooking = new RoomBooking(RoomDatabase.getRoomObject(source.getRealroomname()));
                roomBooking.setVisible(true);
                roomBooking.setAlwaysOnTop(true);
            } else {
                JOptionPane.showMessageDialog(UserLanding.this, "Can't find this room, Maybe try refreshing this page.");
                refreshShowroom();
            }
        } catch (DatabaseGetInterrupted ex) {
            JOptionPane.showMessageDialog(UserLanding.this, ex.getMessage());
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }


    @Override
    public void insertUpdate(DocumentEvent e) {
        String searchText = search_textfield.getText();
        RoomData searchRD = new RoomData();
        searchRD.setRoomName(searchText);
        try {
            ArrayList<RoomData> searchRD_list = RoomDatabase.searchRoomName(searchRD);
            searchRefreshShowroom(searchRD_list);
        } catch (DatabaseGetInterrupted ex) {
            JOptionPane.showMessageDialog(UserLanding.this, ex.getMessage());
        }
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        String searchText = search_textfield.getText();
        RoomData searchRD = new RoomData();
        searchRD.setRoomName(searchText);
        try {
            ArrayList<RoomData> searchRD_list = RoomDatabase.searchRoomName(searchRD);
            searchRefreshShowroom(searchRD_list);
        } catch (DatabaseGetInterrupted ex) {
            JOptionPane.showMessageDialog(UserLanding.this, ex.getMessage());
        }
    }

    @Override
    public void changedUpdate(DocumentEvent e) {

    }
}
