/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import model.Tiket;
import repository.TiketRepository;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class TiketGUI extends JFrame {
    TiketRepository repo = new TiketRepository();
    DefaultTableModel model;
    JTable table;

    JTextField txtNamaPembeli, txtNamaKonser, txtJumlah, txtHarga;
    JComboBox<String> cbKategori;
    JButton btnTambah, btnEdit, btnHapus;

    public TiketGUI() {
        setTitle("Sistem Pemesanan Tiket Konser");
        setSize(800, 450);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(250, 255, 240));
        initComponents();
        setVisible(true);
    }

    private void initComponents() {
        setLayout(new BorderLayout());

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 10, 5, 10);
        gbc.anchor = GridBagConstraints.LINE_START;

        txtNamaPembeli = new JTextField(15);
        txtNamaKonser = new JTextField(15);
        txtJumlah = new JTextField(15);
        cbKategori = new JComboBox<>(new String[]{"VIP", "Reguler", "Festival"});
        txtHarga = new JTextField(15);

        // Nama Pembeli
        gbc.gridx = 0; gbc.gridy = 0;
        panel.add(new JLabel("Nama Pembeli:"), gbc);
        gbc.gridx = 1;
        panel.add(txtNamaPembeli, gbc);

        // Nama Konser
        gbc.gridx = 0; gbc.gridy = 1;
        panel.add(new JLabel("Nama Konser:"), gbc);
        gbc.gridx = 1;
        panel.add(txtNamaKonser, gbc);

        // Jumlah Tiket
        gbc.gridx = 0; gbc.gridy = 2;
        panel.add(new JLabel("Jumlah Tiket:"), gbc);
        gbc.gridx = 1;
        panel.add(txtJumlah, gbc);

        // Kategori
        gbc.gridx = 0; gbc.gridy = 3;
        panel.add(new JLabel("Kategori Kursi:"), gbc);
        gbc.gridx = 1;
        panel.add(cbKategori, gbc);

        // Harga
        gbc.gridx = 0; gbc.gridy = 4;
        panel.add(new JLabel("Harga Total:"), gbc);
        gbc.gridx = 1;
        panel.add(txtHarga, gbc);

        // Tombol Tambah & Edit
        gbc.gridx = 0; gbc.gridy = 5;
        panel.add(btnTambah = new JButton("Tambah"), gbc);
        gbc.gridx = 1;
        panel.add(btnEdit = new JButton("Edit"), gbc);

        // Tombol Hapus full width
        gbc.gridx = 0; gbc.gridy = 6;
        gbc.gridwidth = 2;
        btnHapus = new JButton("Hapus");
        btnHapus.setBackground(Color.RED);
        btnHapus.setForeground(Color.WHITE);
        btnHapus.setPreferredSize(new Dimension(300, 30));
        panel.add(btnHapus, gbc);

        add(panel, BorderLayout.NORTH);

        model = new DefaultTableModel(new String[]{"Nama Pembeli", "Konser", "Jumlah", "Kategori", "Harga"}, 0);
        table = new JTable(model);
        add(new JScrollPane(table), BorderLayout.CENTER);

        // Event handlers
        btnTambah.addActionListener(e -> {
            Tiket tiket = new Tiket(
                    txtNamaPembeli.getText(),
                    txtNamaKonser.getText(),
                    Integer.parseInt(txtJumlah.getText()),
                    cbKategori.getSelectedItem().toString(),
                    Integer.parseInt(txtHarga.getText())
            );
            repo.tambah(tiket);
            refreshTable();
            clearForm();
        });

        btnEdit.addActionListener(e -> {
            int selected = table.getSelectedRow();
            if (selected != -1) {
                Tiket tiket = new Tiket(
                        txtNamaPembeli.getText(),
                        txtNamaKonser.getText(),
                        Integer.parseInt(txtJumlah.getText()),
                        cbKategori.getSelectedItem().toString(),
                        Integer.parseInt(txtHarga.getText())
                );
                repo.update(selected, tiket);
                refreshTable();
                clearForm();
            }
        });

        btnHapus.addActionListener(e -> {
            int selected = table.getSelectedRow();
            if (selected != -1) {
                repo.hapus(selected);
                refreshTable();
                clearForm();
            }
        });

        table.getSelectionModel().addListSelectionListener(e -> {
            int selected = table.getSelectedRow();
            if (selected != -1) {
                txtNamaPembeli.setText(model.getValueAt(selected, 0).toString());
                txtNamaKonser.setText(model.getValueAt(selected, 1).toString());
                txtJumlah.setText(model.getValueAt(selected, 2).toString());
                cbKategori.setSelectedItem(model.getValueAt(selected, 3).toString());
                txtHarga.setText(model.getValueAt(selected, 4).toString());
            }
        });
    }

    private void refreshTable() {
        model.setRowCount(0);
        for (Tiket tiket : repo.getAll()) {
            model.addRow(new Object[]{
                    tiket.getNamaPembeli(),
                    tiket.getNamaKonser(),
                    tiket.getJumlahTiket(),
                    tiket.getKategoriKursi(),
                    tiket.getHarga()
            });
        }
    }

    private void clearForm() {
        txtNamaPembeli.setText("");
        txtNamaKonser.setText("");
        txtJumlah.setText("");
        txtHarga.setText("");
        cbKategori.setSelectedIndex(0);
    }
}
