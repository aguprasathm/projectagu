package com.palletech;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Student
{
	
	private static final String url="jdbc:mysql://localhost:3306/palle";
	private static final String username="root";
	private static final String password="admin";
	
	private static Connection con=null;
	private static Statement s=null;
	private static PreparedStatement ps=null;
	
	private static ResultSet rs=null;
	
	public static void creating()
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url,username,password);
			s=con.createStatement();
			s.executeUpdate("create table student (sno int primary key auto_increment"
					+ ",sname varchar(40) not null,sub varchar(40),email varchar(50) unique)");
			s.close();  
			con.close();
		} 
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		finally
		{
			try 
			{
				if(s!=null)
				{
					s.close();
				}
				if(con!=null)
				{
					con.close();
				}
			}
												
			 catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
	}
	
	public static void inseting( String name, String subs, String semail)
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url,username,password);
			ps=con.prepareStatement("insert into Student(sname,sub,email) values(?,?,?)");
			ps.setString(1, name);
			ps.setString(2, subs);
			ps.setString(3, semail);
			
			ps.executeUpdate();
			
			ps.close();
			con.close();
		} 
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		finally
		{
			try 
			{
				if(ps!=null)
				{
					ps.close();
				}
				if(con!=null)
				{
					con.close();
				}
			}
												
			 catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
	}
	
	public static void updating(int no,String subs,String semail)
	{
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url,username,password);
			ps=con.prepareStatement("update Student set sub=?,email=? where sno=?");
			ps.setString(1, subs);
			ps.setString(2, semail);
			ps.setInt(3, no);
			
			ps.executeUpdate();
			
			ps.close();
			con.close();
			
			
		} 
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		finally
		{
			try 
			{
				if(ps!=null)
				{
					ps.close();
				}
				if(con!=null)
				{
					con.close();
				}
			}
												
			 catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
	}
	
	public static void deleteing(int no)
	{
	try
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection(url,username,password);
		ps=con.prepareStatement("delete from Student where sno=?");
		ps.setInt(1,no);
		
		ps.executeUpdate();
		ps.close();
		con.close();
		
	}
	catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	finally
	{
		try 
		{
			if(ps!=null)
			{
				ps.close();
			}
			if(con!=null)
			{
				con.close();
			}
		}
											
		 catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
	}
	
	public static void read()
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url,username,password);
			s=con.createStatement();
			rs=s.executeQuery("select * from Student");
			
			while(rs.next()==true)
			{
				System.out.println(rs.getInt("sno"));
				System.out.println(rs.getString("sname"));
				System.out.println(rs.getString("sub"));
				System.out.println(rs.getString("email"));
				
				System.out.println("*****************");
			}
			
			rs.close();
			s.close();
			con.close();
			
		}
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		finally
		{
		   try
		   {
			   if(rs!=null)
			   {
			      rs.close();
			   }
			   if(s!=null)
			   {
				s.close();
			   }
			   if(con!=null)
			   {
					con.close();
			   }			
		   } 
		   catch (SQLException e)
		   {
			// TODO Auto-generated catch block
			e.printStackTrace();
		   }
		}
		
	}
	
	public static ArrayList<ReadStudentData> readingAllData()
	{
		ArrayList<ReadStudentData> a=new ArrayList<ReadStudentData>();
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url,username,password);
			s=con.createStatement();
			rs=s.executeQuery("select * from Student");
			
			while(rs.next())
		{
				int id=rs.getInt("sno");
				String name=rs.getString("sname");
				String subject=rs.getString("sub");
				String mail=rs.getString("email");
				
				ReadStudentData r=new ReadStudentData(id, name, subject, mail);
				a.add(r);
			}
		} 
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		finally
		{
			try
			{
				if(rs!=null)
				{
				rs.close();
				}
				if(s!=null)
				{
				s.close();
				}
				if(con!=null)
				{
				con.close();
				}
			} 
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
		
		return a;
		
}
}
