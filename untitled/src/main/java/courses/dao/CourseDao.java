package courses.dao;

import src.main.resources.courses.exc.DaoException;
import src.main.resources.courses.Course;

import java.util.List;
public interface CourseDao {
    void add(Course course) throws DaoException;

    List<Course> findAll();
}
