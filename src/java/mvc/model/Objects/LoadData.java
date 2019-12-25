package mvc.model.Objects;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import mvc.model.Utilities.DBconnect;

public class LoadData {

	Connection con = null;
	Statement Stmt = null;
	ResultSet RS = null;

	ArrayList<String> ET = new ArrayList<String>();
	ArrayList<String> Q = new ArrayList<String>();
	ArrayList<String> allA = new ArrayList<String>();

	public ArrayList<String> Exam_of_cand(String cid) {

		try {
			DBconnect db = new DBconnect();
			Connection con = db.createConnection();
			Stmt = con.createStatement();
			RS = Stmt.executeQuery(" select (ExamType) from hr_exam where (CID)=" + "\"" + cid + "\"" + " and (done) ="
					+ 0 + " ORDER BY (ExamOrder) ASC;");
			while (RS.next()) {
				ET.add(RS.getString("ExamType").toString());
			}

			RS.close();

		} catch (Exception e1) {
			System.out.println(e1.getMessage().toString());
		}
		return ET;

	}

	public ArrayList<String> Random_Ques_of_exam(String Exam) {

		try {
			Q = new ArrayList<String>();
			con = DriverManager.getConnection("jdbc:mysql://localhost:3333/termproject", "Abdallah",
					"el7mdullah$1921999");
			Stmt = con.createStatement();
			RS = Stmt.executeQuery(" select * from question where (ExamType)=" + "\"" + Exam + "\"" + ""
					+ " ORDER BY RAND()" + " LIMIT 3 ;");
			while (RS.next()) {
				Q.add(RS.getString("QID").toString()); // even : QId
				Q.add(RS.getString("Qtext").toString());// odd : Q_text

			}
			RS.close();
		} catch (Exception e1) {
			System.out.println(e1.getMessage().toString());
		}
		return Q;

	}

	public ArrayList<String> Ans_of_Qes(String QID) {
		try {
			allA = new ArrayList<String>();
			con = DriverManager.getConnection("jdbc:mysql://localhost:3333/termproject", "Abdallah",
					"el7mdullah$1921999");
			Stmt = con.createStatement();
			RS = Stmt.executeQuery(
					" select * from answer where (QID) = " + QID + " and (Correct) IS true " + " ORDER BY RAND() ;");
			if (RS.next()) { // "if" ; because thats one correct answer
				allA.add(RS.getString("AID").toString());// even : AId
				allA.add(RS.getString("Atext").toString());// odd : A_text
			}
			RS.close();
			RS = Stmt.executeQuery(" select * from answer where (QID) = " + QID + " and (Correct) IS false "
					+ " ORDER BY RAND()" + " LIMIT 3 ;");
			while (RS.next()) {// "while" ; because thats three incorrect answers
				allA.add(RS.getString("AID").toString());// even : AId
				allA.add(RS.getString("Atext").toString());// odd : A_text
			}

		} catch (Exception e1) {
			System.out.println(e1.getMessage().toString());
		}
		return allA;
	}

}
