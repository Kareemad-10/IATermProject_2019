package mvc.controller;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mvc.model.Utilities.DBconnect;
//import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SignUP
 */
@WebServlet("/SignUP")
public class SignUP extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SignUP() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out = response.getWriter();
		try {
			Statement Stmt = null;
			int insetRows = 0;
                        DBconnect db = new DBconnect();
			Connection con = db.createConnection();
			String un = request.getParameter("UN").toString();
			String ps = request.getParameter("PASS").toString();

			Stmt = con.createStatement();
			insetRows = Stmt.executeUpdate(
					"INSERT INTO candidate (username, password) " + 
					"VALUES ('"+un+"', '"+ps+"');");

			if (insetRows == 1) {
				response.sendRedirect("Login.html");

			}
			Stmt.close();
			con.close();
		} catch (SQLException sqlE) {
			out.println(sqlE.toString());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
