package com.example.bigevent.service;

import com.example.bigevent.pojo.Article;
import com.example.bigevent.pojo.PageBean;

public interface ArticleService {
    /**
     * 新增文章
     * @param article 文章
     */
    void add(Article article);

    /**
     * 条件分页列表查询
     * @param pageNum 页数
     * @param pageSize 页面大小
     * @param categoryId 分类id
     * @param state 状态
     * @return
     */
    PageBean<Article> list(Integer pageNum, Integer pageSize, Integer categoryId, String state);
}
