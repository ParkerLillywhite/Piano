package course;

import courses.Review;
import courses.dao.Sql2oReviewDao;
import courses.exc.DaoException;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class Sql2oReviewDaoTest {
    private Sql2oReviewDao reviewDao;

    private Connection connection;

    @BeforeEach
    public void setUp() throws Exception {
        String connectionString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/init.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");

        reviewDao = new Sql2oReviewDao(sql2o);

        connection = sql2o.open();
    }

    @AfterEach
    public void tearDown() throws Exception {
        connection.close();
    }

    @Test
    private void testAddingReviewSetsId() throws Exception {
        Review review = newTestReview();
        int originalReviewId = review.getId();

        reviewDao.add(review);

        assertNotEquals(originalReviewId, review.getId());
    }

    @Test
    private void addedReviewsAreReturnedByFindAll() throws Exception {
        Review review = newTestReview();

        reviewDao.add(review);

        assertEquals(1, reviewDao.findAll().size());
    }

    @Test
    private void addedReviewsAreReturnedByFindByCourseId() throws Exception {
        Review review = newTestReview();

        reviewDao.add(review);

        Review foundReview = (Review) reviewDao.findByCourseId(review.getId());

        assertEquals(foundReview, review);

    }

//    @Test (expected = DaoException.class)
//    private void addingAReviewToANonExistentCourseThrowsException() throws Exception {
//        Review review = new Review(98, 1, "I found a mouse in my course");
//
//        reviewDao.add(review);
//    }

    public Review newTestReview() throws Exception {
        return new Review(1, 5, "I feel personally attacked by this course.");
    }
}
