package org.example.view.dashboart.application.form.export;



import org.example.view.crazypanel.CrazyPanel;
import org.example.view.crazypanel.FlatLafStyleComponent;
import org.example.view.crazypanel.MigLayoutConstraints;

public class FrameChoseProduct extends javax.swing.JFrame {


    public FrameChoseProduct() {
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        crazyPanel1 = new CrazyPanel();
        lb = new javax.swing.JLabel();
        crazyPanel2 = new CrazyPanel();
        txtSearch = new javax.swing.JTextField();
        cmdAdd = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblProduct1 = new javax.swing.JTable();
        cmdExit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        crazyPanel1.setMigLayoutConstraints(new MigLayoutConstraints(
                "wrap,fill,insets 10",
                "[fill]",
                "[grow 0]25[fill]",
                new String[]{
                        "",
                        "width 200",
                        ""
                }
        ));

        lb.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb.setText("Chọn sản phẩm");
        crazyPanel1.add(lb);

        crazyPanel2.setFlatLafStyleComponent(new FlatLafStyleComponent(
                "",
                new String[]{
                        "JTextField.placeholderText=Search;background=@background"
                }
        ));
        crazyPanel2.setMigLayoutConstraints(new MigLayoutConstraints(
                "insets 5",
                "[]push[][]",
                "",
                new String[]{
                        "width 200",
                        ""
                }
        ));
        crazyPanel2.add(txtSearch);

        cmdAdd.setText("Thêm");
        cmdAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdAddActionPerformed(evt);
            }
        });
        crazyPanel2.add(cmdAdd);

        crazyPanel1.add(crazyPanel2);

        tblProduct1.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                        "", "mã", "Tên ", "Số Lượng", "Đơn vị", "Giá bán", "Nhà cung cấp", " Mô tả "
                }
        ) {
            Class[] types = new Class [] {
                    java.lang.Boolean.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                    false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblProduct1.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                tblProduct1AncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        tblProduct1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProduct1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblProduct1);

        crazyPanel1.add(jScrollPane2);

        cmdExit.setText("Exit");
        cmdExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdExitActionPerformed(evt);
            }
        });
        crazyPanel1.add(cmdExit);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(crazyPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 562, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(crazyPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 405, Short.MAX_VALUE)
        );
        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>

    private void cmdAddActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void tblProduct1AncestorAdded(javax.swing.event.AncestorEvent evt) {
        // TODO add your handling code here:
    }

    private void tblProduct1MouseClicked(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
    }

    private void cmdExitActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }




    // Variables declaration - do not modify
    private javax.swing.JButton cmdAdd;
    private javax.swing.JButton cmdExit;
    private CrazyPanel crazyPanel1;
    private CrazyPanel crazyPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lb;
    private javax.swing.JTable tblProduct1;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration
}
