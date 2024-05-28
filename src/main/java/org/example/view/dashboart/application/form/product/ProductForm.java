package org.example.view.dashboart.application.form.product;


import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import jakarta.persistence.EntityManager;
import lombok.Getter;
import org.example.controller.SearchTableController;
import org.example.controller.productController.ProductController;
import org.example.controller.userController.LoginController;
import org.example.model.entities.Product;
import org.example.model.entities.enums.UnitItem;
import org.example.view.dashboart.application.form.import_form.FrameNewProduct;
import raven.toast.Notifications;

import java.awt.Component;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;



public class ProductForm extends javax.swing.JPanel {

    private final EntityManager em;

    @Getter
    private Product dataSelectTbl;

    private ProductController productController;

    private SearchTableController searchTableController;

    private boolean showFramNewProduct = false;

    private FrameUpdateProduct frameUpdateProduct;

    private FrameNewProduct frameNewProduct;

    public ProductForm(EntityManager em) {
        this.em = em;
        initComponents();
        init();
        applyTableStyle(tblProduct);
       // testData(tblProduct);
        lbTitle.putClientProperty(FlatClientProperties.STYLE, ""
                + "font:$h1.font");
        addDataTbl(tblProduct);
    }

    private void init() {
        productController = new ProductController(em);
    }

    private void addDataTbl(JTable table) {
        productController.showDataProductTbl(table);
    }

    public void updataDataTbl() {
        DefaultTableModel model = (DefaultTableModel) tblProduct.getModel();
        int rowCount = model.getRowCount();
        for (int i = rowCount - 1; i >= 0; i--) {
            model.removeRow(i);
        }

        productController.showDataProductTbl(tblProduct);

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

                }
                return com;
            }
        };
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        crazyPanel1 = new org.example.view.crazypanel.CrazyPanel();
        lbTitle = new javax.swing.JLabel();
        crazyPanel2 = new org.example.view.crazypanel.CrazyPanel();
        txtSearch = new javax.swing.JTextField();
        cmdAdd = new javax.swing.JButton();
        cmdUpdate = new javax.swing.JButton();
        cmdDelete = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProduct = new javax.swing.JTable();
        crazyPanel3 = new org.example.view.crazypanel.CrazyPanel();
        jButton1 = new javax.swing.JButton();


        tblProduct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        crazyPanel1.setMigLayoutConstraints(new org.example.view.crazypanel.MigLayoutConstraints(
                "wrap,fill,insets 15",
                "[fill]",
                "[grow 0][grow 0][fill][grow 0]",
                null
        ));

        lbTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTitle.setText("THÔNG TIN SẢN PHẨM");
        lbTitle.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
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
        cmdDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdDeleteActionPerformed(evt);
            }
        });
        crazyPanel2.add(cmdDelete);

        crazyPanel1.add(crazyPanel2);

        tblProduct.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                        "mã", "Tên ", "Số Lượng", "Đơn vị", "Giá bán", "Nhà cung cấp", " Mô tả "
                }
        ) {
            Class[] types = new Class [] {
                    java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                    false, false, false, false, false, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblProduct.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                tblProductAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        tblProduct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProductMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblProduct);
        if (tblProduct.getColumnModel().getColumnCount() > 0) {
            tblProduct.getColumnModel().getColumn(0).setResizable(false);
            tblProduct.getColumnModel().getColumn(0).setPreferredWidth(10);
            tblProduct.getColumnModel().getColumn(1).setResizable(false);
            tblProduct.getColumnModel().getColumn(2).setResizable(false);
            tblProduct.getColumnModel().getColumn(3).setResizable(false);
            tblProduct.getColumnModel().getColumn(4).setResizable(false);
            tblProduct.getColumnModel().getColumn(5).setResizable(false);
            tblProduct.getColumnModel().getColumn(6).setResizable(false);
        }

        crazyPanel1.add(jScrollPane1);

        crazyPanel3.setMigLayoutConstraints(new org.example.view.crazypanel.MigLayoutConstraints(
                "",
                "push[]",
                "",
                null
        ));

        jButton1.setText("Export");
        crazyPanel3.add(jButton1);

        crazyPanel1.add(crazyPanel3);

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
    }// </editor-fold>

    private void cmdAddActionPerformed(java.awt.event.ActionEvent evt) {

        if(!showFramNewProduct) {
            showFramNewProduct = true;
            frameNewProduct = new FrameNewProduct(em, this);
            frameNewProduct.setVisible(true);

        } else {
            frameNewProduct.dispose();
            frameNewProduct = new FrameNewProduct(em, this);
            frameNewProduct.setVisible(true);
        }
    }

    private void cmdUpdateActionPerformed(java.awt.event.ActionEvent evt) {

        if(!showFrameUpdate) {
            showFrameUpdate = true;
            frameUpdateProduct = new FrameUpdateProduct(em , this);
            frameUpdateProduct.setVisible(true);

        } else {
            frameUpdateProduct.dispose();
            frameUpdateProduct = new FrameUpdateProduct(em , this);
            frameUpdateProduct.setVisible(true);
        }
    }

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {
        searchTableController = new SearchTableController();
        searchTableController.searchTable(tblProduct, txtSearch);
    }

    private void tblProductAncestorAdded(javax.swing.event.AncestorEvent evt) {
        // TODO add your handling code here:
    }

    private void jTable1MouseClicked(MouseEvent evt) {
        if(tblProduct.getSelectedRowCount() > 1 || tblProduct.getSelectedRowCount() < 1) {
            return;
        }
        DefaultTableModel model = (DefaultTableModel) tblProduct.getModel();

        System.out.print(tblProduct.getSelectedRow());
// convert to index default table
        int viewRowIndex = tblProduct.getSelectedRow();
        int modelRowIndex = tblProduct.convertRowIndexToModel(viewRowIndex);

        Integer idProduct = Integer.parseInt(model.getValueAt(modelRowIndex, 0).toString());
        String nameProduct = model.getValueAt(modelRowIndex, 1).toString();
        Long quantityProduct = (long) Integer.parseInt(model.getValueAt(modelRowIndex, 2).toString());
        String unit = model.getValueAt(modelRowIndex, 3).toString();
        long price = Long.parseLong(model.getValueAt(modelRowIndex, 4).toString());
        String mota = model.getValueAt(modelRowIndex, 6).toString();
        //String name = model.getValueAt(modelRowIndex, 3).toString();

        dataSelectTbl = new Product();
        dataSelectTbl.setIdProduct(idProduct);
        dataSelectTbl.setNameProduct(nameProduct);
        dataSelectTbl.setPrice(price);
        dataSelectTbl.setQuantityProduct(quantityProduct);
        dataSelectTbl.setMota(mota);

        if(unit == null) {
            dataSelectTbl.setUnitProduct(null);
        } else if(unit == "l") {
            dataSelectTbl.setUnitProduct(UnitItem.l);
        } else if(unit == "m") {
            dataSelectTbl.setUnitProduct(UnitItem.m);
        } else if(unit == "kg") {
            dataSelectTbl.setUnitProduct(UnitItem.kg);
        }
        System.out.println(dataSelectTbl.toString());
    }
    private void cmdDeleteActionPerformed(java.awt.event.ActionEvent evt) {
        if(dataSelectTbl == null) {
            Notifications.getInstance().show(Notifications.Type.WARNING, "chọn vật phẩm");
            return;
        }
        boolean checkStatus = productController.deleteProduct(dataSelectTbl);
        if(checkStatus) {
            updataDataTbl();
            Notifications.getInstance().show(Notifications.Type.SUCCESS , "Vật phẩm xoá thành công");
        } else {
            Notifications.getInstance().show(Notifications.Type.ERROR, "Vật phẩm xóa thất bại");
        }

    }

    private void tblProductMouseClicked(java.awt.event.MouseEvent evt) {

    }

    private boolean showFrameAdd = false;
    private boolean showFrameUpdate = false;
//    private AddUser addUserFrame;
//    private UpdateUser updateUserFrame;
    // Variables declaration - do not modify
    private javax.swing.JButton cmdAdd;
    private javax.swing.JButton cmdDelete;
    private javax.swing.JButton cmdUpdate;
    private org.example.view.crazypanel.CrazyPanel crazyPanel1;
    private org.example.view.crazypanel.CrazyPanel crazyPanel2;
    private org.example.view.crazypanel.CrazyPanel crazyPanel3;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbTitle;
    private javax.swing.JTable tblProduct;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration
}
