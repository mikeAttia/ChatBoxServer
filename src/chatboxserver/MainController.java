/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatboxserver;

import ChatBox.Client;
import java.rmi.RemoteException;
import java.util.HashMap;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sun.misc.Cleaner;

/**
 *
 * @author Michael
 */
public class MainController {

    DatabaseHandler dbHandler;
    ChatBoxServerFXMLDocController fxmlController;
    ChatBoxServer application;
    ServerModel model;
    ObservableList<String> offlineUsers = FXCollections.observableArrayList();
    ObservableList<String> onlineUsers = FXCollections.observableArrayList();
//    ObservableList<HashMap<String, Client>> onlineUserReferences = FXCollections.observableArrayList();
    HashMap<String, Client> onlineUserReferences = new HashMap<>();
    /*------------------------------------------------
     Default Constructor
     ------------------------------------------------*/

    public MainController(ChatBoxServerFXMLDocController fxmlCtrlr) throws RemoteException {
        dbHandler = new DatabaseHandler(this);
        model = new ServerModel(this);
        fxmlController = fxmlCtrlr;
    }

    /*------------------------------------------------
     Calling methods from Model
     ------------------------------------------------*/
    boolean requestServerStart() {
        fxmlController.fillUsers(dbHandler.getAllUsers());
        return model.bindService();
    }

    boolean requestServerStop() {

        return model.unbindServie();
    }
    /*------------------------------------------------
     online UsersList
     ------------------------------------------------*/

    void updateUsersListGoOnline(String str, Client cl) {
        Platform.runLater(() -> {
            if (offlineUsers.contains(str)) {
                offlineUsers.remove(str);
            }
            if (!onlineUsers.contains(str)) {
                onlineUsers.add(str);
            }
        });
        addtoReference(str, cl);
    }

    void showdata() {
        System.out.println(onlineUserReferences.size());

    }

    void updateUsersListGoOffline(String str) {
        Platform.runLater(() -> {
            if (onlineUsers.contains(str)) {
                onlineUsers.remove(str);
            }
            if (!offlineUsers.contains(str)) {
                offlineUsers.add(str);
            }
        });
        removeFromReference(str);
    }

    public void addtoReference(String str, Client cl) {
        onlineUserReferences.put(str, cl);

    }

    public void removeFromReference(String str) {
        onlineUserReferences.remove(str);

    }
    public Client getUserRefernce(String usrname){
       
    return onlineUserReferences.get(usrname);
    }

}
