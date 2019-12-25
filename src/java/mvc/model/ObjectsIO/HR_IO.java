/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.model.ObjectsIO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import mvc.model.Objects.Answer;
import mvc.model.Objects.Candidate;
import mvc.model.Objects.Exam;
import mvc.model.Objects.HR;
import mvc.model.Objects.Question;
import mvc.model.Objects.Results;
import mvc.model.Objects.hrExam;
import mvc.model.Utilities.DBconnect;
import mvc.model.Utilities.Tools;

/**
 *
 * @author Kareem E.Farouk
 * 
 * 
 * 
 */
public class HR_IO {
    
    public boolean authenticate_HR(HR hr)
    {
        boolean flag = false;
        DBconnect db = new DBconnect();
        
        String username = hr.getUserName();
        String password = hr.getPassword();        
        
        Connection conn = db.createConnection();
        try {
            
            String query = "SELECT * FROM hr";
            Statement stat = conn.createStatement();
            ResultSet res = stat.executeQuery(query);
            while(res.next()){
             if((username.equals(res.getString(1))) && (password.equals(res.getString(2)))){
                 flag = true;
             }
        }
        } catch (SQLException ex) {
            Logger.getLogger(HR_IO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return flag;
    }
        public Vector showCandidate()
        {
           DBconnect db = new DBconnect();
           Vector v = new Vector();
           Connection conn = db.createConnection();
        try {
            
            String query = "SELECT * FROM candidate";
            Statement stat = conn.createStatement();
            ResultSet res = stat.executeQuery(query);
            while(res.next()){
             Candidate can = new Candidate();
             if((res.getInt(9)==1)){
                 can.setID(res.getString(1));
                 can.setUserName(res.getString(2));
                 can.setCV(res.getString(4));
                 v.add(can);
             }
        }
        } catch (SQLException ex) {
            Logger.getLogger(HR_IO.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        return v;
    }
    public void approveCandidate(String[] id_can){
        DBconnect db = new DBconnect();
        Connection conn = db.createConnection();
        try {            
            for (int i=0; i<id_can.length; i++) {
                
                String query = "UPDATE candidate SET approval = 1 WHERE CID = " + id_can[i];
                Statement stat = conn.createStatement();
                stat.executeUpdate(query);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(HR_IO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void toHRExamTable(String id_can, String[] exams_can){
        //"Insert Into hr" + " Values ( "+"\""+ username + "\"," + "\"" + password + "\"";
         
        DBconnect db = new DBconnect();
        Tools t = new Tools();
        Connection conn = db.createConnection();
        try {            
            for (int i=0; i<exams_can.length; i++) {
                   String query = "Insert Into hr_exam" + " Values ( "+"\""+ id_can + "\"," + "\"" + exams_can[i] +"\","+ "\"" + t.getDate() + "\"" + ", 0, "+ i + ");";
                   Statement stat = conn.createStatement();
                   stat.executeUpdate(query);  
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(HR_IO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public Vector showExamTypes(){
           DBconnect db = new DBconnect();
           Vector v = new Vector();
           Connection conn = db.createConnection();
        try {
            
            String query = "SELECT * FROM exams";
            Statement stat = conn.createStatement();
            ResultSet res = stat.executeQuery(query);
            while(res.next()){
             Exam e = new Exam();
             e.setID(res.getString(1));
             e.setType(res.getString(2));
             v.add(e);

        }
        } catch (SQLException ex) {
            Logger.getLogger(HR_IO.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        return v;
    }
    public void updateType(String id, String type){
        DBconnect db = new DBconnect();
        Connection conn = db.createConnection();///"UPDATE candidate SET approval = 1 WHERE CID = " + id_can[i];
        try {            
                String query = "UPDATE exams SET examtype = "+ "\"" + type +"\" " + "WHERE examID = \"" + id + "\";" ;
                Statement stat = conn.createStatement();
                stat.executeUpdate(query); 
            
        } catch (SQLException ex) {
            Logger.getLogger(HR_IO.class.getName()).log(Level.SEVERE, null, ex); 
        }
    }
    public void deleteType(String id){
        DBconnect db = new DBconnect();
        Connection conn = db.createConnection();///"UPDATE candidate SET approval = 1 WHERE CID = " + id_can[i];
        try {            
                String query = "DELETE " + "FROM exams where examID = " + id ; 
                Statement stat = conn.createStatement();
                stat.executeUpdate(query);
            
        } catch (SQLException ex) {
            Logger.getLogger(HR_IO.class.getName()).log(Level.SEVERE, null, ex); 
        }       
    }
    public void addType(String id, String type){ //"Insert Into hrexam" + " Values ( "+"\""+ id_can + "\"," + "\"" + exams_can[i] +"\");";
         DBconnect db = new DBconnect();
        Connection conn = db.createConnection();///"UPDATE candidate SET approval = 1 WHERE CID = " + id_can[i];
        try {            
                String query = "Insert Into exams" + " Values ( "+"\""+ id + "\"," + "\"" + type +"\");";
                Statement stat = conn.createStatement();
                stat.executeUpdate(query);
            
        } catch (SQLException ex) {
            Logger.getLogger(HR_IO.class.getName()).log(Level.SEVERE, null, ex); 
        }  
    } 
    public Vector showAvailableQuestions(){
           DBconnect db = new DBconnect();
           Vector v = new Vector();
           Connection conn = db.createConnection();
        try {
            
            String query = "SELECT * FROM question";
            Statement stat = conn.createStatement();
            ResultSet res = stat.executeQuery(query);
            while(res.next()){
                Question q = new Question();
                q.setID(res.getString(1));
                q.seText(res.getString(2));
                q.setType(res.getString(3));
                v.add(q);

        }
        } catch (SQLException ex) {
            Logger.getLogger(HR_IO.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        return v; 
    }
    public void updateQuestion(String id, String text, String type){
        DBconnect db = new DBconnect();
        Connection conn = db.createConnection();///"UPDATE exams SET examtype = "+ "\"" + type +"\" " + "WHERE examID = \"" + id + "\";" ;
        try {            
                String query = "UPDATE question SET Qtext = "+ "\"" + text +"\"" + ", ExamType = "+ "\"" + type + "\" " + "Where QID = \"" + id + "\";" ;
                Statement stat = conn.createStatement();
                stat.executeUpdate(query); 
            
        } catch (SQLException ex) {
            Logger.getLogger(HR_IO.class.getName()).log(Level.SEVERE, null, ex); 
        }
    }
    public void deleteQuestion(String id){
        DBconnect db = new DBconnect();
        Connection conn = db.createConnection();///"UPDATE candidate SET approval = 1 WHERE CID = " + id_can[i];
        try {            
                String query = "DELETE " + "FROM question where QID = " + id ;  
                Statement stat = conn.createStatement();
                stat.executeUpdate(query);
            
        } catch (SQLException ex) {
            Logger.getLogger(HR_IO.class.getName()).log(Level.SEVERE, null, ex);
        }       
    }
    public void addQuestion(String id, String text, String type){
        DBconnect db = new DBconnect();
        Connection conn = db.createConnection();///"Insert Into exams" + " Values ( "+"\""+ id + "\"," + "\"" + type +"\");"; 
        try {            
                String query = "Insert Into question" + " Values ( "+"\""+ id + "\"," + "\"" + text + "\"," + "\"" + type +"\");";
                Statement stat = conn.createStatement();
                stat.executeUpdate(query);
            
        } catch (SQLException ex) {
            Logger.getLogger(HR_IO.class.getName()).log(Level.SEVERE, null, ex); 
        }  
    }
    public Vector showAvailableAnswers(){
        DBconnect db = new DBconnect();
        Vector v = new Vector();
        Connection conn = db.createConnection();
        try {
            
            String query = "SELECT * FROM answer";
            Statement stat = conn.createStatement();
            ResultSet res = stat.executeQuery(query);
            while(res.next()){
                Answer a = new Answer();
                a.setID(res.getString(1));
                a.setText(res.getString(2));
                a.setQID(res.getString(3));
                a.setCorrectOrnot(res.getString(4));
                v.add(a);

        }
        } catch (SQLException ex) {
            Logger.getLogger(HR_IO.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        return v; 
    }
    public void updateAnswer(String id, String text, String qid, String correct){
        DBconnect db = new DBconnect();
        Connection conn = db.createConnection();///"UPDATE exams SET examtype = "+ "\"" + type +"\" " + "WHERE examID = \"" + id + "\";" ;
        try {            
                String query = "UPDATE answer SET Atext = "+ "\"" + text +"\"" + ", QID = "+ "\"" + qid + "\"" + ", CorrectOrNot = " + "\"" + correct + "\"" +" Where AID = \"" + id + "\";" ;
                Statement stat = conn.createStatement();
                stat.executeUpdate(query); 
            
        } catch (SQLException ex) {
            Logger.getLogger(HR_IO.class.getName()).log(Level.SEVERE, null, ex); 
        }
    }
    public void deleteAnswer(String id){
        DBconnect db = new DBconnect();
        Connection conn = db.createConnection();///"UPDATE candidate SET approval = 1 WHERE CID = " + id_can[i];
        try {            
                String query = "DELETE " + "FROM Answer where AID = " + id ;  
                Statement stat = conn.createStatement();
                stat.executeUpdate(query);
            
        } catch (SQLException ex) {
            Logger.getLogger(HR_IO.class.getName()).log(Level.SEVERE, null, ex);
        }       
    }
    public void addAnswer(String id, String text, String qid, String correct){
        DBconnect db = new DBconnect();
        Connection conn = db.createConnection();///"Insert Into exams" + " Values ( "+"\""+ id + "\"," + "\"" + type +"\");"; 
        try {            
                String query = "Insert Into answer" + " Values ( "+"\""+ id + "\"," + "\"" + text + "\"," + "\"" + qid + "\"," + "\"" + correct + "\");";
                Statement stat = conn.createStatement();
                stat.executeUpdate(query);
            
        } catch (SQLException ex) {
            Logger.getLogger(HR_IO.class.getName()).log(Level.SEVERE, null, ex); 
        }  
    }
    public Vector getCbyName(String key){
        DBconnect db = new DBconnect();
        Vector v = new Vector();
        Connection conn = db.createConnection();
        try {
            
            String query = "SELECT * FROM candidate";
            Statement stat = conn.createStatement();
            ResultSet res = stat.executeQuery(query);
            while(res.next()){
             if((res.getString(2).equals(key))){
                 v.add(res.getString(1));
                 v.add(res.getString(3));
                 v.add(res.getString(4));
                 v.add(res.getString(8));
                 v.add("candidate");
             }
        }
        } catch (SQLException ex) {
            Logger.getLogger(HR_IO.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        return v;
    }
    public Vector getCbyEmail(String key){
        DBconnect db = new DBconnect();
        Vector v = new Vector();
        Connection conn = db.createConnection();
        try {
            
            String query = "SELECT * FROM candidate";
            Statement stat = conn.createStatement();
            ResultSet res = stat.executeQuery(query);
            while(res.next()){
             if((res.getString(3).equals(key))){
                 v.add(res.getString(1));
                 v.add(res.getString(2));
                 v.add(res.getString(4));
                 v.add(res.getString(8));
                 v.add("candidate");
             }
        }
        } catch (SQLException ex) {
            Logger.getLogger(HR_IO.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        return v;
    }
    public Vector getE_Python(String key){
        DBconnect db = new DBconnect();
        Vector v = new Vector();
        Connection conn = db.createConnection();
        try {
            
            String query = "SELECT * FROM hr_exam";
            Statement stat = conn.createStatement();
            ResultSet res = stat.executeQuery(query);
            while(res.next()){
             if((res.getString(2).equals(key))){
                 v.add(res.getString(1));
                 v.add(res.getString(3));
                 v.add("hr_exam");
             }
        }
        } catch (SQLException ex) {
            Logger.getLogger(HR_IO.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        return v;
        
    }
    public Vector getE_Java(String key){
        DBconnect db = new DBconnect();
        Vector v = new Vector();
        Connection conn = db.createConnection();
        try {
            
            String query = "SELECT * FROM hr_exam";
            Statement stat = conn.createStatement();
            ResultSet res = stat.executeQuery(query);
            while(res.next()){
             if((res.getString(2).equals(key))){
                 v.add(res.getString(1));
                 v.add(res.getString(3));
                 v.add("hr_exam");
             }
        }
        } catch (SQLException ex) {
            Logger.getLogger(HR_IO.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        return v;
    }
    public Vector getE_Database(String key){
        DBconnect db = new DBconnect();
        Vector v = new Vector();
        Connection conn = db.createConnection();
        try {
            
            String query = "SELECT * FROM hr_exam";
            Statement stat = conn.createStatement();
            ResultSet res = stat.executeQuery(query);
            while(res.next()){
             if((res.getString(2).equals(key))){
                 v.add(res.getString(1));
                 v.add(res.getString(3));
                 v.add("hr_exam");
             }
        }
        } catch (SQLException ex) {
            Logger.getLogger(HR_IO.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        return v;
    }
    public Vector getE_Iq(String key){
        DBconnect db = new DBconnect();
        Vector v = new Vector();
        Connection conn = db.createConnection();
        try {
            
            String query = "SELECT * FROM hr_exam";
            Statement stat = conn.createStatement();
            ResultSet res = stat.executeQuery(query);
            while(res.next()){
             if((res.getString(2).equals(key))){
                 v.add(res.getString(1));
                 v.add(res.getString(3));
                 v.add("hr_exam");
             }
        }
        } catch (SQLException ex) {
            Logger.getLogger(HR_IO.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        return v;
    }
    public Vector getE_English(String key){
        DBconnect db = new DBconnect();
        Vector v = new Vector();
        Connection conn = db.createConnection();
        try {
            
            String query = "SELECT * FROM hr_exam";
            Statement stat = conn.createStatement();
            ResultSet res = stat.executeQuery(query);
            while(res.next()){
             if((res.getString(2).equals(key))){
                 v.add(res.getString(1));
                 v.add(res.getString(3));
                 v.add("hr_exam");
             }
        }
        } catch (SQLException ex) {
            Logger.getLogger(HR_IO.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        return v;
    }
    public Vector getEbyDate(String key){
        DBconnect db = new DBconnect();
        Vector v = new Vector();
        Connection conn = db.createConnection();
        try {
            
            String query = "SELECT * FROM hr_exam";
            Statement stat = conn.createStatement();
            ResultSet res = stat.executeQuery(query);
            while(res.next()){
             if((res.getString(3).equals(key))){
                 v.add(res.getString(1));
                 v.add(res.getString(2));
                 v.add("hr_exam");
             }
        }
        } catch (SQLException ex) {
            Logger.getLogger(HR_IO.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        return v;   
    }
    public Results showResults(){
        
        Results r = new Results();
        Vector cid = new Vector();
        Vector Tscore = new Vector();
        Vector Exams_res = new Vector();
        Vector Exams = new Vector();

        try{
            DBconnect db = new DBconnect();
            Connection conn = db.createConnection();
        
            String query = "SELECT CID, totalscore FROM candidate";
            Statement stat = conn.createStatement();
            ResultSet res = stat.executeQuery(query);
            

            while (res.next()){
                cid.add(res.getString(1));
                Tscore.add(res.getString(2));
            }
            res.close();
            for(int i = 0 ; i < cid.size() ; i++){
            String query2 = "SELECT DISTINCT ExamType FROM candidateqa where CID = " + cid.get(i);
            res = stat.executeQuery(query2);
            while (res.next()){
                Exams.add(res.getString(1));
            }
            Exams.add("$");

            res.close();

            for( int e = 0 ; e < Exams.size() ; e++){
                String query3 = "SELECT SUM(QGrade) FROM candidateqa where CID = " + cid.get(i) +" and ExamType = "+ Exams.get(e);
                res = stat.executeQuery(query3);
                if (res.next()){
                    Exams_res.add(res.getString(1)); // Score of each exam
                }
                 res.close();    
            }
                Exams_res.add("$");
            
            }
        }catch(SQLException ex){
                        Logger.getLogger(HR_IO.class.getName()).log(Level.SEVERE, null, ex);

        }
        r.setcV(cid);
        r.settotalScoreV(Tscore);
        r.setexamsScoreV(Exams_res);
        r.setexamsTypeV(Exams);
        
        return r;   

        }
    public Results showCanExams(){
        Vector cid = new Vector();
        Vector Exams = new Vector();
        Vector Exams_Q = new Vector();
        Vector Exams_Q_T = new Vector();
        Vector Exams_A = new Vector();
        Vector Exams_A_T = new Vector();
        Results r = new Results();
        try{
            DBconnect db = new DBconnect();
            Connection conn = db.createConnection();
        
            String query = "SELECT CID FROM candidateqa";
            Statement stat = conn.createStatement();
            ResultSet res = stat.executeQuery(query);
            while (res.next()){
                cid.add(res.getString(1));
            }
            res.close();
            for(int i = 0 ; i < cid.size() ; i++){
            String query2 = "SELECT DISTINCT ExamType FROM candidateqa where CID = " + cid.get(i);
            res = stat.executeQuery(query2);
            while (res.next()){
                Exams.add(res.getString(1));
            }
            Exams.add("$");
            res.close();

            for( int e = 0 ; e < Exams.size() ; e++){
                String query3 = "SELECT QID, AID FROM candidateqa where CID = " + cid.get(i) +" and ExamType = "+ Exams.get(e);
                res = stat.executeQuery(query3);
                while (res.next()){
                    Exams_Q.add(res.getString(1)); // Score of each exam
                    Exams_A.add(res.getString(2));
                }
                 res.close();    
            }
                Exams_Q.add("$");
                Exams_A.add("$");
            
            }
            for( int e = 0 ; e < Exams_Q.size() ; e++){
                String query4 = "SELECT Qtext FROM question where QID = " + Exams_Q.get(e);
                res = stat.executeQuery(query4);
                while (res.next()){
                    Exams_Q_T.add(res.getString(1)); // Score of each exam
                }
                 res.close();    
            }
            Exams_Q_T.add("$");
            for( int e = 0 ; e < Exams_A.size() ; e++){
                String query5 = "SELECT Atext FROM answer where AID = " + Exams_A.get(e);
                res = stat.executeQuery(query5);
                while (res.next()){
                    Exams_A_T.add(res.getString(1)); // Score of each exam
                }
                 res.close();    
            }
            Exams_A_T.add("$");
            
        }catch(SQLException ex){
                        Logger.getLogger(HR_IO.class.getName()).log(Level.SEVERE, null, ex);
        }
        r.setcV(cid);
        r.setexamsTypeV(Exams);
        r.setQTV(Exams_Q_T);
        r.setATV(Exams_A_T);
        return r;   
    }
    public String[] spliTTing(String str){
        String temp = "";
        int count = 0;
        String[] A = null;
        for (int i = 0; i < str.length(); i++) {
            if(!(str.charAt(i)=='/')){
                temp+=str.charAt(i);
            }
            else{
               A[i] = temp;
               count++;
            }
               
        }
        return A;
    }
}
