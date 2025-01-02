package com.managementtask.ui;

import javax.swing.*;
import com.formdev.flatlaf.*;
import com.formdev.flatlaf.themes.*;

public class Main {
    public static void main(String[] args) {
        try {
            // Set tema default saat aplikasi dimulai
            UIManager.setLookAndFeel(new FlatMacDarkLaf());
        } catch (Exception e) {
            e.printStackTrace();
        }

        SwingUtilities.invokeLater(() -> {
            MainForm app = new MainForm();
            app.setExtendedState(JFrame.MAXIMIZED_BOTH);
            app.setVisible(true);

            // Tambahkan menu bar dengan fitur tema dan refresh tabel
            setupMenuBar(app);
        });
    }

    private static void setupMenuBar(JFrame app) {
        // Menu Bar
        JMenuBar menuBar = new JMenuBar();

        // Menu Tema
        JMenu themeMenu = new JMenu("Tema");
        JMenuItem macDarkTheme = new JMenuItem("Mac Dark");
        JMenuItem macLightTheme = new JMenuItem("Mac Light");
        JMenuItem intellijDark = new JMenuItem("IntelliJ Dark");
        JMenuItem intellijLight = new JMenuItem("IntelliJ Light");

        // Tambahkan action listener untuk mengganti tema
        macDarkTheme.addActionListener(e -> switchLookAndFeel(new FlatMacDarkLaf(), app));
        macLightTheme.addActionListener(e -> switchLookAndFeel(new FlatMacLightLaf(), app));
        intellijDark.addActionListener(e -> switchLookAndFeel(new FlatDarculaLaf(), app));
        intellijLight.addActionListener(e -> switchLookAndFeel(new FlatLightLaf(), app));
        

        // Tambahkan item ke menu Tema
        themeMenu.add(macDarkTheme);
        themeMenu.add(macLightTheme);
        themeMenu.add(intellijDark);
        themeMenu.add(intellijLight);

        // Menu Utility
        JMenu utilityMenu = new JMenu("Utilitas");
        JMenuItem refreshTableMenuItem = new JMenuItem("Refresh Tabel");
        refreshTableMenuItem.addActionListener(e -> refreshTaskTable(app));

        // Tambahkan item ke menu Utility
        utilityMenu.add(refreshTableMenuItem);

        // Tambahkan menu ke menu bar
        menuBar.add(themeMenu);
        menuBar.add(utilityMenu);

        // Set menu bar ke frame utama
        app.setJMenuBar(menuBar);
    }

    private static void switchLookAndFeel(LookAndFeel newLookAndFeel, JFrame app) {
        try {
            // Set Look and Feel baru
            UIManager.setLookAndFeel(newLookAndFeel);
            // Perbarui semua komponen di frame utama
            SwingUtilities.updateComponentTreeUI(app);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void refreshTaskTable(JFrame app) {
        // Memastikan bahwa frame adalah instance dari TaskManagementFrame
        if (app instanceof MainForm) {
            MainForm taskFrame = (MainForm) app;
            taskFrame.loadTask();
        }
    }
}
