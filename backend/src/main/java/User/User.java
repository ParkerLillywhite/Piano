package User;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private final Long id;
    private String username;
    private String password;

    private Long xp;

    private int level;

    protected User(){
        id = null;
    }

    public User(String username,
                String password,
                Long xp,
                int level){
        this();
        this.username = username;
        this.password = password;
        this.xp = xp;
        this.level = level;
    }

    public String getUsername(){
        return username;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public Long getXp(){
        return xp;
    }

    public void setXp(Long xp){
        this.xp = xp;
    }

    public int getLevel(){
        return level;
    }

    public void setLevel(int level){
        this.level = level;
    }
}
