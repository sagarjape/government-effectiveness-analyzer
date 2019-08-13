package com.model;

import java.sql.*;
import java.util.*;
import java.lang.*;
import java.io.*;

public class Kmean
{     

static double a1[]=new double[100];
	static double a2[]=new double[100];
	static String a3[]=new String[100];
	public static double cl1[]=new double[100];
	public static double cl2[]=new double[100];
	//static	double a1[]={1.0,1.5,3.0,5.0,3.5,4.5,3.5};
// static double a2[]={1.0,2.0,4.0,7.0,5.0,5.0,4.5};
		public static int x;
public static String[][] kmean()
    {
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
ResultSet rs=st.executeQuery("select voice_accountability, governmenteffectiveness, country from worlddata");
int i=1; 
while(rs.next())
{
a1[i] =rs.getDouble(1);
a2[i] =rs.getDouble(2);
a3[i]=rs.getString(3);
i++;
}
} catch (SQLException e) {
e.printStackTrace();


}               

	double sum1,dist1,sum2,dist2;int m=0,n=0;
double max=0;int maxj=0,maxk=0;
for(int j=0;j<100;j++)
{
for(int k=0;k<100;k++)
{  
sum1=(Math.pow((a1[j]-a1[k]),2)+Math.pow((a2[j]-a2[k]),2)); 
dist1=Math.sqrt(sum1);
if(dist1>max)
{
max=dist1;
maxj=j;
maxk=k;
}
}
}
double sclx1=0,sclx2=0,scly1=0,scly2=0;
double mvC1x=a1[maxj];
double mvC1y=a2[maxj];
double mvC2x=a1[maxk];
double mvC2y=a2[maxk];
double mscxl1=0,mscxl2=0;
double mscyl1=0,mscyl2=0;

for(int j=0;j<100;j++)
{
sum1=(Math.pow((a1[j]-mvC1x),2)+Math.pow((a2[j]-mvC1y),2)); 
dist1=Math.sqrt(sum1);
sum2=(Math.pow((a1[j]-mvC2x),2)+Math.pow((a2[j]-mvC2y),2)); 
dist2=Math.sqrt(sum2);
if(dist1<=dist2)
{
cl1[m]=j;
sclx1=sclx1+a1[m];
scly1=scly1+a2[m];
m++;
}
else
{
cl2[n]=j;
sclx2=sclx2+a1[m+n];
scly2=scly2+a2[m+n];
n++;
}
}
double mclx1=sclx1/m;
double mcly1=scly1/m;
double mclx2=sclx2/n;
double mcly2=scly2/n;

System.out.println("Mean Vector of Cluster 1:"+mclx1+" "+mcly1+"\nMean Vector of Cluster 1:"+" "+mclx2+" "+mcly2);
System.out.println("Cluster 1 (Country ID):");
System.out.println("Cluster 2(Country ID:):");
x=1;

String d1[][]=new String[3][m+n];
for(int j=1;j<m;j++)
{
	int id=(int)cl1[j];
	d1[0][j]=a3[id];
}
for(int j=1;j<n;j++)
{
	int id=(int)cl2[j];
d1[1][j]=a3[id];
}
d1[2][0]=m+"";
d1[2][1]=n+"";

return d1;
}}
