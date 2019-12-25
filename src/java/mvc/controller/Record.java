package mvc.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSession;

import java.sql.*;
import java.util.ArrayList;
import mvc.model.Utilities.DBconnect;

/**
 * Servlet implementation class Record
 */
@WebServlet("/Record")
public class Record extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Record() {
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
			HttpSession session = request.getSession(); // the same thing like request.getSession(true);
			int CandID = Integer.parseInt(session.getAttribute("CID").toString());
			String ET = session.getAttribute("ET").toString();
			ArrayList<String> MyQ = (ArrayList<String>) session.getAttribute("Qes");
			ArrayList<String> allAns = (ArrayList<String>) session.getAttribute("Ans");

			int cand_exam = 0, AnsIndex = 0, done = 0, totalScore = -1, setTS = 0;
			ResultSet RS = null;

			DBconnect db = new DBconnect();
			Connection con = db.createConnection();
			Statement Stmt = con.createStatement();

			for (int q = 0; q < MyQ.size() - 1; q += 2) {
				for (int a = 0; a < 4; a++) {

					cand_exam = Stmt.executeUpdate("INSERT INTO candidate_exam VALUES('" + CandID + "' , '" + ET
							+ "' , '" + MyQ.get(q) + "' , '" + allAns.get(AnsIndex) + "');");

					AnsIndex += 2;
				}

			}
			done = Stmt.executeUpdate("UPDATE hr_exam " + "SET done = '" + 1 + "' where (CID) ='" + CandID
					+ "' and (ExamType)='" + ET + "';");
			RS = Stmt.executeQuery("SELECT SUM(Agrade) FROM candidate_q_a where (CID)=" + "\"" + CandID + "\"" + ";");
			if (RS.next()) {
				totalScore = Integer.parseInt(RS.getString(1));
			}
			setTS = Stmt.executeUpdate(
					"UPDATE candidate " + "SET totalscore = '" + totalScore + "' where (CID)='" + CandID + "';");

			if (cand_exam == 1 && done == 1 && setTS == 1) {
				response.sendRedirect("Login.html");
			} else
				response.sendRedirect("ShowExmas.jsp");

			RS.close();
			Stmt.close();
			con.close();

		} catch (Exception e) {
			System.out.println(e.toString());

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
		doGet(request, response);
	}

}
