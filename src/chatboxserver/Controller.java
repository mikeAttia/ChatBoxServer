/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package chatboxserver;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

/**
 *
 * @author Mustafa
 */
public class Controller implements Initializable{
    ChatModel model_chat;
DatabaseHandler model_DB;
ChatBoxServer view_ViewFrame;
public Controller(){
//model_chat=new ChatModel(this);
//model_DB=new DatabaseHandler(this);
//view_ViewFrame = new ServerView(this);

}
void requestServerStart(){}
void requestServerStop(){}
void sendAnnouncement(String str){}

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
}
