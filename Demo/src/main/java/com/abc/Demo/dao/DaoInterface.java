package com.abc.Demo.dao;
import java.util.List;

import com.abc.Demo.model.Student;


public interface DaoInterface {

	

	 

	    public boolean addStudent(Student std);

		public boolean updateStudent(Student std);
		
		public boolean deleteStudent(int sid);
		public  Student getStudentById(int sid);
		public List<Student> viewAllstudents();

	   

	}
	
	
	

