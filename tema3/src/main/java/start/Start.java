package start;

import java.sql.SQLException;
import java.util.logging.Logger;
import presentation.AppController;


/**
 * @Author: Technical University of Cluj-Napoca, Romania Distributed Systems
 *          Research Laboratory, http://dsrl.coned.utcluj.ro/
 * @Since: Apr 03, 2017
 */
public class Start {
	protected static final Logger LOGGER = Logger.getLogger(Start.class.getName());

	public static void main(String[] args) throws SQLException {

		@SuppressWarnings("unused")
		AppController a = new AppController();
		
//		Student student = new Student("dummy name", "dummy address", "dummy@address.co", 24);
//		Student student1 = new Student(10, " name", "dummy address", "dummy@address.co", 33);
//		StudentBLL studentBll = new StudentBLL();
//		for (int i = 0; i < 10; i++) {
//			int id = studentBll.insertStudent(student);
//			if (id > 0) {
//				studentBll.findStudentById(id);
//
//				// Generate error
//				try {
//					studentBll.findStudentById(1);
//				} catch (Exception ex) {
//					LOGGER.log(Level.INFO, ex.getMessage());
//				}
//
//				// obtain field-value pairs for object through reflection
//				ReflectionExample.retrieveProperties(student);
//			}
//		}
//
//		for (int i = 0; i < 5; i++) {
//			studentBll.deleteStudent(i);
//		}
//
//		studentBll.updateStudent(student1);
//		/////////////////
//		Produs produs = new Produs("name");
//		Produs produs1 = new Produs(10, "gigel");
//		Stoc st= new Stoc(1,10);
//		ProdusBLL produsBll = new ProdusBLL();
//		StocBLL stbll = new StocBLL();
//		
//		for (int i = 0; i < 10; i++) {
//			int id = produsBll.insertProdus(produs);
//			if (id > 0) {
//				produsBll.findProdusById(id);
//				// Generate error
//				try {
//					produsBll.findProdusById(1);
//				} catch (Exception ex) {
//					LOGGER.log(Level.INFO, ex.getMessage());
//				}
//
//				// obtain field-value pairs for object through reflection
//				ReflectionExample.retrieveProperties(produs);
//			}
//		}
//		int id3=stbll.findStocById("gigel");
//		Stoc st1= new Stoc(id3,40);
//		stbll.insertStoc(st1);
//		for (int i = 0; i < 5; i++) {
//			produsBll.deleteProdus(i);
//		}
//
//		produsBll.updateProdus(produs1);
//		ComandaBLL a = new ComandaBLL();
//		Comanda comanda = new Comanda(5, 5);
//
//		for (int i = 0; i < 5; i++) {
//			a.insertComanda(comanda);
//		}

	}
}
