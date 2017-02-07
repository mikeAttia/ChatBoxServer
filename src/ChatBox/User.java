
package ChatBox;

import java.io.Serializable;

public class User implements Serializable{
    private String username;
    private String email;
    private String phone;
    private String gender;
    private String dateOfBirth;
    private String password;
    private String country;
    private String status;
    private String img;

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }
    

    public String getPhone() {
        return phone;
    }

    public String getGender() {
        return gender;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getPassword() {
        return password;
    }

    public String getCountry() {
        return country;
    }

    public String getStatus() {
        return status;
    }

    public String getImg() {
        return img;
    }
    
   public User(String name,String email,String phone,String gender,String dob,String passwd,String country,String status,String img)
    {
        this.username=name;
        this.email=email;
        this.phone=phone;
        this.gender=gender;
        this.dateOfBirth=dob;
        this.password=passwd;
        this.country=country;
        this.status=status;
        this.img=img;
    }    
}
