package chatboxserver;

import ChatBox.User;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Vector;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DatabaseHandler {
    
    //TODO: Check if database connection isvalid() before attempting everymethod

    Connection con;
    ResultSet rs;
    PreparedStatement pst;
    MainController cont;
    String property = System.getProperty("user.dir");

    //Constructor that links Database handler to MainController
    public DatabaseHandler(MainController controller) {
        cont = controller;
    }

    /*-------------------------------------------------
       Connection related methods
    -------------------------------------------------*/
    public boolean intiateDBConnection() {
        try {
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection("jdbc:sqlite:" + property + "/ProjectTest.db", "", "");

            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean stopDBConnection() {
        try {
            con.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    /*-------------------------------------------------
        Sign in related methods
    -------------------------------------------------*/
    public Vector<User> getContactList(String userName) {
        Vector<User> contacts = new Vector<>();
        try {
            pst = con.prepareStatement("SELECT u.USERNAME AS friendname,email,phone,gender,BIRTHOFDATE,COUNTRY,STATUS,IMAGE FROM USERS u INNER JOIN CONTACTLIST cl on u.username=cl.friendname where cl.username=?");
            pst.setString(1, userName);
            rs = pst.executeQuery();
            while (rs.next()) {
                System.out.println("asd");
                User contact = new User(rs.getString("friendname"), rs.getString("EMAIL"), rs.getString("PHONE"), rs.getString("GENDER"), rs.getString("BIRTHOFDATE"), null, rs.getString("COUNTRY"), rs.getString("STATUS"), rs.getString("IMAGE"));
                contacts.add(contact);
            }
            return contacts;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public void updateStatus(String username, String status) {
        try {
            pst = con.prepareStatement("UPDATE USERS SET STATUS=? WHERE USERNAME=?");
            pst.setString(1, status);
            pst.setString(2, username);
            pst.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public String getStatus(String username) {
        String result = null;
        try {
            pst = con.prepareStatement("SELECT STATUS FROM USERS WHERE USERNAME=?");
            rs = pst.executeQuery();
            result = rs.getString(1);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return result;
    }

    public User signInbyName(String username, String password) {
        try {
            pst = con.prepareStatement("SELECT * FROM USERS WHERE USERNAME=? and PASSWORD=?");
            pst.setString(1, username);
            pst.setString(2, password);

            rs = pst.executeQuery();

            if (rs.next()) {
                User user = new User(rs.getString("USERNAME"), rs.getString("EMAIL"), rs.getString("PHONE"), rs.getString("GENDER"), rs.getString("BIRTHOFDATE"), rs.getString("PASSWORD"), rs.getString("COUNTRY"), rs.getString("STATUS"), rs.getString("IMAGE"));
                return user;
            } else {
                return null;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }

    }

    public User signIn(String email, String password) {
        try {
            pst = con.prepareStatement("select * from users where (username=? or email=?) and password =?");
            pst.setString(1, email);
                        pst.setString(2, email);

            pst.setString(3, password);

            rs = pst.executeQuery();

            if (rs.next()) {
                User user = new User(rs.getString("USERNAME"), rs.getString("EMAIL"), rs.getString("PHONE"), rs.getString("GENDER"), rs.getString("BIRTHOFDATE"), rs.getString("PASSWORD"), rs.getString("COUNTRY"), rs.getString("STATUS"), rs.getString("IMAGE"));
                return user;
            } else {
                return null;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }

    }
    
     /*-------------------------------------------------
        Sign Up related methods
    -------------------------------------------------*/

    public boolean insertUser(User e) {
        try {
            pst = con.prepareStatement("INSERT INTO USERS VALUES(?,?,?,?,?,?,?,?,?)");
            pst.setString(1, e.getUsername());
            pst.setString(2, e.getEmail());
            pst.setString(3, e.getPassword());
            pst.setString(4, e.getPhone());
            pst.setString(5, e.getDateOfBirth());
            pst.setString(6, e.getGender());
            pst.setString(7, e.getStatus());
            pst.setString(8, e.getCountry());
            pst.setString(9, e.getImg());
            pst.executeUpdate();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean checkUsername(String username) {
        try {
            pst = con.prepareStatement("SELECT * FROM USERS WHERE USERNAME=?");
            pst.setString(1, username);
            rs = pst.executeQuery();
            return !rs.next();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }

    }

    public boolean checkEmail(String email) {
        try {
            pst = con.prepareStatement("SELECT * FROM USERS WHERE EMAIL=?");
            pst.setString(1, email);
            rs = pst.executeQuery();
            return !rs.next(); //if rs has data return false if empty return true
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        
    }
    
     /*-------------------------------------------------
        Updating UserData relatd Methods
    -------------------------------------------------*/

    public boolean insertContact(String userName, String friendName) {
        try {
            pst = con.prepareStatement("INSERT INTO CONTACTLIST VALUES(?,?)");
            pst.setString(1, userName);
            pst.setString(2, friendName);
            pst.executeUpdate();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public void updateImg(String username, Blob img) {
        try {
            pst = con.prepareStatement("UPDATE USERS SET IMAGE=? WHERE USERNAME=?");
            pst.setBlob(1, img);
            pst.setString(2, username);
            pst.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    /*-------------------------------------------------
        Server related Database Queries
    -------------------------------------------------*/
    
    public ObservableList<String> getAllUsers() {
        ObservableList<String> users = FXCollections.observableArrayList();
        try {
            pst = con.prepareStatement("SELECT USERNAME FROM USERS");
            rs = pst.executeQuery();
            while (rs.next()) {
                users.add(rs.getString("USERNAME"));
            }
            return users;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public User getUser(String username) {
        try {
            pst = con.prepareStatement("SELECT * FROM USERS WHERE USERNAME=?");
            pst.setString(1, username);
            rs = pst.executeQuery();

        if (rs.next()) {
                User user = new User(rs.getString("USERNAME"), rs.getString("EMAIL"), rs.getString("PHONE"), rs.getString("GENDER"), rs.getString("BIRTHOFDATE"), rs.getString("PASSWORD"), rs.getString("COUNTRY"), rs.getString("STATUS"), rs.getString("IMAGE"));
                return user;
            } else {
                return null;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public void deleteUser(String username) {
        try {
            pst = con.prepareStatement("DELETE FROM PERSONS WHERE USERNAME=?");
            pst.setString(1, username);
            pst.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void deleteContact(String username, String friendname) {
        try {
            pst = con.prepareStatement("DELETE FROM CONTACTLIST WHERE FRIENDNAME=? AND USERNAME=?");
            pst.setString(1, friendname);
            pst.setString(1, username);
            pst.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

     
}
