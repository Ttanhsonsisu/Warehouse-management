/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example.view.dashboart.application.form.transaction_form.ACTbl;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;


public class TableActionCellRender extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
       Component com = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
       
       PanelAction action = new PanelAction();
       action.setBackground(com.getBackground());
       
       
       return action;
    }
    
    
}
