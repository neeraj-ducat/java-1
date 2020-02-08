package com.ducat.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.ducat.entities.Emp;

public class EmpDao {

	
	private Connection getConnection() throws Exception
	{
		// Driver class is loaded to get it registered
		Class.forName("com.mysql.jdbc.Driver");
		// Connection object is created
		Connection con= DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/userdb",
				"userdb","1234");
		return con;
	}
	
	// Method to save an Emp
	public void save(Emp e) throws Exception
	{
	Connection con = getConnection();
	PreparedStatement stmt=con.prepareStatement(
	"insert into Emp (name, job, salary) values(?,?,?)");
	stmt.setString(1, e.getName());
	stmt.setString(2, e.getJob());
	stmt.setInt(3, e.getSalary());
	stmt.executeUpdate();
	con.close();
	}
	
	// Method to update an Emp
	public void update(Emp e) throws Exception
	{
	Connection con = getConnection();
	PreparedStatement stmt=con.prepareStatement(
	"update Emp set name=?, job=?, salary=? where id=?");
	stmt.setString(1, e.getName());
	stmt.setString(2, e.getJob());
	stmt.setInt(3, e.getSalary());
	stmt.setInt(4, e.getId());
	stmt.executeUpdate();
	con.close();
	}
	
	// Method to delete an Emp
	public int remove(int id) throws Exception
	{
	Connection con = getConnection();
	PreparedStatement stmt=con.prepareStatement(
	"delete from Emp where id=?");
	stmt.setInt(1, id);
	int deleted=stmt.executeUpdate();
	con.close();
	return deleted;
	}
	
	// Method to fetch all Employees
	public List<Emp> getAllEmp() throws Exception
	{
	List<Emp> list = new ArrayList<Emp>();	
	Connection con = getConnection();
	Statement stmt=con.createStatement();
	ResultSet rset=stmt.executeQuery("select * from Emp");
	while(rset.next())
	{
		list.add(mapRecord(rset));
	}
	con.close();
	return list;
	}
	
	// Method to fetch an Emp using its id
	public Emp getById(int id) throws Exception
	{
	Emp emp = null;
	Connection con = getConnection();
	PreparedStatement stmt=con.prepareStatement(
			"select * from Emp where id=?");
	stmt.setInt(1, id);
	ResultSet rset=stmt.executeQuery();
	if(rset.next())
	{
		emp=mapRecord(rset);
	}
	con.close();
	return emp;
	}
	
	//Method to map a record to an Emp object
	private Emp mapRecord(ResultSet rset) throws Exception
	{
		Emp e=new Emp();
		e.setId(rset.getInt(1));
		e.setName(rset.getString(2));
		e.setJob(rset.getString(3));
		e.setSalary(rset.getInt(4));
		return e;
		
	}
}
