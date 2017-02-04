/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatboxserver;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Hyperlink;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

/**
 *
 * @author michael
 */
public class ChatBoxServerFXMLDocController implements Initializable {

    public MainController mainController;
    
    /*------------------------------------------------------------
       References to GUI elements with IDs
     ------------------------------------------------------------*/
    
    
    @FXML
    public Hyperlink reconnectLink; 
    
    @FXML
    public Text DBStatus;
    
    @FXML
    public TextFlow activityLog;

    public ChatBoxServerFXMLDocController() {
        mainController = new MainController(this);
       
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        connectToDB();
    }

    /*------------------------------------------------------------
      Assigning methods to Buttons
     ------------------------------------------------------------*/
    
    /*
    @FXML
    private void handleButtonAction(ActionEvent event) {
        
    }
    */
    
    
    /*------------------------------------------------------------
      Other methods to call inside buttons methods
     ------------------------------------------------------------*/
    
    //Method to try and connect to Database and change the GUI accordingly
    public void connectToDB(){
        if(mainController.dbHandler.intiateDBConnection()){
                guiDBConnected();
            }
            else{
                guiDBDisConnected();
            }
    }
    
    
    //Enable start button if database is connected
    public void guiDBConnected()
    {
        reconnectLink.setVisible(false);
        //TODO: set color to green with css probably
        DBStatus.setText("Online");
        //TODO: enable the start button
        guiAppendToLog("Database Connected", "green");
    }
    
    
    //Disable all fields if cann't connect to Database
    public void guiDBDisConnected()
    {
        reconnectLink.setVisible(true);
        //TODO: set color to red with css probably
        DBStatus.setText("Offline");
        //TODO: disable the rest of the form
        guiAppendToLog("Database Disconnected", "red");
    }
    
    //Append to the Activity log with a ceratin color
    public void guiAppendToLog(String txt,String type)
    {
        Text text=new Text("- " +txt + "\n");
        
        if("green".equals(type))
        {
            text.setFill(Color.GREEN);
        }
        else if("red".equals(type))
        {
            text.setFill(Color.RED);
        }
        activityLog.getChildren().add(text);
        
    }
}
