package org.example.controller;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class SearchTableController {
    public void searchTable(JTable jTable , JTextField jTextField) {
        DefaultTableModel model = (DefaultTableModel) jTable.getModel();
        TableRowSorter<TableModel> rowSorter = new TableRowSorter<TableModel>(model);
        jTable.setRowSorter(rowSorter);

//        JPanel panel = new JPanel(new BorderLayout());
//        panel.add(new JLabel("Specify a word to match:"),
//                BorderLayout.WEST);
//        panel.add(jtfFilter, BorderLayout.CENTER);
//
//        setLayout(new BorderLayout());
//        add(panel, BorderLayout.SOUTH);
//        add(new JScrollPane(jTable), BorderLayout.CENTER);

        jTextField.getDocument().addDocumentListener(new DocumentListener(){

            @Override
            public void insertUpdate(DocumentEvent e) {
                String text = jTextField.getText();

                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String text = jTextField.getText();

                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

        });


    }

}
