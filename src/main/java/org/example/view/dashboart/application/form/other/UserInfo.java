package org.example.view.dashboart.application.form.other;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import org.example.view.dashboart.application.form.AddUser;
import org.example.view.dashboart.application.form.UpdateUser;


import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.text.DecimalFormat;
import java.util.Random;


public class UserInfo extends javax.swing.JPanel {

    public UserInfo() {
        initComponents();
        applyTableStyle(jTable1);
        testData(jTable1);
    }

        private void testData(JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.addRow(getRandomRow("Beer"));
        model.addRow(getRandomRow("Shirt"));
        model.addRow(getRandomRow("Laptop"));
        model.addRow(getRandomRow("Book"));
        model.addRow(getRandomRow("Coffee"));
        model.addRow(getRandomRow("Phone"));
        model.addRow(getRandomRow("Chair"));
        model.addRow(getRandomRow("Watch"));
        model.addRow(getRandomRow("Sunglasses"));
        model.addRow(getRandomRow("Bag"));
        model.addRow(getRandomRow("Headphones"));
        model.addRow(getRandomRow("Camera"));
        model.addRow(getRandomRow("Necklace"));
        model.addRow(getRandomRow("Perfume"));
        model.addRow(getRandomRow("Wallet"));
        model.addRow(getRandomRow("Jacket"));
        model.addRow(getRandomRow("Bicycle"));
        model.addRow(getRandomRow("Game console"));
        model.addRow(getRandomRow("Tennis racket"));
                model.addRow(getRandomRow("Beer"));
        model.addRow(getRandomRow("Shirt"));
        model.addRow(getRandomRow("Laptop"));
        model.addRow(getRandomRow("Book"));
        model.addRow(getRandomRow("Coffee"));
        model.addRow(getRandomRow("Phone"));
        model.addRow(getRandomRow("Chair"));
        model.addRow(getRandomRow("Watch"));
        model.addRow(getRandomRow("Sunglasses"));
        model.addRow(getRandomRow("Bag"));
        model.addRow(getRandomRow("Headphones"));
        model.addRow(getRandomRow("Camera"));
        model.addRow(getRandomRow("Necklace"));
        model.addRow(getRandomRow("Perfume"));
        model.addRow(getRandomRow("Wallet"));
        model.addRow(getRandomRow("Jacket"));
        model.addRow(getRandomRow("Bicycle"));
        model.addRow(getRandomRow("Game console"));
        model.addRow(getRandomRow("Tennis racket"));
    }
        
    private Object[] getRandomRow(String name) {
        DecimalFormat df = new DecimalFormat("#,##0.##");
        return new Object[]{false, name, "$" + df.format(getAmount(9999, 9999999)), "$" + df.format(getAmount(9999, 9999999)), df.format(getAmount(-100, 100))};
    }
    
       private double getAmount(int from, int to) {
        Random ran = new Random();
        return (ran.nextInt(to - from) + from) * ran.nextDouble();
    }
       
     private void applyTableStyle(JTable table) {
         cmdAdd.setIcon(new FlatSVGIcon("icon/svg/add.svg", 0.35f));
         cmdUpdate.setIcon(new FlatSVGIcon("icon/svg/edit.svg", 0.35f));
         cmdDelete.setIcon(new FlatSVGIcon("icon/svg/delete.svg",0.35f));
          txtSearch.putClientProperty(FlatClientProperties.TEXT_FIELD_TRAILING_ICON, new FlatSVGIcon("icon/svg/search.svg", 0.35f));
         //scron
          JScrollPane scroll = (JScrollPane) table.getParent().getParent();
        scroll.setBorder(BorderFactory.createEmptyBorder());
                scroll.getVerticalScrollBar().putClientProperty(FlatClientProperties.STYLE, ""
                + "background:$Table.background;"
                + "track:$Table.background;"
                + "trackArc:999");
        
         table.getTableHeader().putClientProperty(FlatClientProperties.STYLE_CLASS, "table_style");
         table.putClientProperty(FlatClientProperties.STYLE_CLASS, "table_stype");
         
         //can column for table
          table.getTableHeader().setDefaultRenderer(getAlignmentCellRender(table.getTableHeader().getDefaultRenderer(), true));
        table.setDefaultRenderer(Object.class, getAlignmentCellRender(table.getDefaultRenderer(Object.class), false));
     }
    
       private TableCellRenderer getAlignmentCellRender(TableCellRenderer oldRender, boolean header) {
        return new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component com = oldRender.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                if (com instanceof JLabel) {
                    JLabel label = (JLabel) com;
                    if (column == 0 || column == 4) {
                        label.setHorizontalAlignment(SwingConstants.CENTER);
                    } else if (column == 2 || column == 3) {
                        label.setHorizontalAlignment(SwingConstants.TRAILING);
                    } else {
                        label.setHorizontalAlignment(SwingConstants.LEADING);
                    }
                    // 
                    if (header == false) {
                        if (column == 4) {
                            if (Double.parseDouble(value.toString()) > 0) {
                                com.setForeground(new Color(17, 182, 60));
                                label.setText("+" + value);
                            } else {
                                com.setForeground(new Color(202, 48, 48));
                            }
                        } else {
                            if (isSelected) {
                                com.setForeground(table.getSelectionForeground());
                            } else {
                                com.setForeground(table.getForeground());
                            }
                        }
                    }
                }
                return com;
            }
        };
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        crazyPanel1 = new org.example.view.crazypanel.CrazyPanel();
        crazyPanel2 = new org.example.view.crazypanel.CrazyPanel();
        txtSearch = new javax.swing.JTextField();
        cmdAdd = new javax.swing.JButton();
        cmdUpdate = new javax.swing.JButton();
        cmdDelete = new javax.swing.JButton();
        jScrollPane1 = new JScrollPane();
        jTable1 = new JTable();

        crazyPanel1.setMigLayoutConstraints(new org.example.view.crazypanel.MigLayoutConstraints(
            "wrap,fill,insets 15",
            "[fill]",
            "[grow 0][fill]",
            null
        ));

        crazyPanel2.setFlatLafStyleComponent(new org.example.view.crazypanel.FlatLafStyleComponent(
            "",
            new String[]{
                "JTextField.placeholderText=Search;background=@background"
            }
        ));
        crazyPanel2.setMigLayoutConstraints(new org.example.view.crazypanel.MigLayoutConstraints(
            "",
            "[]push[][]",
            "",
            new String[]{
                "width 200"
            }
        ));

        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });
        crazyPanel2.add(txtSearch);

        cmdAdd.setText("Add");
        cmdAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdAddActionPerformed(evt);
            }
        });
        crazyPanel2.add(cmdAdd);

        cmdUpdate.setText("Update");
        cmdUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdUpdateActionPerformed(evt);
            }
        });
        crazyPanel2.add(cmdUpdate);

        cmdDelete.setText("Delete");
        crazyPanel2.add(cmdDelete);

        crazyPanel1.add(crazyPanel2);

        jTable1.setModel(new DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "UseName", "Email", "Số điện Thoại", "Tên", "role"
            }
        ) {
            Class[] types = new Class [] {
                Boolean.class, String.class, String.class, String.class, String.class, String.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(20);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
        }

        crazyPanel1.add(jScrollPane1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(crazyPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 806, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(crazyPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 454, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cmdAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdAddActionPerformed
        
        if(!showFrameAdd) {
            showFrameAdd = true;
            addUserFrame = new AddUser();
            addUserFrame.setVisible(true);
            
        } else {
        addUserFrame.dispose();
        addUserFrame = new AddUser();
        addUserFrame.setVisible(true);
        }
    }//GEN-LAST:event_cmdAddActionPerformed

    private void cmdUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdUpdateActionPerformed
        
        
        if(!showFrameUpdate) {
            showFrameUpdate = true;
            updateUserFrame = new UpdateUser();
            updateUserFrame.setVisible(true);
           
        } else {
        updateUserFrame.dispose();
        updateUserFrame = new UpdateUser();
        updateUserFrame.setVisible(true);
        }
    }//GEN-LAST:event_cmdUpdateActionPerformed

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchActionPerformed

    private boolean showFrameAdd = false;
    private boolean showFrameUpdate = false;
    private AddUser addUserFrame;
    private UpdateUser updateUserFrame;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cmdAdd;
    private javax.swing.JButton cmdDelete;
    private javax.swing.JButton cmdUpdate;
    private org.example.view.crazypanel.CrazyPanel crazyPanel1;
    private org.example.view.crazypanel.CrazyPanel crazyPanel2;
    private JScrollPane jScrollPane1;
    private JTable jTable1;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
