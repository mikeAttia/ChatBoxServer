/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatboxserver;

import ChatBox.Client;
import ChatBox.User;
import ChatBox.Server;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author Mustafa
 */
public class ServerImp extends UnicastRemoteObject implements Server {

    MainController controller;

    /*-------------------------------------------------------------
     Constructor linking to MainController
     -------------------------------------------------------------*/
    public ServerImp(MainController controlerObject) throws RemoteException {
        this.controller = controlerObject;
    }

    @Override
    public void loginRequest(String mailOrUsername, String password, Client clientObj) throws RemoteException {

        //Check if the incoming is username or email
        User userData = controller.dbHandler.signIn(mailOrUsername, password);

        //Validate user existence
        if (userData != null) {
            Vector<User> contacts = controller.dbHandler.getContactList(userData.getUsername());

            //TODO: Call Client method to display main view with user details and contacts
            clientObj.switchToMainView(userData);
            for (int i = 0; i < contacts.size(); i++) {
                clientObj.appednContact(contacts.get(i));

            }
            //TODO: Remove from offline users list and append to Online list
            //TODO: Add user Object to HashMap
            controller.updateUsersListGoOnline(userData.getUsername(), clientObj);

        } else {//Wrong username/Password combination
            //TODO: Call method to display Error message in user interface
            clientObj.signInErrMsg(Client.SIGN_IN_WRONG_DATA);
        }

    }

    @Override
    public void signUp(User newUser, Client clientObj) throws RemoteException {

        boolean emailCheck = controller.dbHandler.checkEmail(newUser.getEmail());
        boolean userNameCheck = controller.dbHandler.checkUsername(newUser.getUsername());
        System.out.println("asd");
        if (emailCheck && userNameCheck) {
            controller.dbHandler.insertUser(newUser);
        } else if (!emailCheck && !userNameCheck) {
            //TODO: Call method at Client's to display Error message of user already exists
            clientObj.signUpErrMsg(Client.SIGN_UP_EXIST_MAIL_USERNAME);
        } else if (!emailCheck) {
            //TODO: Call method at Client's to display Error message of Email already exists
            clientObj.signUpErrMsg(Client.SIGN_UP_EXIST_MAIL);

        } else if (!userNameCheck) {
            //TODO: Call method at Client's to display Error message of userName already exists
            clientObj.signUpErrMsg(Client.SIGN_UP_EXIST_USERNAME);

        }

    }

    
    @Override
    public void requestGroupChat(String... usernames) throws RemoteException {
      List<Client> grouprefrence=new ArrayList<Client>();
      for (String s : usernames) {
            grouprefrence.add(controller.getUserRefernce(s));
    }
        
    }

    @Override
    public void signOut(String username) throws RemoteException {
        //controller.getUserRefernce(username). notify friends 
        
        
        controller.updateUsersListGoOffline(username);
        
    }

    @Override
    public void changeStatus(String status) throws RemoteException {
//notify Freinds
    }

    @Override
    public void searchContacts(String userName) throws RemoteException {

    }

    @Override
    public void addContact(String userName) throws RemoteException {
            
    }

    @Override
    public Client requestChatP2P(String usrname) throws RemoteException {
    return controller.getUserRefernce(usrname);
    }

}
