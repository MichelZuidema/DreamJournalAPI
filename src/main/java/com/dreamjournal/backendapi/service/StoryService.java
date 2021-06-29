package com.dreamjournal.backendapi.service;

import com.dreamjournal.backendapi.entity.Story;
import com.dreamjournal.backendapi.model.response.ApiResponse;
import com.dreamjournal.backendapi.repository.StoryRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StoryService {
    @Autowired
    private StoryRepository storyRepository;

    public ApiResponse validateStory(Story storyRequest) {
        if (StringUtils.isAnyEmpty(storyRequest.getContent(), storyRequest.getSecure().toString())) {
            return new ApiResponse(false, "The story request was not valid, please try again.");
        }

        return new ApiResponse(true);
    }

    public Boolean doesStoryExist(Story story) {
        return doesStoryExist(story.getId());
    }

    public Boolean doesStoryExist(Integer id) {
        Optional<Story> storyOptional = storyRepository.findById(id);

        return storyOptional.isPresent();
    }
}
