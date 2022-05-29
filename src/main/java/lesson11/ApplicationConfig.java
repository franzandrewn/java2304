package lesson11;

import org.springframework.context.annotation.*;
import org.sqlite.SQLiteDataSource;

import javax.sql.DataSource;

@Configuration
@ComponentScan
@PropertySources(
        {@PropertySource("file:./src/main/resources/application.properties"),
        @PropertySource("file:./src/main/resources/additional.properties")}
)
public class ApplicationConfig {

    @Bean
    @Scope("singleton")
    public DataSource dataSource() {
        SQLiteDataSource dataSource = new SQLiteDataSource();
        dataSource.setUrl("jdbc:sqlite:./src/main/resources/users.db");
        return dataSource;
    }
}
