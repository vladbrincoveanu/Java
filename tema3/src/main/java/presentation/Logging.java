package presentation;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class Logging extends JPanel {
	private JButton client;
	private JButton btnProdus;
	private JButton comanda;

	/**
	 * Create the panel.
	 */
	public Logging() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, -34, 368, 251, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		client = new JButton("Client");
		GridBagConstraints gbc_client = new GridBagConstraints();
		gbc_client.fill = GridBagConstraints.HORIZONTAL;
		gbc_client.insets = new Insets(0, 0, 5, 5);
		gbc_client.gridx = 6;
		gbc_client.gridy = 4;
		add(client, gbc_client);
		
		btnProdus = new JButton("Produs");
		GridBagConstraints gbc_btnProdus = new GridBagConstraints();
		gbc_btnProdus.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnProdus.insets = new Insets(0, 0, 5, 5);
		gbc_btnProdus.gridx = 6;
		gbc_btnProdus.gridy = 6;
		add(btnProdus, gbc_btnProdus);
		
		comanda = new JButton("Comanda");
		GridBagConstraints gbc_comanda = new GridBagConstraints();
		gbc_comanda.fill = GridBagConstraints.HORIZONTAL;
		gbc_comanda.insets = new Insets(0, 0, 5, 5);
		gbc_comanda.gridx = 6;
		gbc_comanda.gridy = 8;
		add(comanda, gbc_comanda);

	}
	
	public void addClientListener(ActionListener e){
		client.addActionListener(e);
	}
	
	public void addProdusListener(ActionListener e){
		btnProdus.addActionListener(e);
	}
	
	public void addComandaListener(ActionListener e){
		comanda.addActionListener(e);
	}
	
}
