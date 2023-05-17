package User.Login.dao;

import courses.exc.DaoException;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import User.Login.User;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oUserDao implements UserDao{

    private final Sql2o sql2o;

    public Sql2oUserDao(Sql2o sql2o){ this.sql2o = sql2o; }

    @Override
    public void add(User user) throws DaoException {
        String sqlString = "INSERT INTO users(user_name, password) VALUES (:userName, password)";
        try(Connection connection = sql2o.open()){
            int id = (int) connection.createQuery(sqlString)
                    .bind(user)
                    .executeUpdate()
                    .getKey();
        } catch (Sql2oException exception) {
            throw new DaoException(exception, "Problem adding user");
        }
    }

    @Override
    public List<User> findAll(){
        try(Connection connection = sql2o.open()){
            return connection.createQuery("SELECT * FROM users")
                    .executeAndFetch(User.class);
        }
    }

    @Override
    public List<User> findById(int id){
        try(Connection connection = sql2o.open()){
            return connection.createQuery("SELECT * FROM users WHERE id = :id")
                    .addParameter("id", id)
                    .executeAndFetch(User.class);
        }
    }

}
