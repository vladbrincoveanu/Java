package tema2;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.GridBagConstraints;
import javax.swing.JProgressBar;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class View extends JFrame{
	/**
 	* 
    */
	private ArrayList<JProgressBar> jpb = new ArrayList<JProgressBar>();
	private JPanel contentPane;
	private JLabel label;
	private JProgressBar progressBar;
	private GridBagLayout gbl_contentPane;
	private JPanel settingsPanel;
	private GridBagConstraints gbc_settingsPanel;
	private GridBagLayout gbl_settingsPanel;
	private JLabel lblMinInterval;
	private JTextField minIntevalTextArea;
	private JTextField maxIntervalTextArea;
	private JTextField minServiceTimeTextArea;
	private JTextField maxServiceTimeTextArea;
	private JTextField nbOfQueuesTextArea;
	private JTextField simIntervalTextArea;
	private JLabel lblSimTimeShow;
	private JLabel lblMaximumInterval;
	private JLabel lblMaximumServicetime;
	private JButton btnStart;
	private JButton btnReset;
	private JLabel lblLog;
	private JScrollPane scrollPane_1;
	private JTextArea logTextArea;
	private JPanel queueViewPanel;
	private JScrollPane scrollPane;
	private JPanel queuesPanel;
	private int nbOfQueues;
	private JLabel lblMinimumServicetime;
	private JButton btnSet;

	public View() {
		super("Simulator cozi");
		this.setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		setContentPane(contentPane);
		gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 480, 320 };
		gbl_contentPane.rowHeights = new int[] { 580, 0 };
		contentPane.setLayout(gbl_contentPane);

		settingsPanel = new JPanel();
		gbc_settingsPanel = new GridBagConstraints();
		gbc_settingsPanel.fill = GridBagConstraints.BOTH;
		contentPane.add(settingsPanel, gbc_settingsPanel);
		gbl_settingsPanel = new GridBagLayout();
		gbl_settingsPanel.columnWeights = new double[] { 0.0, 0.0, 1.0 };
		gbl_settingsPanel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				1.0, 0.0, 0.0 };
		settingsPanel.setLayout(gbl_settingsPanel);

		lblMinInterval = new JLabel("Minimal Interval(ms)");
		GridBagConstraints gbc_lblMinInterval = new GridBagConstraints();
		gbc_lblMinInterval.insets = new Insets(0, 0, 5, 5);
		gbc_lblMinInterval.gridx = 1;
		gbc_lblMinInterval.gridy = 1;
		settingsPanel.add(lblMinInterval, gbc_lblMinInterval);

		minIntevalTextArea = new JTextField(10);
		minIntevalTextArea.setText("200");
		GridBagConstraints gbc_minIntevalTextArea = new GridBagConstraints();
		gbc_minIntevalTextArea.insets = new Insets(0, 0, 5, 0);
		gbc_minIntevalTextArea.fill = GridBagConstraints.HORIZONTAL;
		gbc_minIntevalTextArea.gridx = 2;
		gbc_minIntevalTextArea.gridy = 1;
		settingsPanel.add(minIntevalTextArea, gbc_minIntevalTextArea);

		lblMaximumInterval = new JLabel("MaximumInterval(ms)");
		GridBagConstraints gbc_lblMaximumInterval = new GridBagConstraints();
		gbc_lblMaximumInterval.insets = new Insets(0, 0, 5, 5);
		gbc_lblMaximumInterval.gridx = 1;
		gbc_lblMaximumInterval.gridy = 2;
		settingsPanel.add(lblMaximumInterval, gbc_lblMaximumInterval);

		maxIntervalTextArea = new JTextField(10);
		maxIntervalTextArea.setText("400");
		GridBagConstraints gbc_maxIntervalTextArea = new GridBagConstraints();
		gbc_maxIntervalTextArea.insets = new Insets(0, 0, 5, 0);
		gbc_maxIntervalTextArea.fill = GridBagConstraints.HORIZONTAL;
		gbc_maxIntervalTextArea.gridx = 2;
		gbc_maxIntervalTextArea.gridy = 2;
		settingsPanel.add(maxIntervalTextArea, gbc_maxIntervalTextArea);

		lblMinimumServicetime = new JLabel("Minimum ServiceTime(ms)");
		GridBagConstraints gbc_lblMinimumServicetime = new GridBagConstraints();
		gbc_lblMinimumServicetime.insets = new Insets(0, 0, 5, 5);
		gbc_lblMinimumServicetime.gridx = 1;
		gbc_lblMinimumServicetime.gridy = 3;
		settingsPanel.add(lblMinimumServicetime, gbc_lblMinimumServicetime);

		minServiceTimeTextArea = new JTextField(10);
		minServiceTimeTextArea.setText("100");
		GridBagConstraints gbc_minServiceTimeTextArea = new GridBagConstraints();
		gbc_minServiceTimeTextArea.insets = new Insets(0, 0, 5, 0);
		gbc_minServiceTimeTextArea.fill = GridBagConstraints.HORIZONTAL;
		gbc_minServiceTimeTextArea.gridx = 2;
		gbc_minServiceTimeTextArea.gridy = 3;
		settingsPanel.add(minServiceTimeTextArea, gbc_minServiceTimeTextArea);

		lblMaximumServicetime = new JLabel("Maximum ServiceTime(ms)");
		GridBagConstraints gbc_lblMaximumServicetime = new GridBagConstraints();
		gbc_lblMaximumServicetime.insets = new Insets(0, 0, 5, 5);
		gbc_lblMaximumServicetime.gridx = 1;
		gbc_lblMaximumServicetime.gridy = 4;
		settingsPanel.add(lblMaximumServicetime, gbc_lblMaximumServicetime);

		maxServiceTimeTextArea = new JTextField(10);
		maxServiceTimeTextArea.setText("500");
		GridBagConstraints gbc_maxServiceTimeTextArea = new GridBagConstraints();
		gbc_maxServiceTimeTextArea.insets = new Insets(0, 0, 5, 0);
		gbc_maxServiceTimeTextArea.fill = GridBagConstraints.HORIZONTAL;
		gbc_maxServiceTimeTextArea.gridx = 2;
		gbc_maxServiceTimeTextArea.gridy = 4;
		settingsPanel.add(maxServiceTimeTextArea, gbc_maxServiceTimeTextArea);

		JLabel lblNumberOfQueues = new JLabel("Number of Queues");
		GridBagConstraints gbc_lblNumberOfQueues = new GridBagConstraints();
		gbc_lblNumberOfQueues.insets = new Insets(0, 0, 5, 5);
		gbc_lblNumberOfQueues.gridx = 1;
		gbc_lblNumberOfQueues.gridy = 5;
		settingsPanel.add(lblNumberOfQueues, gbc_lblNumberOfQueues);

		nbOfQueuesTextArea = new JTextField(10);
		nbOfQueuesTextArea.setText("5");
		GridBagConstraints gbc_nbOfQueuesTextArea = new GridBagConstraints();
		gbc_nbOfQueuesTextArea.insets = new Insets(0, 0, 5, 0);
		gbc_nbOfQueuesTextArea.fill = GridBagConstraints.HORIZONTAL;
		gbc_nbOfQueuesTextArea.gridx = 2;
		gbc_nbOfQueuesTextArea.gridy = 5;
		settingsPanel.add(nbOfQueuesTextArea, gbc_nbOfQueuesTextArea);

		JLabel lblSimulationInterval = new JLabel("Simulation Interval(ms)");
		GridBagConstraints gbc_lblSimulationInterval = new GridBagConstraints();
		gbc_lblSimulationInterval.insets = new Insets(0, 0, 5, 5);
		gbc_lblSimulationInterval.gridx = 1;
		gbc_lblSimulationInterval.gridy = 6;
		settingsPanel.add(lblSimulationInterval, gbc_lblSimulationInterval);

		simIntervalTextArea = new JTextField(10);
		simIntervalTextArea.setText("100000");
		GridBagConstraints gbc_simIntervalTextArea = new GridBagConstraints();
		gbc_simIntervalTextArea.insets = new Insets(0, 0, 5, 0);
		gbc_simIntervalTextArea.fill = GridBagConstraints.HORIZONTAL;
		gbc_simIntervalTextArea.gridx = 2;
		gbc_simIntervalTextArea.gridy = 6;
		settingsPanel.add(simIntervalTextArea, gbc_simIntervalTextArea);

		JLabel lblSimtime = new JLabel("SimTime(ms)");
		GridBagConstraints gbc_lblSimtime = new GridBagConstraints();
		gbc_lblSimtime.insets = new Insets(0, 0, 5, 5);
		gbc_lblSimtime.gridx = 1;
		gbc_lblSimtime.gridy = 7;
		settingsPanel.add(lblSimtime, gbc_lblSimtime);

		lblSimTimeShow = new JLabel("");
		lblSimTimeShow.setForeground(Color.RED);
		GridBagConstraints gbc_simTimeShow = new GridBagConstraints();
		gbc_simTimeShow.insets = new Insets(0, 0, 5, 0);
		gbc_simTimeShow.fill = GridBagConstraints.HORIZONTAL;
		gbc_simTimeShow.gridx = 2;
		gbc_simTimeShow.gridy = 7;
		settingsPanel.add(lblSimTimeShow, gbc_simTimeShow);

		btnSet = new JButton("Set");
		GridBagConstraints gbc_btnSet = new GridBagConstraints();
		gbc_btnSet.insets = new Insets(0, 0, 5, 5);
		gbc_btnSet.gridx = 1;
		gbc_btnSet.gridy = 8;
		settingsPanel.add(btnSet, gbc_btnSet);

		btnStart = new JButton("Start");
		GridBagConstraints gbc_btnStart = new GridBagConstraints();
		gbc_btnStart.insets = new Insets(0, 0, 5, 5);
		gbc_btnStart.gridx = 1;
		gbc_btnStart.gridy = 9;
		settingsPanel.add(btnStart, gbc_btnStart);

		btnReset = new JButton("Reset");
		GridBagConstraints gbc_btnReset = new GridBagConstraints();
		gbc_btnReset.insets = new Insets(0, 0, 5, 0);
		gbc_btnReset.gridx = 2;
		gbc_btnReset.gridy = 9;
		settingsPanel.add(btnReset, gbc_btnReset);

		lblLog = new JLabel("Log");
		GridBagConstraints gbc_lblLog = new GridBagConstraints();
		gbc_lblLog.insets = new Insets(0, 0, 5, 5);
		gbc_lblLog.gridx = 1;
		gbc_lblLog.gridy = 11;
		settingsPanel.add(lblLog, gbc_lblLog);

		scrollPane_1 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.gridheight = 4;
		gbc_scrollPane_1.gridwidth = 2;
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridx = 1;
		gbc_scrollPane_1.gridy = 12;
		settingsPanel.add(scrollPane_1, gbc_scrollPane_1);

		logTextArea = new JTextArea();
		logTextArea.setEditable(false);
		logTextArea.setFont(new Font("Arial", 0, 15));
		logTextArea.setForeground(Color.BLACK);
		logTextArea.setBackground(Color.LIGHT_GRAY);
		scrollPane_1.setViewportView(logTextArea);

		// partea dreapta a ecranului
		queueViewPanel = new JPanel();
		GridBagConstraints gbc_queueViewPanel = new GridBagConstraints();
		gbc_queueViewPanel.fill = GridBagConstraints.BOTH;
		gbc_queueViewPanel.gridx = 1;
		gbc_queueViewPanel.gridy = 0;
		contentPane.add(queueViewPanel, gbc_queueViewPanel);

		GridBagLayout gbl_queueViewPanel = new GridBagLayout();
		gbl_queueViewPanel.columnWidths = new int[] { 0, 0 };
		gbl_queueViewPanel.rowHeights = new int[] { 0, 0 };
		gbl_queueViewPanel.columnWeights = new double[] { 1.0 };
		gbl_queueViewPanel.rowWeights = new double[] { 1.0 };
		queueViewPanel.setLayout(gbl_queueViewPanel);

		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		queueViewPanel.add(scrollPane, gbc_scrollPane);

		JLabel lblHeader = new JLabel("Simulation of Queues");
		lblHeader.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeader.setForeground(Color.BLUE);
		scrollPane.setColumnHeaderView(lblHeader);

		queuesPanel = new JPanel();
		scrollPane.setViewportView(queuesPanel);
		GridBagLayout gbl_queuesPanel = new GridBagLayout();
		gbl_queuesPanel.columnWidths = new int[] { 35, 200, 0 };
		gbl_queuesPanel.rowHeights = new int[] { 0, 0, 0, 0 };
		gbl_queuesPanel.columnWeights = new double[] { 0.0, 1.0 };
		gbl_queuesPanel.rowWeights = new double[] { 0.0, 0.0, 0.0 };
		queuesPanel.setLayout(gbl_queuesPanel);

		this.setVisible(true);
	}

	/**
	 * reseteaza textArea, SimTime-ul si progressBarurile
	 */
	public void resetView() {
		for (JProgressBar b : jpb) {
			b.setValue(0);
		}
		logTextArea.setText(null);
		lblSimTimeShow.setText(null);
	}

	/**
	 * afiseaza un pop up cu mesaj de eroare
	 */
	void showError(String errMessage) {
		JOptionPane.showMessageDialog(this, errMessage);
	}

	void startListener(ActionListener start) {
		btnStart.addActionListener(start);
	}

	void restartListener(ActionListener restart) {
		btnReset.addActionListener(restart);
	}

	void setListener(ActionListener set) {
		btnSet.addActionListener(set);
	}

	public String getMinIntevalTextArea() {
		return minIntevalTextArea.getText();
	}

	public String getMaxIntervalTextArea() {
		return maxIntervalTextArea.getText();
	}

	public String getMinServiceTimeTextArea() {
		return minServiceTimeTextArea.getText();
	}

	public String getMaxServiceTimeTextArea() {
		return maxServiceTimeTextArea.getText();
	}

	public String getNbOfQueuesTextArea() {
		return nbOfQueuesTextArea.getText();
	}

	public String getSimIntervalTextArea() {
		return simIntervalTextArea.getText();
	}

	public String getSimTimeText() {
		return lblSimTimeShow.getText();
	}

	public void setSimTime(String simTimeTextArea) {
		this.lblSimTimeShow.setText(simTimeTextArea);
	}

	public void setLogNull(){
		logTextArea.setText(null);
	}
	
	public void setLog(String s) {
		logTextArea.setText(s);
	}

	public int getNbOfQueues() {
		return nbOfQueues;
	}

	public void setNbOfQueues(int nbOfQueues) {
		this.nbOfQueues = nbOfQueues;
	}

	public ArrayList<JProgressBar> getJpb() {
		return jpb;
	}

	/**
	 * contruieste progressBarurile in functie de cate queue-uri 
	 * introduce utilizatorul
	 */
	public void setQueues(int nb) {
		GridBagConstraints gbc_label = new GridBagConstraints();
		GridBagConstraints gbc_progressBar = new GridBagConstraints();
		for (int i = 1; i <= nb; i++) {
			label = new JLabel("Queue[" + i + "] ");
			gbc_label.gridx = 0;
			gbc_label.gridy = i;
			queuesPanel.add(label, gbc_label);
			progressBar = new JProgressBar();
			progressBar.setStringPainted(true);
			progressBar.setMaximum(10);
			gbc_progressBar.fill = GridBagConstraints.BOTH;
			gbc_progressBar.gridx = 1;
			gbc_progressBar.gridy = i;
			queuesPanel.add(progressBar, gbc_progressBar);
			jpb.add(progressBar);
		}
	}
}
