package UserInterface.old;


import java.awt.Color;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */

/**
 *
 * @author USER
 */
public class ForgotYourPasswordPanel extends javax.swing.JPanel {

    /**
     * Creates new form ForgotYourPasswordPanel
     */
    public ForgotYourPasswordPanel() {
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

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        studentIDFYPTF = new javax.swing.JTextField();
        emailFYPTF = new javax.swing.JTextField();
        resetPasswordB = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        contactL = new javax.swing.JLabel();

        jPanel2.setBackground(new java.awt.Color(9, 26, 88));
        jPanel2.setPreferredSize(new java.awt.Dimension(1335, 810));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Forgot Your Password");

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("We will send you an email to reset your password.");

        studentIDFYPTF.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        studentIDFYPTF.setForeground(new java.awt.Color(204, 204, 204));
        studentIDFYPTF.setText("Student ID");
        studentIDFYPTF.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                studentIDFYPTFFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                studentIDFYPTFFocusLost(evt);
            }
        });
        studentIDFYPTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentIDFYPTFActionPerformed(evt);
            }
        });

        emailFYPTF.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        emailFYPTF.setForeground(new java.awt.Color(204, 204, 204));
        emailFYPTF.setText("Email");
        emailFYPTF.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                emailFYPTFFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                emailFYPTFFocusLost(evt);
            }
        });
        emailFYPTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailFYPTFActionPerformed(evt);
            }
        });

        resetPasswordB.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        resetPasswordB.setForeground(new java.awt.Color(9, 26, 88));
        resetPasswordB.setText("Reset password");
        resetPasswordB.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        resetPasswordB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetPasswordBActionPerformed(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(9, 26, 88));
        jPanel4.setPreferredSize(new java.awt.Dimension(1335, 20));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Problem?");

        contactL.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        contactL.setForeground(new java.awt.Color(255, 255, 255));
        contactL.setText("Contact the developer");
        contactL.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 255, 255)));
        contactL.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        contactL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                contactLMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(contactL)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(contactL)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 3, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1335, Short.MAX_VALUE)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(resetPasswordB)
                        .addGap(584, 584, 584))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(studentIDFYPTF, javax.swing.GroupLayout.PREFERRED_SIZE, 496, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(emailFYPTF, javax.swing.GroupLayout.PREFERRED_SIZE, 496, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(414, 414, 414))))
            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(231, 231, 231)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(emailFYPTF, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(studentIDFYPTF, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(resetPasswordB, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 238, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void studentIDFYPTFFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_studentIDFYPTFFocusGained
        // TODO add your handling code here:
        if (studentIDFYPTF.getText().equals("Student ID")) {
            studentIDFYPTF.setText("");
            studentIDFYPTF.setForeground(new Color(0, 0, 0));
        }
    }//GEN-LAST:event_studentIDFYPTFFocusGained

    private void studentIDFYPTFFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_studentIDFYPTFFocusLost
        // TODO add your handling code here:
        if (studentIDFYPTF.getText().equals("")) {
            studentIDFYPTF.setText("Student ID");
            studentIDFYPTF.setForeground(new Color(204, 204, 204));
        }
    }//GEN-LAST:event_studentIDFYPTFFocusLost

    private void studentIDFYPTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentIDFYPTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_studentIDFYPTFActionPerformed

    private void emailFYPTFFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_emailFYPTFFocusGained
        // TODO add your handling code here:
        if (emailFYPTF.getText().equals("Email")) {
            emailFYPTF.setText("");
            emailFYPTF.setForeground(new Color(0, 0, 0));
        }
    }//GEN-LAST:event_emailFYPTFFocusGained

    private void emailFYPTFFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_emailFYPTFFocusLost
        // TODO add your handling code here:

        if (emailFYPTF.getText().equals("")) {
            emailFYPTF.setText("Email");
            emailFYPTF.setForeground(new Color(204, 204, 204));
        }
    }//GEN-LAST:event_emailFYPTFFocusLost

    private void emailFYPTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailFYPTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailFYPTFActionPerformed

    private void resetPasswordBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetPasswordBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_resetPasswordBActionPerformed

    private void contactLMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_contactLMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_contactLMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel contactL;
    private javax.swing.JTextField emailFYPTF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JButton resetPasswordB;
    private javax.swing.JTextField studentIDFYPTF;
    // End of variables declaration//GEN-END:variables

    private void setContentPane(LoginPanel loginPanel) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
