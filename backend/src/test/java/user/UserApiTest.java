package user;

import User.Login.dao.Sql2oUserDao;
import User.Login.dao.UserDao;
import User.Login.User;
import courses.exc.DaoException;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.exceptions.base.MockitoException;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.beans.factory.annotation.Autowired;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.sql2o.Sql2oException;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class UserApiTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private Sql2oUserDao userDao;

    @BeforeEach
    public void setUp(){
        RestAssuredMockMvc.mockMvc(mockMvc);
        userDao = mock(Sql2oUserDao.class);
    }

    @Test
    public void testCreateUserEndpoint() throws DaoException {

        String requestPayload = "{ \"userName\": \"DarkSouls\", \"passWord\": \"something\" }";

        doNothing().when(userDao).add(any(User.class));

        given()
                .contentType(ContentType.JSON)
                .body(requestPayload)
                .when()
                .post("/users")
                .then()
                .statusCode(201)
                .body("userName", equalTo("DarkSouls"))
                .body("passWord", equalTo("something"));

        verify(userDao, times(1)).add(any(User.class));

    }
}
