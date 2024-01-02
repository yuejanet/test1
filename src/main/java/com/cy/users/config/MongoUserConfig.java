package com.cy.users.config;

import com.mongodb.MongoClientSettings;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.Collections;

@Configuration
@ComponentScan("com.cy.users")
@EnableMongoRepositories(basePackages = "com.cy.users.repositories")
public class MongoUserConfig extends AbstractMongoClientConfiguration {

    @Override
    protected String getDatabaseName(){
        return "userManagement";
    }
    @Override
    protected void configureClientSettings(MongoClientSettings.Builder builder){
        builder.credential(MongoCredential.createCredential("admin","userManagement","123456".toCharArray())
                ).applyToClusterSettings(settings -> settings.hosts(Collections.singletonList(new ServerAddress("localhost",27017))));
    }

}
