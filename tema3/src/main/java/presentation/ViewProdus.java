package presentation;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class ViewProdus extends JPanel {
	private JLabel lblName;
	private JTextField nume;
	private JTable table;
	private JTextField cantitate;
	private JButton btnDelete;
	private JButton btnEdit;
	private JLabel lblCantitate;
	private JPanel panel; 
	private JButton insertProdus;
	private JButton btnBack;
	/**
	 * Create the panel.
	 */
	public ViewProdus() {
		this.setSize(800, 600);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 81, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 64, 54, 56, 51, 88, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, 1.0, 1.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 1.0, 1.0, 1.0, 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblManagerClienti = new JLabel("Manager Produse");
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
		
		nume = new JTextField();
		GridBagConstraints gbc_nume = new GridBagConstraints();
		gbc_nume.insets = new Insets(0, 0, 5, 5);
		gbc_nume.fill = GridBagConstraints.HORIZONTAL;
		gbc_nume.gridx = 2;
		gbc_nume.gridy = 2;
		add(nume, gbc_nume);
		nume.setColumns(10);
		
		panel= new JPanel();
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
		
		lblCantitate = new JLabel("Cantitate");
		GridBagConstraints gbc_lblCantitate = new GridBagConstraints();
		gbc_lblCantitate.insets = new Insets(0, 0, 5, 5);
		gbc_lblCantitate.anchor = GridBagConstraints.EAST;
		gbc_lblCantitate.gridx = 1;
		gbc_lblCantitate.gridy = 3;
		add(lblCantitate, gbc_lblCantitate);
		
		cantitate = new JTextField();
		GridBagConstraints gbc_address = new GridBagConstraints();
		gbc_address.insets = new Insets(0, 0, 5, 5);
		gbc_address.fill = GridBagConstraints.HORIZONTAL;
		gbc_address.gridx = 2;
		gbc_address.gridy = 3;
		add(cantitate, gbc_address);
		cantitate.setColumns(10);
		
		insertProdus = new JButton("Add");
		GridBagConstraints gbc_btnAddstoc = new GridBagConstraints();
		gbc_btnAddstoc.insets = new Insets(0, 0, 5, 5);
		gbc_btnAddstoc.gridx = 2;
		gbc_btnAddstoc.gridy = 8;
		add(insertProdus, gbc_btnAddstoc);
		
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
		gbc_btnBack.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnBack.insets = new Insets(0, 0, 5, 0);
		gbc_btnBack.gridx = 7;
		gbc_btnBack.gridy = 8;
		add(btnBack, gbc_btnBack);

	}


	public void addDeleteListener(ActionListener e){
		btnDelete.addActionListener(e);
	}
	
	public void addInsertListener(ActionListener e){
		insertProdus.addActionListener(e);
	}
	
	public void addEditListener(ActionListener e){
		btnEdit.addActionListener(e);
	}

	public void addBtnBackListenr(ActionListener e){
		btnBack.addActionListener(e);
	}
	
	public JTextField getNume() {
		return nume;
	}

	public JButton getBtnBack(){
		return btnBack;
	}
	
	public void setNume(JTextField nume) {
		this.nume = nume;
	}


	public JTable getTable() {
		return table;
	}


	public void setTable(JTable table) {
		this.panel.remove(table);
		this.table = table;
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


	public JTextField getCantitate() {
		return cantitate;
	}


	public void setCantitate(JTextField cant) {
		this.cantitate = cant;
	}


	public JButton getBtnDelete() {
		return btnDelete;
	}


	public void setBtnDelete(JButton btnDelete) {
		this.btnDelete = btnDelete;
	}


	public JButton getBtnEdit() {
		return btnEdit;
	}


	public void setBtnEdit(JButton btnEdit) {
		this.btnEdit = btnEdit;
	}


	public JButton getInsertProdus() {
		return insertProdus;
	}


	public void setInsertProdus(JButton insertProdus) {
		this.insertProdus = insertProdus;
	}

}

