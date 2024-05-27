package org.example.view.dashboart.application.form.other;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import jakarta.persistence.EntityManager;
import lombok.Getter;
import org.example.controller.userController.DeleteUserController;
import org.example.controller.SearchTableController;
import org.example.controller.userController.UserInfoController;
import org.example.model.entities.UserApp;
import org.example.view.dashboart.application.form.AddUser;
import org.example.view.dashboart.application.form.UpdateUserForm;

import raven.toast.Notifications;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.MouseEvent;


public class UserInfo extends javax.swing.JPanel {

    private UserInfoController userInfoController;

    private DeleteUserController deleteUserController;

    private final EntityManager em;

    @Getter
    private UserApp dataSelectTbl;


    public UserInfo(EntityManager em) {
        this.em = em;
        userInfoController = new UserInfoController(em);
        deleteUserController = new DeleteUserController(em);
        initComponents();
        applyTableStyle(jTable1);
        addDataTbl(jTable1);
    }

        public void addDataTbl(JTable table) {

            userInfoController.ShowDataTbl(table);
        }

    public void updataDataTbl() {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        int rowCount = model.getRowCount();
        for (int i = rowCount - 1; i >= 0; i--) {
            model.removeRow(i);
        }

        userInfoController.ShowDataTbl(jTable1);

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

        jTable1.setRowHeight(40);
        // add event jtable
        ///////////////////////////////////////////////////////////////////////////////////////////////////////
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });

        //////////////////////////////////////////////////////////////////////////////////////////////////////////
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
               // addDataTbl(jTable1);
            }
        });

        crazyPanel2.add(cmdAdd);

        cmdUpdate.setText("Update");
        cmdUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdUpdateActionPerformed(evt);
            }
        });

        cmdDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdDeleteActionPerformed(evt);
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
                 "UseName", "Email", "Số điện Thoại", "Tên", "role"
            }
        ) {
            Class[] types = new Class [] {
                    java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                    false, false, false, true, true
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

    private void jTable1MouseClicked(MouseEvent evt) {
//
//        jTable.getSelectionModel().addListSelectionListener(event -> {
//            if (!event.getValueIsAdjusting()) {
//                int viewRowIndex = jTable.getSelectedRow();
//                if (viewRowIndex != -1) {
//                    int modelRowIndex = jTable.convertRowIndexToModel(viewRowIndex);
//                    System.out.println("Selected row in model: " + modelRowIndex);
//                    // Perform your logic with the model row index here
//                }
//            }
//        });

        if(jTable1.getSelectedRowCount() > 1 || jTable1.getSelectedRowCount() < 1) {
            return;
        }
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

        System.out.print(jTable1.getSelectedRow());
// convert to index default table
            int viewRowIndex = jTable1.getSelectedRow();
            int modelRowIndex = jTable1.convertRowIndexToModel(viewRowIndex);

       String userName = model.getValueAt(modelRowIndex, 0).toString();
       String email = model.getValueAt(modelRowIndex, 1).toString();
       String phoneNumber = model.getValueAt(modelRowIndex, 2).toString();
       //String name = model.getValueAt(modelRowIndex, 3).toString();

       dataSelectTbl = new UserApp();
       dataSelectTbl.setUserName(userName);
       dataSelectTbl.setEmail(email);
       //dataSelectTbl.setName(name);
       dataSelectTbl.setPhoneNumber(phoneNumber);
       System.out.println(dataSelectTbl.toString());

    }

    private void cmdDeleteActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            deleteUserController.deleteUser(dataSelectTbl);
            updataDataTbl();
            Notifications.getInstance().show(Notifications.Type.SUCCESS, "Xoa Thanh cong");

        } catch (Exception e) {
            e.printStackTrace();
            Notifications.getInstance().show(Notifications.Type.ERROR, "Xoa khong thanh cong");
        }
    }

    private void cmdAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdAddActionPerformed

        if(!showFrameAdd) {
            showFrameAdd = true;
            addUserFrame = new AddUser(em, this);
            addUserFrame.setVisible(true);

        } else {
        addUserFrame.dispose();
        addUserFrame = new AddUser(em, this);
        addUserFrame.setVisible(true);
        }
    }//GEN-LAST:event_cmdAddActionPerformed

    private void cmdUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdUpdateActionPerformed
            if(!showFrameUpdate) {
                showFrameUpdate = true;
                updateUserFrame = new UpdateUserForm(em, this);
                updateUserFrame.setVisible(true);

            } else {
                updateUserFrame.dispose();
                updateUserFrame = new UpdateUserForm(em, this);
                updateUserFrame.setVisible(true);
            }

    }//GEN-LAST:event_cmdUpdateActionPerformed

    private SearchTableController searchTableController;
    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        searchTableController = new SearchTableController();
        searchTableController.searchTable(jTable1, txtSearch);

    }//GEN-LAST:event_txtSearchActionPerformed

    private boolean showFrameAdd = false;
    private boolean showFrameUpdate = false;
    private AddUser addUserFrame;
    private UpdateUserForm updateUserFrame;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cmdAdd;
    private javax.swing.JButton cmdDelete;
    private javax.swing.JButton cmdUpdate;
    private org.example.view.crazypanel.CrazyPanel crazyPanel1;
    private org.example.view.crazypanel.CrazyPanel crazyPanel2;
    private JScrollPane jScrollPane1;

    @Getter
    private JTable jTable1;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
