package org.example.view.dashboart.application.form.transaction_form;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import org.example.view.dashboart.application.form.transaction_form.ACTbl.TableActionCellEditor;
import org.example.view.dashboart.application.form.transaction_form.ACTbl.TableActionCellRender;
import org.example.view.dashboart.application.form.transaction_form.ACTbl.TableActionEvent;
import org.example.view.dashboart.managerFrame.TxtDate;


import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.text.DecimalFormat;
import java.util.Random;


public class FormTransaction extends javax.swing.JPanel {

    private TxtDate fieldTxtDate;

    public FormTransaction() {
        initComponents();
        init();
        applyTableStyle(tblTransaction);
        testData(tblTransaction);
                lbTitle.putClientProperty(FlatClientProperties.STYLE, ""
                + "font:$h1.font");
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
        return new Object[]{true, name, "$" + df.format(getAmount(9999, 9999999)), "$" + df.format(getAmount(9999, 9999999)), df.format(getAmount(-100, 100))};
    }
    
       private double getAmount(int from, int to) {
        Random ran = new Random();
        return (ran.nextInt(to - from) + from) * ran.nextDouble();
    }
       
     private void applyTableStyle(JTable table) {
         
         cmdRefresh.setIcon(new FlatSVGIcon("icon/svg/edit.svg", 0.35f));
         cmdExportTo.setIcon(new FlatSVGIcon("icon/svg/delete.svg",0.35f));
       
         
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
//                    if (header == false) {
//                        if (column == 4) {
//                            if (Double.parseDouble(value.toString()) > 0) {
//                                com.setForeground(new Color(17, 182, 60));
//                                label.setText("+" + value);
//                            } else {
//                                com.setForeground(new Color(202, 48, 48));
//                            }
//                        } else {
//                            if (isSelected) {
//                                com.setForeground(table.getSelectionForeground());
//                            } else {
//                                com.setForeground(table.getForeground());
//                            }
//                        }
//                    }
                }
                return com;
            }
        };
    }

    private void init() {

        //action row table
        TableActionEvent event = new TableActionEvent() {
            @Override
            public void onView(int row) {
                System.out.println("show" + row);
            }
        };
        tblTransaction.getColumnModel().getColumn(7).setCellRenderer(new TableActionCellRender());
        tblTransaction.getColumnModel().getColumn(7).setCellEditor(new TableActionCellEditor(event));

        // set up date picker

        fieldTxtDate = new TxtDate(txtDate);


    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        crazyPanel1 = new org.example.view.crazypanel.CrazyPanel();
        lbTitle = new JLabel();
        crazyPanel2 = new org.example.view.crazypanel.CrazyPanel();
        txtSearch = new javax.swing.JTextField();
        cmdRefresh = new javax.swing.JButton();
        txtDate = new javax.swing.JFormattedTextField();
        cmdExportTo = new javax.swing.JButton();
        jScrollPane1 = new JScrollPane();
        tblTransaction = new JTable();

        crazyPanel1.setMigLayoutConstraints(new org.example.view.crazypanel.MigLayoutConstraints(
            "wrap,fill,insets 15",
            "[fill]",
            "[grow 0][grow 0][fill][grow 0]",
            null
        ));

        lbTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lbTitle.setText("Thông tin nhập xuất");
        lbTitle.setHorizontalTextPosition(SwingConstants.CENTER);
        crazyPanel1.add(lbTitle);

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
                "width 200",
                "",
                ""
            }
        ));

        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });
        crazyPanel2.add(txtSearch);

        cmdRefresh.setText("Refresh");
        cmdRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdRefreshActionPerformed(evt);
            }
        });
        crazyPanel2.add(cmdRefresh);

        txtDate.setPreferredSize(new java.awt.Dimension(200, 22));
        crazyPanel2.add(txtDate);

        cmdExportTo.setText("Export to");
        cmdExportTo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdExportToActionPerformed(evt);
            }
        });
        crazyPanel2.add(cmdExportTo);

        crazyPanel1.add(crazyPanel2);

        tblTransaction.setModel(new DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "mã", "Ngày", "Số Lượng", "Đơn vị", "Tổng giá", "Khách hàng", "Loại GD", "AC"
            }
        ) {
            Class[] types = new Class [] {
                Integer.class, String.class, Integer.class, String.class, Integer.class, String.class, String.class, Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblTransaction.setRowHeight(40);
        tblTransaction.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                tblImportNoteAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        tblTransaction.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblImportNoteMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblTransaction);
        if (tblTransaction.getColumnModel().getColumnCount() > 0) {
            tblTransaction.getColumnModel().getColumn(0).setResizable(false);
            tblTransaction.getColumnModel().getColumn(0).setPreferredWidth(10);
            tblTransaction.getColumnModel().getColumn(1).setResizable(false);
            tblTransaction.getColumnModel().getColumn(2).setResizable(false);
            tblTransaction.getColumnModel().getColumn(3).setResizable(false);
            tblTransaction.getColumnModel().getColumn(4).setResizable(false);
            tblTransaction.getColumnModel().getColumn(5).setResizable(false);
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
            .addComponent(crazyPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 460, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cmdRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdRefreshActionPerformed
        
//
//        if(!showFrameUpdate) {
//            showFrameUpdate = true;
//            updateUserFrame = new UpdateUser();
//            updateUserFrame.setVisible(true);
//
//        } else {
//        updateUserFrame.dispose();
//        updateUserFrame = new UpdateUser();
//        updateUserFrame.setVisible(true);
//        }
    }//GEN-LAST:event_cmdRefreshActionPerformed

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchActionPerformed

    private void tblImportNoteAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_tblImportNoteAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_tblImportNoteAncestorAdded

    private void cmdExportToActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdExportToActionPerformed
        DefaultTableModel model = (DefaultTableModel) tblTransaction.getModel();
       
        if(tblTransaction.getSelectedRowCount()== 1) {
            model.removeRow(tblTransaction.getSelectedRow());
        } else {
            if(tblTransaction.getSelectedRow()== 0)
                System.out.print("hdhd");
        }
        
    }//GEN-LAST:event_cmdExportToActionPerformed

    private void tblImportNoteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblImportNoteMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblImportNoteMouseClicked

    private boolean showFrameAdd = false;
    private boolean showFrameUpdate = false;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cmdExportTo;
    private javax.swing.JButton cmdRefresh;
    private org.example.view.crazypanel.CrazyPanel crazyPanel1;
    private org.example.view.crazypanel.CrazyPanel crazyPanel2;
    private JScrollPane jScrollPane1;
    private JLabel lbTitle;
    private JTable tblTransaction;
    private javax.swing.JFormattedTextField txtDate;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
