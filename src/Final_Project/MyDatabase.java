/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Final_Project;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.util.Date;
import java.sql.Timestamp;

/**
 *
 * @author Mohammedkh21
 */
public class  MyDatabase {
    private static Connection conn = null;
    private static String url = "jdbc:mysql://localhost:3306/final_project_java3";
    private static String username = "root";
    private static String password = "";
    
    
    public static void getConnection() throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection(url, username, password);
        System.out.println("Connection ok");
    }
    
    public static ObservableList<Maniger> getAllManiger() throws SQLException{
        PreparedStatement statment = conn.prepareStatement("select * from admins");
        ResultSet rs = statment.executeQuery();
        ObservableList<Maniger> sl = FXCollections.observableArrayList();
        while(rs.next()){
            int id = rs.getInt("id");
            String name = rs.getString("name");
            
            String password = rs.getString("password");
            
            
            Maniger s = new Maniger(name, password);
            s.setId(id);
            sl.add(s);
        }
        
        return sl;
    }
    public static void addManjer(Maniger Maniger) throws SQLException, ClassNotFoundException, NoSuchAlgorithmException{
        if(conn == null){
            getConnection();
        }
        PreparedStatement statment = conn.prepareStatement("insert into admins(name,password) values(?,?)");
        
        statment.setString(1, Maniger.getName());
        
        String passwordToHash = Maniger.getPassword();
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(passwordToHash.getBytes());
        byte[] bytes = md.digest();
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < bytes.length; i++) {
          sb.append(Integer.toString((bytes[i] & 0xff) + 0x1030, 16).substring(1));
        }
        
        
        statment.setString(2, sb.toString());

        
        statment.executeUpdate();
    }
    
    public static void deleteManjer(int i) throws SQLException, ClassNotFoundException{
        if(conn == null){
            getConnection();
        }
        PreparedStatement statment = conn.prepareStatement("delete from admins where id = ?");
        statment.setInt(1, i);
        
        
        statment.executeUpdate();
    }
    
    public static void UpdateManjer(int id,Maniger Maniger) throws SQLException, ClassNotFoundException, NoSuchAlgorithmException{
        if(conn == null){
            getConnection();
        }
        String passwordToHash = Maniger.getPassword();
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(passwordToHash.getBytes());
        byte[] bytes = md.digest();
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < bytes.length; i++) {
          sb.append(Integer.toString((bytes[i] & 0xff) + 0x1030, 16).substring(1));
        }
        
        PreparedStatement statment = conn.prepareStatement("update admins "
                + "set name='"+ Maniger.getName() +"',password ='"+ sb.toString() +"' where id = ? ");
        statment.setInt(1, id);
        
        
        statment.executeUpdate();
    }
    
    
    public static ObservableList<Item> getAllItems() throws SQLException{
        PreparedStatement statment = conn.prepareStatement("select * from items");
        ResultSet rs = statment.executeQuery();
        ObservableList<Item> sl = FXCollections.observableArrayList();
        while(rs.next()){
            int id = rs.getInt("id");
            String name = rs.getString("name");
            
            String description = rs.getString("description");
            
            int amount = rs.getInt("amount");
            
            Timestamp add = rs.getTimestamp("added_at");
            
            Timestamp update = rs.getTimestamp("lastUpdated");
            
            String price = rs.getString("price");
            
            Item s = new Item(amount,name, description,price);
            s.setId(id);
            s.setAdded_at(add);
            s.setLastupdate(update);
            sl.add(s);
        }
        
        return sl;
    }
    
    public static void addItem(Item Item) throws SQLException, ClassNotFoundException{
        if(conn == null){
            getConnection();
        }
        
        PreparedStatement statment = conn.prepareStatement("insert into items(name,description,amount,price) values(?,?,?,?)");
        
        statment.setString(1, Item.getName());
        statment.setString(2, Item.getDescription());
        statment.setInt(3, Item.getAmount());
        statment.setString(4, Item.getPrice());
        
        
        statment.executeUpdate();
        
    }
    
    public static void deleteItem(int i) throws SQLException, ClassNotFoundException{
        if(conn == null){
            getConnection();
        }
        PreparedStatement statment = conn.prepareStatement("delete from items where id = ?");
        statment.setInt(1, i);
        
        
        statment.executeUpdate();
    }
    
    public static void UpdateItem(int id,Item Item) throws SQLException, ClassNotFoundException{
        if(conn == null){
            getConnection();
        }
        Date date=new Date();
        Timestamp sqlTime=new Timestamp(date.getTime());
        PreparedStatement statment = conn.prepareStatement("update items "
                + "set name='"+ Item.getName() +"',description ='"+ Item.getDescription() +"',amount='"+ Item.getAmount() +"',lastUpdated='"+ sqlTime +"' "
                        + "where id = ? ");
        statment.setInt(1, id);
        
        
        statment.executeUpdate();
    }
    
    public static ObservableList<Worker> getAllWorkers() throws SQLException{
        PreparedStatement statment = conn.prepareStatement("select * from worker");
        ResultSet rs = statment.executeQuery();
        ObservableList<Worker> sl = FXCollections.observableArrayList();
        while(rs.next()){
            int id = rs.getInt("id");
            String name = rs.getString("name");
            
            String phone = rs.getString("phone");
            
            int salary = rs.getInt("salary");
            
            int start = rs.getInt("start_work");
            int finshed = rs.getInt("finished_work");
            int houers = rs.getInt("houers");
            
            Worker s = new Worker(salary,name, phone);
            s.setId(id);
            s.setHouers(houers);
            s.setStart_work(start);
            s.setFinshed_work(finshed);
            s.setId(id);
            
            sl.add(s);
        }
        
        return sl;
    }
    public static void addWorker(Worker Worker) throws SQLException, ClassNotFoundException{
        if(conn == null){
            getConnection();
        }
        int h=0;
        PreparedStatement statment = conn.prepareStatement("insert into worker(name,salary,phone,houers,start_work,finished_work) "
                + "values(?,?,?,?,?,?)");
        
        if(Worker.getFinshed_work()>0){
             h = Worker.getStart_work() - Worker.getFinshed_work();
        }
        int hou = Worker.getHouers() + h;
        
        statment.setString(1, Worker.getName());
        statment.setInt(2, Worker.getSalary());
        statment.setString(3, Worker.getPhone());
        statment.setInt(4, hou);
        statment.setInt(5, Worker.getStart_work());
        statment.setInt(6, Worker.getFinshed_work());

        
        statment.executeUpdate();
    }
    
    public static void deleteWorker(int i) throws SQLException, ClassNotFoundException{
        if(conn == null){
            getConnection();
        }
        PreparedStatement statment = conn.prepareStatement("delete from worker where id = ?");
        statment.setInt(1, i);
        
        
        statment.executeUpdate();
    }
    
    public static void UpdateWorker(int id,Worker Worker) throws SQLException, ClassNotFoundException{
        int start , finsh =0;
        start = Worker.getStart_work();
        if(conn == null){
            getConnection();
        } 
        int h=0;
        if(Worker.getStart_work()<=0){
            Worker.setFinshed_work(0); finsh =0;
        }

        
        if(Worker.getFinshed_work()>0){ 
             h =  Worker.getFinshed_work() - Worker.getStart_work() ; start =0; finsh =0;
        }
        int hou = Worker.getHouers() + h;
        
        PreparedStatement statment = conn.prepareStatement("update worker "
                + "set name='"+ Worker.getName() +"',salary ='"+ Worker.getSalary() +"',phone='"+ Worker.getPhone() +"' "
                        + "   ,houers= "+ hou +"  "
                                + " ,start_work= "+ start +"  "
                                        + "   ,finished_work= "+ finsh +"    where id ="+id);
        
        
        
        
        statment.executeUpdate();
    }
    
    
}
