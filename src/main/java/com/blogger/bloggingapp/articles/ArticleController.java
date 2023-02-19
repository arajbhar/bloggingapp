package com.blogger.bloggingapp.articles;

import com.blogger.bloggingapp.articles.dto.ArticleResponseDTO;
import com.blogger.bloggingapp.articles.dto.CreateArticleDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/articles")
public class ArticleController {

    private final ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @PostMapping("")
    public ResponseEntity<ArticleResponseDTO> createArticle(@RequestBody CreateArticleDTO createArticleDTO){

        var savedArticle=articleService.createArticle(createArticleDTO);
        return ResponseEntity
                .created(URI.create("/articles/"+savedArticle.getSlug()+savedArticle.getId()))
                .body(savedArticle);

    }


}
