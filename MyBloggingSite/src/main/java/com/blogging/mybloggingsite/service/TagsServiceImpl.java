package com.blogging.mybloggingsite.service;

import com.blogging.mybloggingsite.model.Tags;
import com.blogging.mybloggingsite.repo.TagsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TagsServiceImpl implements TagsService {
    private final TagsRepository tagsRepository;

    @Override
    public Tags addNewTag(Tags tags) {
        return tagsRepository.save(tags);
    }

    @Override
    public List<Tags> getAllTags() {
        return tagsRepository.findAll();
    }

    @Override
    public Tags getTagById(long tagId) {
        return tagsRepository.findById(tagId).orElseThrow();
    }
}
