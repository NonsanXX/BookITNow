/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Form.Admin;

import Database.Database;
import Database.Dataclass.RoomData;
import Database.Dataclass.TimeRange;
import Database.Exception.DatabaseGetInterrupted;
import Database.RoomDatabase;

import javax.swing.*;
import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author acer
 */
public class RoomRegister extends javax.swing.JFrame {

    /**
     * Creates new form room_register
     */
    public RoomRegister() {
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

        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        room_name_label = new javax.swing.JLabel();
        room_name_tf = new javax.swing.JTextField();
        building_tf = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        capacity_spin = new javax.swing.JSpinner();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        floor_tf = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        open_hour = new javax.swing.JSpinner();
        close_hour = new javax.swing.JSpinner();
        jLabel8 = new javax.swing.JLabel();
        open_min = new javax.swing.JSpinner();
        close_min = new javax.swing.JSpinner();
        jLabel9 = new javax.swing.JLabel();
        status = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        facility_JList = new javax.swing.JList<>();
        facility = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        facility1 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        add_room = new javax.swing.JButton();
        cancel_btn = new javax.swing.JButton();
        description = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel4.setBackground(new java.awt.Color(24, 24, 24));

        jLabel1.setFont(new java.awt.Font("FreesiaUPC", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Room Register");

        jPanel1.setBackground(new java.awt.Color(24, 24, 24));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(85, 85, 85), 5));

        room_name_label.setFont(new java.awt.Font("FreesiaUPC", 1, 24)); // NOI18N
        room_name_label.setForeground(new java.awt.Color(255, 255, 255));
        room_name_label.setText("ชื่อห้อง");
        room_name_label.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        room_name_tf.setFont(new java.awt.Font("FreesiaUPC", 0, 24)); // NOI18N

        building_tf.setFont(new java.awt.Font("FreesiaUPC", 0, 24)); // NOI18N

        jLabel4.setFont(new java.awt.Font("FreesiaUPC", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("จำนวนคน");
        jLabel4.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        capacity_spin.setModel(new javax.swing.SpinnerNumberModel(1, 1, 100, 1));

        jLabel5.setFont(new java.awt.Font("FreesiaUPC", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("อาคาร");
        jLabel5.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        jLabel6.setFont(new java.awt.Font("FreesiaUPC", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("ชั้น");
        jLabel6.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        floor_tf.setFont(new java.awt.Font("FreesiaUPC", 0, 24)); // NOI18N

        jLabel7.setFont(new java.awt.Font("FreesiaUPC", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("เวลาเปิด");
        jLabel7.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        open_hour.setModel(new javax.swing.SpinnerNumberModel(Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(23L), Long.valueOf(1L)));
        open_hour.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                open_hourStateChanged(evt);
            }
        });

        close_hour.setModel(new javax.swing.SpinnerNumberModel(Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(23L), Long.valueOf(1L)));

        jLabel8.setFont(new java.awt.Font("FreesiaUPC", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("เวลาปิด");
        jLabel8.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        open_min.setModel(new javax.swing.SpinnerNumberModel(Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(59L), Long.valueOf(1L)));

        close_min.setModel(new javax.swing.SpinnerNumberModel(Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(59L), Long.valueOf(1L)));

        jLabel9.setFont(new java.awt.Font("FreesiaUPC", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("สถานะ");
        jLabel9.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        status.setFont(new java.awt.Font("FreesiaUPC", 0, 18)); // NOI18N
        status.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "เปิด", "ปิด" }));

        facility_JList.setFont(new java.awt.Font("FreesiaUPC", 0, 48)); // NOI18N
        facility_JList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "TV", "White Board", "USB Charger", "Projector", "VR Headset", "Speaker", "Wi-Fi", "Computer" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        facility_JList.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        facility_JList.setLayoutOrientation(javax.swing.JList.HORIZONTAL_WRAP);
        jScrollPane1.setViewportView(facility_JList);

        facility.setFont(new java.awt.Font("FreesiaUPC", 1, 36)); // NOI18N
        facility.setForeground(new java.awt.Color(255, 255, 255));
        facility.setText("สิ่งอำนวยความสะดวก");
        facility.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        facility1.setFont(new java.awt.Font("FreesiaUPC", 1, 24)); // NOI18N
        facility1.setForeground(new java.awt.Color(255, 255, 255));
        facility1.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        facility1.setText("กดปุ่ม CTRL หรือ SHIFT ค้างเพื่อเลือกหลายรายการ");

        add_room.setFont(new java.awt.Font("FreesiaUPC", 1, 24)); // NOI18N
        add_room.setText("เพิ่มห้อง");
        add_room.setBorderPainted(false);
        add_room.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        add_room.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        add_room.setMargin(new java.awt.Insets(15, 5, 5, 5));
        add_room.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_roomActionPerformed(evt);
            }
        });

        cancel_btn.setFont(new java.awt.Font("FreesiaUPC", 1, 24)); // NOI18N
        cancel_btn.setText("ยกเลิก");
        cancel_btn.setBorderPainted(false);
        cancel_btn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cancel_btn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        cancel_btn.setMargin(new java.awt.Insets(15, 5, 5, 5));
        cancel_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancel_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(close_hour, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(close_min, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(floor_tf, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(open_hour, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(open_min, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(room_name_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(capacity_spin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(building_tf, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(room_name_tf, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jSeparator1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(cancel_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(96, 96, 96)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(facility1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(facility, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(226, 226, 226))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(16, 16, 16)
                    .addComponent(add_room, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(823, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(facility, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(room_name_tf, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(room_name_label, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(capacity_spin, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(building_tf, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(floor_tf, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(open_hour, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(open_min, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(close_hour, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(close_min, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cancel_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(facility1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(471, Short.MAX_VALUE)
                    .addComponent(add_room, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );

        description.setFont(new java.awt.Font("FreesiaUPC", 0, 24)); // NOI18N
        description.setForeground(new java.awt.Color(255, 255, 255));
        description.setText("เพิ่มห้องเข้าสู่ระบบจองห้อง");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 760, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(description)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(description, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void open_hourStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_open_hourStateChanged
        if ((long)open_hour.getValue() >= (long)close_hour.getValue()){
            close_hour.setModel(new javax.swing.SpinnerNumberModel(
                    Long.valueOf((long) open_hour.getValue()),
                    Long.valueOf((long) open_hour.getValue()),
                    Long.valueOf(23L),
                    Long.valueOf(1L)));
        }
        else if ((long)open_hour.getValue() < (long)close_hour.getValue()){
            close_hour.setModel(new javax.swing.SpinnerNumberModel(
                    Long.valueOf((long) close_hour.getValue()),
                    Long.valueOf((long) open_hour.getValue()),
                    Long.valueOf(23L),
                    Long.valueOf(1L)));
        }
    }//GEN-LAST:event_open_hourStateChanged

    private void add_roomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_roomActionPerformed
        String roomName = room_name_tf.getText();
        String roomNamePlusBuilding = building_tf.getText()+"-"+room_name_tf.getText();
        int capacity = (int)capacity_spin.getValue();
        String building = building_tf.getText();
        String floor = floor_tf.getText();
        long openHour = (long)open_hour.getValue();
        long openMin = (long)open_min.getValue();
        long closeHour = (long)close_hour.getValue();
        long closeMin = (long)close_min.getValue();
        ArrayList<TimeRange> timeRange = new ArrayList<>();
        timeRange.add(new TimeRange((openHour + openMin/60.0), (closeHour + closeMin/60.0)));
        ArrayList<String> facilityList;
        boolean available = status.getSelectedItem() == "เปิด";
        if (facility_JList.getSelectedValuesList().isEmpty()){
            facilityList = new ArrayList<>();
        } else {
            facilityList = (ArrayList<String>) facility_JList.getSelectedValuesList();
        }
        if (!roomName.isEmpty() && capacity != 0 && !building.isEmpty() && !floor.isEmpty()){
            if (openHour == closeHour && openMin < closeMin || closeHour > openHour){
                try {
                    if (RoomDatabase.getRoomObject(roomName) == null){
                        RoomData roomData = new RoomData(roomNamePlusBuilding, building, floor, facilityList, timeRange, new ArrayList<>(), new HashMap<>(), capacity, available);
                        try {
                            RoomDatabase.addRoom(roomData);
                        } catch (DatabaseGetInterrupted e) {
                            JOptionPane.showMessageDialog(RoomRegister.this, "Add room error. Please try again later.");
                        }
                        JOptionPane.showMessageDialog(RoomRegister.this, "Add Room Successful!");
                        this.dispose();
                    } else {
                        JOptionPane.showMessageDialog(RoomRegister.this, "This room is already exist. Please Change the name/building of this room.");
                    }
                } catch (DatabaseGetInterrupted e) {
                    e.printStackTrace();
                }
            }else {
                JOptionPane.showMessageDialog(RoomRegister.this, "Please enter valid time.");
            }
        } else {
            JOptionPane.showMessageDialog(RoomRegister.this, "Please fill empty containers.");
        }
    }//GEN-LAST:event_add_roomActionPerformed

    private void cancel_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancel_btnActionPerformed
        this.dispose();
    }//GEN-LAST:event_cancel_btnActionPerformed
    
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
            java.util.logging.Logger.getLogger(RoomRegister.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RoomRegister.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RoomRegister.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RoomRegister.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RoomRegister().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add_room;
    private javax.swing.JTextField building_tf;
    private javax.swing.JButton cancel_btn;
    private javax.swing.JSpinner capacity_spin;
    private javax.swing.JSpinner close_hour;
    private javax.swing.JSpinner close_min;
    private javax.swing.JLabel description;
    private javax.swing.JLabel facility;
    private javax.swing.JLabel facility1;
    private javax.swing.JList<String> facility_JList;
    private javax.swing.JTextField floor_tf;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSpinner open_hour;
    private javax.swing.JSpinner open_min;
    private javax.swing.JLabel room_name_label;
    private javax.swing.JTextField room_name_tf;
    private javax.swing.JComboBox<String> status;
    // End of variables declaration//GEN-END:variables
}
