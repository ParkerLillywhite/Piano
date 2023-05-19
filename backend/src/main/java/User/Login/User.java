package User.Login;

import java.util.Objects;

public class User {
    private int id;

    private String userName;

    private String passWord;

    public User(String userName, String passWord){
        this.userName = userName;
        this.passWord = passWord;
    }

    public int getId(){
       return id;
    }

    public String getUserName(){
        return userName;
    }

    public String getPassWord(){
        return passWord;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setUserName(String userName){
        this.userName = userName;
    }

    public void setPassWord(String Password){
        this.passWord = passWord;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && Objects.equals(userName, user.userName) && Objects.equals(passWord, user.passWord);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userName, passWord);
    }
}
