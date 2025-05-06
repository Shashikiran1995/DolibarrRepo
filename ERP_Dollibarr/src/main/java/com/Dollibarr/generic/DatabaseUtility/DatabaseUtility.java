package com.Dollibarr.generic.DatabaseUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DatabaseUtility 
{
	Connection conn;
public void getDbConnection(String url,String username,String password)
{
	
	try 
	{
	Driver driver=new Driver();	
	DriverManager.registerDriver(driver);
	DriverManager.getConnection(url, username, password);
	}
	catch(Exception e)
	{
		
	}
}
public void getDbconnection()
{
	try
	{
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		DriverManager.getConnection("jdbc:mysql://49.249.28.218:3333/ninza_hrm", "root", "root");
	}
	catch(Exception e)
	{
		
	}
}
	
public void closeDbConnection()
{
	try
	{
		conn.close();
	}
	catch(Exception e)
	{
		
	}
}

public ResultSet executeSelectQuery(String query) throws SQLException
{
	ResultSet result = null;
	try {
	Statement stat = conn.createStatement();
	result = stat.executeQuery(query);
	}
	catch(Exception e) {
	}
	return result;
}
public ResultSet getDbConnectionWithExecuteSelectQuery(String url,String username,String password,String Query) throws SQLException
{
	Connection conn;
	ResultSet result = null;
	try
	{
	Driver driver=new Driver();
	DriverManager.registerDriver(driver);
	conn = DriverManager.getConnection(url,username,password);
	Statement stat = conn.createStatement();
	result=stat.executeQuery(Query);
	}
	catch(Exception e)
	{
		
	}
	return result;
}

public int executeNonSelectQuery(String query)
{
	int result = 0;
	try {
		Statement stat = conn.createStatement();
		result=stat.executeUpdate(query);
	}
	catch(Exception e) {
		
	}
	return result;
}
public int getDbConnectionWithNonExecuteSelectQuery(String url,String username,String password,String Query) throws SQLException
{
	Connection conn;
	int result = 0;
	try
	{
	Driver driver=new Driver();
	DriverManager.registerDriver(driver);
	conn = DriverManager.getConnection(url,username,password);
	Statement stat = conn.createStatement();
	result=stat.executeUpdate(Query);
	}
	catch(Exception e)
	{
		
	}
	return result;
}
}
