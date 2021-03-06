package in.co.galaxy.assignment.config;

import org.apache.derby.jdbc.EmbeddedDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Atul.Jain on 2019/01/05.
 */
@Configuration
public class DatasourceBean {

    @Bean
    public DataSource dataSource() {
        EmbeddedDataSource dataSource = new EmbeddedDataSource();
        dataSource.setConnectionAttributes("create=true");
        dataSource.setDatabaseName("InterstellarTransportSystem");
        dataSource.setUser("username");
        dataSource.setPassword("password");

        try {
            dataSource.getConnection();
        } catch (SQLException e) {
            Logger.getLogger("discovery").log(Level.SEVERE, "Failed to connect to the database: " + e);
        }

        return dataSource;
    }
}