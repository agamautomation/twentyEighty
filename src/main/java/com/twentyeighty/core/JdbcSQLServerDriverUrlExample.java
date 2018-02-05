package com.twentyeighty.core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class JdbcSQLServerDriverUrlExample
{
	
	public String sqlmethod(String value, String query, String databaseName)
	{
		
		String bodyvalue =null ;
		Connection connection = null;
		try
		{

			
			String url = "jdbc:sqlserver://USOAK-STAGEDB01;databaseName="+ databaseName;
			// the sql server driver string
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			connection = DriverManager.getConnection(url,"esinet_dbo", "(*D3M0Cr@t)");
			System.out.println("check now");
			PreparedStatement stmt=connection.prepareStatement(query); 
			stmt.setString(1, value);
			ResultSet rs=stmt.executeQuery();
			
			int count =0;
			while(rs.next())
			{
				bodyvalue= rs.getString("Body");
				++count;
			}
		
		}
		
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
			System.exit(1);
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			System.exit(2);
		}
		return bodyvalue;
	}}
