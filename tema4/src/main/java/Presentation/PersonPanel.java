package Presentation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class PersonPanel extends JPanel {

    private JTextField nume;
    private JTable table;
    private JTextField adresa;
    private JButton btnDelete;
    private JButton btnEdit;
    private JPanel panel;
    private JButton btnInsert;
    private JButton btnShowInfo;
    private JTextField cnp;
    private JTextField varsta;

    PersonPanel() {
        this.setSize(800, 600);
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{0, 0, 81, 0, 0, 0, 0, 170, 0, 0};
        gridBagLayout.rowHeights = new int[]{18, 31, 0, 64, 54, 56, 51, 88, 0, 0, 0, 0};
        gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, 1.0, 1.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
        gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, 1.0, 1.0, 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        setLayout(gridBagLayout);

        JLabel lblPersons = new JLabel("Persons");
        GridBagConstraints gbc_lblPersons = new GridBagConstraints();
        gbc_lblPersons.insets = new Insets(0, 0, 5, 5);
        gbc_lblPersons.gridx = 2;
        gbc_lblPersons.gridy = 1;
        add(lblPersons, gbc_lblPersons);

        JLabel lblName = new JLabel("Name");
        GridBagConstraints gbc_lblName = new GridBagConstraints();
        gbc_lblName.anchor = GridBagConstraints.EAST;
        gbc_lblName.insets = new Insets(0, 0, 5, 5);
        gbc_lblName.gridx = 1;
        gbc_lblName.gridy = 3;
        add(lblName, gbc_lblName);

        nume = new JTextField();
        GridBagConstraints gbc_nume = new GridBagConstraints();
        gbc_nume.insets = new Insets(0, 0, 5, 5);
        gbc_nume.fill = GridBagConstraints.HORIZONTAL;
        gbc_nume.gridx = 2;
        gbc_nume.gridy = 3;
        add(nume, gbc_nume);
        nume.setColumns(10);

        panel = new JPanel();
        GridBagConstraints gbc_panel = new GridBagConstraints();
        gbc_panel.gridheight = 6;
        gbc_panel.gridwidth = 6;
        gbc_panel.insets = new Insets(0, 0, 5, 0);
        gbc_panel.fill = GridBagConstraints.BOTH;
        gbc_panel.gridx = 3;
        gbc_panel.gridy = 2;
        add(panel, gbc_panel);
        GridBagLayout gbl_panel = new GridBagLayout();
        gbl_panel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0};
        gbl_panel.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        gbl_panel.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        panel.setLayout(gbl_panel);

        JLabel lblAdresa = new JLabel("Adresa");
        GridBagConstraints gbc_lblAdresa = new GridBagConstraints();
        gbc_lblAdresa.insets = new Insets(0, 0, 5, 5);
        gbc_lblAdresa.anchor = GridBagConstraints.EAST;
        gbc_lblAdresa.gridx = 1;
        gbc_lblAdresa.gridy = 4;
        add(lblAdresa, gbc_lblAdresa);

        adresa = new JTextField();
        GridBagConstraints gbc_adresa = new GridBagConstraints();
        gbc_adresa.insets = new Insets(0, 0, 5, 5);
        gbc_adresa.fill = GridBagConstraints.HORIZONTAL;
        gbc_adresa.gridx = 2;
        gbc_adresa.gridy = 4;
        add(adresa, gbc_adresa);
        adresa.setColumns(10);

        JLabel lblCnp = new JLabel("CNP");
        GridBagConstraints gbc_lblCnp = new GridBagConstraints();
        gbc_lblCnp.anchor = GridBagConstraints.EAST;
        gbc_lblCnp.insets = new Insets(0, 0, 5, 5);
        gbc_lblCnp.gridx = 1;
        gbc_lblCnp.gridy = 5;
        add(lblCnp, gbc_lblCnp);

        cnp = new JTextField();
        GridBagConstraints gbc_cnp = new GridBagConstraints();
        gbc_cnp.insets = new Insets(0, 0, 5, 5);
        gbc_cnp.fill = GridBagConstraints.HORIZONTAL;
        gbc_cnp.gridx = 2;
        gbc_cnp.gridy = 5;
        add(cnp, gbc_cnp);
        cnp.setColumns(10);

        JLabel lblVarsta = new JLabel("Varsta");
        GridBagConstraints gbc_lblVarsta = new GridBagConstraints();
        gbc_lblVarsta.anchor = GridBagConstraints.EAST;
        gbc_lblVarsta.insets = new Insets(0, 0, 5, 5);
        gbc_lblVarsta.gridx = 1;
        gbc_lblVarsta.gridy = 6;
        add(lblVarsta, gbc_lblVarsta);

        varsta = new JTextField();
        GridBagConstraints gbc_varsta = new GridBagConstraints();
        gbc_varsta.insets = new Insets(0, 0, 5, 5);
        gbc_varsta.fill = GridBagConstraints.HORIZONTAL;
        gbc_varsta.gridx = 2;
        gbc_varsta.gridy = 6;
        add(varsta, gbc_varsta);
        varsta.setColumns(10);

        btnInsert = new JButton("Add");
        GridBagConstraints gbc_btnInsert = new GridBagConstraints();
        gbc_btnInsert.fill = GridBagConstraints.BOTH;
        gbc_btnInsert.insets = new Insets(0, 0, 5, 5);
        gbc_btnInsert.gridx = 2;
        gbc_btnInsert.gridy = 9;
        add(btnInsert, gbc_btnInsert);

        btnDelete = new JButton("Delete");
        GridBagConstraints gbc_btnDelete = new GridBagConstraints();
        gbc_btnDelete.fill = GridBagConstraints.HORIZONTAL;
        gbc_btnDelete.insets = new Insets(0, 0, 5, 5);
        gbc_btnDelete.gridx = 3;
        gbc_btnDelete.gridy = 9;
        add(btnDelete, gbc_btnDelete);

        btnEdit = new JButton("Edit");
        GridBagConstraints gbc_btnEdit = new GridBagConstraints();
        gbc_btnEdit.fill = GridBagConstraints.HORIZONTAL;
        gbc_btnEdit.insets = new Insets(0, 0, 5, 5);
        gbc_btnEdit.gridx = 4;
        gbc_btnEdit.gridy = 9;
        add(btnEdit, gbc_btnEdit);

        btnShowInfo = new JButton("ShowAccounts");
        GridBagConstraints gbc_btnShowInfo = new GridBagConstraints();
        gbc_btnShowInfo.fill = GridBagConstraints.HORIZONTAL;
        gbc_btnShowInfo.insets = new Insets(0, 0, 5, 5);
        gbc_btnShowInfo.gridx = 7;
        gbc_btnShowInfo.gridy = 9;
        add(btnShowInfo, gbc_btnShowInfo);

    }

    public void addShowAccountsListener(ActionListener e) {
        btnShowInfo.addActionListener(e);
    }

    public void addDeleteListener(ActionListener e) {
        btnDelete.addActionListener(e);
    }

    public void addInsertListener(ActionListener e) {
        btnInsert.addActionListener(e);
    }

    public void addEditListener(ActionListener e) {
        btnEdit.addActionListener(e);
    }

    public JTextField getNume() {
        return nume;
    }

    public JTextField getAdresa() {
        return adresa;
    }

    public JTextField getCnp() {
        return cnp;
    }

    public JTextField getVarsta() {
        return varsta;
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
        gbc_table_1.gridheight = 4;
        gbc_table_1.gridwidth = 11;
        gbc_table_1.insets = new Insets(0, 0, 5, 5);
        gbc_table_1.fill = GridBagConstraints.BOTH;
        gbc_table_1.gridx = 0;
        gbc_table_1.gridy = 0;
        panel.add(js, gbc_table_1);
        panel.revalidate();
    }

    public JButton getBtnDelete() {
        return btnDelete;
    }

    public JButton getBtnEdit() {
        return btnEdit;
    }

    public JButton getInsertPerson() {
        return btnInsert;
    }

}