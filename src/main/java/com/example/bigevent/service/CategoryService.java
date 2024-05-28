package com.example.bigevent.service;

import com.example.bigevent.pojo.Category;

import java.util.List;

public interface CategoryService {
    /**
     * 新增分类
     * @param category 类别
     */
    void add(Category category);

    /**
     * 分类列表
     * @return List<Category>
     */
    List<Category> list();

    /**
     * 根据id查询分类信息
     * @param id 分类id
     * @return Category
     */
    Category findById(Integer id);

    /**
     * 更新分类
     * @param category 分类信息
     */
    void update(Category category);

    /**
     * 删除分类
     * @param id 分类id
     */
    void deleteById(Integer id);
}
