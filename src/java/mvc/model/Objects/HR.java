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
public class HR {
    
    private String username;
    private String password;
    private boolean ifLoggedOut;

    public String getUserName() {
        return username;
    }
    
    public String getPassword() {
        return password;
    }
    public void setUserName(String username) {
        this.username = username;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public boolean getIfloggedOut() {
        return ifLoggedOut;
    }
    public void setIfloggedOut(boolean b) {
        this.ifLoggedOut = b;
    }
}