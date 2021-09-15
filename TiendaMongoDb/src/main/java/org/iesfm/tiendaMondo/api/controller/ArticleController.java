package org.iesfm.tiendaMondo.api.controller;

import org.iesfm.tiendaMondo.Article;
import org.iesfm.tiendaMondo.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ArticleController {
    @Autowired
    private ArticleRepository articleRepository;


    @RequestMapping(method = RequestMethod.POST, path = "/articles")
    public void insert (
            @RequestBody Article article
            ){
        articleRepository.save(article);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/articles")
    public List<Article> findByArticle(){
        return articleRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/articles/order=:order")
    public List<Article> findByOrder(){
        return articleRepository.findByOrder();
    }
}
