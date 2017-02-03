/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatboxserver;


import java.util.Vector;

/**
 *
 * @author Mustafa
 */
public class ChatModel implements ServerInterface {

    Vector<User> groupChatNames;
    Vector<Vector<User>> groupChatRefrences;
    MainController controlerObject;

    public ChatModel(MainController c) {
        controlerObject = c;
    }

    boolean bindService() {
        return true;
    }

    boolean unbindService() {
        return true;
    }

    void sendAnnouncment(String s) {
    }

    @Override
    public Vector<User> loginRequest(String x, String z, Client y) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String signUp(User x, Client y) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void changeStatus(String x, Client y) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Client requestChatP2P(Client src, String dest) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void intiateGroupChat(String groupChatName, Vector<User> group, Client initiator) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void sendMessageToGroup(String groupChatName, String msg) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void sendFileToGroup(String fname, byte[] bytes, int length) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
