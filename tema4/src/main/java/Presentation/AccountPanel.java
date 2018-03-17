package Presentation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class AccountPanel extends JPanel {
    private JTable table;
    private JTextField suma;
    private JButton btnDelete;
    private JButton btnSaving;
    private JButton btnAddspending;
    private JPanel panel;
    private JTextField textField;
    private JButton btnAdd;
    private JButton btnRetrage;
    private JButton btnBack;

    AccountPanel() {
        this.setSize(689, 420);
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{0, 125, 120, 104, 23, 115, 0, 0};
        gridBagLayout.rowHeights = new int[]{18, 31, 0, 64, 54, 56, 94, 66, 0, 0, 0, 0, 0, 0, 0};
        gridBagLayout.columnWeights = new double[]{0.0, 1.0, 1.0, 1.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
        gridBagLayout.rowWeights = new double[]{0.0, 0.0, 1.0, 1.0, 1.0, 1.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        setLayout(gridBagLayout);

        JLabel lblPersons = new JLabel("Accounts");
        GridBagConstraints gbc_lblPersons = new GridBagConstraints();
        gbc_lblPersons.insets = new Insets(0, 0, 5, 5);
        gbc_lblPersons.gridx = 1;
        gbc_lblPersons.gridy = 1;
        add(lblPersons, gbc_lblPersons);

        panel = new JPanel();
        GridBagConstraints gbc_panel = new GridBagConstraints();
        gbc_panel.gridheight = 5;
        gbc_panel.gridwidth = 5;
        gbc_panel.insets = new Insets(0, 0, 5, 5);
        gbc_panel.fill = GridBagConstraints.BOTH;
        gbc_panel.gridx = 1;
        gbc_panel.gridy = 3;
        add(panel, gbc_panel);
        GridBagLayout gbl_panel = new GridBagLayout();
        gbl_panel.columnWidths = new int[]{0, 0};
        gbl_panel.rowHeights = new int[]{0, 0};
        gbl_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
        gbl_panel.rowWeights = new double[]{1.0, Double.MIN_VALUE};
        panel.setLayout(gbl_panel);

        JLabel lblSuma = new JLabel("Suma");
        GridBagConstraints gbc_lblSuma = new GridBagConstraints();
        gbc_lblSuma.insets = new Insets(0, 0, 5, 5);
        gbc_lblSuma.gridx = 1;
        gbc_lblSuma.gridy = 9;
        add(lblSuma, gbc_lblSuma);

        suma = new JTextField();
        GridBagConstraints gbc_suma = new GridBagConstraints();
        gbc_suma.insets = new Insets(0, 0, 5, 5);
        gbc_suma.fill = GridBagConstraints.HORIZONTAL;
        gbc_suma.gridx = 2;
        gbc_suma.gridy = 9;
        add(suma, gbc_suma);
        suma.setColumns(10);

        btnAdd = new JButton("Adauga");
        GridBagConstraints gbc_btnAdd = new GridBagConstraints();
        gbc_btnAdd.fill = GridBagConstraints.HORIZONTAL;
        gbc_btnAdd.insets = new Insets(0, 0, 5, 5);
        gbc_btnAdd.gridx = 3;
        gbc_btnAdd.gridy = 9;
        add(btnAdd, gbc_btnAdd);

        JLabel lblInterestrate = new JLabel("InterestRate(%)");
        GridBagConstraints gbc_lblInterestrate = new GridBagConstraints();
        gbc_lblInterestrate.insets = new Insets(0, 0, 5, 5);
        gbc_lblInterestrate.gridx = 1;
        gbc_lblInterestrate.gridy = 10;
        add(lblInterestrate, gbc_lblInterestrate);

        textField = new JTextField();
        GridBagConstraints gbc_textField = new GridBagConstraints();
        gbc_textField.insets = new Insets(0, 0, 5, 5);
        gbc_textField.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField.gridx = 2;
        gbc_textField.gridy = 10;
        add(textField, gbc_textField);
        textField.setColumns(10);

        btnRetrage = new JButton("Retrage");
        GridBagConstraints gbc_btnRetrage = new GridBagConstraints();
        gbc_btnRetrage.fill = GridBagConstraints.HORIZONTAL;
        gbc_btnRetrage.insets = new Insets(0, 0, 5, 5);
        gbc_btnRetrage.gridx = 3;
        gbc_btnRetrage.gridy = 10;
        add(btnRetrage, gbc_btnRetrage);

        btnAddspending = new JButton("AddSpending");
        GridBagConstraints gbc_btnAddspending = new GridBagConstraints();
        gbc_btnAddspending.fill = GridBagConstraints.HORIZONTAL;
        gbc_btnAddspending.insets = new Insets(0, 0, 5, 5);
        gbc_btnAddspending.gridx = 1;
        gbc_btnAddspending.gridy = 12;
        add(btnAddspending, gbc_btnAddspending);

        btnSaving = new JButton("AddSaving");
        GridBagConstraints gbc_btnSaving = new GridBagConstraints();
        gbc_btnSaving.anchor = GridBagConstraints.NORTH;
        gbc_btnSaving.fill = GridBagConstraints.HORIZONTAL;
        gbc_btnSaving.insets = new Insets(0, 0, 5, 5);
        gbc_btnSaving.gridx = 2;
        gbc_btnSaving.gridy = 12;
        add(btnSaving, gbc_btnSaving);

        btnDelete = new JButton("Delete");
        GridBagConstraints gbc_btnDelete = new GridBagConstraints();
        gbc_btnDelete.fill = GridBagConstraints.HORIZONTAL;
        gbc_btnDelete.insets = new Insets(0, 0, 5, 5);
        gbc_btnDelete.gridx = 3;
        gbc_btnDelete.gridy = 12;
        add(btnDelete, gbc_btnDelete);

        btnBack = new JButton("Back");
        GridBagConstraints gbc_btnBack = new GridBagConstraints();
        gbc_btnBack.fill = GridBagConstraints.HORIZONTAL;
        gbc_btnBack.insets = new Insets(0, 0, 5, 5);
        gbc_btnBack.gridx = 5;
        gbc_btnBack.gridy = 12;
        add(btnBack, gbc_btnBack);

    }

    public void addDeleteListener(ActionListener e) {
        btnDelete.addActionListener(e);
    }

    public void BackListener(ActionListener e) {
        btnBack.addActionListener(e);
    }

    public void addInsertListener(ActionListener e) {
        btnSaving.addActionListener(e);
        btnAddspending.addActionListener(e);
    }

    public void addAdaugaSumaListener(ActionListener e) {
        btnAdd.addActionListener(e);
    }

    public void addRetrageSumaListener(ActionListener e) {
        btnRetrage.addActionListener(e);
    }

    public JTable getTable() {
        return table;
    }

    public void setTable(JTable table) {
        this.panel.remove(table);
        this.table = table;
        JScrollPane js = new JScrollPane(table);
        js.setVisible(true);
        GridBagConstraints gbc_table_1 = new GridBagConstraints();
        gbc_table_1.fill = GridBagConstraints.BOTH;
        gbc_table_1.gridx = 0;
        gbc_table_1.gridy = 0;
        panel.add(js, gbc_table_1);
        panel.revalidate();
    }

    public JButton getBtnDelete() {
        return btnDelete;
    }

    public JButton getBtnAddspending() {
        return btnAddspending;
    }

    public JButton getBtnAddSaving() {
        return btnSaving;
    }

    public JButton getBtnAdd() {
        return btnAdd;
    }

    public JButton getBtnRetrage() {
        return btnRetrage;
    }

    public JTextField getSuma() {
        return suma;
    }

    public JTextField getInterestRate() {
        return textField;
    }
}
