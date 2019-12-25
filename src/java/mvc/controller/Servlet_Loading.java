package mvc.controller;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import mvc.model.Objects.LoadData;

/**
 * Servlet implementation class Servlet_Loading
 */
@WebServlet("/Servlet_Loading")
public class Servlet_Loading extends HttpServlet {
	private static final long serialVersionUID = 1L;

	LoadData ld = null;

	ArrayList<String> ET = new ArrayList<String>();
	ArrayList<String> Q = new ArrayList<String>();
	ArrayList<String> A = new ArrayList<String>(); // ans of Q
	ArrayList<String> allA = new ArrayList<String>(); // ans of all

	HttpSession session = null;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Servlet_Loading() {
		// TODO Auto-generated constructor stub
		super();
		ld = new LoadData();
		ET = null;
		Q = null;
		A = null;
		allA = null;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String OP = request.getParameter("OP").toString(); // Operation
		session = request.getSession(); // the same thing like request.getSession(true);
		if (OP.equals("sh_ex")) { // on click of "List of Exams" Button:

			String cid = session.getAttribute("CID").toString();
			System.out.println("CID: " + cid);
			ET = ld.Exam_of_cand(cid);
			session.setAttribute("Exams", ET);
			response.sendRedirect("ShowExmas.jsp");

		} else if (OP.equals("sh_Q")) {// on click of "Exam" Button:
			// three random Questions for Exam.......................................
			String myExam = request.getParameter("ET");
			Q = ld.Random_Ques_of_exam(myExam);
			session.setAttribute("Qes", Q);
			System.out.println("Exam: " + myExam);
			System.out.println("........................................");
			// .....................................................................
			allA = new ArrayList<String>();
			A = new ArrayList<String>();
			// answers for questions
			for (int q = 0; q < Q.size() - 1; q += 2) {
				A = ld.Ans_of_Qes(Q.get(q));
				allA.addAll(A);
				A.removeAll(A);
			}
			session.setAttribute("Ans", allA);

			System.out.println("allA_size:" + allA.size());
			for (int i = 0; i < allA.size(); i++)
				System.out.println(allA.get(i));

			
			response.sendRedirect("MyExam.jsp?ET=" + myExam);
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
