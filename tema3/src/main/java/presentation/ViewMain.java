package presentation;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import java.awt.Insets;
import java.awt.event.ActionListener;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class ViewMain extends JPanel {
	private JTable client;
	private JTable produs;
	private JTable comanda;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblCantitate;
	private JTextField cantitate;
	private JButton btnAdaugacomanda;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JButton btnBack;

	/**
	 * Create the panel.
	 */
	public ViewMain() {
		//this.setMinimumSize(new Dimension(800,600));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{215, 0, 0, 0, 0, 0, 0, 91, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		lblNewLabel = new JLabel("Clienti");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		add(lblNewLabel, gbc_lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Produse");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 5;
		gbc_lblNewLabel_1.gridy = 0;
		add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Comenzi");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 9;
		gbc_lblNewLabel_2.gridy = 0;
		add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 2;
		gbc_panel.gridheight = 12;
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 1;
		add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.gridheight = 12;
		gbc_panel_1.gridwidth = 6;
		gbc_panel_1.insets = new Insets(0, 0, 5, 5);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 2;
		gbc_panel_1.gridy = 1;
		add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0};
		gbl_panel_1.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
				
		panel_2= new JPanel();
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.gridheight = 12;
		gbc_panel_2.gridwidth = 2;
		gbc_panel_2.insets = new Insets(0, 0, 5, 0);
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 9;
		gbc_panel_2.gridy = 1;
		add(panel_2, gbc_panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{0, 0};
		gbl_panel_2.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_2.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		lblCantitate = new JLabel("Cantitate");
		GridBagConstraints gbc_lblCantitate = new GridBagConstraints();
		gbc_lblCantitate.insets = new Insets(0, 0, 5, 5);
		gbc_lblCantitate.gridx = 7;
		gbc_lblCantitate.gridy = 13;
		add(lblCantitate, gbc_lblCantitate);
		
		cantitate = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 9;
		gbc_textField.gridy = 13;
		add(cantitate, gbc_textField);
		cantitate.setColumns(10);
		
		btnAdaugacomanda = new JButton("AdaugaComanda");
		GridBagConstraints gbc_btnAdaugacomanda = new GridBagConstraints();
		gbc_btnAdaugacomanda.insets = new Insets(0, 0, 0, 5);
		gbc_btnAdaugacomanda.gridx = 7;
		gbc_btnAdaugacomanda.gridy = 14;
		add(btnAdaugacomanda, gbc_btnAdaugacomanda);
		
		btnBack = new JButton("Back");
		GridBagConstraints gbc_btnBack = new GridBagConstraints();
		gbc_btnBack.insets = new Insets(0, 0, 0, 5);
		gbc_btnBack.gridx = 9;
		gbc_btnBack.gridy = 14;
		add(btnBack, gbc_btnBack);

	}
	
	public void addComandaListener(ActionListener e){
		btnAdaugacomanda.addActionListener(e);
	}
	
	public void addBtnBackListenr(ActionListener e){
		btnBack.addActionListener(e);
	}

	public JTable getTable() {
		return client;
	}

	public void setTable(JTable client) {
		this.panel.remove(client);
		this.client = client;
		JScrollPane js=new JScrollPane(client);
		js.setVisible(true);
		GridBagConstraints gbc_table = new GridBagConstraints();
		gbc_table.gridheight = 6;
		gbc_table.gridwidth = 4;
		gbc_table.fill = GridBagConstraints.BOTH;
		gbc_table.gridx = 0;
		gbc_table.gridy = 0;
		panel.add(js, gbc_table);
		panel.revalidate();		
	}

	public JTable getTable_1() {
		return produs;
	}

	public void setTable_1(JTable produs) {
		this.panel_1.remove(produs);
		this.produs = produs;
		JScrollPane js=new JScrollPane(produs);
		js.setVisible(true);
		GridBagConstraints gbc_table_1 = new GridBagConstraints();
		gbc_table_1.fill = GridBagConstraints.BOTH;
		gbc_table_1.gridx = 0;
		gbc_table_1.gridy = 0;
		panel_1.add(js, gbc_table_1);
		panel_1.revalidate();		
	}

	public JTable getTable_2() {
		return comanda;
	}

	public void setTable_2(JTable comanda) {
		this.panel_2.remove(comanda);
		this.comanda = comanda;
		JScrollPane js=new JScrollPane(comanda);
		js.setVisible(true);
		GridBagConstraints gbc_table_2 = new GridBagConstraints();
		gbc_table_2.gridheight = 7;
		gbc_table_2.fill = GridBagConstraints.BOTH;
		gbc_table_2.gridx = 0;
		gbc_table_2.gridy = 0;
		panel_2.add(js, gbc_table_2);
		panel_2.revalidate();	
	}

	public JTextField getCantitate() {
		return cantitate;
	}
	
	public JButton getBtnBack(){
		return btnBack;
	}
}
