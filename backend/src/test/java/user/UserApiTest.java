package user;

import User.Login.api.UserApi;
import User.Login.dao.UserDao;
import com.google.gson.Gson;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import spark.Request;
import spark.Response;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class UserApiTest {
    private UserApi userApi;
    private UserDao userDao;
    private Gson gson;

    private Request request;

    private Response response;

    @Before
    public void setup() {
        userDao = mock(UserDao.class);
        gson = new Gson();
        userApi = new UserApi();
        request = mock(Request.class);
        response = mock(Response.class);
    }

    @Test
    public void testCreateUserEndpoint() throws Exception {

    }

}