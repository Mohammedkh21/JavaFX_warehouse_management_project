/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Final_Project;

import java.sql.SQLException;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author Mohammedkh21
 */
public class MainApp extends Application{
    static Stage c ;
    
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        launch(args);
        
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        c= primaryStage;
        FXMLLoader fXMLLoader = new FXMLLoader(
                getClass().getResource("LoginScreen.fxml") );
        fXMLLoader.setController(new LoginScreenController());
        Scene scene = new Scene(fXMLLoader.load(),500,500);
        primaryStage.setTitle("login");
        primaryStage.getIcons().add(new Image("/Images/logo.png"));
        primaryStage.setScene(scene);
        primaryStage.show();
        //new Tableview("items").show();
        
    }
    public static Stage fclose(){
        return c;
    }
    
}
