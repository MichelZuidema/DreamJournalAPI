package com.dreamjournal.backendapi.controller;

import com.dreamjournal.backendapi.entity.Story;
import com.dreamjournal.backendapi.model.response.ApiResponse;
import com.dreamjournal.backendapi.repository.StoryRepository;
import com.dreamjournal.backendapi.service.StoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(path = "/api/story")
public class StoryController {
    @Autowired
    private StoryRepository storyRepository;

    @Autowired
    private StoryService storyService;

    @GetMapping(path = "/")
    public @ResponseBody
    ResponseEntity getAllStories() {
        ArrayList<Story> stories = (ArrayList<Story>) storyRepository.findAll();

        if(stories.size() > 0) {
            return ResponseEntity.ok(new ApiResponse(true, stories));
        }

        return ResponseEntity.ok(new ApiResponse(false, "No public stories found!"));
    }

    @PostMapping(path = "/add")
    public @ResponseBody ResponseEntity addStory(@RequestBody Story story) {
        ApiResponse validateStory = storyService.validateStory(story);

        if(!validateStory.getSuccess()) {
            return ResponseEntity.ok(new ApiResponse(false, validateStory.getMessage()));
        }

        storyRepository.save(story);

        return ResponseEntity.ok(new ApiResponse(true, "Story Added!", story));
    }

    @GetMapping(path = "/{id}")
    public @ResponseBody
    ResponseEntity getStoryById(@PathVariable Integer id) {
        if(storyService.doesStoryExist(id)) {
            Story story = storyRepository.findById(id).get();

            return ResponseEntity.ok(new ApiResponse(true, story));
        }

        return ResponseEntity.ok(new ApiResponse(false, "Story not found!"));
    }

    @GetMapping(path = "/public")
    public @ResponseBody
    ResponseEntity getPublicStories() {
        List<Story> stories = storyRepository.findBySecure(false);

        if(stories.size() > 0) {
            return ResponseEntity.ok(new ApiResponse(true, stories));
        }

        return ResponseEntity.ok(new ApiResponse(false, "No public stories found!"));
    }

    @GetMapping(path = "/private")
    public @ResponseBody
    ResponseEntity getPrivateStories() {
        List<Story> stories = storyRepository.findBySecure(true);

        if(stories.size() > 0) {
            return ResponseEntity.ok(new ApiResponse(true, stories));
        }

        return ResponseEntity.ok(new ApiResponse(false, "No private stories found!"));
    }
}
