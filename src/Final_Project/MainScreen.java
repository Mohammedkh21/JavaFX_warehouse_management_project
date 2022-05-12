/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Final_Project;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javafx.application.Application.STYLESHEET_MODENA;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.FileChooser;
import javafx.stage.Stage;


/**
 *
 * @author Mohammedkh21
 */
public class MainScreen extends Stage{
    ListView<String> listview =new ListView();
    Button buttonAdd, buttonDel, buttonUpdate, buttonClear ,print ,viewall;
    TextField tfname,tfpassword,tfdescription,tfamount,tfsalary,tfphone,tfprice;
    ObservableList<Maniger> Manigers;
    ObservableList<Item> Items;
    ObservableList<Worker> Workers;
    String tipe ;
    int selected , selectedIndex;
    FileChooser fileChooder = new FileChooser();
    File file = new File("");
    ToggleGroup toggleGroup = new ToggleGroup();
    Date date = new Date();
    RadioButton rb1,rb2;
    Label  added_at,lastUpdate , houers;
            
            
    public MainScreen() throws ClassNotFoundException, SQLException {
         //FXMLLoader fXMLLoader = new FXMLLoader(getClass().getResource("MainScreen.fxml") );
        Scene scene;
        
        BorderPane bp = new BorderPane();
        
        MenuBar menubar = new MenuBar();
        bp.setTop(menubar);
        
        Menu menu1 = new Menu("Tipe");

        MenuItem menuItme1 = new MenuItem("Itmes");
        MenuItem menuItme2 = new MenuItem("Workers");
        MenuItem menuItme3 = new MenuItem("Manjers");
        
        menu1.getItems().addAll(menuItme1,menuItme2,menuItme3);
        menubar.getMenus().addAll(menu1);
        
        viewall = new Button("View All");
        VBox vbb = new VBox(listview,viewall);
        vbb.setAlignment(Pos.CENTER);
        vbb.setPadding(new Insets(5));
        vbb.setSpacing(5);

        bp.setRight(vbb);
        
        
        viewall.setOnAction(e-> {
            if(!tipe.isEmpty()){
                try {
                    new Tableview(tipe).show();
                } catch (SQLException ex) {
                    Logger.getLogger(MainScreen.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(MainScreen.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                
        });
        
        
        
        
        buttonAdd = new Button("Add");
        buttonDel = new Button("Delete");
        buttonUpdate = new Button("Update");
        print = new Button("print Report");
        buttonClear = new Button("Clear");
         rb1 = new RadioButton("start work");
         rb2 = new RadioButton("Finshed work");
        rb1.setToggleGroup(toggleGroup);
        rb2.setToggleGroup(toggleGroup);
       
        HBox hBox = new HBox(10, buttonAdd, buttonDel, buttonUpdate ,print, buttonClear);
        hBox.setAlignment(Pos.CENTER);
        hBox.setPadding(new Insets(20, 0, 20, 0));
        hBox.setStyle("-fx-border-color: black");
        bp.setBottom(hBox);
        
        
        
        Label welcome = new Label("Mohammed Khalaf");
        welcome.setFont(Font.font(STYLESHEET_MODENA, FontWeight.MEDIUM , FontPosture.REGULAR, 20));
        
          added_at = new Label("");
         lastUpdate = new Label("");
        
        houers = new Label("");
         
        Label lname = new Label("Name");
         tfname = new TextField();
        HBox hbname = new HBox(lname,tfname);
        hbname.setAlignment(Pos.CENTER);
        hbname.setSpacing(20);
        
        Label lpassword = new Label("password");
         tfpassword = new TextField();
        HBox hbpassword = new HBox(lpassword,tfpassword);
        hbpassword.setAlignment(Pos.CENTER);
        hbpassword.setSpacing(20);
        
        Label lprice = new Label("Price");
         tfprice = new TextField();
        HBox hbprice = new HBox(lprice,tfprice);
        hbprice.setAlignment(Pos.CENTER);
        hbprice.setSpacing(20);
        
        Label ldescription = new Label("Description");
         tfdescription = new TextField();
        HBox hbdescription = new HBox(ldescription,tfdescription);
        hbdescription.setAlignment(Pos.CENTER);
        hbdescription.setSpacing(20);
        
        Label lamount = new Label("Amount");
         tfamount = new TextField();
        HBox hbdamount = new HBox(lamount,tfamount);
        hbdamount.setAlignment(Pos.CENTER);
        hbdamount.setSpacing(20);
        
        Label lsalary = new Label("salary");
         tfsalary = new TextField();
        HBox hbsalary = new HBox(lsalary,tfsalary);
        hbsalary.setAlignment(Pos.CENTER);
        hbsalary.setSpacing(20);
        
        Label lphone = new Label("phone");
         tfphone = new TextField();
        HBox hbphone = new HBox(lphone,tfphone);
        hbphone.setAlignment(Pos.CENTER);
        hbphone.setSpacing(20);
        
        VBox vBox = new VBox(welcome);
        vBox.setSpacing(20);
        vBox.setAlignment(Pos.CENTER);
        
        bp.setCenter(vBox);
        
        listview.getSelectionModel().selectedItemProperty()
         .addListener(e->
         {
             //tfname.setText(listview.getSelectionModel().getSelectedItem());
             int j = listview.getSelectionModel().getSelectedIndex();
             selectedIndex = j;
             if(tipe.equalsIgnoreCase("items")){
                 Item i = Items.get(j); 
                 tfname.setText(i.getName());
                 tfamount.setText( String.valueOf(i.getAmount()));
                 tfdescription.setText(i.getDescription());
                 tfprice.setText(i.getPrice());
                 added_at.setText("Added At : "+i.getAdded_at()); 
                 lastUpdate.setText("Last Update  : "+i.getLastupdate());
                 selected = i.getId();
                 
             }else if(tipe.equalsIgnoreCase("worker")){
                 Worker w = Workers.get(j);
                 System.out.println(w.toString());
                 tfname.setText(w.getName());
                 tfsalary.setText(String.valueOf(w.getSalary()));
                 tfphone.setText(w.getPhone());
                 houers.setText("Houers : "+w.getHouers());
                 int s = w.getStart_work();
                 if(s>0){
                     rb1.setSelected(true);
                 }else{
                     rb1.setSelected(false);
                 }
                 if(w.getFinshed_work() >0){
                     rb2.setSelected(true);
                 }else{
                     rb2.setSelected(false);
                 }
                 selected = w.getId();
                 
             }else if(tipe.equalsIgnoreCase("manjers")){
                 Maniger m = Manigers.get(j);
                 tfname.setText(m.getName());
                 tfpassword.setText(m.getPassword());
                 selected = m.getId();
             }
         }
        );
        
        
        
        menuItme3.setOnAction(e->{ 
            clare();
            tipe = "manjers";
            vBox.getChildren().clear();
            vBox.getChildren().addAll(hbname,hbpassword);
            try {
                MyDatabase.getConnection();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(MainScreen.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(MainScreen.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                Manigers = MyDatabase.getAllManiger();
            } catch (SQLException ex) {
                Logger.getLogger(MainScreen.class.getName()).log(Level.SEVERE, null, ex);
            }

            ArrayList<String> ars= new ArrayList<>();
            for(Maniger m : Manigers){
                ars.add(m.getName());
            }
            listview.setItems(FXCollections.observableArrayList(ars));
            
            
            
            
        
        });
        menuItme1.setOnAction((ActionEvent e)->{
            clare();
            tipe = "items";
            vBox.getChildren().clear();
            vBox.getChildren().addAll(hbname,hbdamount,hbprice,hbdescription,added_at,lastUpdate);
            try {
                MyDatabase.getConnection();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(MainScreen.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(MainScreen.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                Items = MyDatabase.getAllItems();
            } catch (SQLException ex) {
                Logger.getLogger(MainScreen.class.getName()).log(Level.SEVERE, null, ex);
            }

            ArrayList<String> ars= new ArrayList<>();
            Items.forEach(i -> {
                ars.add(i.getName());
            });
            listview.setItems(FXCollections.observableArrayList(ars));
            
        
        });
        
        menuItme2.setOnAction(e->{ 
            clare();
            tipe = "worker";
            vBox.getChildren().clear();
            vBox.getChildren().addAll(hbname,hbsalary,hbphone,rb1,rb2,houers);
            try {
                MyDatabase.getConnection();
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(MainScreen.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                Workers = MyDatabase.getAllWorkers();
            } catch (SQLException ex) {
                Logger.getLogger(MainScreen.class.getName()).log(Level.SEVERE, null, ex);
            }

            ArrayList<String> ars= new ArrayList<>();
            for(Worker w : Workers){
                ars.add(w.getName());
            }
            listview.setItems(FXCollections.observableArrayList(ars));
            
        
        });
        
        buttonAdd.setOnAction(e->{
            if(tipe.equalsIgnoreCase("items")){
                
                Item i = new Item( Integer.parseInt(tfamount.getText())  , tfname.getText(), tfdescription.getText(),tfprice.getText());
                
                try {
                    MyDatabase.addItem(i);
                } catch (SQLException ex) {
                    Logger.getLogger(MainScreen.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(MainScreen.class.getName()).log(Level.SEVERE, null, ex);
                }
                 try {
                    Items = MyDatabase.getAllItems();
                } catch (SQLException ex) {
                    Logger.getLogger(MainScreen.class.getName()).log(Level.SEVERE, null, ex);
                }

                ArrayList<String> ars= new ArrayList<>();
                for(Item ii : Items){
                    ars.add(ii.getName());
                }
                listview.setItems(FXCollections.observableArrayList(ars));
                 clare();
                 
             }else if(tipe.equalsIgnoreCase("worker")){
                 Worker w = new Worker( Integer.parseInt(tfsalary.getText())  , tfname.getText(), tfphone.getText());
                 try {
                    MyDatabase.addWorker(w);
                } catch (SQLException ex) {
                    Logger.getLogger(MainScreen.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(MainScreen.class.getName()).log(Level.SEVERE, null, ex);
                }
                 try {
                    Workers = MyDatabase.getAllWorkers();
                } catch (SQLException ex) {
                    Logger.getLogger(MainScreen.class.getName()).log(Level.SEVERE, null, ex);
                }

                ArrayList<String> ars= new ArrayList<>();
                for(Worker ww : Workers){
                    ars.add(ww.getName());
                }
                listview.setItems(FXCollections.observableArrayList(ars));
                clare();
                 
             }else if(tipe.equalsIgnoreCase("manjers")){
                 Maniger m = new Maniger(tfname.getText(), tfpassword.getText());
                 try {
                    MyDatabase.addManjer(m);
                } catch (SQLException ex) {
                    Logger.getLogger(MainScreen.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(MainScreen.class.getName()).log(Level.SEVERE, null, ex);
                } catch (NoSuchAlgorithmException ex) {
                    Logger.getLogger(MainScreen.class.getName()).log(Level.SEVERE, null, ex);
                }
                 try {
                    Manigers = MyDatabase.getAllManiger();
                } catch (SQLException ex) {
                    Logger.getLogger(MainScreen.class.getName()).log(Level.SEVERE, null, ex);
                }

                ArrayList<String> ars= new ArrayList<>();
                for(Maniger mm : Manigers){
                    ars.add(mm.getName());
                }
                listview.setItems(FXCollections.observableArrayList(ars));
                clare();
             }
        });
        
        
        buttonDel.setOnAction(e->{
            
            if(tipe.equalsIgnoreCase("items")){

                try {
                    MyDatabase.deleteItem(selected);
                } catch (SQLException ex) {
                    Logger.getLogger(MainScreen.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(MainScreen.class.getName()).log(Level.SEVERE, null, ex);
                }
                 try {
                    Items = MyDatabase.getAllItems();
                } catch (SQLException ex) {
                    Logger.getLogger(MainScreen.class.getName()).log(Level.SEVERE, null, ex);
                }

                ArrayList<String> ars= new ArrayList<>();
                for(Item ii : Items){
                    ars.add(ii.getName());
                }
                listview.setItems(FXCollections.observableArrayList(ars));
                 clare();
                 
             }else if(tipe.equalsIgnoreCase("worker")){
                 try {
                    MyDatabase.deleteWorker(selected);
                } catch (SQLException ex) {
                    Logger.getLogger(MainScreen.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(MainScreen.class.getName()).log(Level.SEVERE, null, ex);
                }
                 try {
                    Workers = MyDatabase.getAllWorkers();
                } catch (SQLException ex) {
                    Logger.getLogger(MainScreen.class.getName()).log(Level.SEVERE, null, ex);
                }

                ArrayList<String> ars= new ArrayList<>();
                for(Worker ww : Workers){
                    ars.add(ww.getName());
                }
                listview.setItems(FXCollections.observableArrayList(ars));
                clare();
                 
             }else if(tipe.equalsIgnoreCase("manjers")){
                 try {
                    MyDatabase.deleteManjer(selected);
                } catch (SQLException ex) {
                    Logger.getLogger(MainScreen.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(MainScreen.class.getName()).log(Level.SEVERE, null, ex);
                }
                 try {
                    Manigers = MyDatabase.getAllManiger();
                } catch (SQLException ex) {
                    Logger.getLogger(MainScreen.class.getName()).log(Level.SEVERE, null, ex);
                }

                ArrayList<String> ars= new ArrayList<>();
                for(Maniger mm : Manigers){
                    ars.add(mm.getName());
                }
                listview.setItems(FXCollections.observableArrayList(ars));
                clare();
             }
        });
        
        buttonUpdate.setOnAction(e->{
            if(tipe.equalsIgnoreCase("items")){
                
                Item i = new Item( Integer.parseInt(tfamount.getText())  , tfname.getText(), tfdescription.getText(),tfprice.getText());

                try {
                    MyDatabase.UpdateItem(selected, i);
                } catch (SQLException ex) {
                    Logger.getLogger(MainScreen.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(MainScreen.class.getName()).log(Level.SEVERE, null, ex);
                }
                 try {
                    Items = MyDatabase.getAllItems();
                } catch (SQLException ex) {
                    Logger.getLogger(MainScreen.class.getName()).log(Level.SEVERE, null, ex);
                }

                ArrayList<String> ars= new ArrayList<>();
                for(Item ii : Items){
                    ars.add(ii.getName());
                }
                listview.setItems(FXCollections.observableArrayList(ars));
                 clare();
                 
             }else if(tipe.equalsIgnoreCase("worker")){
                 Worker i = Workers.get(selectedIndex);
                 
                 Worker w = new Worker( Integer.parseInt(tfsalary.getText())  , tfname.getText(), tfphone.getText());
                 w.setStart_work(i.getStart_work());
                 if(rb1.isSelected()){
                    w.setStart_work(date.getHours());
                }else if(rb2.isSelected() ){

                    w.setFinshed_work(date.getHours());
                     
                }
                 w.setHouers(i.getHouers());
                 
                if(i.getStart_work() > 0 || w.getStart_work() >0){
                    try {
                    MyDatabase.UpdateWorker(selected, w);
                } catch (SQLException ex) {
                    Logger.getLogger(MainScreen.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(MainScreen.class.getName()).log(Level.SEVERE, null, ex);
                }
                }
                 
                 try {
                    Workers = MyDatabase.getAllWorkers();
                } catch (SQLException ex) {
                    Logger.getLogger(MainScreen.class.getName()).log(Level.SEVERE, null, ex);
                }

                ArrayList<String> ars= new ArrayList<>();
                for(Worker ww : Workers){
                    ars.add(ww.getName());
                }
                listview.setItems(FXCollections.observableArrayList(ars));
                clare();
                 
             }else if(tipe.equalsIgnoreCase("manjers")){
                 Maniger m = new Maniger(tfname.getText(), tfpassword.getText());
                 try {
                    MyDatabase.UpdateManjer(selected, m);
                } catch (SQLException ex) {
                    Logger.getLogger(MainScreen.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(MainScreen.class.getName()).log(Level.SEVERE, null, ex);
                } catch (NoSuchAlgorithmException ex) {
                    Logger.getLogger(MainScreen.class.getName()).log(Level.SEVERE, null, ex);
                }
                 try {
                    Manigers = MyDatabase.getAllManiger();
                } catch (SQLException ex) {
                    Logger.getLogger(MainScreen.class.getName()).log(Level.SEVERE, null, ex);
                }

                ArrayList<String> ars= new ArrayList<>();
                Manigers.forEach(mm -> {
                    ars.add(mm.getName());
                });
                listview.setItems(FXCollections.observableArrayList(ars));
                clare();
             }
        });
        buttonClear.setOnAction(e-> clare());
        
        
        print.setOnAction(e->{ 
            int j = selectedIndex; 
             if(tipe.equalsIgnoreCase("items")){
                if(j>=0){
                    Item i = Items.get(j);

                    fileChooder.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Text file", ".TXT"),
                                                        new FileChooser.ExtensionFilter("All file", "*.*"));
                    file = fileChooder.showSaveDialog(this);

                    try {
                        FileWriter fw = new FileWriter(file);
                        fw.write(i.toString());
                        fw.close();
                    } catch (IOException ex) {
                        Logger.getLogger(MainScreen.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                
                 
                
                 
             }else if(tipe.equalsIgnoreCase("worker")){
                 if(j>=0){
                    Worker w = Workers.get(j);

                    fileChooder.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Text file", ".TXT"),
                                                        new FileChooser.ExtensionFilter("All file", "*.*"));
                    file = fileChooder.showSaveDialog(this);

                    try {
                        FileWriter fw = new FileWriter(file);
                        fw.write(w.toString());
                        fw.close();
                    } catch (IOException ex) {
                        Logger.getLogger(MainScreen.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

                 
             }else if(tipe.equalsIgnoreCase("manjers")){
                 if(j>=0){
                    Maniger m = Manigers.get(j);

                    fileChooder.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Text file", ".TXT"),
                                                        new FileChooser.ExtensionFilter("All file", "*.*"));
                    file = fileChooder.showSaveDialog(this);

                    try {
                        FileWriter fw = new FileWriter(file);
                        fw.write(m.toString());
                        fw.close();
                    } catch (IOException ex) {
                        Logger.getLogger(MainScreen.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

             }
        });
        this.setTitle("Main");
        this.getIcons().add(new Image("/Images/logo.png"));
        scene = new Scene(bp,800,600);
        this.setScene(scene);
       
    }
    
    public  void clare(){
        tfname.setText("");
        tfpassword.setText("");
        tfdescription.setText("");
        tfamount.setText("");
        tfsalary.setText("");
        tfphone.setText("");
        tfprice.setText("");
        rb1.setSelected(false);
        rb2.setSelected(false);
        added_at.setText("");
        lastUpdate.setText("");
        houers.setText("");
    }
    
}
