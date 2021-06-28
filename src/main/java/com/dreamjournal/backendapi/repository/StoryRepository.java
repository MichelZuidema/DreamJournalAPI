package com.dreamjournal.backendapi.repository;

import com.dreamjournal.backendapi.entity.Story;
import com.dreamjournal.backendapi.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StoryRepository extends CrudRepository<Story, Integer> {
    List<Story> findBySecure(Boolean secure);
    List<Story> findByDeleted(Boolean deleted);
    List<Story> findByCreatedBy(User user);
}
