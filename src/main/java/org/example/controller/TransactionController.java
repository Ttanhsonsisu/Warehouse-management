package org.example.controller;

import jakarta.persistence.EntityManager;
import org.example.model.entities.ExportNote;
import org.example.model.entities.ImportNote;
import org.example.model.entities.Product;
import org.example.service.ServiceExportNote;
import org.example.service.ServiceImportNote;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;

public class TransactionController {

    private final EntityManager em;

    private ServiceImportNote serviceImportNote;

    private ServiceExportNote serviceExportNote;

    public TransactionController(EntityManager em) {
        this.em = em;
        serviceExportNote = new ServiceExportNote(em);
        serviceImportNote = new ServiceImportNote(em);
    }

    public void showDataTblTransaction(JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();

        List<ExportNote> dataExport = serviceExportNote.getExportNotes();
        for(ExportNote transaction : dataExport) {
            model.addRow(new Object[] {
                    transaction.getIdExportNote(),
                    transaction.getDateTranSaction(),
                    transaction.getTotalPrice(),
                    transaction.getClient().getName(),
                    "Xuất kho"
                    }
            );
        }

        List<ImportNote> dataImport = serviceImportNote.getImportNotes();
        for(ImportNote transaction : dataImport) {
            model.addRow(new Object[] {
                    transaction.getIdImportNote(),
                    transaction.getDateTranSaction(),
                    transaction.getTotalPrice(),
                    transaction.getSuppiers().getName(),
                    "nhập kho"
                    }
            );
        }

        TableRowSorter<TableModel> rowSorter = new TableRowSorter<>(model);
        table.setRowSorter(rowSorter);
    }
    private void showDataTwoList(JTable table, List<ExportNote> dataExport , List<ImportNote> dataImport) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        if(!dataExport.isEmpty()) {
            for(ExportNote transaction : dataExport) {
                model.addRow(new Object[] {
                                transaction.getIdExportNote(),
                                transaction.getDateTranSaction(),
                                transaction.getTotalPrice(),
                                transaction.getClient().getName(),
                                "Xuất kho"
                        }
                );
            }
        }
        if(!dataImport.isEmpty()) {
            for(ImportNote transaction : dataImport) {
                model.addRow(new Object[] {
                                transaction.getIdImportNote(),
                                transaction.getDateTranSaction(),
                                transaction.getTotalPrice(),
                                transaction.getSuppiers().getName(),
                                "nhập kho"
                        }
                );
            }
        }

    }

    public void showDataBetweenData(JTable table , Date begin , Date end) {
        List<ExportNote> list1 = serviceExportNote.getAllDataBetween(begin, end);

        List<ImportNote> list2 = serviceImportNote.getAllDataBetween(begin, end);

        this.showDataTwoList(table, list1, list2);
    }
}
