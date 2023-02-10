package com.dashboard.servlet.toolservlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dashboard.objects.SamplePOJO;

/**
 * Servlet implementation class JSPServlet
 */
@WebServlet("/jspform")
public class JSPServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JSPServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.sendRedirect("jspform.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String input=request.getParameter("inputname");
		String input2=request.getParameter("inputnametwo");
		//change request on post (form submit)
		request.setAttribute("inputname", input);
		request.setAttribute("inputnametwo", input2);
		
		//----------additional for adding objects instead of strings------------------
		// creat pojo list 
		SamplePOJO sp = new SamplePOJO();
		SamplePOJO sp2 = new SamplePOJO();
		sp.setFieldName(input);
		sp2.setFieldName(input2);
		List<SamplePOJO> inputItemsToAdd= new ArrayList();
		inputItemsToAdd.add(sp);
		inputItemsToAdd.add(sp2);
		request.setAttribute("inputObjects", inputItemsToAdd);
		//------------------------------------------------------------------------------
		
		//Send request to JSP for further processing
		RequestDispatcher dispatcher = request.getRequestDispatcher("jspform.jsp");
		dispatcher.forward(request, response);
		
	}

}
