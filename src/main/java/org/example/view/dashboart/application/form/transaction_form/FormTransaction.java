package org.example.view.dashboart.application.form.transaction_form;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import jakarta.persistence.EntityManager;
import org.example.controller.TransactionController;

import org.example.view.dashboart.managerFrame.TxtDate;
import raven.datetime.component.date.DateEvent;
import raven.datetime.component.date.DatePicker;
import raven.datetime.component.date.DateSelectionAble;
import raven.datetime.component.date.DateSelectionListener;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;


public class FormTransaction extends javax.swing.JPanel {

    private final EntityManager em;
    private TransactionController transactionController;
    public FormTransaction(EntityManager em) {
        this.em = em;
        initComponents();
        init();
        transactionController = new TransactionController(em);
        applyTableStyle(tblTransaction);
        addDataTbl(tblTransaction);
                lbTitle.putClientProperty(FlatClientProperties.STYLE, ""
                + "font:$h1.font");
    }

    private void init() {
        //new TxtDate(txtDate).betweenDateSelected();
        DatePicker datePicker = new DatePicker();
        datePicker.setDateSelectionMode(DatePicker.DateSelectionMode.BETWEEN_DATE_SELECTED);
        datePicker.setSeparator(" dến ");
        datePicker.setUsePanelOption(true);
        datePicker.setDateSelectionAble(new DateSelectionAble() {
            @Override
            public boolean isDateSelectedAble(LocalDate localDate) {
                return !localDate.isAfter(LocalDate.now());
            }
        });

        datePicker.addDateSelectionListener(new DateSelectionListener() {
            @Override
            public void dateSelected(DateEvent dateEvent) {
                LocalDate dates[] = datePicker.getSelectedDateRange();
                DateTimeFormatter df = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                if(dates != null){
                    Date dateStart = Date.from(dates[0].atStartOfDay(ZoneId.systemDefault()).toInstant());
                    Date dateEnd = Date.from(dates[1].atStartOfDay(ZoneId.systemDefault()).toInstant());

                    updateDataTbl(dateStart , dateEnd);
                    //System.out.println(df.format(dates[0]) + " " + df.format(dates[1]));
                }
            }
        });
        datePicker.setEditor(txtDate);
    }

    private void addDataTbl(JTable table) {
        transactionController.showDataTblTransaction(table);
    }

    private void updateDataTbl(Date startDate, Date endDate) {
        DefaultTableModel model = (DefaultTableModel) tblTransaction.getModel();
        int rowCount = model.getRowCount();
        for (int i = rowCount - 1; i >= 0; i--) {
            model.removeRow(i);
        }
        transactionController.showDataBetweenData(tblTransaction,startDate, endDate );
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
                    }else if(column == 1){
                        label.setHorizontalAlignment(SwingConstants.RIGHT);
                    }
                    else if (column == 2 || column == 3) {
                        label.setHorizontalAlignment(SwingConstants.TRAILING);
                    } else {
                        label.setHorizontalAlignment(SwingConstants.LEADING);
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
                "mã", "Ngày",  "Tổng giá", "Người thực hiện", "Loại GD"
            }
        ) {
            Class[] types = new Class [] {
                Integer.class, String.class,   Long.class, String.class, String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false,  false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblTransaction.setRowHeight(40);

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
        DefaultTableModel model = (DefaultTableModel) tblTransaction.getModel();
        int rowCount = model.getRowCount();
        for (int i = rowCount - 1; i >= 0; i--) {
            model.removeRow(i);
        }
        addDataTbl(tblTransaction);

    }//GEN-LAST:event_cmdRefreshActionPerformed

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchActionPerformed

    private void cmdExportToActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdExportToActionPerformed

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
