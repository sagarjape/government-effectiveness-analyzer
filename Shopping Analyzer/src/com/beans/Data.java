package com.beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Data {
	
		public static String[][] getData(){
			String d[][]=new String[7][100];
			try {
			      Class.forName("org.postgresql.Driver");		
			  		//Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			  		//DriverManager.registerDriver(new com.mysql.jdbc.Driver());
					
			  	} catch (Exception e) {
			e.printStackTrace();
			}
			Connection con = null;
			Statement st= null;
			try {
				
			con= DriverManager.getConnection("jdbc:postgresql://localhost:5432/bank","postgres", "sagar");
			st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from worlddata");
			int i=1; 
			while(rs.next())
			{
			d[0][i] =rs.getString(2);
			d[1][i] =rs.getDouble(3)+"";
			d[2][i] =rs.getDouble(4)+"";
			d[3][i] =rs.getDouble(5)+"";
			d[4][i] =rs.getDouble(6)+"";
			d[5][i] =rs.getDouble(7)+"";
			d[6][i] =rs.getDouble(8)+"";
			i++;
			}
			
			} catch (SQLException e) {
			e.printStackTrace();
			}               			
			return d;
		}
}
