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
public class Candidate {
    private String id;
    private String username;
    private String password;
    private String cv;
    private String email;
    private String totalScore;
    
    public String getUserName() {
        return username;
    }
    public String getTotalScore() {
        return totalScore;
    }
    public String getEmail() {
        return email;
    }
    
    public String getPassword() {
        return password;
    }
    public String getID() {
        return id;
    }
    public String getCV() {
        return cv;
    }
    public void setUserName(String username) {
        this.username = username;
    }
    public void setID(String id) {
        this.id = id;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setCV(String cv) {
        this.cv = cv;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setTotalScore(String tscore) {
        this.totalScore = tscore;
    }
    
}
