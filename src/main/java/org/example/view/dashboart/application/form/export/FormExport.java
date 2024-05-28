package org.example.view.dashboart.application.form.export;


import com.formdev.flatlaf.FlatClientProperties;
import jakarta.persistence.EntityManager;
import lombok.Getter;
import org.example.controller.SearchTableController;
import org.example.model.entities.ExportNote;
import org.example.model.entities.ImportNote;
import org.example.model.entities.Product;
import org.example.model.entities.UserApp;
import org.example.model.entities.enums.UnitItem;
import org.example.service.ServiceExportNote;
import org.example.service.ServiceProduct;
import org.example.service.ServiceUserApp;
import org.example.view.dashboart.application.Application;
import org.example.view.dashboart.application.form.login.util.UserSession;
import raven.toast.Notifications;


import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class FormExport extends javax.swing.JPanel {

    private Application app;

    private FrameChoseProduct frameChoseProduct;

    private boolean showFrameChose = false;

    private final EntityManager em;

    private boolean loadDataTbl = false;

    @Getter
    private ArrayList<Long> price;

    private ExportNote dataInsertExportNote;

    private ServiceUserApp serviceUserApp;

    private ServiceProduct serviceProduct;

    private ServiceExportNote serviceExportNote;

    @Getter
    private Product dataSelectTbl;


    public FormExport(EntityManager em) {
        this.em = em;
        price = new ArrayList<>();

        initComponents();
        init();
        lb.putClientProperty(FlatClientProperties.STYLE, ""
                + "font:$h1.font");
    }

    public void addDataTbl(List<Product> dataAdd) {

        DefaultTableModel model = (DefaultTableModel) this.tbl.getModel();

        loadDataTbl = true;

        if(dataAdd == null) {
            model.addRow(new Object[]{});
        } else {
            for (Product product : dataAdd) {
                model.addRow(new Object[]{
                        product.getIdProduct(),
                        product.getNameProduct(),
                        product.getUnitProduct(),
                        product.getPrice(),
                        0,
                        0
                });
            }
        }

        loadDataTbl = false;
    }

    private void init() {

        serviceUserApp = new ServiceUserApp(em);

        serviceProduct = new ServiceProduct(em);

        serviceExportNote = new ServiceExportNote(em);

        DefaultTableModel model = (DefaultTableModel) tbl.getModel();

        model.addTableModelListener(new TableModelListener() {

            @Override
            public void tableChanged(TableModelEvent e) {
                if(!loadDataTbl) {

                    int row = e.getFirstRow();
                    int column = e.getColumn();

                    if(row >=0 && row < price.size() ) {
                        price.remove(row);
                    }

                    price.add(row, 0l);

                    if(column == 4) {
                        long soLuong = (long) model.getValueAt(row, column);
                        long giaNhap = (long) model.getValueAt(row, 3);
                        long result = soLuong * giaNhap;
                        System.out.println(result + " " + row + " " + price.size());
                        price.set(row, result);

                        long totalPrice = 0l;

                        for (long i : price) {
                            totalPrice += i;
                        }
                        txtTotalPrice.setText(String.valueOf(totalPrice));
                    }
                }
            }
        });
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        crazyPanel1 = new org.example.view.crazypanel.CrazyPanel();
        crazyPanel2 = new org.example.view.crazypanel.CrazyPanel();
        lb = new javax.swing.JLabel();
        crazyPanel3 = new org.example.view.crazypanel.CrazyPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtIdUser = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtNameUser = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtTotalPrice = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtDate = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtNote = new javax.swing.JTextArea();
        jSeparator1 = new javax.swing.JSeparator();
        cmdSave = new javax.swing.JButton();
        cmdExportTo = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        crazyPanel4 = new org.example.view.crazypanel.CrazyPanel();
        crazyPanel5 = new org.example.view.crazypanel.CrazyPanel();
        txtSearch = new javax.swing.JTextField();
        cmdAddProduct = new javax.swing.JButton();
        //cmdDel = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl = new javax.swing.JTable();

// set content text
        txtIdUser.setText(UserSession.getIdUser().toString());
        txtNameUser.setText(UserSession.getName());
        txtDate.setValue(LocalDate.now());
        ////////////////////
        txtDate.setEnabled(false);
        txtIdUser.setEditable(false);
        txtNameUser.setEditable(false);

        crazyPanel1.setMigLayoutConstraints(new org.example.view.crazypanel.MigLayoutConstraints(
                "wrap,fill,insets 15",
                "[fill][fill]",
                "[grow 0]40[fill]",
                new String[]{
                        "span 2",
                        ""
                }
        ));

        crazyPanel2.setMigLayoutConstraints(new org.example.view.crazypanel.MigLayoutConstraints(
                "fill,insets",
                "[fill]",
                "",
                null
        ));

        lb.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb.setText("Tạo phiếu xuất kho");
        crazyPanel2.add(lb);

        crazyPanel1.add(crazyPanel2);

        crazyPanel3.setFlatLafStyleComponent(new org.example.view.crazypanel.FlatLafStyleComponent(
                "",
                new String[]{
                        "font:bold +1"
                }
        ));
        crazyPanel3.setMigLayoutConstraints(new org.example.view.crazypanel.MigLayoutConstraints(
                "wrap 2,fillx,insets 40 15 15 15 15",
                "[grow 0,trail]15[fill]",
                "",
                new String[]{
                        "wrap,al lead",
                        "",
                        "",
                        "",
                        "",
                        "",
                        "",
                        "",
                        "",
                        "",
                        "",
                        "span 2,grow 1",
                        "span 2,al trail",
                        "span 2,al trail",
                        "span 2,al trail"
                }
        ));

        jLabel7.setText("Thông tin khách hàng");
        crazyPanel3.add(jLabel7);

        jLabel2.setText("Mã");
        crazyPanel3.add(jLabel2);
        crazyPanel3.add(txtIdUser);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Tên");
        crazyPanel3.add(jLabel3);

        txtNameUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameUserActionPerformed(evt);
            }
        });
        crazyPanel3.add(txtNameUser);

        jLabel4.setText("Thành tiền");
        crazyPanel3.add(jLabel4);
        crazyPanel3.add(txtTotalPrice);

        jLabel5.setText("Ngày tạo");
        crazyPanel3.add(jLabel5);
        crazyPanel3.add(txtDate);

        jLabel6.setText("Ghi chú");
        crazyPanel3.add(jLabel6);

        txtNote.setColumns(20);
        txtNote.setRows(5);
        jScrollPane2.setViewportView(txtNote);

        crazyPanel3.add(jScrollPane2);
        crazyPanel3.add(jSeparator1);

        cmdSave.setText("save");
        cmdSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    cmdSaveActionPerformed(evt);
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        cmdAddProduct.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                cmdAddProductActionPerformed(evt);
            }
        });
        crazyPanel3.add(cmdSave);

        cmdExportTo.setText("xuất hóa đơn");
        crazyPanel3.add(cmdExportTo);
        crazyPanel3.add(jSeparator2);

        crazyPanel1.add(crazyPanel3);

        crazyPanel4.setMigLayoutConstraints(new org.example.view.crazypanel.MigLayoutConstraints(
                "wrap,fill,insets 15",
                "[fill]",
                "[grow 0]15[fill]",
                null
        ));

        crazyPanel5.setFlatLafStyleComponent(new org.example.view.crazypanel.FlatLafStyleComponent(
                "",
                new String[]{
                        "JTextField.placeholderText=Search;background=@background",
                        "JTextField.placeholderText=Search;background=@background"
                }
        ));
        crazyPanel5.setMigLayoutConstraints(new org.example.view.crazypanel.MigLayoutConstraints(
                "",
                "[]push[][]",
                "",
                new String[]{
                        "width 200",
                        ""
                }
        ));
        txtSearch.addActionListener(e->{
            SearchTableController searchTableController = new SearchTableController();
            searchTableController.searchTable(tbl, txtSearch);
        });
        crazyPanel5.add(txtSearch);

        cmdAddProduct.setText("Thêm SP");
        crazyPanel5.add(cmdAddProduct);

//        cmdDel.setText("Xóa");
//
//        cmdDel.addActionListener(new java.awt.event.ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                cmdDelAcctionPerformed(e);
//            }
//        });
//        crazyPanel5.add(cmdDel);


        crazyPanel4.add(crazyPanel5);

        tbl.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                        "Mã", "Tên", "Đơn vị", "Giá/1","số lượng"
                }
        ) {
            Class[] types = new Class [] {
                    java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Long.class,java.lang.Long.class
            };
            boolean[] canEdit = new boolean [] {
                    false, false, false,false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });

        tbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl);

        crazyPanel4.add(jScrollPane1);

        crazyPanel1.add(crazyPanel4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(crazyPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 806, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(crazyPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 460, Short.MAX_VALUE)
        );

    }// </editor-fold>

    private void jTable1MouseClicked(MouseEvent evt) {
        if(tbl.getSelectedRowCount() > 1 || tbl.getSelectedRowCount() < 1) {
            return;
        }
        DefaultTableModel model = (DefaultTableModel) tbl.getModel();

        System.out.print(tbl.getSelectedRow());
// convert to index default table
        int viewRowIndex = tbl.getSelectedRow();
        int modelRowIndex = tbl.convertRowIndexToModel(viewRowIndex);

        Integer idProduct = Integer.parseInt(model.getValueAt(modelRowIndex, 0).toString());
        String nameProduct = model.getValueAt(modelRowIndex, 1).toString();
        Long quantityProduct = (long) Integer.parseInt(model.getValueAt(modelRowIndex, 4).toString());
        String unit = model.getValueAt(modelRowIndex, 2).toString();
        long price = Long.parseLong(model.getValueAt(modelRowIndex, 3).toString());

        //String name = model.getValueAt(modelRowIndex, 3).toString();

        dataSelectTbl = new Product();
        dataSelectTbl.setIdProduct(idProduct);
        dataSelectTbl.setNameProduct(nameProduct);
        dataSelectTbl.setPrice(price);
        dataSelectTbl.setQuantityProduct(quantityProduct);

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


    private void txtNameUserActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void cmdSaveActionPerformed(java.awt.event.ActionEvent evt) throws ParseException {

        dataInsertExportNote = new ExportNote();
        if(txtTotalPrice == null) {
            Notifications.getInstance().show(Notifications.Type.WARNING , "chưa có dữ liệu");
        } else {
            int id = Integer.parseInt(txtIdUser.getText());
            UserApp userApp = serviceUserApp.findUserAppById(id);
            dataInsertExportNote.setClient(userApp);
            List<Product> products = new ArrayList<>();

            DefaultTableModel model = (DefaultTableModel) tbl.getModel();
            Product product ;

            for(int i=0; i<price.size(); i++) {
                product = serviceProduct.findById((Integer) model.getValueAt(i,0));
                products.add(product);
            }

            products.forEach(e->{
                System.out.println(e.toString());
            });

            dataInsertExportNote.setProducts(products);
            dataInsertExportNote.setTotalPrice(Long.parseLong(txtTotalPrice.getText()));
            // change to date java
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date date = formatter.parse(txtDate.getText());
            dataInsertExportNote.setDateTranSaction(date);
            serviceExportNote.insertExportNote(dataInsertExportNote);
            Product changeQuantityProduct = new Product();
             for(int i = 0; i < price.size(); i++) {
                changeQuantityProduct = serviceProduct.findById((Integer) model.getValueAt(i,0));
                Long quantity = changeQuantityProduct.getQuantityProduct();
                Long change = quantity + (Long)model.getValueAt(i , 4);

                serviceProduct.updateQuantityProduct(changeQuantityProduct, change);
             }
            Notifications.getInstance().show(Notifications.Type.SUCCESS, "thêm thành công");

        }
    }

    private void cmdAddProductActionPerformed(java.awt.event.ActionEvent evt) {
        if(!showFrameChose) {
showFrameChose = true;
frameChoseProduct = new FrameChoseProduct(em, this);
            frameChoseProduct.setVisible(true);

        } else {
                frameChoseProduct.dispose();
frameChoseProduct = new FrameChoseProduct(em, this);
            frameChoseProduct.setVisible(true);
        }

    }
    // Variables declaration - do not modify
    private javax.swing.JButton cmdAddProduct;
    //private javax.swing.JButton cmdDel;
    private javax.swing.JButton cmdExportTo;
    private javax.swing.JButton cmdSave;
    private org.example.view.crazypanel.CrazyPanel crazyPanel1;
    private org.example.view.crazypanel.CrazyPanel crazyPanel2;
    private org.example.view.crazypanel.CrazyPanel crazyPanel3;
    private org.example.view.crazypanel.CrazyPanel crazyPanel4;
    private org.example.view.crazypanel.CrazyPanel crazyPanel5;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lb;
    @Getter
    private javax.swing.JTable tbl;
    private javax.swing.JFormattedTextField txtDate;
    private javax.swing.JTextField txtIdUser;
    private javax.swing.JTextField txtNameUser;
    private javax.swing.JTextArea txtNote;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtTotalPrice;
    // End of variables declaration
}


