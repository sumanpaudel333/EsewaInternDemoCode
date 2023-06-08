package com.blogging.mybloggingsite.controller;

import com.blogging.mybloggingsite.model.Tags;
import com.blogging.mybloggingsite.service.TagsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/tags")
public class TagsController {
    private final TagsService tagsService;
    @PostMapping("/addnewtag")
    ResponseEntity<Tags> addNewTag(@RequestBody Tags tags){
    Tags tags1=tagsService.addNewTag(tags);
    return ResponseEntity.status(HttpStatus.CREATED).body(tags1);
    }

    @GetMapping("/getalltags")
    ResponseEntity<List<Tags>> getAllTags(){
        List<Tags> tags=tagsService.getAllTags();
        return ResponseEntity.status(HttpStatus.FOUND).body(tags);
    }

    @GetMapping("/gettagbyid/{tagId}")
    ResponseEntity<Tags> getTagById(@PathVariable Long tagId){
        Tags tags=tagsService.getTagById(tagId);
        return ResponseEntity.status(HttpStatus.FOUND).body(tags);
    }
}
