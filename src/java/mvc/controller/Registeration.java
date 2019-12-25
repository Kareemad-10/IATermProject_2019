package mvc.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
//import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import mvc.model.Utilities.DBconnect;

/**
 * Servlet implementation class Registeration
 */
@WebServlet("/Registeration")
public class Registeration extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Registeration() {
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

			DBconnect db = new DBconnect();
			Connection con = db.createConnection();
			Statement Stmt = null;
			int insetRows = 0;
			HttpSession session = request.getSession(); // the same thing like request.getSession(true);
			String un = session.getAttribute("un").toString();
			String ps = session.getAttribute("ps").toString();

			String Email = request.getParameter("EM").toString();
			String CV = request.getParameter("CV").toString();
			String Tele = request.getParameter("TELE").toString();

			Stmt = con.createStatement();
			insetRows = Stmt.executeUpdate("UPDATE candidate " + "SET email = '" + Email + "' ,cv = '" + CV
					+ "' , telephone='" + Tele + "' , registered='"+1+"' WHERE username= '" + un + "' and password= '" + ps + "';");

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
