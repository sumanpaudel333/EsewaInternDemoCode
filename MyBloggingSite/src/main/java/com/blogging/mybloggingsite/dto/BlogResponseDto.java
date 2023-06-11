package com.blogging.mybloggingsite.dto;

import com.blogging.mybloggingsite.model.Tags;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BlogResponseDto {
    private String blogTitle;
    private String blogContent;
    private String categoryName;
    private List<Tags> tag;
    private String authorUserName;
}
