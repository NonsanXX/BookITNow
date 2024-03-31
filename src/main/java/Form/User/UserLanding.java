package Form.User;/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

import Firebase.UserLoginToken;
import Form.Admin.*;
import Database.Dataclass.RoomData;
import Database.Exception.DatabaseGetInterrupted;
import Database.RoomDatabase;
import Form.LoginGUI;
import Form.RoomPanel.RoomPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

/**
 *
 * @author acer
 */

public class UserLanding extends javax.swing.JFrame implements MouseListener{
    ArrayList<String> roomdata = RoomDatabase.getRoomList();
    int showroom_rows = Math.max(3, (int) Math.ceil((double)roomdata.size() / 4));
    /**
     * Creates new form landing
     */
    public UserLanding() {

        initComponents();
        refreshShowroom();
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
        jMenuBar1 = new javax.swing.JMenuBar();
        user_menu = new javax.swing.JMenu();
        change_pass_item = new javax.swing.JMenuItem();
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
                .addContainerGap(370, Short.MAX_VALUE))
        );
        showroomPanelLayout.setVerticalGroup(
            showroomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(showroomPanelLayout.createSequentialGroup()
                .addGap(245, 245, 245)
                .addComponent(loading, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(127, Short.MAX_VALUE))
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

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(1118, Short.MAX_VALUE)
                .addComponent(ref_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jScrollPane2)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ref_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

        user_menu.setText("Hi, "+ UserLoginToken.getClient().getEnglishName() +" "+ UserLoginToken.getClient().getEnglishSurname());

        change_pass_item.setText("Change Password");
        change_pass_item.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                change_pass_itemActionPerformed(evt);
            }
        });
        user_menu.add(change_pass_item);

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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(1220, 620));
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
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        refreshShowroom();
    }//GEN-LAST:event_formWindowOpened

    private void logout_itemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logout_itemActionPerformed
        int choice = JOptionPane.showConfirmDialog(UserLanding.this,
                "Do you want to logout?", "Logout",
                JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);

        if (choice == JOptionPane.YES_OPTION) {
            UserLoginToken.logoutUser();
            this.dispose();
            new LoginGUI().setVisible(true);
        }

    }//GEN-LAST:event_logout_itemActionPerformed

    private void change_pass_itemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_change_pass_itemActionPerformed
       new UserAccountManagement().setVisible(true);
    }//GEN-LAST:event_change_pass_itemActionPerformed
    private void refreshShowroom() {
        ref_btn.setEnabled(false);
        jScrollPane2.getVerticalScrollBar().setValue(jScrollPane2.getVerticalScrollBar().getMinimum());
        roomdata = RoomDatabase.getRoomList(); // get new room data from database
        showroom_rows = Math.max(3, (int) Math.ceil((double)roomdata.size() / 4));
        showroomPanel.removeAll();
        for (String room : roomdata) {
            try {
                RoomPanel rp = new RoomPanel(RoomDatabase.getRoomObject(room));
                rp.addMouseListener(this);
                showroomPanel.add(rp);
                System.out.println(room);
            } catch (DatabaseGetInterrupted e) {
                e.printStackTrace();
            }
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
            java.util.logging.Logger.getLogger(UserLanding.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserLanding.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserLanding.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserLanding.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserLanding().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu about_menu;
    private javax.swing.JMenuItem change_pass_item;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel loading;
    private javax.swing.JMenuItem logout_item;
    private javax.swing.JButton ref_btn;
    private javax.swing.JPanel showroomPanel;
    private javax.swing.JMenu user_menu;
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


}
