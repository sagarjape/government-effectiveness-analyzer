package com.model;

import java.sql.*;
import java.util.*;
public class Bayes
{
public static String main(String vac,String gef,String coc)
{
Scanner sc = new Scanner (System.in);
int i=0,j,k,ts;
double classg=1,classb=1;
double VAwclassg=0,VAwclassb=0,VAbclassg=0,
VAbclassb=0,VAmclassg=0,VAmclassb=0;
double GEwclassg=0,GEwclassb=0,GEbclassg=0,
GEbclassb=0,GEmclassg=0,GEmclassb=0;
double CCwclassg=0, CCwclassb=0,CCbclassg=0,CCbclassb=0,
CCmclassg=0,CCmclassb=0;
double pgood,pbad;
double VAwg=0, VAwb=0,VAbg=0, VAbb=0,VAmg=0,VAmb=0;
double GEwg=0, GEwb=0,GEbg=0,GEbb=0, GEmg=0,GEmb=0;
double CCwg=0, CCwb=0,CCbg=0, CCbb=0,CCmg=0,CCmb=0;
int g=0,b=0;
double VAw=0,VAb=0,VAm=0;
double GEw=0,GEb=0,GEm=0;
double CCw=0,CCb=0,CCm=0;
String good="Good";
String bad="Bad";
String v,ge,cc;
int t;
Double Voice[]=new Double[99];
Double GovtEff[]=new Double[99];
Double ControlofCorr[]=new Double[99];
String eff[]=new String[99];
try
{
 Class.forName("org.postgresql.Driver");
Connection Con= DriverManager.getConnection("jdbc:postgresql://localhost:5432/bank","postgres", "sagar");
	
Statement st=Con.createStatement();
ResultSet rs=st.executeQuery("Select voice_accountability,governmenteffectiveness,controlofcurroption,efficiency from worlddata");
while(rs.next() && i<98)
{
Voice[i]=rs.getDouble(1);
GovtEff[i]=rs.getDouble(2);
ControlofCorr[i]=rs.getDouble(3);
eff[i]=rs.getString(4);
i++;
}
}
catch(Exception ex)
{
System.out.println(ex);
}
for(j=0;j<98;j++)
{
if(eff[j].equals("Good"))
g++;
else
b++;
}
i=0;
while(i<98)
{
/*Voice Accountability*/
if(Voice[i]<33)
{
VAw++;
if(eff[i].equals("Good"))
VAwg++;
else
VAwb++;
}
else if((Voice[i]<66)&&(Voice[i]>=33))
{
VAm++;
if(eff[i].equals("Good"))
VAmg++;
else
VAmb++;
}
else if(Voice[i]>=66)
{
VAb++;
if(eff[i].equals("Good"))
VAbg++;
else
VAbb++;
}
/*ControlOfCorruption*/
if(ControlofCorr[i]<33)
{
CCw++;
if(eff[i].equals("Good"))
CCwg++;
else
CCwb++;
}
else if((ControlofCorr[i]<66)&&(ControlofCorr[i]>=33))
{
CCm++;
if(eff[i].equals("Good"))
CCmg++;
else
CCmb++;
}
if(ControlofCorr[i]>=66)
{
CCb++;
if(eff[i].equals("Good"))
{
CCbg++;

}

else
CCbb++;
}
/*GovernmentEffectiveness*/
if(GovtEff[i]<33)
{
GEw++;
if(eff[i].equals("Good"))
GEwg++;
else
GEwb++;
}
else if((GovtEff[i]<66)&&(GovtEff[i]>=33))
{
GEm++;
if(eff[i].equals("Good"))
GEmg++;
else
GEmb++;
}
else if(GovtEff[i]>=66)
{
GEb++;
if(eff[i].equals("Good"))
GEbg++;
else
GEbb++;
}
i++;
}
/*Voice Accountability Class Probablity*/
VAwclassg=VAwg/VAw;
VAwclassb=VAwb/VAw;
VAbclassg=VAbg/VAb;
VAbclassb=VAbb/VAb;
VAmclassg=VAmg/VAm;
VAmclassb=VAmb/VAm;

/*Govt Eff Class Probablity*/
GEwclassg=GEwg/GEw;
GEwclassb=GEwb/GEw;
GEbclassg=GEbg/GEb;
GEbclassb=GEbb/GEb;
GEmclassg=GEmg/GEm;
GEmclassb=GEmb/GEm;

/*Control Of Corruption*/
CCwclassg=CCwg/CCw;
CCwclassb=CCwb/CCw;
CCbclassg=CCbg/CCb;
CCbclassb=CCbb/CCb;
CCmclassg=CCmg/CCm;
CCmclassb=CCmb/CCm;

pgood=((double)g/98);
pbad=((double)b/98);
v=vac;
ge=gef;
cc=coc;
i=0;
if(v!=""){
/*Class For Voice Accountability*/
if(Double.parseDouble(v)<33)
{
classg*=VAwclassg;
classb*=VAwclassb;
}
if((Double.parseDouble(v)>=33)&&(Double.parseDouble(v)<66))
{
classg*=VAmclassg;
classb*=VAmclassb;
}

if(Double.parseDouble(v)>=66)
{
classg*=VAbclassg;
classb*=VAbclassb;
}

/*Class For Govt Eff*/
if(Double.parseDouble(ge)<33)
{
classg*=GEwclassg;
classb*=GEwclassb;
}
if((Double.parseDouble(ge)>=33)&&(Double.parseDouble(ge)<66))
{
classg*=GEmclassg;
classb*=GEmclassb;
}
if(Double.parseDouble(ge)>=66)
{
classg*=GEbclassg;
classb*=GEbclassb;
}

/*Class For Control of Corruption*/
if(Double.parseDouble(cc)<33)
{
classg*=CCwclassg;
classb*=CCwclassb;
}
if((Double.parseDouble(cc)>=33)&&(Double.parseDouble(cc)<66))
{
classg*=CCmclassg;
classb*=CCmclassb;
}
if(Double.parseDouble(cc)>=66)
{
classg*=CCbclassg;
classb*=CCbclassb;
}
classg*=pgood;
classb*=pbad;String cl;
if(classg>classb)
cl="Good";
else
cl="Bad";
return cl;
}
else
	return "";
}}
