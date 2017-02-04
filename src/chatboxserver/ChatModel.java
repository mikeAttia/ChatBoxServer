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
import java.rmi.server.UnicastRemoteObject;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mustafa
 */
public class ChatModel extends UnicastRemoteObject implements ServerInterface {

    Vector<User> groupChatNames;
    Vector<Vector<User>> groupChatRefrences;
    MainController controlerObject;
    private Registry reg;

    public ChatModel(MainController c) throws RemoteException
    {
        controlerObject = c;
    }

    boolean bindService() {
        try {
            reg=LocateRegistry.createRegistry(5005);
            reg.rebind("ChatBox", this);
            return true;
        } catch (RemoteException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    boolean unbindService() {
        
        try {
            reg.unbind("ChatBox");
            return true;
        } catch (RemoteException ex) {
            ex.printStackTrace();
            return false;
        } catch (NotBoundException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public Vector<User> loginRequest(String username, String password, Client userInt) {
        /*
            1. call function getUser to check username and password (return null)
            2. call function getFriends (return vector of friends bjects).
        */
        return null; // to be removed
    }

    @Override
    public String signUp(User newUser, Client userInt) {
        /*
            1.call function checkUsername (return error message related to username)
            2.call function checkEmail  (retrun error message related to email)
            3.call function insertUser  (return succes message)
        */
        return null; // to be removed
    }
    
}
