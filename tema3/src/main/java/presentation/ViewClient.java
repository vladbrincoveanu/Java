package presentation;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class ViewClient extends JPanel {
	private JLabel lblName;
	private JLabel lblAddress;
	private JLabel lblAge;
	private JLabel lblEmail;
	private JTextField name;
	private JTable table;
	private JTextField address;
	private JTextField email;
	private JTextField age;
	private JButton btnDelete;
	private JButton insertClient;
	private JButton btnEdit;
	private JPanel panel;
	private JButton btnBack;

	/**
	 * Create the panel.
	 */
	public ViewClient() {
		//this.setSize(800, 600);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 81, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 64, 54, 56, 51, 88, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, 1.0, 1.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 1.0, 1.0, 1.0, 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblManagerClienti = new JLabel("Manager Clienti");
		GridBagConstraints gbc_lblManagerClienti = new GridBagConstraints();
		gbc_lblManagerClienti.insets = new Insets(0, 0, 5, 5);
		gbc_lblManagerClienti.gridx = 2;
		gbc_lblManagerClienti.gridy = 0;
		add(lblManagerClienti, gbc_lblManagerClienti);
		
		lblName = new JLabel("Name");
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.anchor = GridBagConstraints.EAST;
		gbc_lblName.insets = new Insets(0, 0, 5, 5);
		gbc_lblName.gridx = 1;
		gbc_lblName.gridy = 2;
		add(lblName, gbc_lblName);
		
		name = new JTextField();
		GridBagConstraints gbc_name = new GridBagConstraints();
		gbc_name.insets = new Insets(0, 0, 5, 5);
		gbc_name.fill = GridBagConstraints.HORIZONTAL;
		gbc_name.gridx = 2;
		gbc_name.gridy = 2;
		add(name, gbc_name);
		name.setColumns(10);
		
		panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridheight = 6;
		gbc_panel.gridwidth = 5;
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 3;
		gbc_panel.gridy = 1;
		add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
			
		lblAddress = new JLabel("Address");
		GridBagConstraints gbc_lblAddress = new GridBagConstraints();
		gbc_lblAddress.anchor = GridBagConstraints.EAST;
		gbc_lblAddress.insets = new Insets(0, 0, 5, 5);
		gbc_lblAddress.gridx = 1;
		gbc_lblAddress.gridy = 3;
		add(lblAddress, gbc_lblAddress);
		
		address = new JTextField();
		GridBagConstraints gbc_address = new GridBagConstraints();
		gbc_address.insets = new Insets(0, 0, 5, 5);
		gbc_address.fill = GridBagConstraints.HORIZONTAL;
		gbc_address.gridx = 2;
		gbc_address.gridy = 3;
		add(address, gbc_address);
		address.setColumns(10);
		
		lblEmail = new JLabel("Email");
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.anchor = GridBagConstraints.EAST;
		gbc_lblEmail.fill = GridBagConstraints.VERTICAL;
		gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmail.gridx = 1;
		gbc_lblEmail.gridy = 4;
		add(lblEmail, gbc_lblEmail);
		
		email = new JTextField();
		GridBagConstraints gbc_email = new GridBagConstraints();
		gbc_email.insets = new Insets(0, 0, 5, 5);
		gbc_email.fill = GridBagConstraints.HORIZONTAL;
		gbc_email.gridx = 2;
		gbc_email.gridy = 4;
		add(email, gbc_email);
		email.setColumns(10);
		
		lblAge = new JLabel("Age");
		GridBagConstraints gbc_lblAge = new GridBagConstraints();
		gbc_lblAge.anchor = GridBagConstraints.EAST;
		gbc_lblAge.insets = new Insets(0, 0, 5, 5);
		gbc_lblAge.gridx = 1;
		gbc_lblAge.gridy = 5;
		add(lblAge, gbc_lblAge);
		
		age = new JTextField();
		GridBagConstraints gbc_age = new GridBagConstraints();
		gbc_age.insets = new Insets(0, 0, 5, 5);
		gbc_age.fill = GridBagConstraints.HORIZONTAL;
		gbc_age.gridx = 2;
		gbc_age.gridy = 5;
		add(age, gbc_age);
		age.setColumns(10);
		
		insertClient = new JButton("Add");
		GridBagConstraints gbc_btnAdd = new GridBagConstraints();
		gbc_btnAdd.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnAdd.insets = new Insets(0, 0, 5, 5);
		gbc_btnAdd.gridx = 2;
		gbc_btnAdd.gridy = 8;
		add(insertClient, gbc_btnAdd);
		
		btnDelete = new JButton("Delete");
		GridBagConstraints gbc_btnDelete = new GridBagConstraints();
		gbc_btnDelete.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnDelete.insets = new Insets(0, 0, 5, 5);
		gbc_btnDelete.gridx = 3;
		gbc_btnDelete.gridy = 8;
		add(btnDelete, gbc_btnDelete);
		
		btnEdit = new JButton("Edit");
		GridBagConstraints gbc_btnEdit = new GridBagConstraints();
		gbc_btnEdit.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnEdit.insets = new Insets(0, 0, 5, 5);
		gbc_btnEdit.gridx = 4;
		gbc_btnEdit.gridy = 8;
		add(btnEdit, gbc_btnEdit);
		
		btnBack = new JButton("Back");
		GridBagConstraints gbc_btnBack = new GridBagConstraints();
		gbc_btnBack.insets = new Insets(0, 0, 5, 5);
		gbc_btnBack.gridx = 6;
		gbc_btnBack.gridy = 8;
		add(btnBack, gbc_btnBack);

	}
	
	public void addDeleteListener(ActionListener e){
		btnDelete.addActionListener(e);
	}
	
	public void addInsertListener(ActionListener e){
		insertClient.addActionListener(e);
	}
	
	public void addEditListener(ActionListener e){
		btnEdit.addActionListener(e);
	}

	public void addBtnBackListener(ActionListener e){
		btnBack.addActionListener(e);
	}
	
	public JTextField getNume() {
		return name;
	}

	public void setNume(JTextField name) {
		this.name = name;
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.panel.remove(table);
		this.table=table;
		JScrollPane js=new JScrollPane(table);
		js.setVisible(true);
		GridBagConstraints gbc_table = new GridBagConstraints();
		gbc_table.gridwidth = 11;
		gbc_table.gridheight = 4;
		gbc_table.insets = new Insets(0, 0, 5, 5);
		gbc_table.fill = GridBagConstraints.BOTH;
		gbc_table.gridx = 0;
		gbc_table.gridy = 0;
		panel.add(js, gbc_table);
		panel.revalidate();		
	}
	
	public JTextField getAddress() {
		return address;
	}

	public void setAddress(JTextField address) {
		this.address = address;
	}

	public JTextField getEmail() {
		return email;
	}

	public void setEmail(JTextField email) {
		this.email = email;
	}

	public JTextField getAge() {
		return age;
	}

	public void setAge(JTextField age) {
		this.age = age;
	}

	public JButton getBtnDelete() {
		return btnDelete;
	}

	public JButton getInsertClient() {
		return insertClient;
	}

	public JButton getBtnEdit() {
		return btnEdit;
	}
	
	public JButton getBtnBack(){
		return btnBack;
	}
	
	
}
