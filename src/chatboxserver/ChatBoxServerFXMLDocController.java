/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatboxserver;

import java.net.URL;
import java.rmi.RemoteException;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
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
    public Text serverStatus;
    
    @FXML
    public TextArea activityLog;
    
    @FXML
    public Button startBtn;
    
    @FXML
    public Button stopBtn;
    
    @FXML
    public Button statsBtn;
    
    @FXML
    public ListView lstonlineView;
    
    @FXML
    public ListView lstofflineView;
    
    @FXML
    public TextArea announceArea;
    
    @FXML
    public Button announceBtn;

    public ChatBoxServerFXMLDocController() throws RemoteException {
        //linking to maincontroller object
        mainController = new MainController(this);

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        connectToDB();
                        lstofflineView.setItems(mainController.offlineUsers);
        lstonlineView.setItems(mainController.onlineUsers);

    }

    /*------------------------------------------------------------
      Assigning methods to Buttons
     ------------------------------------------------------------*/
    
    //Reconnect hyperlink action
    @FXML
    private void reconnectToDB(ActionEvent event)
    {
        connectToDB();
    }
    
    //Start Button action
    @FXML
    private void startServer(ActionEvent event)
    {
        if(mainController.requestServerStart())
        {
            guiAppendToLog("-Server Connected", "green");
            startBtn.setDisable(true);
            stopBtn.setDisable(false);
            statsBtn.setDisable(false);
            announceArea.setDisable(false);
            announceBtn.setDisable(false);
            lstonlineView.setDisable(false);
            lstofflineView.setDisable(false);
            serverStatus.setText("Online");
            serverStatus.setFill(Color.GREEN);
        }
        else
        {
            guiAppendToLog("error in connection to server", "red");
        }
    }
    
    //Stop button server
    @FXML
    private void stopServer(ActionEvent event)
    {
        if(mainController.requestServerStop())
        {
            guiAppendToLog("-Server Disconnected", "red");
            startBtn.setDisable(false);
            stopBtn.setDisable(true);
            statsBtn.setDisable(true);
            announceArea.setDisable(true);
            announceBtn.setDisable(true);
            lstonlineView.setDisable(true);
            lstofflineView.setDisable(true);
            serverStatus.setText("Offline");
            serverStatus.setFill(Color.RED);
        }
        else
        {
            guiAppendToLog("error in disconnecting from server", "red");
        }
    }
    
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
        DBStatus.setText("Online");
        DBStatus.setFill(Color.GREEN);
        startBtn.setDisable(false);
        stopBtn.setDisable(true);
        statsBtn.setDisable(true);
        announceArea.setDisable(true);
        announceBtn.setDisable(true);
        lstonlineView.setDisable(true);
        lstofflineView.setDisable(true);
        guiAppendToLog("Database Connected", "green");
    }
    
    
    //Disable all fields if cann't connect to Database
    public void guiDBDisConnected()
    {
        reconnectLink.setVisible(true);
        DBStatus.setText("Offline");
        DBStatus.setFill(Color.RED);
        startBtn.setDisable(true);
        stopBtn.setDisable(true);
        statsBtn.setDisable(true);
        announceArea.setDisable(true);
        announceBtn.setDisable(true);
        lstonlineView.setDisable(true);
        lstofflineView.setDisable(true);
        guiAppendToLog("Database Disconnected", "red");
    }
  public  void fillUsers(ObservableList<String> m){
    lstofflineView.setItems(m);
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
        
        //TODO: change props of string to show before appending
        
        activityLog.appendText(txt + "\n");
        
    }

    
}
