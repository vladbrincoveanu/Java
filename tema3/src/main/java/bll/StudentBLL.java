package bll;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import bll.validators.EmailValidator;
import bll.validators.StudentAgeValidator;
import bll.validators.Validator;
import dao.StudentDAO;
import model.Student;

/**
 * @Author: Technical University of Cluj-Napoca, Romania Distributed Systems
 *          Research Laboratory, http://dsrl.coned.utcluj.ro/
 * @Since: Apr 03, 2017
 */
public class StudentBLL {

	private List<Validator<Student>> validators;

	public StudentBLL() {
		validators = new ArrayList<Validator<Student>>();
		validators.add(new EmailValidator());
		validators.add(new StudentAgeValidator());
	}

	public Student findStudentById(int id) {
		Student st = StudentDAO.findById(id);
		if (st == null) {
			throw new NoSuchElementException("The student with id =" + id + " was not found!");
		}
		return st;
	}

	public ArrayList<Student> showStudentInfo(){
		//for(int i=0; i < StudentDAO.showClientInfo().size(); i++)
		//	System.out.println("TESTING"+StudentDAO.showClientInfo().get(i));
		return StudentDAO.showInfo();
	}
		
	public int insertStudent(Student student) {
		for (Validator<Student> v : validators) {
			v.validate(student);
		}
		return StudentDAO.insert(student);
	}
	
	public int deleteStudent(int id){
		return StudentDAO.delete(id);
	}
	
	public int updateStudent(Student student) {
		for (Validator<Student> v : validators) {
			v.validate(student);
		}
		return StudentDAO.update(student);
	}
}
