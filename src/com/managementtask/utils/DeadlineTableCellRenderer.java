package com.managementtask.utils;


import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DeadlineTableCellRenderer extends DefaultTableCellRenderer {
    private final DateTimeFormatter formatter;

    public DeadlineTableCellRenderer() {
        this.formatter = DateTimeFormatter.ofPattern("d MMMM yyyy HH:mm", new Locale("id", "ID"));
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        if (value != null && column == 5) { // Kolom Deadline
            try {
                LocalDateTime deadline = LocalDateTime.parse(value.toString(), formatter);
                if (deadline.isBefore(LocalDateTime.now())) {
                    component.setBackground(Color.RED);
                    component.setForeground(Color.WHITE);
                } else {
                    component.setBackground(isSelected ? table.getSelectionBackground() : table.getBackground());
                    component.setForeground(isSelected ? table.getSelectionForeground() : table.getForeground());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            component.setBackground(isSelected ? table.getSelectionBackground() : table.getBackground());
            component.setForeground(isSelected ? table.getSelectionForeground() : table.getForeground());
        }

        return component;
    }
}

