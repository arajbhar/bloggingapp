package com.blogger.bloggingapp.comments;

import com.blogger.bloggingapp.articles.ArticleEntity;
import com.blogger.bloggingapp.commons.BaseEntity;
import com.blogger.bloggingapp.users.UserEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity(name = "comments")
public class CommentEntity extends BaseEntity {

    @Column(nullable = false,length = 100)
    String title;

    @Column(length = 1000)
    String body;

    @ManyToOne
    UserEntity auther;

    @ManyToOne
    ArticleEntity article;
}
