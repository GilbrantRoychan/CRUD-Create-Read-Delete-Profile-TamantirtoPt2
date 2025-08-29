package roychan.gill.database.tmtt.pt2.utill;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class HikariConnection {

    private static HikariDataSource dataSource;

    private  static  final Integer MINIMUM_IDLE = 5;
    private  static  final Integer MAXIMUM_POOL_SIZE = 10;
    private  static  final Long IDLE_TIMEOUT = 60_000L;

    static {
        HikariConfig config = new HikariConfig();
        config.setUsername("test");
        config.setPassword("test");
        config.setJdbcUrl("jdbc:mysql://localhost:3306/tamantirto");


        // set Connection Configuration
        config.setMinimumIdle(MINIMUM_IDLE);
        config.setMaximumPoolSize(MAXIMUM_POOL_SIZE);
        config.setIdleTimeout(IDLE_TIMEOUT);
        config.setMaxLifetime(IDLE_TIMEOUT * 10);

        // initialize datasource
        dataSource = new HikariDataSource(config);
    }

    public  static  HikariDataSource getDataSource(){
        return  dataSource;
    }
}
