/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.model.Objects;

import java.util.Vector;

/**
 *
 * @author Kareem E.Farouk
 */
public class Results {
    private Vector cV;
    private Vector totalScore_C;
    private Vector Q_T_C;
    private Vector A_T_C;
    private Vector exams_Score;
    private Vector exams_Type;
    
    public Vector getcV() {
        return cV;
    }
   public Vector gettotalScoreV(){
        return totalScore_C;
    }
    public Vector getexamsScoreV() {
        return exams_Score;
    }
    public  Vector getexamsTypeV() {
       return exams_Type;
    }
    public Vector getQTV(){
        return Q_T_C;
    }
    public Vector getATV(){
        return A_T_C;
    }
    public void setcV(Vector v) {
        this.cV = v;
    }
    public void setQTV(Vector v) {
        this.Q_T_C = v;
    }
    public void setATV(Vector v) {
        this.A_T_C = v;
    }
    public void settotalScoreV(Vector v) {
        this.totalScore_C = v;
    }
    public void setexamsScoreV(Vector v) {
        this.exams_Score = v;
    }
    public void setexamsTypeV(Vector v) {
        this.exams_Type = v;
    }
    
}
