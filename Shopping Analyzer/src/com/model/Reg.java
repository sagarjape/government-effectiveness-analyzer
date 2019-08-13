package com.model;
import java.sql.*;
import java.util.*;
import java.lang.*;
import java.io.*;

public class Reg
{
public static double[] main()throws IOException {

double res[]=new double[2];

try { 
	 Class.forName("org.postgresql.Driver");	
} catch (Exception e) { 

System.out.println("Where is your PostgreSQL JDBC Driver? "+ "Include in your library path!"); 

e.printStackTrace(); 
} 
Connection con = null;

 Statement st,st1= null; 

try {

 con= DriverManager.getConnection("jdbc:postgresql://localhost:5432/bank","postgres", "sagar");
				
st=con.createStatement(); 

st1=con.createStatement();

ResultSet rs=st.executeQuery("select voice_accountability,politicalstability_voilence from worlddata");

        double a1[]=new double[100];

       double a2[]=new double[100];

       int i=0;int j; 

double mean1;double mean2;double sum1=0,sum2=0; 

double p,a,b,c,s=0,s1=0,w1,w0; 

while(rs.next()) 

{ 

a1[i]=rs.getDouble(1); 

a2[i]=rs.getDouble(2); 

i++; 

}

for(j=0;j<99;j++)

{ 

sum1=sum1+a1[j]; 

sum2=sum2+a2[j];

}

mean1=sum1/99;

mean2=sum2/99;

ResultSet rs1=st1.executeQuery("select voice_accountability,politicalstability_voilence from worlddata");

while(rs1.next())

{ 

a1[i]=rs1.getDouble(1); 

a2[i]=rs1.getDouble(2); 

a=a1[i]-mean1; 

b=a2[i]-mean2; 

p=a*b; 

s=s+p; 

c=a*a; 

s1=s1+c; 

} 

w1=s/s1; 

w0=mean2-(w1*mean1); 

res[0]=w1;
res[1]=w0;

} 

 catch (SQLException e) { 

}               
return res;
}
}