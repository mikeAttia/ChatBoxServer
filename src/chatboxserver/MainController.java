/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatboxserver;


/**
 *
 * @author Mustafa
 */
public class MainController{

     ChatModel chatModel;
     DatabaseHandler dbHandler;
     ChatBoxServerFXMLDocController fxmlController;
     ChatBoxServer application;
    
    
    //Constructor that takes FXMLController and creates objects of other classes
    public MainController(ChatBoxServerFXMLDocController fxmlCtrlr) {
        chatModel=new ChatModel(this);
        dbHandler = new DatabaseHandler(this);
        fxmlController = fxmlCtrlr;
    }
 
}
