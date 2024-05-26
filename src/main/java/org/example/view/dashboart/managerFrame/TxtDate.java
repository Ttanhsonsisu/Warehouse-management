package org.example.view.dashboart.managerFrame;

import lombok.Getter;
import raven.datetime.component.date.DateEvent;
import raven.datetime.component.date.DatePicker;
import raven.datetime.component.date.DateSelectionAble;
import raven.datetime.component.date.DateSelectionListener;

import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TxtDate {

    @Getter
    private JFormattedTextField txtDate;


    public TxtDate(JFormattedTextField txtDate) {
        this.txtDate = txtDate;
        init();
    }

    public void init() {
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
                System.out.println(df.format(dates[0]) + " " + df.format(dates[1]));
            }
        }
    });
        datePicker.setEditor(this.getTxtDate());
    }
}
