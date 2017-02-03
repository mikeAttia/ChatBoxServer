/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatboxserver;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.Initializable;

/**
 *
 * @author Mustafa
 */
public class MainController implements Initializable {

    ChatModel chatModel;
    static DatabaseHandler dbModel;
    static ChatBoxServerFXMLDocController viewController;

    public MainController() {
        //chatModel=new ChatModel(this);
        //dbModel=new DatabaseHandler(this);
        //viewController = new ChatBoxServerFXMLDocController(this);
    }

    void requestServerStart() {
        //Ehab
    }

    void requestServerStop() {
        //Ehab
    }

    void sendAnnouncement(String str) {
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
    
    public static void main(String[] args) {
        /*if( dbModel.intiateDBConnection()){
            viewController.guiDBConnected();
        }else{
            viewController.guiDBDisConnected();
        }*/
        Application.launch(ChatBoxServer.class, args);
    }
}
