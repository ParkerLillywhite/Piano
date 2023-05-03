package courses.dao;

import courses.exc.DaoException;
import courses.Course;

import java.util.List;
public interface CourseDao {
    void add(Course course) throws DaoException;

    List<Course> findAll();

    Course findById(int id);
}
