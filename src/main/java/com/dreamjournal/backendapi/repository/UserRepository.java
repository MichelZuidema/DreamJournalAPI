package com.dreamjournal.backendapi.repository;

import com.dreamjournal.backendapi.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    User findByName(String name);

    Boolean existsByName(String name);
}
