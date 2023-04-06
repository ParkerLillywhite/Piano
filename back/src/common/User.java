public class User {
    private int id;
    private string userName;
    private string password;
    private string email;

    public User(String userName, String password, String email){
        this.userName = userName;
        this.password = password;
        this.email = email;
    }

    public getId(){
        return id;
    }

    public setId(){
        this.id = id;
    }

    public getUserName(){
        return userName;
    }

    public setUserName(){
        this.userName = userName;
    }

    public getPassword(){
        return password;
    }

    public setPassword(){
        this.password = password;
    }

    public getEmail(){
        return email;
    }

    public setEmail(){
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