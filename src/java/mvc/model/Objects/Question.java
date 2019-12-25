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
public class Question {
    private String ID;
    private String Text;
    private String Type;

    public String getID() {
        return ID;
    }
    
    public String getText() {
        return Text;
    }
    public String getType() {
        return Type;
    }
    public void setID(String id) {
        this.ID = id;
    }
    public void setType(String type) {
        this.Type = type;
    }
    public void seText(String text) {
        this.Text = text;
    }
}
