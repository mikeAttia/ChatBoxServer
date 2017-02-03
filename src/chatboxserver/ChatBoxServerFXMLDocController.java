/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatboxserver;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 *
 * @author michael
 */
public class ChatBoxServerFXMLDocController implements Initializable {
    
    @FXML
    private Label label;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 
    
    //reconnect button onaction -- call DbConnect()
    //Start button onaction -- call 
    
    //EHAB
    //ID selectors for all elements in GUI
    /*void guiDBConnected
        1. disable all fields
        2. enable start button
        3. hide reconnect
        4. call appendToLog()
        5. setDBStatus to online
    */
    void guiDBDisConnected (){
    
    }
//        1. disable all fields
//        2.show reconnect
//        3. call appendToLog()
//        4. setDBStatus to offlineline
    
    //End EHAB
}
