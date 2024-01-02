package com.cy.users.services;

import com.cy.users.dto.UserDto;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserService extends MongoRepository<UserDto, String> {

    public UserDto getUserById(String id);

}
