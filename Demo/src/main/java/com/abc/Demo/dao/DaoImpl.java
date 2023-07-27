package com.abc.Demo.dao;

import com.abc.Demo.model.Student;
	import java.sql.Connection;

	import java.sql.DriverManager;

	import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
	
import java.util.List;
	 

	public  class DaoImpl implements DaoInterface {

	 
	    Connection con=null;

	    public DaoImpl() {

	        

	        try {

	            Class.forName("com.mysql.cj.jdbc.Driver");

	            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db","root","root");

	        }

	        catch(Exception e) {

	            System.out.println(e);

	        }

	    }

	    

	    


	    public boolean addStudent(Student std)  {

	        

	       boolean b=false;

	       try {

	       PreparedStatement pstmt=con.prepareStatement("insert into student values(?,?,?,?)");

	       pstmt.setInt(1, std.getSid());

	       pstmt.setString(2, std.getSname());

	       pstmt.setInt(3, std.getMarks());

	       pstmt.setString(4, std.getCity());

	       int i=pstmt.executeUpdate();

	       if(i>0) {

	           b=true;

	       }

	       }

	       catch(Exception e) {

	           System.out.println(e);

	       }

	        return b;

	    }
	    
	    
	    
	    
	    public boolean updateStudent(Student std) {
		
	    	boolean b=false;
	    	Student std1=getStudentById(std.getSid());

            if(std.getMarks()!=0) {

                std1.setMarks(std.getMarks());

            }

            if(std.getCity()!=null) {

                std1.setCity(std.getCity());

            }

            if(std.getSname()!=null) {

                std1.setSname(std.getSname());

            } 
	    	
	    	try {
	    		
	    	PreparedStatement pstmt =con.prepareStatement("Update student set marks=?,sname=?,city=? where sid=? ");

	    	pstmt.setInt(1,std1.getMarks());
	    	   pstmt.setString(2, std1.getSname());
	    	   pstmt.setString(3, std1.getCity());
	    	   pstmt.setInt(4, std1.getSid());
	    	   
		       
		       
	    	int i=pstmt.executeUpdate();
	    	
	    	if(i>=0) {
	    		b=true;
	    	}		
	    	}
	    	catch(Exception e ) {
	    		System.out.println(e);
	    	}
	    	return b;
	    }
	    
	    
	    public boolean deleteStudent(int sid) {
	    	boolean b=false;
	    	try {
	    		PreparedStatement pstmt =con.prepareStatement("delete from student where sid=? ");
	    		pstmt.setInt(1,sid);
	    		int i=pstmt.executeUpdate();
		    	
		    	if(i>0) {
		    		b=true;
		    	}		
		    	
	    	
	    	}
	    	catch(Exception e) {
	    		System.out.println(e);
	    	}
	    	return b;
	    }

	    
	    
	    public  Student getStudentById(int sid) {
			Student student=null; 
			try {
				PreparedStatement pstmt=con.prepareStatement("select * from student where sid=? ");
				pstmt.setInt(1, sid);
			
				ResultSet rs=pstmt.executeQuery();
				student=new Student();
				while(rs.next()) {
					student.setSid(rs.getInt("sid"));
					student.setMarks(rs.getInt("marks"));
					student.setCity(rs.getString("city"));
					student.setSname(rs.getString("sname"));
	              }
			}
			catch(Exception e) {
				System.out.println(e);
			}
			return student;
	    	
	    }
	 
	    public List<Student> viewAllstudents() {
	    	ArrayList<Student> std = new ArrayList<Student>();
	    	Student student=null;
	    	try {
	    		PreparedStatement pstmt=con.prepareStatement("select * from student");
	    		ResultSet rs=pstmt.executeQuery();
	    		student =new Student();
	    		
	    		while(rs.next()) {
	    			Student s=new Student();
	    			s.setSid(rs.getInt("sid"));
	    			s.setMarks(rs.getInt("marks"));
	    			s.setCity(rs.getString("City"));
	    			s.setSname(rs.getString("sname"));
	    			 std.add(s);
	    		}
	    	}
	    	catch(Exception e) {
	    		System.out.println(e);
	    	}
			return std;
	    	
	    }
	}
	    
	//order by name
	  /*  public List<Student> viewAllStudents(){
	    	ArrayList<Student> std=new ArrayList<Student>();
	    	try {
	    		PreparedStatement pstmt=con.prepareStatement("select * from student order by sname asc");
	    		ResultSet rs=pstmt.executeQuery();
	    		while(rs.next()) {
	    			Student s =new Student();
	    			s.setSid(rs.getInt("sid"));
	    			s.setMarks(rs.getInt("marks"));
	    			s.setSname(rs.getString("sname"));
	    			s.setCity(rs.getString("City"));
	    			std.add(s);
	    			
	    		}
	    	}catch(Exception e) {
	    		System.out.println(e);
	    	}
return std;

	    } */
	
	
	//order by marks
	/*public List<Student> viewAllStduents() {
		ArrayList<Student> std=new ArrayList<Student>();
		try {
    		PreparedStatement pstmt=con.prepareStatement("select * from student order by marks asc");
    		ResultSet rs=pstmt.executeQuery();
    		while(rs.next()) {
    			Student s =new Student();
    			s.setSid(rs.getInt("sid"));
    			s.setMarks(rs.getInt("marks"));
    			s.setSname(rs.getString("sname"));
    			s.setCity(rs.getString("City"));
    			std.add(s);
    			
    		}
    	}catch(Exception e) {
    		System.out.println(e);
    	}
return std;
	} */
	
	
	
	//Range city,marks
	
	/*public void List<Student> viewAllStudents(String city,int mark1,int mark2){
		ArrayList<Student> std=new ArrayList<Student>();
		try {
			PreparedStatement pstmt=con.prepareStatement("select * from student where mark1>=? and mark2<=? and city=? ");
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				pstmt.setInt(1, mark1);
				pstmt.setInt(2, mark2);
				pstmt.setString(3, city);
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		return std;
	} */
	
	
	
	
	
	
	
	
	
	
	
	

	 