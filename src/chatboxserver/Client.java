/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package chatboxserver;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Mustafa
 */
public interface Client extends Remote{
//    +displayMsg(String msg) void
//+showAdvert(String s)
//+getNotification(User s,String Status) void
//+notifyServerStop() Void
//+notifySchduledServerStop(Time m) void
//+requestFileSend(String ... FileName) Boolean
//+SendFile(String fName,byte[] bytes,int len) void
    
    void displayMsg(String msg) throws RemoteException;
    void showAdvert(String s) throws RemoteException ;
    void getNotification(User s,String Status) throws RemoteException;
    void notifyServerStop() throws RemoteException;
    void notifySchduledServerStop(int seconds) throws RemoteException;
    boolean requestFileSend(String ... FileName) throws RemoteException;
    void SendFile(String fName,byte[] bytes,int len) throws RemoteException;
    
}