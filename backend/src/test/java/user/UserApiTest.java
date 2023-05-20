package user;

import User.Login.dao.Sql2oUserDao;
import User.Login.dao.UserDao;
import User.Login.User;
import courses.exc.DaoException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.exceptions.base.MockitoException;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.beans.factory.annotation.Autowired;
import io.restassured.module.mockmvc.RestAssuredMockMvc;

import static io.restassured.RestAssured.when;
import static org.mockito.ArgumentMatchers.any;

public class UserApiTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private Sql2oUserDao userDao;

    @BeforeEach
    public void setUp(){
        RestAssuredMockMvc.mockMvc(mockMvc);
    }

    @Test
    public void testCreateUserEndpoint() {
        User user = new User("Borbley", "Bonson");
        try {
            when(userDao.add(any(User.class))).thenReturn(user);
        } catch (DaoException e){
            throw new MockitoException("problem");
        }
    }
}
