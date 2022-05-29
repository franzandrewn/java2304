package lesson11;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@Component
@Scope("prototype")
public class UserDao {
    // UserDao зависит от DataSource
    final DataSource dataSource;

    public UserDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public User findById(Long id) {
        try (Connection conn = dataSource.getConnection()) {
            // jdbc код для поиска человека по ид
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public List<User> findAll() {
        try (Connection conn = dataSource.getConnection()) {
            // jdbc код для получения всех людей
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

//    public DataSource newDataSource() {
//        SQLiteDataSource dataSource = new SQLiteDataSource();
//        dataSource.setUrl("jdbc:sqlite:./src/main/resources/users.db");
//        return dataSource;
//    }
}
