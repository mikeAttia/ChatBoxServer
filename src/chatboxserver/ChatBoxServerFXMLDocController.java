/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatboxserver;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

/**
 *
 * @author michael
 */
public class ChatBoxServerFXMLDocController implements Initializable {

    public MainController mainController;

    public ChatBoxServerFXMLDocController() {
        mainController = new MainController(this);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        /*
            connect to database through the mainController object.
            change elements appearance according to connected or not (calling other methods from in here).
        */
       
    }

    /*
    Assigning methods to Buttons similar to the commented example
     */
    /*
    @FXML
    private void handleButtonAction(ActionEvent event) {
        
    }
    */

}
