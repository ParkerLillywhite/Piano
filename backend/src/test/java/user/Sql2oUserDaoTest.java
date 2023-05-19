package user;

import User.Login.dao.Sql2oUserDao;
import User.Login.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class Sql2oUserDaoTest {

    private Sql2oUserDao sql2oUserDao;

    private Connection connection;

    @BeforeEach
    public void setUp(){
        String connectionString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/init.sql'";

        Sql2o sql2o = new Sql2o(connectionString, "", "");

        sql2oUserDao = new Sql2oUserDao(sql2o);

        connection = sql2o.open();
    }

    @AfterEach
    public void tearDown(){
        connection.close();
    }

    @Test
    public void addingNewUserSetsId() throws Exception {
        User user = newTestUser();
        int userId = user.getId();

        sql2oUserDao.add(user);

        assertNotEquals(userId, user.getId());
    }

    @Test
    public void listOfUsersAreReturnedFromFindAll() throws Exception {
        User user = newTestUser();
        User otherUser = new User("CrogNor", "abs");

        sql2oUserDao.add(user);
        sql2oUserDao.add(otherUser);

        assertEquals(2, sql2oUserDao.findAll().size());
    }

    public User newTestUser() throws Exception {
        return new User("Borbley", "nunchucks");
    }

}
