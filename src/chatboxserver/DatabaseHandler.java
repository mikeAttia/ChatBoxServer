package chatboxserver;


import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler {

    Connection con;
    ResultSet rs;
    PreparedStatement pst;
    MainController cont;

    public DatabaseHandler(MainController m) {
        cont=m;
    }
    
    public boolean intiateDBConnection() {
        try {
            //   DriverManager.registerDriver(new OracleDriver());
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "ehab", "ehab");
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

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

    public List getAllUsers() {
        List<User> users = new ArrayList<>();
        try {
            pst = con.prepareStatement("SELECT * FROM USERS");
            rs = pst.executeQuery();
            while (rs.next()) {
                User user = new User(rs.getString("USERNAME"), rs.getString("EMAIL"), rs.getString("PHONE"), rs.getString("GENDER"), rs.getString("BIRTHOFDATE"), rs.getString("PASSWORD"), rs.getString("COUNTRY"), rs.getString("STATUS"), rs.getString("IMAGE"));
                users.add(user);
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

    public List getFriends(String username) {
        List<User> friends = new ArrayList<>();
        try {
            pst = con.prepareStatement("SELECT * FROM CONTACTLIST WHERE USERNAME=?");
            pst.setString(1, username);
            rs = pst.executeQuery();
            while (rs.next()) {
                User friend = new User(rs.getString("USERNAME"), rs.getString("EMAIL"), rs.getString("PHONE"), rs.getString("GENDER"), rs.getString("BIRTHOFDATE"), rs.getString("PASSWORD"), rs.getString("COUNTRY"), rs.getString("STATUS"), rs.getString("IMAGE"));
                friends.add(friend);
            }
            return friends;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
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

    public boolean stopDBConnection() {
        try {
            con.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

   
}
