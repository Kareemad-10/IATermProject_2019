package mvc.controller;

import java.io.IOException;
import java.io.PrintWriter;
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
import javax.swing.text.StyledEditorKit.BoldAction;
import mvc.model.Utilities.DBconnect;

/**
 * Servlet implementation class Myservlet
 */
@WebServlet("/Myservlet")
public class Myservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public Myservlet() {
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
			int approv = -2;
			int insertedrows = 0, Agrade = 0;
			String OP = request.getParameter("OP").toString(); // Operation
			DBconnect db = new DBconnect();
			Connection con = db.createConnection();
			Statement Stmt = null;
			ResultSet RS = null;
			HttpSession mysession = request.getSession(true);

			if (OP.equals("ifApprov")) { // Checking Approval :
				String email = request.getParameter("EM").toString();
				String un = mysession.getAttribute("un").toString();
				String ps = mysession.getAttribute("ps").toString();
                                
				Stmt = con.createStatement();
				RS = Stmt.executeQuery(" select (approval) from candidate where (email)=" + "\"" + email + "\""
						+ "and (username)=" + "\"" + un + "\"" + " and (password)=" + "\"" + ps + "\"" + ";");

				if (RS.next()) {
					approv = Integer.parseInt(RS.getString("approval"));
					if (approv == 1)
						out.print("Congratulation!!! ,you are accepted ");
					else if (approv == 0)
						out.print("We Are Sorry for you :(  ,you are rejected ");
					else if (approv == -1)
						out.print("please wait for HR response and try again later !");
					else
						out.print("There is a problem !!");
				} else {
					out.print("There is a problem! Please Enter Your Correct E-mail !");
				}
				RS.close();
				Stmt.close();
				con.close();

			} else if (OP.equals("signup")) { // Checking User name Excitation for sign up
				String un = request.getParameter("UN").toString();

				
				Stmt = con.createStatement();
				RS = Stmt.executeQuery(" select * from candidate where (username)=" + "\"" + un + "\"" + "; ");

				if (RS.next())
					out.print("Please Enter Another Name !");
				else if (un.equals(""))
					out.print("0");
				else {
					out.print("free");
				}
				RS.close();
				Stmt.close();
				con.close();

			} else if (OP.equals("regist")) { // Checking E-mail Excitation for Registeration :
				String email = request.getParameter("EM").toString();

				
				Stmt = con.createStatement();
				RS = Stmt.executeQuery(" select * from candidate where (email)=" + "\"" + email + "\"" + "; ");

				if (RS.next())
					out.print("already taken");
				else if (email.equals(""))
					out.print("0");
				else
					out.print("you can take this");

				RS.close();
				Stmt.close();
				con.close();
			} else if (OP.equals("HaveExmas")) { // Checking if there is exams :
				String CID = (String) mysession.getAttribute("CID");
				String EM = request.getParameter("EM").toString();
				boolean trueEmail = false;

				
				Stmt = con.createStatement();
				RS = Stmt.executeQuery("select * from candidate where (CID)=" + "\"" + CID + "\"" + "and (email) ="
						+ "\"" + EM + "\"" + ";");
				if (RS.next())
					trueEmail = true;
				else {
					trueEmail = false;
					out.print("Please Enter Your Correct E-mail !");
				}
				RS.close();
				if (trueEmail == true) {
					RS = Stmt.executeQuery("select * from hr_exam where (CID)=" + "\"" + CID + "\"" + ";");
					if (RS.next()) {
						out.print("yes");
					} else {
						out.print("There's no Exams for you!");
					}
				}
				RS.close();
				Stmt.close();
				con.close();
			} else if (OP.equals("AA")) { // Answer Action
				String CID = (String) mysession.getAttribute("CID");
				String ET = request.getParameter("ET").toString();
				String QID = request.getParameter("QID").toString();
				String AID = request.getParameter("AID").toString();
				System.out.println(QID + ":" + AID);

				
				Stmt = con.createStatement();
				RS = Stmt.executeQuery(
						" select * from answer where (AID)=" + "\"" + AID + "\"" + " and (Correct) IS true ;");

				if (RS.next()) {
					out.print("correct");
					Agrade = 1;
				} else {
					out.print("incorrect");
					Agrade = 0;
				}
				RS.close();
				insertedrows = Stmt.executeUpdate("INSERT INTO candidate_q_a VALUES('" + CID + "' , '" + ET + "' , '"
						+ QID + "' , '" + AID + "' , '" + Agrade + "');");

				Stmt.close();
				con.close();
			}

		} catch (

		SQLException sqlE) {
			out.print(sqlE.toString());
		} finally {
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
