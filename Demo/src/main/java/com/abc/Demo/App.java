package com.abc.Demo;

import java.util.List;
import java.util.Scanner;

import com.abc.Demo.model.Student;
import com.abc.Demo.dao.DaoImpl;
import com.abc.Demo.dao.DaoInterface;


import java.sql.*;

 

public class App {

	  DaoInterface dao=new DaoImpl();
	  static Scanner sc=new Scanner(System.in);
	   
	    //Add -s
	  
	  public void add() {
	     Student std=new Student();

	    System.out.println("Enter sid");

	    std.setSid(sc.nextInt()); 

	   System.out.println("Enter student name");

	    std.setSname(sc.next());

	    System.out.println("Enter marks ");

	    std.setMarks(sc.nextInt()); 
	   
	   System.out.println("Enter city");

	    std.setCity(sc.next()); 

	    boolean b=dao.addStudent(std);

	    if(b) {

	        System.out.println("student record added successfully");

	    }

	    else {

	        System.out.println("fail");

	    }

	 

	    }  
	    
	     
	    
	    
	    //update -s
	  
	  public void update() {
	    Student std=new Student();
	   
	    System.out.println("Enter the student id :");
	    int sid=sc.nextInt(); 
	    std.setSid(sid);
	    System.out.println("Enter the student name :");
	    String sname=sc.next();
	    std.setSname(sname);
	    System.out.println("Enter the student marks :");
	    int marks=sc.nextInt();
	    std.setMarks(marks);
	    System.out.println("Enter the student city :");
	    String city=sc.next();  
	    std.setCity(city);
	    
	    boolean b=dao.updateStudent(std);
	    if(b) {

	        System.out.println("student record Updated successfully");

	    }

	    else {

	        System.out.println("fail");
	    }
	    } 
	    
	    
	    
	    
	    //delete  -s
	    public void delete() {
	  System.out.println("Enter the student id to delete :");
	    int sid=sc.nextInt();
	    boolean b=dao.deleteStudent(sid); 

	    if(b) {

	        System.out.println("student record Deleted successfully");

	    }

	    else {

	        System.out.println("fail");

	    } 
	    }
	    
	    
	    
	    //view student details by id -s
	    
	    public void id() {
	     System.out.println("Enter student id to get details of student :");
	    int sid=sc.nextInt();
	    Student rs=dao.getStudentById(sid);
	    System.out.println("Student name: "+rs.getSname());
	    System.out.println("Student marks: "+rs.getMarks());
	    System.out.println("Student city: "+rs.getCity()); 
	    
	    }
	    
	   
	 
	    
	    
	    
	   //view All students -s
	    public void all() {
	    List<Student> std=dao.viewAllstudents();
	   
	    for (Student s : std) {
	    	System.out.println("Student ID: " + s.getSid());
	        System.out.println("Student name :"+s.getSname());
	        System.out.println("Student marks :"+s.getMarks());
	        System.out.println("Student city :"+s.getCity());
	    
	    } 
	    }
	    
	    
	    
	    
	    
	    public void viewOptions() {
	    	 int option = 0;
	         
	         do {
	        	 System.out.println("1.Add Student details");
	        	 System.out.println("2.Update student details");
	        	 System.out.println("3.Delete student details");
	        	 System.out.println("4.View Student details by student ID");
	        	 System.out.println("5.View All students details");
	        	 System.out.println("6.Exit");
	         
	              System.out.println("Enter the option: ");
	        	  option=sc.nextInt();
	        	  if(option==1) {
	        		  add();
	        	  }
	        	  else if(option==2) {
	        		  update();
	        	  }
	        	  else if(option==3) {
	        		  delete();
	        	  }
	        	  else if(option==4) {
	        		  id();
	        	  }
	        	  else if(option==5) {
	        		  all();
	        	  }
	         }while(option!=6);
	         
	    }

    

    public static void main(String[] args ) {
    	App obj=new App();
    	obj.viewOptions();
  
  
    }
}




 





