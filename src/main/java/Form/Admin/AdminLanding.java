package Form.Admin;/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

import Database.Dataclass.RoomData;
import Database.Exception.DatabaseGetInterrupted;
import Database.RoomDatabase;
import Firebase.UserLoginToken;
import Form.LoginGUI;
import Form.RoomPanel.RoomPanel;
import Form.User.UserLanding;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;

/**
 *
 * @author acer
 */

public class AdminLanding extends javax.swing.JFrame implements MouseListener, DocumentListener{
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
    public AdminLanding() {

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
        add_btn = new javax.swing.JButton();
        ref_btn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        clear_button = new javax.swing.JLabel();
        search_textfield = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        user_menu = new javax.swing.JMenu();
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
                .addGap(337, 337, 337)
                .addComponent(loading)
                .addContainerGap(346, Short.MAX_VALUE))
        );
        showroomPanelLayout.setVerticalGroup(
            showroomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(showroomPanelLayout.createSequentialGroup()
                .addGap(192, 192, 192)
                .addComponent(loading, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(177, Short.MAX_VALUE))
        );

        jScrollPane2.setViewportView(showroomPanel);

        add_btn.setText("Add");
        add_btn.setMaximumSize(new java.awt.Dimension(33, 28));
        add_btn.setMinimumSize(new java.awt.Dimension(33, 28));
        add_btn.setPreferredSize(new java.awt.Dimension(33, 28));
        add_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_btnActionPerformed(evt);
            }
        });

        ref_btn.setText("Refresh");
        ref_btn.setMaximumSize(new java.awt.Dimension(33, 28));
        ref_btn.setMinimumSize(new java.awt.Dimension(33, 28));
        ref_btn.setPreferredSize(new java.awt.Dimension(33, 28));
        ref_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ref_btnActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/search.png"))); // NOI18N

        clear_button.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/xbutton.png")).getImage().getScaledInstance(16, 16, Image.SCALE_SMOOTH)));
        clear_button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        clear_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clear_buttonMouseClicked(evt);
            }
        });

        search_textfield.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                search_textfieldPropertyChange(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(search_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(clear_button, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 418, Short.MAX_VALUE)
                .addComponent(add_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ref_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jScrollPane2)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                        .addComponent(ref_btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(add_btn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel1)
                        .addComponent(search_textfield)
                        .addComponent(clear_button, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 543, Short.MAX_VALUE))
        );

        jScrollPane2.getVerticalScrollBar().setUnitIncrement(16);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        user_menu.setText("Hello, Administator");

        logout_item.setText("Logout");
        logout_item.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logout_itemActionPerformed(evt);
            }
        });
        user_menu.add(logout_item);

        jMenuBar1.add(user_menu);

        about_menu.setText("About");
        jMenuBar1.add(about_menu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(1194, 620));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void ref_btnActionPerformed(java.awt.event.ActionEvent evt) {

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
    private void add_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_btnActionPerformed
        RoomRegister roomRegister = new RoomRegister();
        roomRegister.setVisible(true);
        roomRegister.setAlwaysOnTop(true);
    }//GEN-LAST:event_add_btnActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        refreshShowroom();
    }//GEN-LAST:event_formWindowOpened

    private void logout_itemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logout_itemActionPerformed
        int choice = JOptionPane.showConfirmDialog(AdminLanding.this,
            "Do you want to logout?", "Logout",
            JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);

        if (choice == JOptionPane.YES_OPTION) {
            UserLoginToken.logoutUser();
            this.dispose();
            new LoginGUI().setVisible(true);
        }
    }//GEN-LAST:event_logout_itemActionPerformed

    private void search_textfieldPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_search_textfieldPropertyChange
        System.out.println(search_textfield.getText());
    }//GEN-LAST:event_search_textfieldPropertyChange

    private void clear_buttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clear_buttonMouseClicked
        search_textfield.setText("");
        search_textfield.setFocusable(false);
        search_textfield.setFocusable(true);
        refreshShowroom();
    }//GEN-LAST:event_clear_buttonMouseClicked
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
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AdminLanding.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminLanding.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminLanding.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminLanding.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminLanding().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu about_menu;
    private javax.swing.JButton add_btn;
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
    private javax.swing.JMenu user_menu;
    // End of variables declaration//GEN-END:variables

    @Override
    public void mouseClicked(MouseEvent e) {
        RoomPanel source = (RoomPanel) e.getComponent();
        System.out.println(source.getRoomName());
        RoomEdit roomEdit;
        try {
            System.out.println("Checking...");
            if (RoomDatabase.getRoomObject(source.getRealroomname()) != null){
                roomEdit = new RoomEdit(RoomDatabase.getRoomObject(source.getRealroomname()));
                roomEdit.setVisible(true);
                roomEdit.setAlwaysOnTop(true);
            } else {
                JOptionPane.showMessageDialog(AdminLanding.this, "Can't find this room, Maybe try refreshing this page.");
                refreshShowroom();
            }
        } catch (DatabaseGetInterrupted ex) {
            JOptionPane.showMessageDialog(AdminLanding.this, ex.getMessage());
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
            JOptionPane.showMessageDialog(AdminLanding.this, ex.getMessage());
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
            JOptionPane.showMessageDialog(AdminLanding.this, ex.getMessage());
        }
    }

    @Override
    public void changedUpdate(DocumentEvent e) {

    }
}
