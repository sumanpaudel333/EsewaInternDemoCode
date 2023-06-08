package com.blogging.mybloggingsite.service;

import com.blogging.mybloggingsite.model.Tags;

import java.util.List;

public interface TagsService {
    Tags addNewTag(Tags tags);
    List<Tags> getAllTags();
    Tags getTagById(long tagId);
}
