/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Final_Project;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 *
 * @author Mohammedkh21
 */
public class Tableview extends Stage{
    Scene scene;
    TableView<Maniger> mtv = new TableView<Maniger>();
    TableView<Item> itv = new TableView<Item>();
    TableView<Worker> wtv = new TableView<Worker>();
    FileChooser fileChooder = new FileChooser();
    File file = new File("");
    
    public Tableview(String tipe) throws SQLException, ClassNotFoundException {
        this.setTitle(tipe);
        MyDatabase.getConnection();
        
        Button b1 = new Button("Print Report");
        Button b2 = new Button("close");
        HBox hbox = new HBox(b1,b2);
        hbox.setAlignment(Pos.CENTER);
        hbox.setPadding(new Insets(50));
        hbox.setSpacing(22);
        
        b2.setOnAction(e->this.close());
        
        b1.setOnAction(e->{ 
             
             if(tipe.equalsIgnoreCase("items")){
                
                    

                    fileChooder.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Text file", ".TXT"),
                                                        new FileChooser.ExtensionFilter("All file", "*.*"));
                    file = fileChooder.showSaveDialog(this);

                    try {
                        FileWriter fw = new FileWriter(file);
                        for(Item i : MyDatabase.getAllItems()){
                            fw.write(i.toString());
                            fw.write("\n \n");
                        }
                        
                        fw.close();
                    } catch (IOException ex) {
                        Logger.getLogger(MainScreen.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (SQLException ex) {
                     Logger.getLogger(Tableview.class.getName()).log(Level.SEVERE, null, ex);
                 }
                
                
                 
                
                 
             }else if(tipe.equalsIgnoreCase("worker")){
                    fileChooder.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Text file", ".TXT"),
                                                        new FileChooser.ExtensionFilter("All file", "*.*"));
                    file = fileChooder.showSaveDialog(this);

                    try {
                        FileWriter fw = new FileWriter(file);
                        for(Worker i : MyDatabase.getAllWorkers()){
                            fw.write(i.toString());
                            fw.write("\n \n");
                        }
                        
                        fw.close();
                    } catch (IOException ex) {
                        Logger.getLogger(MainScreen.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (SQLException ex) {
                     Logger.getLogger(Tableview.class.getName()).log(Level.SEVERE, null, ex);
                 }

                 
             }else if(tipe.equalsIgnoreCase("manjers")){
                    fileChooder.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Text file", ".TXT"),
                                                        new FileChooser.ExtensionFilter("All file", "*.*"));
                    file = fileChooder.showSaveDialog(this);

                    try {
                        FileWriter fw = new FileWriter(file);
                        for(Maniger i : MyDatabase.getAllManiger()){
                            fw.write(i.toString());
                            fw.write("\n \n");
                        }
                        
                        fw.close();
                    } catch (IOException ex) {
                        Logger.getLogger(MainScreen.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (SQLException ex) {
                     Logger.getLogger(Tableview.class.getName()).log(Level.SEVERE, null, ex);
                 }

             }
        });
        
        
        
        TableColumn mid = new TableColumn("id"); mid.setMinWidth(100);
        TableColumn mname = new TableColumn("name"); mname.setMinWidth(100);
        TableColumn iid = new TableColumn("id"); iid.setMinWidth(100);
        TableColumn iname = new TableColumn("name"); iname.setMinWidth(100);
        TableColumn wid = new TableColumn("id"); wid.setMinWidth(100);
        TableColumn wname = new TableColumn("name"); wname.setMinWidth(100);
        TableColumn password = new TableColumn("password"); password.setMinWidth(100);
        TableColumn amount = new TableColumn("amount"); amount.setMinWidth(100);
        TableColumn description = new TableColumn("description"); description.setMinWidth(100);
        TableColumn salary = new TableColumn("salary"); salary.setMinWidth(100);
        TableColumn phone = new TableColumn("phone"); phone.setMinWidth(100);
        TableColumn price = new TableColumn("price"); price.setMinWidth(100);
        TableColumn added_at = new TableColumn("Added At"); 
        TableColumn lastupdate = new TableColumn("Last Update"); 
        TableColumn start_work = new TableColumn("Start Work"); 
        TableColumn finshed_work = new TableColumn("Finshed Work"); 
        TableColumn houers = new TableColumn("Houers"); 
        
 
        
        
        
        
        VBox vbox = new VBox(mtv,hbox);

        
        
        
        mid.setCellValueFactory(new PropertyValueFactory<Maniger,String>("id"));
        mname.setCellValueFactory(new PropertyValueFactory<Maniger,String>("name"));
        password.setCellValueFactory(new PropertyValueFactory<Maniger,String>("password"));
        
        iid.setCellValueFactory(new PropertyValueFactory<Item,String>("id"));
        iname.setCellValueFactory(new PropertyValueFactory<Item,String>("name"));
        amount.setCellValueFactory(new PropertyValueFactory<Item,String>("amount"));
        description.setCellValueFactory(new PropertyValueFactory<Item,String>("description"));
        price.setCellValueFactory(new PropertyValueFactory<Item,String>("price"));
        added_at.setCellValueFactory(new PropertyValueFactory<Item,Timestamp>("added_at"));
        lastupdate.setCellValueFactory(new PropertyValueFactory<Item,Timestamp>("lastupdate"));
        
        wid.setCellValueFactory(new PropertyValueFactory<Worker,String>("id"));
        wname.setCellValueFactory(new PropertyValueFactory<Worker,String>("name"));
        salary.setCellValueFactory(new PropertyValueFactory<Worker,String>("salary"));
        phone.setCellValueFactory(new PropertyValueFactory<Worker,String>("phone"));
        start_work.setCellValueFactory(new PropertyValueFactory<Worker,Integer>("start_work"));
        finshed_work.setCellValueFactory(new PropertyValueFactory<Worker,Integer>("finshed_work"));
        houers.setCellValueFactory(new PropertyValueFactory<Worker,Integer>("houers"));
        
        
        if(tipe.equalsIgnoreCase("items")){
            itv.getColumns().addAll(iid,iname,amount,price,description,added_at,lastupdate);
            ObservableList<Item> data = MyDatabase.getAllItems();
            itv.setItems(data);
            vbox = new VBox(itv,hbox);
        }else if(tipe.equalsIgnoreCase("worker")){
            wtv.getColumns().addAll(wid,wname,salary,phone,houers,start_work,finshed_work);
            ObservableList<Worker> data = MyDatabase.getAllWorkers();
            wtv.setItems(data);
            vbox = new VBox(wtv,hbox);
        }else if(tipe.equalsIgnoreCase("manjers")){
            mtv.getColumns().addAll(mid,mname,password);
            ObservableList<Maniger> data = MyDatabase.getAllManiger();
            mtv.setItems(data);
            vbox = new VBox(mtv,hbox);
        }
        
        
        
        
        this.getIcons().add(new Image("/Images/logo.png"));
        scene = new Scene(vbox,800,500);
        this.setScene(scene);
        
    }
    
}
