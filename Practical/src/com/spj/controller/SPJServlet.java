package com.spj.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.spj.Emp;
import com.spj.dao.EmpDAO;



@WebServlet("/SPJServlet")
public class SPJServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public SPJServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    @EJB
    Emp emp;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		emp.setId(Integer.parseInt(request.getParameter("id")));
		emp.setFname(request.getParameter("firstName"));
		emp.setLname(request.getParameter("lastName"));
		emp.setDesignation(request.getParameter("designation"));
		EmpDAO dao = new EmpDAO();
		dao.add(emp);
		out.print("Hello  "+emp.getDesignation());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
