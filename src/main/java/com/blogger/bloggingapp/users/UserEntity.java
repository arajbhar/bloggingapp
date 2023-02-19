package com.blogger.bloggingapp.users;

import com.blogger.bloggingapp.articles.ArticleEntity;
import com.blogger.bloggingapp.commons.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity(name = "users")
@Getter
@Setter
public class UserEntity extends BaseEntity {

    @Column(unique = true,nullable = false,length = 50)
    String username;
    String password; //TO DO hash
    String email;
    String bio;
    String image;

    @ManyToMany(mappedBy = "likedby")
    List<ArticleEntity> likedArticle;

    @ManyToMany
            @JoinTable(
                    name = "user_follows",
                    joinColumns = @JoinColumn(name = "follower_id"),
                    inverseJoinColumns = @JoinColumn(name = "following_id")
            )
    List<UserEntity> following;

    @ManyToMany(mappedBy = "following")
    List<UserEntity> followers;
}
