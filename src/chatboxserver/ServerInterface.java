/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package chatboxserver;

import java.rmi.Remote;
import java.util.Vector;

/**
 *
 * @author Mustafa
 */
public interface ServerInterface extends Remote{
//    +LoginRequest(String user,String Password,Client cl) Vector<User>
//+signUp(Client cl,User usr) Boolean
//+changeStatus(String newStatus,Client u) void
//+requestChatP2P(Client src,String DestUserName) Client
//+intiateGroupChat(String groupChatName,Vector<User> group ChatMembers,Client inititor)
//+sendMessageToGroup(String groupName,String msg) void
//+sendFileToGroup(String fName,byte[] bytes,int len) void
    Vector<User> loginRequest(String username,String password,Client userInt);
    String signUp(User newUser,Client userInt);
    void changeStatus(String x,Client y);
    Client requestChatP2P(Client src,String dest);
    void intiateGroupChat(String groupChatName,Vector<User> group,Client initiator);
    void sendMessageToGroup(String groupChatName,String msg);
    void sendFileToGroup(String fname,byte[] bytes,int length);
    
}
