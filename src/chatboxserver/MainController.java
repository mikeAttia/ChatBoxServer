/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatboxserver;

import java.rmi.RemoteException;


/**
 *
 * @author Mustafa
 */
public class MainController{

     ChatModel chatModel;
     DatabaseHandler dbHandler;
     ChatBoxServerFXMLDocController fxmlController;
     ChatBoxServer application;
    
    
    //Constructor that takes FXMLController and creates objects of other classes
    public MainController(ChatBoxServerFXMLDocController fxmlCtrlr) throws RemoteException {
        chatModel=new ChatModel(this);
        dbHandler = new DatabaseHandler(this);
        fxmlController = fxmlCtrlr;
    }
    void requestServerStart() {
        //Ehab
        if(chatModel.bindService())
        {
            fxmlController.guiAppendToLog("serverconnected", "green");
        }
        else
        {
            fxmlController.guiAppendToLog("serverdisconnected", "red");
        }
    }

    void requestServerStop() {
        //Ehab
    }
}
