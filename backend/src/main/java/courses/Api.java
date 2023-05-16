package courses;

import com.google.gson.Gson;
import courses.dao.ReviewDao;
import courses.dao.Sql2oReviewDao;
import courses.exc.ApiException;
import courses.exc.DaoException;
import org.sql2o.Sql2o;
import courses.dao.Sql2oCourseDao;
import courses.dao.CourseDao;

import java.util.HashMap;
import java.util.Map;

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
        ReviewDao reviewDao = new Sql2oReviewDao(sql2o);
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
            if(course == null){
                throw new ApiException(404, "Could not find course id " + id);
            }
            return course;
        }, gson::toJson);

        post("/courses/:courseId/reviews", "application/json", (req, res) -> {
            int courseId = Integer.parseInt(req.params("courseId"));
            Review review = gson.fromJson(req.body(), Review.class);
            review.setId(courseId);
            try {
                reviewDao.add(review);
            } catch (DaoException exception) {
                throw new ApiException(500, exception.getMessage());
            }
            res.status(201);
            return review;
        }, gson::toJson);

        get("/courses/:courseId/reviews", "application/Json",
                (req, res) -> reviewDao.findAll() ,gson::toJson);

        get("/course/:courseId/reviews", "application/Json", (req, res) -> {
            int courseId = Integer.parseInt(req.params("courseId"));
            return reviewDao.findByCourseId(courseId);
        }, gson::toJson);

        exception(ApiException.class, (exc, req, res) -> {
            ApiException exception = (ApiException) exc;
            Map<String, Object> jsonMap = new HashMap<>();
            jsonMap.put("status", exception.getStatus());
            jsonMap.put("errorMessage", exception.getMessage());
            res.type("application/json");
            res.status(exception.getStatus());
            res.body(gson.toJson(jsonMap));
        });

        after((req, res) -> {
            res.type("application/json");
        });
    }
}
