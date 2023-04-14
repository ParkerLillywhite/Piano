package courses.dao;

import src.main.resources.courses.exc.DaoException;
import src.main.resources.courses.Review;

import java.util.List;

public interface ReviewDao {
    void add(Review review) throws DaoException;

    List<Review> findAll();

    List<Review> findByCourseId(int courseId);
}
