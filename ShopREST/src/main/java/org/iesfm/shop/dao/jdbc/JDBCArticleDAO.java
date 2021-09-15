package org.iesfm.shop.dao.jdbc;

import org.iesfm.shop.Article;
import org.iesfm.shop.dao.ArticleDAO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JDBCArticleDAO implements ArticleDAO {
private static final String SELECT_ARTICLE = "SELECT * FROM Article";
    @Override
    public List<Article> list() {
        Map<String, Object> params = new HashMap<>();

        return null;
    }

    @Override
    public List<Article> list(String tag) {
        return null;
    }

    @Override
    public Article get(int id) {
        return null;
    }

    @Override
    public boolean insert(Article article) {
        return false;
    }

    @Override
    public boolean update(Article article) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}
