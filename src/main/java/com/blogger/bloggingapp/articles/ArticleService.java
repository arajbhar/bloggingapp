package com.blogger.bloggingapp.articles;

import com.blogger.bloggingapp.articles.dto.ArticleResponseDTO;
import com.blogger.bloggingapp.articles.dto.CreateArticleDTO;
import com.blogger.bloggingapp.users.dto.CreateUserDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleService {

    private final ArticleRepository articleRepository;
    private final ModelMapper modelMapper;

    public ArticleService(ArticleRepository articleRepository, ModelMapper modelMapper) {
        this.articleRepository = articleRepository;
        this.modelMapper = modelMapper;
    }

    public ArticleResponseDTO createArticle(CreateArticleDTO createArticleDTO){
        var article=modelMapper.map(createArticleDTO,ArticleEntity.class);
        var savedArticle=articleRepository.save(article);
        var articleResponseDTO=modelMapper.map(savedArticle,ArticleResponseDTO.class);
        return articleResponseDTO;
    }
}
