package org.iesfm.tiendamongo.services;

import org.iesfm.tiendamongo.Article;
import org.iesfm.tiendamongo.repository.ArticleRepository;
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
