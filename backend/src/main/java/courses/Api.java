package courses;

import com.google.gson.Gson;
import org.sql2o.Sql2o;
import courses.dao.Sql2oCourseDao;
import courses.dao.CourseDao;

import static spark.Spark.*;

public class Api {
    public static void main(String[] args){
        String dataSource = "jdbc:h2:~/reviews.db";

        if(args.length > 0){
            if(args.length != 2){
                System.out.println("Java Api <port> <datasource>");
                System.exit(0);
            }
            port(Integer.parseInt(args[0]));
            dataSource = args[1];
        }
        Sql2o sql2o = new Sql2o(
                String.format("%s;INIT=RUNSCRIPT from 'classpath:db/init.sql'", dataSource),
                "", "");
        CourseDao courseDao = new Sql2oCourseDao(sql2o);
        Gson gson = new Gson();

        post("/courses", "application/json", (req, res) -> {
            Course course = gson.fromJson(req.body(), Course.class);
            courseDao.add(course);
            res.status(201);
            return course;
        }, gson::toJson);

        get("/courses", "application/json",
                (req, res) -> courseDao.findAll(), gson::toJson);

        get("/courses/:id", "application/json", (req, res) -> {
            int id = Integer.parseInt(req.params("id"));
            Course course = courseDao.findById(id);
            return course;
        }, gson::toJson);

        after((req, res) -> {
            res.type("application/json");
        });
    }
}
