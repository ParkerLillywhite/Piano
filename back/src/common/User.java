package src.common;

import java.util.Objects;
public class User {
    private int id;
    private String userName;
    private String password;
    private String email;

    public User(String userName, String password, String email){
        this.userName = userName;
        this.password = password;
        this.email = email;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getUserName(){
        return userName;
    }

    public void setUserName(String userName){
        this.userName = userName;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        User user = (User) object;
        return id == user.id && java.util.Objects.equals(userName, user.userName) && java.util.Objects.equals(password, user.password) && java.util.Objects.equals(email, user.email);
    }

    public int hashCode() {
        return Objects.hash(super.hashCode(), id, userName, password, email);
    }
}