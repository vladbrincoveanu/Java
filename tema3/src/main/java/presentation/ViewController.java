package presentation;

import javax.swing.JFrame;

public class ViewController {

	private Frame frame;
	private Logging logInPanel;
	private ViewClient clientPanel;
	private ViewProdus produsPanel;
	private ViewMain mainPanel;
	private LogIn logger;
	
	public void showFrame() {
		frame = new Frame();
		frame.setTitle("Warehouse");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 600);
		// frame.setLayout(new GridBagLayout());
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	public void showLogerPanel() {
		frame.getContentPane().removeAll();
		logger = new LogIn();
		frame.add(logger);
		frame.revalidate();
		//frame.pack();
	}
	
	public void showLogInPanel() {
		frame.getContentPane().removeAll();
		logInPanel = new Logging();
		frame.add(logInPanel);
		frame.revalidate();
		//frame.pack();
	}
	
	public void showClientPanel() {
		frame.getContentPane().removeAll();
		clientPanel = new ViewClient();
		frame.add(clientPanel);
		frame.revalidate();
		//frame.pack();
	}
	
	public void showProdusPanel() {
		frame.getContentPane().removeAll();
		produsPanel = new ViewProdus();
		frame.add(produsPanel);
		frame.revalidate();
		//frame.pack();
	}
	
	public void showMainPanel() {
		frame.getContentPane().removeAll();
		mainPanel = new ViewMain();
		frame.add(mainPanel);
		frame.revalidate();
		//frame.pack();
	}

	public LogIn getLogger() {
		return logger;
	}

	public Frame getFrame() {
		return frame;
	}

	public ViewClient getClientPanel() {
		return clientPanel;
	}

	public ViewProdus getProdusPanel() {
		return produsPanel;
	}

	public ViewMain getMainPanel() {
		return mainPanel;
	}

	public Logging getLogInPanel() {
		return logInPanel;
	}

	public void setLogInPanel(Logging logInPanel) {
		this.logInPanel = logInPanel;
	}
}
