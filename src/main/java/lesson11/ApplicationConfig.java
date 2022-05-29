package lesson11;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.sqlite.SQLiteDataSource;

import javax.sql.DataSource;

@Configuration
@ComponentScan
public class ApplicationConfig {

    @Bean
    @Scope("singleton")
    public DataSource dataSource() {
        SQLiteDataSource dataSource = new SQLiteDataSource();
        dataSource.setUrl("jdbc:sqlite:./src/main/resources/users.db");
        return dataSource;
    }
}
