/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Form.Admin;

import Database.ClientDatabase;
import Database.Dataclass.ClientData;
import Database.Dataclass.RoomData;
import Database.Exception.DatabaseGetInterrupted;
import Database.RoomDatabase;
import Firebase.UserLoginToken;
import Form.User.CheckRoomReserveTime;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.beans.PropertyVetoException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static Database.RoomDatabase.getRoomList;

/**
 *
 * @author Nonsan
 */
public class AdminManagement extends javax.swing.JFrame {
    ArrayList<String> roomNameArrayList;
    /**
     * Creates new form AdminManagement
     */
    public AdminManagement() {
        initComponents();
        refreshRoomHistory();
        refreshUserTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        user_table_frame = new javax.swing.JInternalFrame();
        jScrollPane1 = new javax.swing.JScrollPane();
        ClientDatabase clientDatabase = new ClientDatabase();
        userTable = clientDatabase.report();
        jLabel2 = new javax.swing.JLabel();
        refresh_btn = new javax.swing.JButton();
        room_history_frame = new javax.swing.JInternalFrame();
        jScrollPane2 = new javax.swing.JScrollPane();
        room_history_table = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        room_JList = new javax.swing.JList<>();
        ref_btn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        view = new javax.swing.JMenu();
        user_manage_item = new javax.swing.JCheckBoxMenuItem();
        room_history_item = new javax.swing.JCheckBoxMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("AdminMananagement");
        setExtendedState(getExtendedState() | MAXIMIZED_BOTH);

        user_table_frame.setVisible(false);

        userTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                userTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(userTable);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setText("User Management");

        refresh_btn.setText("Refresh");
        refresh_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refresh_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout user_table_frameLayout = new javax.swing.GroupLayout(user_table_frame.getContentPane());
        user_table_frame.getContentPane().setLayout(user_table_frameLayout);
        user_table_frameLayout.setHorizontalGroup(
            user_table_frameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1081, Short.MAX_VALUE)
            .addGroup(user_table_frameLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(refresh_btn)
                .addGap(21, 21, 21))
        );
        user_table_frameLayout.setVerticalGroup(
            user_table_frameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, user_table_frameLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(user_table_frameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(refresh_btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jDesktopPane1.add(user_table_frame);
        user_table_frame.setBounds(6, 6, 1093, 571);

        room_history_frame.setVisible(false);

        jScrollPane2.setViewportView(room_history_table);

        room_JList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        room_JList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                room_JListValueChanged(evt);
            }
        });
        jScrollPane3.setViewportView(room_JList);

        ref_btn.setText("Refresh");
        ref_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ref_btnActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Room Name");

        javax.swing.GroupLayout room_history_frameLayout = new javax.swing.GroupLayout(room_history_frame.getContentPane());
        room_history_frame.getContentPane().setLayout(room_history_frameLayout);
        room_history_frameLayout.setHorizontalGroup(
            room_history_frameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, room_history_frameLayout.createSequentialGroup()
                .addGroup(room_history_frameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(room_history_frameLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(room_history_frameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE)
                            .addGroup(room_history_frameLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(0, 239, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(room_history_frameLayout.createSequentialGroup()
                        .addGap(102, 102, 102)
                        .addComponent(ref_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 560, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        room_history_frameLayout.setVerticalGroup(
            room_history_frameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(room_history_frameLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ref_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(51, Short.MAX_VALUE))
        );

        jDesktopPane1.add(room_history_frame);
        room_history_frame.setBounds(0, 0, 930, 540);

        view.setText("View & Modify");

        user_manage_item.setText("User Management");
        user_manage_item.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                user_manage_itemStateChanged(evt);
            }
        });
        view.add(user_manage_item);

        room_history_item.setText("Room History");
        room_history_item.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                room_history_itemStateChanged(evt);
            }
        });
        view.add(room_history_item);

        jMenuBar1.add(view);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );

        setSize(new java.awt.Dimension(1527, 607));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    private void refreshRoomHistory(){
        roomNameArrayList = RoomDatabase.getRoomList();
        DefaultListModel<String> listModel = new DefaultListModel<>();
        for (String room_name : roomNameArrayList){
            listModel.addElement(room_name);
        }
        room_JList.setModel(listModel);
    }
    private void userTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userTableMouseClicked
        JTable source = (JTable)evt.getSource();
            int row = source.rowAtPoint( evt.getPoint() );
            String studID =source.getModel().getValueAt(row, 0)+"";
            ClientData user = new ClientData();
        try {
            user = ClientDatabase.getClientObject(studID);
        } catch (DatabaseGetInterrupted e) {
            e.printStackTrace();
        }
        String[] options = { "Delete", "Edit", "Cancel" };
            int selection = JOptionPane.showOptionDialog(user_table_frame,
                    (user.getStudentID()+"\n"+user.getEnglishName()+" "+user.getEnglishSurname()+"\nWhat you want to do with this user?"),"User Management",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
            if (selection == 0) {
                int choice  =JOptionPane.showConfirmDialog(user_table_frame,
                        "Are you sure you want to delete this user?\nThis action cannot be undone.",
                        "Delete user", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                if (choice == 0 && !studID.equals(UserLoginToken.getClientID())){
                    ClientDatabase.deleteClient(studID);
                } else {
                    JOptionPane.showMessageDialog(user_table_frame, "Please don't delete your own account!");
                }
            }
            if (selection == 1) {
                AdminEdit adminEdit = new AdminEdit(user);
                adminEdit.setLocationRelativeTo(user_table_frame);
                adminEdit.setVisible(true);
            }
    }//GEN-LAST:event_userTableMouseClicked

    private void ref_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ref_btnActionPerformed
        refreshRoomHistory();
    }//GEN-LAST:event_ref_btnActionPerformed

    private void room_JListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_room_JListValueChanged
        if (!evt.getValueIsAdjusting() && room_JList.getSelectedValue() != null) {
            try {
                RoomData selectedRoom = RoomDatabase.getRoomObject(room_JList.getSelectedValue());
                room_history_table.setModel(selectedRoom.report().getModel());

            } catch (DatabaseGetInterrupted e) {
                e.printStackTrace();
            }

        } else {
            room_history_table.setModel(new DefaultTableModel());

        }
    }//GEN-LAST:event_room_JListValueChanged

    private void user_manage_itemStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_user_manage_itemStateChanged
        if (user_manage_item.getState()){
            user_table_frame.show();
        } else {
            user_table_frame.hide();
        }
    }//GEN-LAST:event_user_manage_itemStateChanged

    private void room_history_itemStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_room_history_itemStateChanged
       if (room_history_item.getState()){
           room_history_frame.show();
       } else {
           room_history_frame.hide();
       }
    }//GEN-LAST:event_room_history_itemStateChanged

    private void refresh_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refresh_btnActionPerformed
        refreshUserTable();
    }//GEN-LAST:event_refresh_btnActionPerformed
    private void refreshUserTable(){
        ClientDatabase clientDatabase = new ClientDatabase();
        userTable.setModel(clientDatabase.report().getModel());
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(AdminManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminManagement().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton ref_btn;
    private javax.swing.JButton refresh_btn;
    private javax.swing.JList<String> room_JList;
    private javax.swing.JInternalFrame room_history_frame;
    private javax.swing.JCheckBoxMenuItem room_history_item;
    private javax.swing.JTable room_history_table;
    private javax.swing.JTable userTable;
    private javax.swing.JCheckBoxMenuItem user_manage_item;
    private javax.swing.JInternalFrame user_table_frame;
    private javax.swing.JMenu view;
    // End of variables declaration//GEN-END:variables

}
