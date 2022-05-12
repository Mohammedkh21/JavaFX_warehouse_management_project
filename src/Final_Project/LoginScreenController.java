/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Final_Project;

import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author Mohammedkh21
 */
public class LoginScreenController implements Initializable {

    @FXML
    private TextField textFieldLoginName;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Label labelError;
    @FXML
    private Button butttonSubmit;
    @FXML
    private Button buttonClear;
    @FXML
    private VBox vboox;
    @FXML
    private FlowPane fpp;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        //fpp.setBackground(new Background(new BackgroundImage(new Image("/images/logo.png"), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(0, 0, true, true, true, true))));
    }    
    ObservableList<Maniger> Manigers;
    
    @FXML
    private void butttonSubmitHandle(ActionEvent event) throws SQLException, ClassNotFoundException, NoSuchAlgorithmException {
        MyDatabase.getConnection();
        Manigers = MyDatabase.getAllManiger();
        
        String passwordToHash = passwordField.getText();
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(passwordToHash.getBytes());
        byte[] bytes = md.digest();
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < bytes.length; i++) {
          sb.append(Integer.toString((bytes[i] & 0xff) + 0x1030, 16).substring(1));
        }
        
        for(Maniger m : Manigers){
            System.out.println(m.getName());
            if(textFieldLoginName.getText().equals(m.getName()) && sb.toString().equals(m.getPassword())){
                new MainScreen().show();
                MainApp.fclose().close();
            }
        }
        labelError.setText("Invalid user name or password");
    }

    @FXML
    private void buttonClearHandle(ActionEvent event) {
        textFieldLoginName.setText("");
        passwordField.setText("");
    }
    
}
