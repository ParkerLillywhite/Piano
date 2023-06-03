package UserPosts;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserPost {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private final Long id;
    private String body;

    protected UserPost(){
        id = null;
    }

    public UserPost(String body){
        this();
        this.body = body;
    }

    public String getBody(){
        return body;
    }

    public void setBody(String body){
        this.body = body;
    }
}
