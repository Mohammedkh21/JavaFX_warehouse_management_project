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
public class Worker {
    private int id ,salary ,start_work,finshed_work,houers;

    public int getStart_work() {
        return start_work;
    }

    public void setStart_work(int start_work) {
        this.start_work = start_work;
    }

    public int getFinshed_work() {
        return finshed_work;
    }

    public void setFinshed_work(int finshed_work) {
        this.finshed_work = finshed_work;
    }

    public int getHouers() {
        return houers;
    }

    public void setHouers(int houers) {
        this.houers = houers;
    }
    private String name,phone;

    public Worker( int salary, String name, String phone) {
        
        this.salary = salary;
        this.name = name;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Worker :" + "\nid=" + id + "\nsalary=" + salary + "\nstart_work=" + start_work + "\nfinshed_work=" + finshed_work + "\nhouers=" + houers + "\nname=" + name + "\nphone=" + phone ;
    }

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
