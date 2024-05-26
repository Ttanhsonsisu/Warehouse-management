
package org.example.view.dashboart.application.form.transaction_form.ACTbl;

import javax.swing.*;
import java.awt.*;


public class TableActionCellEditor extends DefaultCellEditor {
    
    private TableActionEvent event;

    public TableActionCellEditor(TableActionEvent event) {
        super(new JCheckBox());
        this.event = event;
    }
    
    @Override
    public Component getTableCellEditorComponent(JTable jtable, Object o, boolean bln, int row, int column) {
        PanelAction action = new PanelAction();
        action.initEvent(event, row);
        action.setBackground(jtable.getSelectionBackground());
        return action;
    }

    
}
