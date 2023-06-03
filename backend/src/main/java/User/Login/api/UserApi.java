package User.Login.api;

import User.Login.dao.Sql2oUserDao;
import User.Login.dao.UserDao;
import com.google.gson.Gson;
import courses.exc.ApiException;
import org.sql2o.Sql2o;
import User.User;

import static spark.Spark.port;
import static spark.Spark.post;
import static spark.Spark.*;

public class UserApi {

    public static void main(String[] args){
        String dataSource = "jdbc:h2:~/users.db";

        if(args.length > 0){
            if(args.length !=1){
                System.out.println("Java Api <port> <datasource>");
                System.exit(0);
            }
            port(Integer.parseInt(args[0]));
            dataSource = args[1];
        }
        Sql2o sql2o = new Sql2o(
                String.format("%s:INIT=RUNSCRIPT from 'classpath:db/user_init.sql'", dataSource),
                "", ""
        );

        UserDao userDao = new Sql2oUserDao(sql2o);

        Gson gson = new Gson();

        post("/users", "application/json", (req, res) -> {
            User user = gson.fromJson(req.body(), User.class);
            userDao.add(user);
            res.status(201);
            return user;
        }, gson::toJson);

        get("/users", "application/json",
                (req, res) -> userDao.findAll(), gson::toJson);

        get("/users/:id", "application/json", (req, res) -> {
            int id = Integer.parseInt(req.params("id"));
            User user = userDao.findById(id);
            if(user == null){
                throw new ApiException(404, "Could not find user with id: " + id);
            }
            return user;
        }, gson::toJson);
    }
}
