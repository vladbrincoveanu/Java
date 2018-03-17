import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class Interfata extends JFrame {

	/**
	 * nume folosite la JComboBox;
	 *
	 */
	private String[] names = { "Adunare", "Scadere", "Impartire", "Inmultire", "Derivare", "Integrare" };
	private JPanel contentPane;
	private JTextField textField;
	private JLabel lblIntroducetiPolinomul;
	private JLabel lblAfisari;
	private JScrollPane scrollPane;
	private JTextArea textArea;
	private JButton btnAdauga;
	private JComboBox<String> alegeOperatie = new JComboBox<String>(names);
	private JButton btnStart;
	private JLabel lblSelecteazaOperatia;
	private JButton btnClear;

	/**
	 * contructorul interfetei, foloseste BoxLayout,
	 * nu e resizable;
	 *
	 */
	public Interfata() {

		super("Polinoame");
		setSize(600, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 178, 255));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.PAGE_AXIS));

		lblAfisari = new JLabel("Afisari");
		lblAfisari.setHorizontalAlignment(SwingConstants.CENTER);
		scrollPane = new JScrollPane();
		scrollPane.setMaximumSize(new Dimension(450, 400));

		textArea = new JTextArea();
		textArea.setMinimumSize(new Dimension(450, 300));
		textArea.setEditable(false);
		textArea.setFont(new Font("Arial", 0, 20));
		textArea.setBackground(Color.LIGHT_GRAY);

		scrollPane.setViewportView(textArea);

		btnStart = new JButton("Start");
		btnClear = new JButton("Clear");

		lblIntroducetiPolinomul = new JLabel(" Introduceti polinomul in format: 3x^2+2x-1!!");
		lblIntroducetiPolinomul.setForeground(Color.RED);

		textField = new JTextField();
		textField.setMaximumSize(new Dimension(630, 200));

		btnAdauga = new JButton("Adauga");

		lblSelecteazaOperatia = new JLabel("Selecteaza Operatia");
		alegeOperatie.setForeground(Color.BLUE);

		contentPane.add(lblAfisari);
		contentPane.add(scrollPane);
		contentPane.add(textArea);
		contentPane.add(Box.createRigidArea(new Dimension(0, 10)));
		contentPane.add(btnClear);
		contentPane.add(Box.createRigidArea(new Dimension(0, 10)));
		contentPane.add(lblIntroducetiPolinomul);
		contentPane.add(textField);
		contentPane.add(Box.createRigidArea(new Dimension(0, 10)));
		contentPane.add(btnAdauga);
		contentPane.add(Box.createRigidArea(new Dimension(0, 10)));
		contentPane.add(lblSelecteazaOperatia);
		contentPane.add(alegeOperatie);
		contentPane.add(Box.createRigidArea(new Dimension(0, 10)));
		contentPane.add(btnStart);

		this.setVisible(true);
	}

	/**
	 * reseteaza campul textArea;
	 */
	void reset() {
		textArea.setText(null);
	}

	/**
	 *getter pentru textField
	 */
	String getUserInput() {
		return textField.getText();
	}

	/**
	 *setter pentru textArea de string
	 */
	void setText(String text) {
		textArea.append(text + "\n");
	}

	/**
	 *setter pentru textArea de Polinom
	 */
	void setTextPolinom(String s, Polinom a) {
		textArea.append(s);
		textArea.append(a.toString());
		textArea.append("\n");
	}

	/**
	 *getter pentru textField
	 */
	JComboBox<String> getComboBox() {
		return alegeOperatie;
	}

	/**
	 *getter pentru names
	 */
	String[] getStringFromComboBox() {
		return names;
	}

	/**
	 *pop-up error panel, foloseste
	 *JOptionPane
	 */
	void showError(String errMessage) {
		JOptionPane.showMessageDialog(this, errMessage);
	}
	
	/**
	 *ascultator pentru butonul adauga
	 */
	void addAdaugaListener(ActionListener adauga) {
		btnAdauga.addActionListener(adauga);
	}

	/**
	 *ascultator pentru butonul start
	 */
	void addStartListener(ActionListener start) {
		btnStart.addActionListener(start);
	}

	/**
	 *ascultator pentru butonul clear
	 */
	void addClearListener(ActionListener clear) {
		btnClear.addActionListener(clear);
	}

	/**
	 *ascultator pentru combo box
	 */
	void addJComboBoxListener(ActionListener comboBox) {
		alegeOperatie.addActionListener(comboBox);
	}

}
