/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatboxserver;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import ChatBox.User;
import java.util.Vector;

/**
 *
 * @author michael
 */
public class ServerModel {
    
    MainController mainController;
    private Registry reg;
    
    Vector<User> groupChatNames; // ???? TODO
    Vector<Vector<User>> groupChatRefrences; // ???? TODO
    

    
    /*------------------------------------------------
        Default Constructor
    ------------------------------------------------*/
    ServerModel(MainController controller) {
        mainController = controller;
        try {
            reg=LocateRegistry.createRegistry(1099);
        } catch (RemoteException ex) {
            ex.printStackTrace();
            System.out.println("Cann't connect to Registry");
        }
    }
    
    
    /*------------------------------------------------
        Registry related Methods
    ------------------------------------------------*/
    boolean bindService() {
        
        try {
            reg.rebind("ChatBox", new ServerImp(mainController));
            
        } catch (RemoteException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }
    
    boolean unbindServie() {
        try {
            reg.unbind("ChatBox");
            return true;
        } catch (RemoteException | NotBoundException ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
