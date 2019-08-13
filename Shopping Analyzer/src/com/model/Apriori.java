
package com.model;

import java.sql.*;
import java.util.*;
import java.lang.*;
import java.io.*;
public class Apriori{

public static String[][] main(int minsupp)
{
	final String driver = "org.postgresql.Driver";
    final String url = "jdbc:postgresql://localhost:5432/apriori"; //apriori mere database ka naam h
    final String username = "postgres";
    final String password = "sagar";
    
try { 
Class.forName(driver);


} catch (ClassNotFoundException e) { 

System.out.println("Where is your PostgreSQL JDBC Driver? " );

e.printStackTrace();


}
System.out.println("PostgreSQL JDBC Driver Registered!");

Connection con = null;

Statement st= null;
int a1[]=new int[10];
String a2[]=new String[10]; 
try { 

con=DriverManager.getConnection(url,username,password);
st=con.createStatement();
ResultSet rs=st.executeQuery("select * from transaction");
int i1=0; 
while(rs.next())

{ 

a1[i1] =rs.getInt(1);
a2[i1] =rs.getString(2);
i1++; 
}}
catch(Exception e){
}	//INITIALIZATION 
	String itemset1[]={"A","B","C","D","E","F"};
	String itemset2[]={"AB","AC","AD","AE","AF","BC","BD","BE","BF","CD","CE","CF","DE","DF","EF"};
	int cnt1[]=new int[6];
	int cnt2[]=new int[15];
	int j=0,k=0;
    int fcnt[]=new int[15];
    String l1[]=new String[6];
    String l2[]=new String[15]; 
 
 //SETTING INITIAL FREQUENCY TO 0
 int cnta=0,cntb=0,cntc=0,cntd=0,cnte=0,cntf=0;
 int cntab=0,cntac=0,cntad=0,cntae=0,cntaf=0,cntbc=0,cntbd=0,cntbe=0,cntbf=0;
 int cntcd=0,cntce=0,cntcf=0,cntde=0,cntdf=0,cntef=0;
 for(int i=0;i<10;i++)
 {
 	if(a2[i].contains("A"))
 		cnta++;   //Check for frequency of A
}
for(int i=0;i<10;i++){
 	if(a2[i].contains("B"))
 		cntb++;}
 	for(int i=0;i<10;i++)
 	{if(a2[i].contains("C"))
 		cntc++;}
 		for(int i=0;i<10;i++)
 	{ if(a2[i].contains("D"))
 		cntd++;}
 		for(int i=0;i<10;i++)
     {if(a2[i].contains("E"))
 		cnte++;}
 		for(int i=0;i<10;i++){
 	 if(a2[i].contains("F"))
 		cntf++;}

//Putting all values of frequency in array for display
cnt1[0]=cnta;
cnt1[1]=cntb;
cnt1[2]=cntc;
cnt1[3]=cntd;
cnt1[4]=cnte;
cnt1[5]=cntf;


System.out.println("-----L1-----");
for(int i=0;i<6;i++)
	System.out.println("{"+itemset1[i]+"}\t"+cnt1[i]+"");
System.out.println();
System.out.println("pruning of L1(according to minimum support count)");
for(int i=0;i<6;i++)
{
	if(cnt1[i]>=minsupp)
		{
			System.out.println("{"+itemset1[i]+"}\t"+cnt1[i]+"");
			l1[j]=itemset1[i];

			j++;
}
}
System.out.println();
for(int i=0;i<10;i++){
 	if(a2[i].contains("A")&& a2[i].contains("B")) //Check for Frequency of AB
 		cntab++;} 
 	for(int i=0;i<10;i++)
 	{if(a2[i].contains("A")&&a2[i].contains("C"))
 		cntac++;}
 		for(int i=0;i<10;i++)
 	{ if(a2[i].contains("A")&&a2[i].contains("D"))
 		cntad++;}
 		for(int i=0;i<10;i++)
     {if(a2[i].contains("A")&&a2[i].contains("E"))
 		cntae++;}
 		for(int i=0;i<10;i++){
 	 if(a2[i].contains("A")&&a2[i].contains("F"))
 		cntaf++;}
 	for(int i=0;i<10;i++){
 	 if(a2[i].contains("B")&&a2[i].contains("C"))
 		cntbc++;}
 	for(int i=0;i<10;i++){
 	 if(a2[i].contains("B")&&a2[i].contains("D"))
 		cntbd++;}
 	for(int i=0;i<10;i++){
 	 if(a2[i].contains("B")&&a2[i].contains("E"))
 		cntbe++;}
 	for(int i=0;i<10;i++){
 	 if(a2[i].contains("B")&&a2[i].contains("F"))
 		cntbf++;}
 	for(int i=0;i<10;i++){
 	 if(a2[i].contains("C")&&a2[i].contains("D"))
 		cntcd++;}
 	for(int i=0;i<10;i++){
 	 if(a2[i].contains("C")&&a2[i].contains("E"))
 		cntce++;}
 	for(int i=0;i<10;i++){
 	 if(a2[i].contains("C")&&a2[i].contains("F"))
 		cntcf++;}
 	for(int i=0;i<10;i++){
 	 if(a2[i].contains("D")&&a2[i].contains("E"))
 		cntde++;}
 	for(int i=0;i<10;i++){
 	 if(a2[i].contains("D")&&a2[i].contains("F"))
 		cntdf++;}
 	for(int i=0;i<10;i++){
 	 if(a2[i].contains("E")&&a2[i].contains("E"))
 		cntef++;}
cnt2[0]=cntab;
cnt2[1]=cntac;
cnt2[2]=cntad;
cnt2[3]=cntae;
cnt2[4]=cntaf;
cnt2[5]=cntbc;
cnt2[6]=cntbd;
cnt2[7]=cntbe;
cnt2[8]=cntbf;
cnt2[9]=cntcd;
cnt2[10]=cntce;
cnt2[11]=cntcf;
cnt2[12]=cntde;
cnt2[13]=cntdf;
cnt2[14]=cntef;
System.out.println("------L2------");
System.out.println();
for(int i=0;i<15;i++)
{
	System.out.println("{"+itemset2[i]+"}\t"+cnt2[i]+"");
}
System.out.println();
System.out.println("L2 after pruning(according to minimum support count)");
System.out.println();
for(int i=0;i<15;i++)
{
	if(cnt2[i]>=minsupp)
   {
   	System.out.println("{"+itemset2[i]+"}\t"+cnt2[i]+"");
    l2[k]=itemset2[i];
    fcnt[k]=cnt2[i];
    k++;

    }

}
int len=k;

int l=2*k;

String ass[]=new String[l];
float assc[]=new float[l];
float conf[]=new float[l];
j=0;

for(int i=0;i<(2*len);i+=2)
	{
		ass[i]=l2[j];
        assc[i]=(float)fcnt[j];
        assc[i+1]=(float)fcnt[j];
		ass[i+1]=new StringBuilder(l2[j]).reverse().toString();
 		j++;
}

int len1=ass.length;
System.out.println();

for(int i=0;i<(2*len);i++)
{
if((ass[i].charAt(0)=='A')&&(ass[i].contains("AB")))
	conf[i]=(assc[i]/cnta);
else if((ass[i].charAt(0)=='B')&&(ass[i].contains("BA")))
    conf[i]=(assc[i]/cntb);
else if((ass[i].charAt(0)=='A')&&(ass[i].contains("AC")))
    conf[i]=(assc[i]/cnta);
else if((ass[i].charAt(0)=='C')&&(ass[i].contains("CA")))
    conf[i]=(assc[i]/cntc);
else if((ass[i].charAt(0)=='A')&&(ass[i].contains("AD")))
    conf[i]=(assc[i]/cnta);
else if((ass[i].charAt(0)=='D')&&(ass[i].contains("DA")))
    conf[i]=(assc[i]/cntd);
else if((ass[i].charAt(0)=='C')&&(ass[i].contains("CD")))
    conf[i]=(assc[i]/cntc);
else if((ass[i].charAt(0)=='D')&&(ass[i].contains("DC")))
    conf[i]=(assc[i]/cntc);
else if((ass[i].charAt(0)=='C')&&(ass[i].contains("CE")))
    conf[i]=(assc[i]/cntc);
else if((ass[i].charAt(0)=='E')&&(ass[i].contains("EC")))
    conf[i]=(assc[i]/cnte);
else if((ass[i].charAt(0)=='C')&&(ass[i].contains("CF")))
    conf[i]=(assc[i]/cntc);
else if((ass[i].charAt(0)=='F')&&(ass[i].contains("FC")))
    conf[i]=(assc[i]/cntf);
else if((ass[i].charAt(0)=='E')&&(ass[i].contains("EF")))
    conf[i]=(assc[i]/cnte);
else if((ass[i].charAt(0)=='F')&&(ass[i].contains("FE")))
    conf[i]=(assc[i]/cntf);
}

String [][] res=new String[(2*len)+1][3];
System.out.println("Association rules:");
System.out.println("Rules\t min supp\t conf");

for(int i=1;i<=(2*len);i++)
{
	System.out.println(ass[i-1]+"\t"+minsupp+"\t\t"+conf[i-1]);
	res[i][0]=ass[i-1];
	res[i][1]=minsupp+"";
	res[i][2]=conf[i-1]+"";
}
res[0][0]=(2*len)+"";
System.out.print(res[0][0]);
return res;
}
public static String[][] main1()
{
	String res[][]=new String[10][2];
	final String driver = "org.postgresql.Driver";
    final String url = "jdbc:postgresql://localhost:5432/apriori"; //apriori mere database ka naam h
    final String username = "postgres";
    final String password = "sagar";
    
try { 
Class.forName(driver);


} catch (ClassNotFoundException e) { 

System.out.println("Where is your PostgreSQL JDBC Driver? " );

e.printStackTrace();


}
System.out.println("PostgreSQL JDBC Driver Registered!");

Connection con = null;

Statement st= null;
int a1[]=new int[10];
String a2[]=new String[10]; 
try { 

con=DriverManager.getConnection(url,username,password);
st=con.createStatement();
ResultSet rs=st.executeQuery("select * from transaction");
int i1=0; 
while(rs.next())

{ 

a1[i1] =rs.getInt(1);
a2[i1] =rs.getString(2);
res[i1][0]=a1[i1]+"";
res[i1][1]=a2[i1]+"";
i1++; 
}}
catch(Exception e){
}
return res;
}

}

