/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.model.Objects;

/**
 *
 * @author Kareem E.Farouk
 */
public class Answer {
    private String ID;
    private String Text;
    private String QID;
    private String CorrectOrnot;

    public String getID() {
        return ID;
    }
    
    public String getText() {
        return Text;
    }
    
    public String getQID() {
        return QID;
    }
    public String getCorrectOrnot() {
        return CorrectOrnot;
    }
    public void setID(String id) {
        this.ID = id;
    }
     public void setText(String text) {
        this.Text= text;
    }
    public void setQID(String qid) {
        this.QID = qid;
    }
    public void setCorrectOrnot(String correct) {
        this.CorrectOrnot = correct;
    }
}
