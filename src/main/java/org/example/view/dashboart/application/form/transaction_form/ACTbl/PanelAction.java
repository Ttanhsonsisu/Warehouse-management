
package org.example.view.dashboart.application.form.transaction_form.ACTbl;


public class PanelAction extends javax.swing.JPanel {


    public PanelAction() {
        initComponents();

    }

    public void initEvent(TableActionEvent event, int row) {
        cmdShow.addActionListener((e) -> {
            event.onView(row);
        });
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cmdShow = new org.example.view.dashboart.application.form.transaction_form.ACTbl.ActionButton();

        cmdShow.setIcon(new javax.swing.ImageIcon("src/main/resources/icon/png/view.png")); // NOI18N
        cmdShow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdShowActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(cmdShow, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cmdShow, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cmdShowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdShowActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmdShowActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.example.view.dashboart.application.form.transaction_form.ACTbl.ActionButton cmdShow;
    // End of variables declaration//GEN-END:variables
}
