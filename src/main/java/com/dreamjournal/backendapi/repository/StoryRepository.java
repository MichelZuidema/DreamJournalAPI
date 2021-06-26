package com.dreamjournal.backendapi.repository;

import com.dreamjournal.backendapi.entity.Story;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StoryRepository extends CrudRepository<Story, Integer> {
    List<Story> findBySecure(Boolean secure);
}
