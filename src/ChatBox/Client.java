/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChatBox;

import ChatBox.User;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Mustafa
 */
public interface Client extends Remote {

//    +displayMsg(String msg) void
//+showAdvert(String s)
//+getNotification(User s,String Status) void
//+notifyServerStop() Void
//+notifySchduledServerStop(Time m) void
//+requestFileSend(String ... FileName) Boolean
//+SendFile(String fName,byte[] bytes,int len) void
//    void displayMsg(String msg) throws RemoteException;
//    void showAdvert(String s) throws RemoteException ;
//    void getNotification(User s,String Status) throws RemoteException;
//    void notifyServerStop() throws RemoteException;
//    void notifySchduledServerStop(int seconds) throws RemoteException;
//    boolean requestFileSend(String ... FileName) throws RemoteException;
//    void SendFile(String fName,byte[] bytes,int len) throws RemoteException;
    int SIGN_UP_EXIST_MAIL = 1;
    int SIGN_UP_EXIST_USERNAME = 2;
    int SIGN_UP_EXIST_MAIL_USERNAME = 3;
    int SIGN_IN_WRONG_DATA = 4;

    public void switchToMainView(User userData) throws RemoteException;

    public void appednContact(User contactData) throws RemoteException;

    public void sendAnnouncement(String message) throws RemoteException;

    public void signInErrMsg(int errorNUM) throws RemoteException;

    public void signUpErrMsg(int errorNUM) throws RemoteException;

    public void startChatWindow() throws RemoteException;

    public void notifyServerClosing() throws RemoteException;

    public void sendMessage(String msgXML) throws RemoteException;

    public void sendNotification(String notification) throws RemoteException;

    public boolean requestFileSend(String... fileName) throws RemoteException;

    public void sendFile(String fName, byte[] bytes, int len) throws RemoteException;

}
