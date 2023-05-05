package course;

import com.google.gson.Gson;
import courses.Api;
import org.junit.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import spark.Spark;
import testing.ApiClient;
import testing.ApiResponse;
import org.junit.jupiter.api.Test;


import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ApiTest {

    public static String PORT = "4568";
    public static String TEST_DATASOURCE = "jdbc:h2:mem:testing";

    private Connection conn;
    private ApiClient client;
    private Gson gson;

    @BeforeClass
    public static void startServer() throws Exception {
        String[] args = { PORT, TEST_DATASOURCE };
        Api.main(args);
    }

    @AfterClass
    public static void stopServer() throws Exception {
        Spark.stop();
    }

    @BeforeEach
    public void setUp() throws Exception {
        Sql2o sql2o = new Sql2o(TEST_DATASOURCE + ";INIT=RUNSCRIPT from 'classpath:db/init.sql'", "", "");
        conn = sql2o.open();
        client = new ApiClient("http://localhost:" + PORT);
        gson = new Gson();
    }

    @AfterEach
    public void tearDown() throws Exception {
        conn.close();
    }

    @Test
    public void addingCoursesReturnsCreatedStatus() throws Exception {
        Map<String, String> values = new HashMap<>();
        values.put("name", "test");

        ApiResponse response = client.request("POST", "/courses", gson.toJson(values));

        assertEquals(201, response.getStatus());
    }
}
