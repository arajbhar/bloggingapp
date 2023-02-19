package com.blogger.bloggingapp.articles.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ArticleResponseDTO {

    String id;
    String slug;
    String title;
    String author;
}
