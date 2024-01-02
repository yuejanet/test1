package com.cy.users;
import java.util.*;
import com.cy.users.dto.UserDto;
import com.cy.users.services.UserService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;

import static java.lang.Long.parseLong;


@SpringBootTest
class UsersApplicationTests {
    @Autowired
    private UserService userservice;

    @Autowired
    private MongoTemplate mongoTemplate;
    @Test
    public void testInsert() {
        UserDto user = new UserDto("NewfirstName","NewlastName","20/04/1996", "France");
        userservice.insert(user);
    }
    @Test
    public void testFindById() {
        UserDto user = userservice.getUserById("63616cd64581edbfddfd4a1e");

    }
}
