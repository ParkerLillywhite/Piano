package user;

import User.Login.api.UserApi;
import User.Login.dao.UserDao;
import com.google.gson.Gson;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import spark.Request;
import spark.Response;
import spark.Route;
import User.Login.User;

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
        Route createUserEndpoint = (req, res) -> {
            User user = gson.fromJson(req.body(), User.class);
            userDao.add(user);
            res.status(201);
            return gson.toJson(user);
        };

        when(request.body()).thenReturn("{\"UserName\":\"John\",\"PassWord\":\"boppla\"}");

        String result = (String) createUserEndpoint.handle(request, response);

        verify(response).status(201);

        assertEquals("{\"UserName\":\"John\",\"PassWord\":\"boppla\"}", result);

        verify(userDao).add(any(User.class));
    }

}