package courses.dao;

import org.sql2o.Sql2oException;
import courses.Course;
import courses.exc.DaoException;
import org.sql2o.Sql2o;
import org.sql2o.Connection;

import java.util.List;

public class Sql2oCourseDao implements CourseDao {

    private final Sql2o sql2o;
    public Sql2oCourseDao(Sql2o sql2o){
        this.sql2o = sql2o;
    }
    @Override
    public void add(Course course) throws DaoException {
        String sqlString = "INSERT INTO courses(name) VALUES (:name)";
        try (Connection connection = sql2o.open()) {
            int id = (int) connection.createQuery(sqlString)
                    .bind(course)
                    .executeUpdate()
                    .getKey();
            course.setId(id);
        } catch (Sql2oException exception) {
            throw new DaoException(exception, "Problem adding course");
        }
    }

    @Override
    public List<Course> findAll() {
        try(Connection connection = sql2o.open()) {
            return connection.createQuery("SELECT * FROM courses")
                    //this returns a list of whatever class you pass in
                    .executeAndFetch(Course.class);
        }
    }

    @Override
    public Course findById(int id) {
        try (Connection con = sql2o.open()) {
            return con.createQuery("SELECT * from courses WHERE id = :id")
                    .addParameter("id", id)
                    .executeAndFetchFirst(Course.class);
        }
    }
}
