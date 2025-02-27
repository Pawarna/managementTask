package com.managementtask.ui;

import com.managementtask.models.Task;
import com.managementtask.services.TaskService;
import com.managementtask.services.UserService;
import com.managementtask.utils.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;
import javax.swing.table.TableRowSorter;

public class MainForm extends javax.swing.JFrame {
    private String userEmail;
    TaskService taskService = new TaskService();
    SendNotification sendNotification = new SendNotification();
    TranslateTaskWithGemini gemini = new TranslateTaskWithGemini();
    private boolean isEditMode = false;
    /**
     * Creates new form Test
     */
    public MainForm(String userEmail) {
        this.userEmail = userEmail;
        initComponents();
        loadTask();
    }

    private MainForm() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel8 = new javax.swing.JLabel();
        cmbSubject = new javax.swing.JComboBox<>();
        btnDelete = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblResult = new javax.swing.JTable();
        btnUpdate = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtTaskTitle = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDescription = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        dateTaskChooser = new datechooser.beans.DateChooserCombo();
        jLabel5 = new javax.swing.JLabel();
        dueDateChooser = new datechooser.beans.DateChooserCombo();
        jLabel6 = new javax.swing.JLabel();
        cmbTaskType = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        cmbSubmissionMethod = new javax.swing.JComboBox<>();
        spnrJam = new javax.swing.JSpinner(new SpinnerNumberModel(0,0,23,1));
        spnrMenit = new javax.swing.JSpinner(new SpinnerNumberModel(0,0,59,1));
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        btnLogout = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Management Task");

        jLabel8.setText("Metode Pengumpulan");

        cmbSubject.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Praktikum Pemrograman Berorientasi Objek", "Pemrograman Berorientasi Objek", "Rekayasa Perangkat Lunak", "Statistika", "Praktikum Statistika", "Interaksi Manusia dan Komputer", "Jaringan dan Komputer", "Praktikum Jaringan dan Komputer", "Kecerdasan Buatan", "Agama", "Bahasa Indonesia" }));

        btnDelete.setText("Hapus");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        tblResult.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblResult);

        btnUpdate.setText("Edit");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnAdd.setText("Tambah");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Sistem Management Tugas");
        jLabel1.setToolTipText("");

        jLabel2.setText("Mata Kuliah");

        txtDescription.setColumns(20);
        txtDescription.setLineWrap(true);
        txtDescription.setRows(5);
        jScrollPane2.setViewportView(txtDescription);

        jLabel3.setText("Judul Tugas");

        jLabel4.setText("Deskripsi");

        jLabel5.setText("Tanggal Penugasan");

        jLabel6.setText("Deadline");

        cmbTaskType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Individual", "Group" }));

        jLabel7.setText("Jenis Tugas");

        cmbSubmissionMethod.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sipedar", "Google Form", "HardFile", "Presentasi" }));

        spnrJam.setRequestFocusEnabled(false);

        jLabel9.setText("Jam");

        jLabel10.setText("Menit");

        btnLogout.setText("Log Out");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLogout))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnAdd)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnUpdate)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnDelete))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8))
                                .addGap(13, 13, 13)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cmbSubject, 0, 452, Short.MAX_VALUE)
                                    .addComponent(txtTaskTitle)
                                    .addComponent(jScrollPane2)
                                    .addComponent(dateTaskChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(cmbSubmissionMethod, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(cmbTaskType, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(dueDateChooser, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel9)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(spnrJam, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(spnrMenit, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1)))
                .addGap(16, 16, 16))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(btnLogout))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(cmbSubject, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtTaskTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(dateTaskChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(dueDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(spnrJam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(spnrMenit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel9)
                                .addComponent(jLabel10)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(cmbTaskType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(cmbSubmissionMethod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnDelete)
                            .addComponent(btnUpdate)
                            .addComponent(btnAdd)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(41, 41, 41))
        );

        dateTaskChooser.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
        dueDateChooser.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
        JSpinner.NumberEditor editor = new JSpinner.NumberEditor(spnrJam, "00");
        spnrJam.setEditor(editor);
        JSpinner.NumberEditor editorHour = new JSpinner.NumberEditor(spnrMenit, "00");
        spnrMenit.setEditor(editorHour);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        String HH = String.format("%02d", spnrJam.getValue());
        String mm = String.format("%02d", spnrMenit.getValue());
        String dueTime = HH + ":" + mm;
        
        try{
            String subject = cmbSubject.getSelectedItem().toString();
            String taskTitle = txtTaskTitle.getText();
            String description = txtDescription.getText();
            LocalDate taskDate = dateTaskChooser.getSelectedDate().getTime()
                                                .toInstant()
                                                .atZone(ZoneId.systemDefault())
                                                .toLocalDate();
            LocalDate dueDate = dueDateChooser.getSelectedDate().getTime()
                                                .toInstant()
                                                .atZone(ZoneId.systemDefault())
                                                .toLocalDate();
            LocalDateTime dueDateTime = LocalDateTime.of(
                dueDate,
                LocalTime.parse(dueTime, DateTimeFormatter.ofPattern("HH:mm")));
            String taskType = cmbTaskType.getSelectedItem().toString();
            String submissionMethod = cmbSubmissionMethod.getSelectedItem().toString();
            
            Task task = new Task(
                subject,
                taskTitle,
                description,
                taskDate,
                dueDateTime,
                taskType,
                submissionMethod);
            if(new TaskValidation().isNotValid(task)){
                JOptionPane.showMessageDialog(this, "Semua bidang harus diisi!");
                return;
            }
            taskService.addTask(task, userEmail);
            String notif = gemini.result(task);
            String userNumber = new UserService().getUser(this.userEmail).getPhoneNumber();
            sendNotification.toWhatsapp(notif, userNumber);
            loadTask();
            clearField();
        }catch(Exception e){

        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        if (isEditMode) {
        // Keluar dari mode edit
        exitEditMode();
    } else {
        // Hapus tugas
        deleteSelectedTasks();
    }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        if (isEditMode) {
        // Simpan perubahan
        saveTaskChanges();
        } else {
            // Masuk ke mode edit
            enterEditMode();
        }      
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        UserService userService = new UserService();
        userService.logout(userEmail);
        SessionManager.clearSession();
        new Login().setVisible(true);
        dispose();
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void saveTaskChanges() {
        try {
            String HH = String.format("%02d", spnrJam.getValue());
            String mm = String.format("%02d", spnrMenit.getValue());
            String dueTime = HH + ":" + mm;

            int selectedRow = tblResult.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(this, "Pilih tugas yang ingin diedit!");
                return;
            }

            int taskId = (int) tblResult.getModel().getValueAt(selectedRow, 8);

            String subject = cmbSubject.getSelectedItem().toString();
            String taskTitle = txtTaskTitle.getText();
            String description = txtDescription.getText();

            LocalDate taskDate = dateTaskChooser.getSelectedDate().getTime()
                                                .toInstant()
                                                .atZone(ZoneId.systemDefault())
                                                .toLocalDate();
            LocalDate dueDate = dueDateChooser.getSelectedDate().getTime()
                                              .toInstant()
                                              .atZone(ZoneId.systemDefault())
                                              .toLocalDate();
            LocalDateTime dueDateTime = LocalDateTime.of(
                dueDate,
                LocalTime.parse(dueTime, DateTimeFormatter.ofPattern("HH:mm"))
            );

            String taskType = cmbTaskType.getSelectedItem().toString();
            String submissionMethod = cmbSubmissionMethod.getSelectedItem().toString();

            Task task = new Task(
                subject,
                taskTitle,
                description,
                taskDate,
                dueDateTime,
                taskType,
                submissionMethod
            );

            // Validasi tugas
            if (new TaskValidation().isNotValid(task)) {
                JOptionPane.showMessageDialog(this, "Semua bidang harus diisi!");
                return;
            }

            // Perbarui tugas
            taskService.updateTask(taskId, task);
            loadTask(); // Reload data tabel
            JOptionPane.showMessageDialog(this, "Tugas berhasil diperbarui!");

            // Reset form dan keluar dari mode edit
            clearField();
            exitEditMode();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Terjadi kesalahan saat menyimpan tugas.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void enterEditMode() {
        int selectedRow = tblResult.getSelectedRow();
        if (selectedRow != -1) {
            int taskId = (int) tblResult.getModel().getValueAt(selectedRow, 8);
            loadTaskToField(taskId); // Muat data ke field input
            isEditMode = true;
            btnUpdate.setText("Simpan");
            btnAdd.setEnabled(false);
            btnDelete.setText("Batal");
        } else {
            JOptionPane.showMessageDialog(this, "Pilih tugas yang ingin diedit!");
        }
    }


 
    private void deleteSelectedTasks() {
        int[] selectedRows = tblResult.getSelectedRows();

        if (selectedRows.length > 0) {
            int confirm = JOptionPane.showConfirmDialog(this,
                    "Apa kamu yakin ingin menghapus tugas yang dipilih?",
                    "Hapus Tugas",
                    JOptionPane.YES_NO_OPTION);

            if (confirm == JOptionPane.YES_OPTION) {
                try {
                    for (int row : selectedRows) {
                        int taskId = (int) tblResult.getModel().getValueAt(row, 8);
                        taskService.deleteTask(taskId);
                    }
                    loadTask(); // Muat ulang data tabel
                    JOptionPane.showMessageDialog(this, "Tugas yang dipilih telah dihapus.");
                } catch (Exception e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(this, "Error saat melakukan penghapusan tugas.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Tolong pilih 1 atau lebih tugas untuk dihapus!", "Tidak ada tugas yang dipilih", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void exitEditMode() {
        isEditMode = false;
        btnUpdate.setText("Edit");
        btnDelete.setText("Hapus");
        btnAdd.setEnabled(true);

        // Bersihkan field input
        clearField();
    }

    public void loadTask(){
        List<Task> tasks = taskService.getTasksByUserEmail(userEmail);
        // Urutkan tugas berdasarkan deadline dan durasi
        tasks.sort((task1, task2) -> {
            // Bandingkan berdasarkan deadline
            int deadlineComparison = task1.getDueDate().compareTo(task2.getDueDate());
            if (deadlineComparison == 0) {
                // Jika deadline sama, bandingkan berdasarkan durasi penyelesaian
                long duration1 = Duration.between(task1.getTaskDate().atStartOfDay(), task1.getDueDate()).toHours();
                long duration2 = Duration.between(task2.getTaskDate().atStartOfDay(), task2.getDueDate()).toHours();
                return Long.compare(duration1, duration2);
            }
            return deadlineComparison;
        });

        
        LocalDateTime now = LocalDateTime.now();
        List<Task> overdueTasks = new ArrayList<>();
        List<Task> upcomingTasks = new ArrayList<>();

        for (Task task : tasks) {
            if (task.getDueDate().isBefore(now)) {
                overdueTasks.add(task);
            } else {
                upcomingTasks.add(task);
            }
        }

        // Gabungkan tugas yang belum overdue dengan tugas yang sudah overdue
        List<Task> sortedTasks = new ArrayList<>();
        sortedTasks.addAll(upcomingTasks);
        sortedTasks.addAll(overdueTasks);
    
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("No");
        model.addColumn("Mata Kuliah");
        model.addColumn("Judul Tugas");
        model.addColumn("Deskripsi");
        model.addColumn("Tanggal Penugasan");
        model.addColumn("Deadline");
        model.addColumn("Tipe Tugas");
        model.addColumn("Metode Pengumpulan");
        model.addColumn("ID");
        
        int number = 1;
        for(Task task: sortedTasks){
            model.addRow(new Object[]{
                    number++,
                    task.getSubject(),
                    task.getTaskTitle(),
                    task.getDescription(),
                    task.getTaskDate().format(DateTimeFormatter.ofPattern("d MMMM yyyy", new Locale("id", "ID"))),
                    task.getDueDate().format(DateTimeFormatter.ofPattern("d MMMM yyyy HH:mm", new Locale("id", "ID"))),
                    task.getTaskType(),
                    task.getSubmissionMethod(),
                    task.getId()
            }); 
        }
        tblResult.setModel(model);
        
        tblResult.getColumnModel().getColumn(8).setMinWidth(0);
        tblResult.getColumnModel().getColumn(8).setMaxWidth(0);
        tblResult.getColumnModel().getColumn(8).setWidth(0);
        
        tblResult.getColumnModel().getColumn(0).setMaxWidth(30);
        
        tblResult.setRowHeight(200);
        
        tblResult.getColumnModel().getColumn(0).setPreferredWidth(50);  // No
        tblResult.getColumnModel().getColumn(1).setPreferredWidth(200); // Mata Kuliah
        tblResult.getColumnModel().getColumn(2).setPreferredWidth(200); // Judul Tugas
        tblResult.getColumnModel().getColumn(3).setPreferredWidth(300); // Deskripsi
        tblResult.getColumnModel().getColumn(4).setPreferredWidth(120); // Tanggal Penugasan
        tblResult.getColumnModel().getColumn(5).setPreferredWidth(150); // Deadline
        tblResult.getColumnModel().getColumn(6).setPreferredWidth(120); // Tipe Tugas
        tblResult.getColumnModel().getColumn(7).setPreferredWidth(150); // Metode Pengumpulan

        // Custom renderer untuk text wrapping di kolom Deskripsi
        tblResult.getColumnModel().getColumn(3).setCellRenderer(new TextAreaRenderer());
        
        tblResult.getColumnModel().getColumn(5).setCellRenderer(new DeadlineTableCellRenderer());
        
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
        tblResult.setRowSorter(sorter);
        sorter.setSortable(0, false);        
        sorter.addRowSorterListener(e -> refreshTableNumbering());
        refreshTableNumbering();
    }
    
    private void loadTaskToField(int taskId){
        Task task = taskService.getTask(taskId);
        
        cmbSubject.setSelectedItem(task.getSubject());
        txtTaskTitle.setText(task.getTaskTitle());
        txtDescription.setText(task.getDescription());
        
        try {
            Date taskDate = new SimpleDateFormat("yyyy-MM-dd").parse(task.getTaskDate().toString());
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(taskDate);

            Date dueDate = new SimpleDateFormat("yyyy-MM-dd").parse(task.getDueDate().toString());
            Calendar calender = Calendar.getInstance();
            calender.setTime(dueDate);

            dateTaskChooser.setSelectedDate(calendar);
            dueDateChooser.setSelectedDate(calender);
            
        } catch (ParseException e) {
            e.printStackTrace();
        }
        
        spnrJam.setValue(task.getDueDate().getHour());
        spnrMenit.setValue(task.getDueDate().getMinute());
        cmbTaskType.setSelectedItem(task.getTaskType());
        cmbSubmissionMethod.setSelectedItem(task.getSubmissionMethod());
        
    }
    
    private void refreshTableNumbering() {
    for (int i = 0; i < tblResult.getRowCount(); i++) {
        tblResult.setValueAt(i + 1, i, 0);
    }
    
    
    
    }
    
    private void clearField() {
    // Clear JTextFields
    txtTaskTitle.setText("");
    txtDescription.setText("");

    // Reset JComboBoxes to default state
    cmbSubject.setSelectedIndex(0);
    cmbTaskType.setSelectedIndex(0);
    cmbSubmissionMethod.setSelectedIndex(0);

    // Clear JDateChoosers
    dateTaskChooser.setSelectedDate(Calendar.getInstance());
    dueDateChooser.setSelectedDate(Calendar.getInstance());

    // Reset JSpinners to default value (e.g., 0 or starting hour/minute)
    spnrJam.setValue(0);
    spnrMenit.setValue(0);
    }

    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Metal".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cmbSubject;
    private javax.swing.JComboBox<String> cmbSubmissionMethod;
    private javax.swing.JComboBox<String> cmbTaskType;
    private datechooser.beans.DateChooserCombo dateTaskChooser;
    private datechooser.beans.DateChooserCombo dueDateChooser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSpinner spnrJam;
    private javax.swing.JSpinner spnrMenit;
    private javax.swing.JTable tblResult;
    private javax.swing.JTextArea txtDescription;
    private javax.swing.JTextField txtTaskTitle;
    // End of variables declaration//GEN-END:variables
}
