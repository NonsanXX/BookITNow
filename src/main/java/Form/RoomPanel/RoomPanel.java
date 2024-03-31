/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Form.RoomPanel;
import Database.Dataclass.RoomData;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author Nonsan
 */
public class RoomPanel extends javax.swing.JPanel {
    String realroomname;

    /**
     * Creates new form RoomPanel
     */
    public RoomPanel(RoomData roomdata) {
        initComponents();
        this.realroomname = roomdata.getRoomName();
        room_name.setText("ห้อง : "+roomdata.getRoomName());
        building.setText("อาคาร : "+roomdata.getBuilding());
        floor.setText("ชั้น : "+roomdata.getFloor());
    }

    public String getRoomName() {
        return room_name.getText();
    }
    public String getRealroomname(){return realroomname;}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        room_name = new javax.swing.JLabel();
        building = new javax.swing.JLabel();
        floor = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        setPreferredSize(new java.awt.Dimension(300, 250));

        room_name.setFont(new java.awt.Font("FreesiaUPC", 0, 24)); // NOI18N
        room_name.setText("ห้อง : ");

        building.setFont(new java.awt.Font("FreesiaUPC", 0, 24)); // NOI18N
        building.setText("อาคาร : ");

        floor.setFont(new java.awt.Font("FreesiaUPC", 0, 24)); // NOI18N
        floor.setText("ชั้น : ");

        jLabel1.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/room_icon.png")).getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(building, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(floor, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(room_name, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(room_name, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(building, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(floor, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel building;
    private javax.swing.JLabel floor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel room_name;
    // End of variables declaration//GEN-END:variables
}
