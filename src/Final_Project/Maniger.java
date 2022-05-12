/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Final_Project;

/**
 *
 * @author Mohammedkh21
 */
public class Maniger {
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    private String name , password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Maniger(String name, String password) {
        
        this.name = name;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Maniger" + "\nid=" + id + "\nname=" + name + "\npassword=" + password;
    }

  
    
}
