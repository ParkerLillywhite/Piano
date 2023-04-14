package src.main.java.courses.dao;

import src.main.java.courses.exc.DaoException;
import src.main.java.courses.Course;

import java.util.List;
public interface CourseDao {
    void add(Course course) throws DaoException;

    List<Course> findAll();
}
