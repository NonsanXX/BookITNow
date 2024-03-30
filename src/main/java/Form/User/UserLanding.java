package Form.User;/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

import Database.Exception.DatabaseGetInterrupted;
import Database.RoomDatabase;
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
    int showroom_rows = Math.max(1, (int) Math.ceil((double)roomdata.size() / 4));
    /**
     * Creates new form landing
     */
    public UserLanding() {

        initComponents();

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
        menu_btn = new javax.swing.JButton();
        ref_btn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane2.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        showroomPanel.setBackground(new java.awt.Color(153, 153, 255));
        showroomPanel.setPreferredSize( new Dimension(800, Math.max(300*showroom_rows, 600)));

        loading.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        loading.setText("LOADING...");

        javax.swing.GroupLayout showroomPanelLayout = new javax.swing.GroupLayout(showroomPanel);
        showroomPanel.setLayout(showroomPanelLayout);
        showroomPanelLayout.setHorizontalGroup(
            showroomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, showroomPanelLayout.createSequentialGroup()
                .addContainerGap(427, Short.MAX_VALUE)
                .addComponent(loading)
                .addGap(361, 361, 361))
        );
        showroomPanelLayout.setVerticalGroup(
            showroomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(showroomPanelLayout.createSequentialGroup()
                .addGap(219, 219, 219)
                .addComponent(loading)
                .addContainerGap(2717, Short.MAX_VALUE))
        );

        jScrollPane2.setViewportView(showroomPanel);

        menu_btn.setText("menu");
        menu_btn.setMaximumSize(new java.awt.Dimension(33, 28));
        menu_btn.setMinimumSize(new java.awt.Dimension(33, 28));
        menu_btn.setPreferredSize(new java.awt.Dimension(33, 28));
        menu_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_btnActionPerformed(evt);
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

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(menu_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ref_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1058, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ref_btn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(menu_btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 511, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane2.getVerticalScrollBar().setUnitIncrement(16);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
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
    private void menu_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_btnActionPerformed
        new UserAccountManagement().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_menu_btnActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        refreshShowroom();
    }//GEN-LAST:event_formWindowOpened
    private void refreshShowroom() {
        ref_btn.setEnabled(false);
        jScrollPane2.getVerticalScrollBar().setValue(jScrollPane2.getVerticalScrollBar().getMinimum());
        roomdata = RoomDatabase.getRoomList(); // get new room data from database
        showroom_rows = Math.max(1, (int) Math.ceil((double)roomdata.size() / 4));
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
        showroomPanel.setLayout(new GridLayout(showroom_rows, 4, 5, 5));
        showroomPanel.setPreferredSize( new Dimension(800, 150*showroom_rows));
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel loading;
    private javax.swing.JButton menu_btn;
    private javax.swing.JButton ref_btn;
    private javax.swing.JPanel showroomPanel;
    // End of variables declaration//GEN-END:variables

    @Override
    public void mouseClicked(MouseEvent e) {
        RoomPanel source = (RoomPanel) e.getComponent();
        System.out.println(source.getRoomName());
        try {
            new UserDashboard(RoomDatabase.getRoomObject(source.getRoomName())).setVisible(true);
        } catch (DatabaseGetInterrupted ex) {
            ex.printStackTrace();
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
