package com.managementtask.utils;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

public class TextAreaRenderer extends JTextArea implements TableCellRenderer {
    public TextAreaRenderer() {
        setLineWrap(true); // Aktifkan text wrapping
        setWrapStyleWord(true); // Bungkus berdasarkan kata, bukan huruf
        setOpaque(true); // Pastikan background ditampilkan
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        setText(value != null ? value.toString() : ""); // Atur teks
        // Ubah warna latar dan teks jika dipilih
        if (isSelected) {
            setBackground(table.getSelectionBackground());
            setForeground(table.getSelectionForeground());
        } else {
            setBackground(table.getBackground());
            setForeground(table.getForeground());
        }
        setFont(table.getFont()); // Gunakan font tabel
        setSize(table.getColumnModel().getColumn(column).getWidth(), getPreferredSize().height);
        return this;
    }
}
