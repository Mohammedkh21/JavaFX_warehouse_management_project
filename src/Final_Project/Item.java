/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Final_Project;

import java.sql.Timestamp;

/**
 *
 * @author Mohammedkh21
 */
public class Item {
    private int id,amount;
    private Timestamp added_at,lastupdate;
    private String price;

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
    

    public Item( int amount, String name, String description,String price) {
        this.price = price;
        this.amount = amount;
        this.name = name;
        this.description = description;
    }

    public Timestamp getAdded_at() {
        return added_at;
    }

    public void setAdded_at(Timestamp added_at) {
        this.added_at = added_at;
    }

    public Timestamp getLastupdate() {
        return lastupdate;
    }

    public void setLastupdate(Timestamp lastupdate) {
        this.lastupdate = lastupdate;
    }

    @Override
    public String toString() {
        return "Item" + "\nid=" + id + "\namount=" + amount + "\nadded_at=" + added_at + "\nlastupdate=" + lastupdate + 
                "\nprice=" + price + "\nname=" + name + "\ndescription=" + description ;
    }

   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    private String name,description;
    
}
