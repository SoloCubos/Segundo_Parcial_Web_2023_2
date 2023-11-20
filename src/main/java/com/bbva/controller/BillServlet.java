package com.bbva.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import com.bbva.model.User;
import com.bbva.models.DAO.BillDAO;
import com.bbva.models.DAO.Login;

/**
 * Servlet implementation class BillServlet
 */
public class BillServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Login login;
	private BillDAO billDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BillServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		this.login = new Login();
		this.billDAO = new BillDAO();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		System.out.println(action);
		try {
			switch (action) {
			case "/getallbills":
				getAllBills(request, response);
				break;
			case "/newbill":
				showNewBillForm(request, response);
				break;
			case "/deletebill":	
				deleteBill(request, response);
				break;			
			case "/new":	
				newBill(request, response);
				break;
			case "/getonebill":
				getOneBill(request, response);
				break;	
			case "/login":
				userLogin(request, response);
				break;
			default:
				showLoginForm(request, response);
				break;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	public void showLoginForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
		dispatcher.forward(request, response);
	}
	
	private void userLogin(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException, SQLException {
		
		String username = request.getParameter("username");
		String pass = request.getParameter("pass");
		
		System.out.println(username + pass);
		
		if(login.validateLogin(username, pass)){
			response.sendRedirect("getallbills");
			
		}else {
			response.sendRedirect("");
		}
		

	}


	private void getOneBill(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void newBill(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void deleteBill(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void showNewBillForm(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void getAllBills(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}
	
}
