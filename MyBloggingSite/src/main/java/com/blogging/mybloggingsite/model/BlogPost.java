package com.blogging.mybloggingsite.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CurrentTimestamp;
import org.hibernate.tuple.GenerationTiming;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BlogPost {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "post_id")
    private String blogPostId;
    @Column(name = "blog_title")
    private String blogTitle;
    @Column(name = "blog_content")
    private String blogContent;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id")
    private Category category;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Tags> tag;
    @Column(name = "published_date")
    @CurrentTimestamp(timing = GenerationTiming.INSERT)
    private Date publishedDate;
    @ManyToOne
    private Author author;
}
