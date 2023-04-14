package src.main.java.courses.dao;

import src.main.java.courses.exc.DaoException;
import src.main.java.courses.Review;

import java.util.List;

public interface ReviewDao {
    void add(Review review) throws DaoException;

    List<Review> findAll();

    List<Review> findByCourseId(int courseId);
}
