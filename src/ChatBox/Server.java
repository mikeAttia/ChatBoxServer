/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ChatBox;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Vector;

/**
 *
 * @author Mustafa
 */
public interface Server extends Remote{
    
    

    public void loginRequest(String mailOrPassword, String password, Client clientObj) throws RemoteException;
    public void signUp(User newUser, Client clientObj) throws RemoteException;
    public void requestGroupChat(String... usernames)throws RemoteException;
    public void signOut(String usrname)throws RemoteException;
    public void changeStatus(String status) throws RemoteException;
    public void searchContacts(String userName) throws RemoteException;
    public void addContact(String userName) throws RemoteException;
    public Client requestChatP2P(String usrname)throws RemoteException;
    
}
