package com.fjiskra.model;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Locale;

/**
 * Created by jiskra on 18.3.2016.
 */
@Configuration
public class MainConfig {

    private String connectionUrl = "postgres://afppbwgrazhckh:Lh-NR1KVXsTKE_TyWxxUMAYZtE@ec2-54-83-36-203.compute-1.amazonaws.com:5432/dc5rqkj10gg1fc";

    //@Bean
    public BasicDataSource dataSource() throws URISyntaxException {
        URI dbUri = new URI(connectionUrl);

        String username = dbUri.getUserInfo().split(":")[0];
        String password = dbUri.getUserInfo().split(":")[1];
        String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath();

        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setUrl(dbUrl);
        basicDataSource.setUsername(username);
        basicDataSource.setPassword(password);

        return basicDataSource;
    }
}
