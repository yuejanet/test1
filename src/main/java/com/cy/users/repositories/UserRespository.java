package com.cy.users.repositories;

import com.cy.users.dto.MongoUser;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface UserRespository extends PagingAndSortingRepository {
    Optional<MongoUser> findBylogin(String login);

}
