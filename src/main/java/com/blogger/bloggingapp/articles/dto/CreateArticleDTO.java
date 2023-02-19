package com.blogger.bloggingapp.articles.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CreateArticleDTO {

    String slug;
    String title;
    String subTitle;
    String body;
    String author;

}
