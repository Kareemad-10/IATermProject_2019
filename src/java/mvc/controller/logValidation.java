package mvc.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
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
 * Servlet implementation class Validation
 */
@WebServlet("/logValidation")
public class logValidation extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public logValidation() {
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
		try {
			HttpSession mysession = request.getSession(true);
                        DBconnect db = new DBconnect();
			String un = request.getParameter("UN");
			String pass = request.getParameter("PASS");

			if (request.getParameter("CAND") != null) { // Log as Candidate 
				Connection con = db.createConnection();
				Statement Stmt = con.createStatement();
				ResultSet RS = Stmt.executeQuery(" select * from candidate where (username)=" + "\"" + un + "\""
						+ "and (password)=" + "\"" + pass + "\"" + "; ");

				if (RS.next()) {
					mysession.setAttribute("un", un);
					mysession.setAttribute("ps", pass);
					mysession.setAttribute("CID", RS.getString("CID"));
					response.sendRedirect("RegisterPage.jsp");
				} else {
					response.sendRedirect("Login.html");
				}
				RS.close();
				Stmt.close();
				con.close();
			} else if (request.getParameter("HR") != null) {// Log as HR 
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3333/termproject", "Abdallah",
						"el7mdullah$1921999");
				Statement Stmt = con.createStatement();
				ResultSet RS = Stmt.executeQuery(" select * from hr_table where (username)=" + "\"" + un + "\""
						+ "and (password)=" + "\"" + pass + "\"" + "; ");

				if (RS.next()) {
					mysession.setAttribute("un", un);
					mysession.setAttribute("ps", pass);
					response.sendRedirect("Hr_Page.jsp");
				} else {
					response.sendRedirect("Login.html");
				}
				RS.close();
				Stmt.close();
				con.close();
			}

		} catch (SQLException sqlE) {
			System.out.println(sqlE.toString());
			response.getWriter().append(sqlE.toString());
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
