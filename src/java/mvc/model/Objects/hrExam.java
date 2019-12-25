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
public class hrExam {
    private String cid;
    private String examType;
    private String examDate;
    
    public String getCID() {
        return cid;
    }
    public String getExamType() {
        return examType;
    }
    public String getExamDate() {
        return examDate;
    }
    
    
    public void setCID(String cid) {
        this.cid = cid;
    }
    public void setExamType(String type) {
        this.examType = type;
    }
    public void setExamDate(String date) {
        this.examDate = date;
    }
}
