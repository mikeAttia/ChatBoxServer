/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatboxserver;

import java.rmi.RemoteException;
import java.util.Vector;

/**
 *
 * @author Mustafa
 */
public class MainController {

    ChatModel chatModel;
    DatabaseHandler dbHandler;
    ChatBoxServerFXMLDocController fxmlController;
    ChatBoxServer application;

    //Constructor that takes FXMLController and creates objects of other classes
    public MainController(ChatBoxServerFXMLDocController fxmlCtrlr) throws RemoteException {
        dbHandler = new DatabaseHandler(this);

        chatModel = new ChatModel(this);
        fxmlController = fxmlCtrlr;
    }

    boolean requestServerStart() {
        //Ehab
        return chatModel.bindService();
    }

    boolean requestServerStop() {
        //Ehab
        return chatModel.unbindService();
    }

    public Vector<User> loginRequest(String username, String password) {
        /*
         1. call function getUser to check username and password (return null)
         2. call function getFriends (return vector of friends bjects).
         */
        if (dbHandler.checkUsername(username, password)) {
            return dbHandler.getAllUserFriends(username);
        }
        return null;
    }

}
