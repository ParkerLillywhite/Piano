package courseDao;



import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import src.main.java.courses.Course;
import src.main.java.courses.dao.Sql2oCourseDao;

public class Sql2oCourseDaoTest {

    private Sql2oCourseDao dao;
    private Connection connection;

    @org.junit.jupiter.api.BeforeEach
    public void setUp() throws Exception {
        //on start up this will run the script to create our tables which is all good fun
        String connectionString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/init.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");

        dao = new Sql2oCourseDao(sql2o);

        //keep connection open through the entire test so that it isn't wiped out

        connection = sql2o.open();
    }

    @AfterEach
    public void TearDown() throws Exception {
        connection.close();
    }

    @Test
    public void testAddingCourseSetsId() throws Exception {
        Course course = new Course("Test");
        int originalCourseId = course.getId();

        dao.add(course);

        assertNotEquals(originalCourseId, course.getId());
    }

    @Test
    public void AddedCoursesAreReturnedFromFindAll() throws Exception {
        Course course = new Course("Test");

        dao.add(course);

        assertEquals(1, dao.findAll().size());
    }


}