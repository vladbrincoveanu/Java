package presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;

import bll.*;
import bll.SendEmail;
import com.itextpdf.text.DocumentException;
import com.zaxxer.hikari.HikariDataSource;
import connection.ConnectionFactory;
import model.Comanda;
import model.HelpClass;
import model.Produs;
import model.Stoc;
import model.Student;

public class AppController {

	private StudentBLL student;
	private ProdusBLL produs;
	private ComandaBLL comanda;
	private StocBLL stoc;
	private ViewController viewController;
	private ToPdf toPdf;
	public int contorChitante = 0;

	public AppController() {
		viewController = new ViewController();
		student = new StudentBLL();
		produs = new ProdusBLL();
		stoc = new StocBLL();
		comanda = new ComandaBLL();
		toPdf = new ToPdf();
		drawFrame();
		drawLoggerPanel();
	}

	private void drawFrame() {
		SwingUtilities.invokeLater(new Runnable() {

			public void run() {
				viewController.showFrame();
			}
		});
	}

	private void drawLoggerPanel() {
		SwingUtilities.invokeLater(new Runnable() {

			public void run() {
				viewController.showLogerPanel();
				addLogInListener();
			}
		});
	}

	private void drawLoggingPanel() {
		SwingUtilities.invokeLater(new Runnable() {

			public void run() {
				viewController.showLogInPanel();
				addClientListener();
				addProdusListener();
				addComandaListener();
			}
		});
	}

	private void drawClientPanel() {
		SwingUtilities.invokeLater(new Runnable() {

			public void run() {
				viewController.showClientPanel();
				addDeleteListener();
				addInsertListener();
				addEditListener();
				redrawJTable();
				addBackToMainListenerFromClient();

			}
		});
	}

	private void drawProductPanel() {
		SwingUtilities.invokeLater(new Runnable() {

			public void run() {
				viewController.showProdusPanel();
				addDelete1Listener();
				addInsert1Listener();
				addEdit1Listener();
				redrawJTable1();
				addBackToMainListenerFromProdus();
			}
		});
	}

	private void drawMainPanel() {
		SwingUtilities.invokeLater(new Runnable() {

			public void run() {
				viewController.showMainPanel();
				addComandaMainListener();
				redrawMainJTable();
				addBackToMainListenerFromMain();

			}
		});
	}

	private void addLogInListener(){
		viewController.getLogger().addLogInListener(new LoginListener());
	}

	// Login PANEL
	private void addClientListener() {
		viewController.getLogInPanel().addClientListener(new OpenClientPanel());
	}

	private void addProdusListener() {
		viewController.getLogInPanel().addProdusListener(new OpenProdusPanel());
	}

	private void addComandaListener() {
		viewController.getLogInPanel().addComandaListener(new OpenMainPanel());
	}

	private class OpenClientPanel implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			drawClientPanel();
		}
	}

	private class OpenProdusPanel implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			drawProductPanel();
		}
	}

	private class OpenMainPanel implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			drawMainPanel();
		}
	}

	// CLIENT PANEL
	private void addDeleteListener() {
		viewController.getClientPanel().addDeleteListener(new deleteMetod());
	}

	private void addInsertListener() {
		viewController.getClientPanel().addInsertListener(new insertMetod());
	}

	private void addEditListener() {
		viewController.getClientPanel().addEditListener(new editMetod());
	}

	private void addBackToMainListenerFromClient() {
		viewController.getClientPanel().addBtnBackListener(new BackListener());
	}

	// Product PANEL
	private void addDelete1Listener() {
		viewController.getProdusPanel().addDeleteListener(new deleteMetod());
	}

	private void addInsert1Listener() {
		viewController.getProdusPanel().addInsertListener(new insertMetod());
	}

	private void addEdit1Listener() {
		viewController.getProdusPanel().addEditListener(new editMetod());
	}

	private void addBackToMainListenerFromProdus() {
		viewController.getProdusPanel().addBtnBackListenr(new BackListener());
	}

	// MAIN PANEL
	private void addComandaMainListener() {
		viewController.getMainPanel().addComandaListener(new ecomandaMetod());
	}

	private void addBackToMainListenerFromMain() {
		viewController.getMainPanel().addBtnBackListenr(new BackListener());
	}

	private void redrawJTable1() {
		ArrayList<Produs> resultSet = produs.showProdusInfo();
		ArrayList<Stoc> resultSet2 = stoc.showStocInfo();

		ArrayList<HelpClass> rs = new ArrayList<HelpClass>();
		ArrayList<?> a = rs;
		for (Produs p : resultSet) {
			for (Stoc s : resultSet2) {
				if (p.getId() == s.getIdProdus()) {
					rs.add(new HelpClass(p.getId(), p.getName(), s.getCantitate()));
				}
			}
		}
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				viewController.getProdusPanel().setTable(createTable(a));
			}
		});
	}

	private void redrawMainJTable() {
		ArrayList<?> order = comanda.showInfo();
		ArrayList<Produs> resultSet1 = produs.showProdusInfo();
		ArrayList<Stoc> resultSet2 = stoc.showStocInfo();
		ArrayList<?> client = student.showStudentInfo();
		ArrayList<HelpClass> rs = new ArrayList<HelpClass>();
		ArrayList<?> produse = rs;
		for (Produs p : resultSet1) {
			for (Stoc s : resultSet2) {
				if (p.getId() == s.getIdProdus()) {
					rs.add(new HelpClass(p.getId(), p.getName(), s.getCantitate()));
				}
			}
		}
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				if (!order.isEmpty())
					viewController.getMainPanel().setTable_2(createTable(order));
				viewController.getMainPanel().setTable_1(createTable(produse));
				viewController.getMainPanel().setTable(createTable(client));
			}
		});
	}

	private void redrawJTable() {
		ArrayList<?> resultSet = student.showStudentInfo();
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				viewController.getClientPanel().setTable(createTable(resultSet));
			}
		});
	}

	private class LoginListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String email = viewController.getLogger().getLblUser().getText();
			String password = viewController.getLogger().getPasswordField().getText();
			HikariDataSource connection=null;
			connection =ConnectionFactory.dataSource(email,password);
			if(connection != null){
				drawLoggingPanel();
			}else {
				JOptionPane.showConfirmDialog(null, "nu s-a conectat la server", null, JOptionPane.INFORMATION_MESSAGE);
			}
			ConnectionFactory.close(connection);
		}
	}

	private class BackListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			drawLoggingPanel();
		}
	}

	private class deleteMetod implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (viewController.getClientPanel() != null
					&& e.getSource().equals(viewController.getClientPanel().getBtnDelete())) {
				int index = viewController.getClientPanel().getTable().getSelectedRow();
				Student st = student.showStudentInfo().get(index);
				student.deleteStudent(st.getId());
				drawClientPanel();
			} else if (viewController.getProdusPanel() != null
					&& e.getSource().equals(viewController.getProdusPanel().getBtnDelete())) {
				int index = viewController.getProdusPanel().getTable().getSelectedRow();
				Produs pr = produs.showProdusInfo().get(index);
				stoc.deleteStoc(pr.getId());
				produs.deleteProdus(pr.getId());
				drawProductPanel();
			}
		}
	}

	private class insertMetod implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (viewController.getClientPanel() != null
					&& e.getSource().equals(viewController.getClientPanel().getInsertClient())) {
				String nume = viewController.getClientPanel().getNume().getText();
				String adresa = viewController.getClientPanel().getAddress().getText();
				String email = viewController.getClientPanel().getEmail().getText();
				Integer age = Integer.parseInt(viewController.getClientPanel().getAge().getText());
				try {
					student.insertStudent(new Student(nume, adresa, email, age));
				} catch (IllegalArgumentException e2) {
					JOptionPane.showMessageDialog(null, e2.getMessage(), null, JOptionPane.INFORMATION_MESSAGE);
				}
				drawClientPanel();
			} else if (viewController.getProdusPanel() != null
					&& e.getSource().equals(viewController.getProdusPanel().getInsertProdus())) {
				String nume = viewController.getProdusPanel().getNume().getText();
				Integer cantitate = Integer.parseInt(viewController.getProdusPanel().getCantitate().getText());
				Produs p = new Produs(nume);
				try {
					int index = produs.insertProdus(p);
					stoc.insertStoc(new Stoc(index, cantitate));
				} catch (IllegalArgumentException e3) {
					JOptionPane.showMessageDialog(null, e3.getMessage(), null, JOptionPane.INFORMATION_MESSAGE);
				}
				drawProductPanel();
			}
		}
	}

	private class editMetod implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (viewController.getClientPanel() != null
					&& e.getSource().equals(viewController.getClientPanel().getBtnEdit())) {
				int index = viewController.getClientPanel().getTable().getSelectedRow();
				Student st = student.showStudentInfo().get(index);
				String nume = viewController.getClientPanel().getNume().getText();
				String adresa = viewController.getClientPanel().getAddress().getText();
				String email = viewController.getClientPanel().getEmail().getText();
				Integer age = Integer.parseInt(viewController.getClientPanel().getAge().getText());
				try {
					student.updateStudent(new Student(st.getId(), nume, adresa, email, age));
				} catch (IllegalArgumentException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(), null, JOptionPane.INFORMATION_MESSAGE);
				}
				redrawJTable();
			} else if (viewController.getProdusPanel() != null
					&& e.getSource().equals(viewController.getProdusPanel().getBtnEdit())) {
				int ind = viewController.getProdusPanel().getTable().getSelectedRow();
				Produs pt = produs.showProdusInfo().get(ind);
				String nume = viewController.getProdusPanel().getNume().getText();
				Integer cantitate = Integer.parseInt(viewController.getProdusPanel().getCantitate().getText());
				try {
					produs.updateProdus(new Produs(pt.getId(), nume));
					stoc.updateStoc(new Stoc(pt.getId(), cantitate));
				} catch (IllegalArgumentException e2) {
					JOptionPane.showMessageDialog(null, e2.getMessage(), null, JOptionPane.INFORMATION_MESSAGE);
				}
				drawProductPanel();
			}
		}
	}

	private class ecomandaMetod implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			int indexClient = viewController.getMainPanel().getTable().getSelectedRow();
			int indexProdus = viewController.getMainPanel().getTable_1().getSelectedRow();
			Produs pt = produs.showProdusInfo().get(indexProdus);
			Student st = student.showStudentInfo().get(indexClient);
			Stoc a = stoc.showStocInfo().get(indexProdus);
			Integer cantitate = Integer.parseInt(viewController.getMainPanel().getCantitate().getText());
			if (cantitate > 0) {
				try {
					stoc.updateStoc(new Stoc(pt.getId(), a.getCantitate() - cantitate));
					comanda.insertComanda(new Comanda(st.getId(), pt.getId(), cantitate));
					String RESULT
							= "C:\\Users\\Vlad\\Desktop\\Chitanta[" + contorChitante + "] ---- " + st.getName()+".pdf";
					toPdf.createPdf(RESULT,toPdf.createFirstTable(contorChitante,st,pt,cantitate));
					BufferedWriter out = null;
					String fisier = null;
					// Recipient's email ID needs to be mentioned.
					String to = st.getEmail();

					// Sender's email ID needs to be mentioned
					String from = "gg.vladbrincoveanu@gmail.com";

					// Assuming you are sending email from localhost
					String host = "localhost";
					SendEmail.sendEmail(host,to,from,RESULT);
					try {
						fisier = new String("Chitanta[" + contorChitante + "] ---- " + st.getName() + ".txt");
						FileWriter f = new FileWriter(fisier, false);
						contorChitante++;
						out = new BufferedWriter(f);
						out.write("Informatii client");
						out.newLine();
						out.write("Nume = " + st.getName());
						out.newLine();
						out.write("Adresa =" + st.getAddress());
						out.newLine();
						out.write("Email =" + st.getEmail());
						out.newLine();
						out.write("Varsta =" + st.getAge());
						out.newLine();
						out.newLine();
						out.write("Informatii produs");
						out.newLine();
						out.write("Nume =" + pt.getName());
						out.newLine();
						out.write("Cantitate =" + cantitate);
					} catch (IOException e11) {
						System.err.println("Error: " + e11.getMessage());
					} finally {
						if (out != null) {
							try {
								out.close();
							} catch (IOException e21) {
								e21.printStackTrace();
							}
						}
					}
				} catch (IllegalArgumentException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(), null, JOptionPane.INFORMATION_MESSAGE);
				} catch (DocumentException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			} else {
				JOptionPane.showMessageDialog(null, "Introdu un numar pozitiv!", null, JOptionPane.INFORMATION_MESSAGE);
			}
			drawMainPanel();

		}
	}

	// private void retrieveProperties(Object object) {
	//
	// for (Field field : object.getClass().getDeclaredFields()) {
	// field.setAccessible(true);
	// Object value;
	// try {
	// value = field.get(object);
	// System.out.println(field.getName() + "=" + value);
	// } catch (IllegalArgumentException e) {
	// e.printStackTrace();
	// } catch (IllegalAccessException e) {
	// e.printStackTrace();
	// }
	//
	// }
	// }

	private JTable createTable(ArrayList<?> obj) {
		String[][] data = null;
		String[] columnNames = null;
		Field[] fields;
		int i = 0, j = 0;
		int row = obj.size();
		int col = obj.get(0).getClass().getDeclaredFields().length;
		data = new String[row][col];
		columnNames = new String[col];
		for (Object o : obj) {
			fields = o.getClass().getDeclaredFields();
			for (Field f : fields) {
				try {
					f.setAccessible(true);
					int index = f.getName().lastIndexOf('.');
					columnNames[j] = f.getName().substring(index + 1);
					data[i][j] = String.valueOf(f.get(o));
					j++;
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
			}
			i++;
			j = 0;
		}
		return new JTable(data, columnNames);
	}
}
