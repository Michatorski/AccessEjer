package org.iesfm.tiendaMondo.services;

import org.iesfm.tiendaMondo.Article;
import org.iesfm.tiendaMondo.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleService {
    @Autowired
    private ArticleRepository articleRepository;

    public boolean insert(Article article){
        if (articleRepository.existsById(article.getId())){
            return false;
        }
        articleRepository.insert(article);
        return true;
    }
}
