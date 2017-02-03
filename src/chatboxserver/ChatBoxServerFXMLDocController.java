/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatboxserver;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

/**
 *
 * @author michael
 */
public class ChatBoxServerFXMLDocController implements Initializable {
    
    MainController controller;
    @FXML
    public Hyperlink reconnect; 
    @FXML
    public TextArea activity;
    @FXML
    public Text DBStatus;
    @FXML
    public Text serverStatus;
    @FXML
    public ListView onlineUsers;
    @FXML
    public ListView offlineUsers;
    @FXML
    public Button serverStart;
    @FXML
    public Button serverStop;
    @FXML
    public Button stats;
    @FXML
    public Button announce;
    @FXML
    public TextArea announceArea;

    /*ChatBoxServerFXMLDocController(MainController controller) {
        this.controller=controller;
    }*/
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
    /*void guiDBDisConnected (){
    
    }*/
//        1. disable all fields
//        2.show reconnect
//        3. call appendToLog()
//        4. setDBStatus to offlineline
    
    //End EHAB
public void guiDBConnected()
    {
        reconnect.setVisible(false);
        DBStatus.setText("online");
    }
    public void guiDBDisConnected()
    {
        reconnect.setVisible(true);
        DBStatus.setText("offline");
    }
    public void guiAppendToLog(String txt,String type)
    {
        Text text=new Text(txt);
        if(type=="connected")
        {
            text.setFill(Color.GREEN);
        }
        else
        {
            text.setFill(Color.RED);
        }
        activity.appendText(text.toString());
    }
    public void guiOnlineListAppendUpdate(ObservableList list)
    {
        onlineUsers.setItems(list);
    }
    public void guiOfflineListAppendUpdate(ObservableList list)
    {
        offlineUsers.setItems(list);
    }
    public void guiAppendUserToOnline(User user)
    {
        onlineUsers.getItems().add(user);
    }
    public void guiAppendUserToOffline(User user)
    {
        offlineUsers.getItems().add(user);
    }
    public void guiRemoveuserFromOnline(User user)
    {
        ObservableList online=onlineUsers.getItems();
        online.stream().filter((newuser) -> (newuser==user)).forEachOrdered((newuser) -> {
            online.remove(newuser);
        });
    }
    public void guiRemoveuserFromOffline(User user)
    {
        ObservableList offline=offlineUsers.getItems();
        offline.stream().filter((newuser) -> (newuser==user)).forEachOrdered((newuser) -> {
            offline.remove(newuser);
        });
    }
    /*@FXML
    private void startHandler()
    {
        if(control.requestServerStart())
        {
            serverStatus.setText("online");
        }
        else
        {
            System.out.println("can't connect to server");
        }
    }
    @FXML
    private void stopHandler()
    {
        if(control.requestServerStop())
        {
            serverStatus.setText("offline");
        }
        else
        {
            System.out.println("can't disconnect from server");
        }
    }
    @FXML
    private void statsHandler()
    {
        
    }
    @FXML
    private void announceHandler()
    {
        control.sendAnnouncement(announceArea.getText());
    }
    @FXML
    private void reconnectHandler()
    {
        control.openDatabase();
    }*/
}