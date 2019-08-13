package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.beans.*;
import com.model.*;
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action=request.getParameter("user");
		if(action == null){
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		else{
			if(action.equals("data-set")){
				String d[][]=Data.getData();
				request.setAttribute("values", d);
				request.getRequestDispatcher("data-set.jsp").forward(request, response);	
			}
			
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action=request.getParameter("user");
		
		double res[]=new double[2];
		
		if(action.equals("clustering")){
			String d[][]=Kmean.kmean();
			request.setAttribute("values", d);
			request.getRequestDispatcher("clustering.jsp").forward(request, response);	
		}
		if(action.equals("prediction")){
			res=Reg.main();
			request.setAttribute("values", res);
			request.getRequestDispatcher("prediction.jsp").forward(request, response);
		}
		if(action.equals("calY")){
			
			res=Reg.main();
			double x=Double.parseDouble(request.getParameter("x"));
		double y=res[0]*x+res[1];	
		request.setAttribute("y", y);
		request.setAttribute("x1", x);
		request.setAttribute("values", res);
		request.getRequestDispatcher("prediction.jsp").forward(request, response);
		}
		if(action.equals("findClass")){
			String va=request.getParameter("va");
			String ge=request.getParameter("ge");
			String cc=request.getParameter("cc");
			String result=Bayes.main(va,ge,cc);
			request.setAttribute("result", result);
			request.setAttribute("va", va);
			request.setAttribute("ge", ge);
			request.setAttribute("cc", cc);
			request.getRequestDispatcher("classification.jsp").forward(request, response);
			
		}
		if(action.equals("classification")){
			String result=Bayes.main("","","");
			request.setAttribute("result", result);
			request.getRequestDispatcher("classification.jsp").forward(request, response);
		}
		if(action.equals("association")){
			String result[][]=Apriori.main1();
			request.setAttribute("values", result);
			request.setAttribute("flag", "false");
			request.getRequestDispatcher("association.jsp").forward(request, response);
		}
		if(action.equals("rules")){
			int minsup=Integer.parseInt(request.getParameter("x"));
			String result[][]=Apriori.main(minsup);
			String result1[][]=Apriori.main1();
			request.setAttribute("values", result1);
			request.setAttribute("res", result);
			request.setAttribute("flag", "true");
		request.getRequestDispatcher("association.jsp").forward(request, response);
		}
		
		}
	}


