package com.example.bigevent.service.impl;

import com.example.bigevent.mapper.CategoryMapper;
import com.example.bigevent.pojo.Category;
import com.example.bigevent.service.CategoryService;
import com.example.bigevent.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    /**
     * 新增分类
     * @param category 类别
     */
    @Override
    public void add(Category category) {
        //补充属性值
        category.setCreateTime(LocalDateTime.now());
        category.setUpdateTime(LocalDateTime.now());
        Map<String,Object> map = ThreadLocalUtil.get();
        Integer userId = (Integer) map.get("id");
        category.setCreateUser(userId);
        categoryMapper.add(category);
    }

    /**
     * 分类列表
     * @return List<Category>
     */
    @Override
    public List<Category> list() {
        Map<String,Object> map = ThreadLocalUtil.get();
        Integer userId = (Integer) map.get("id");
        return categoryMapper.list(userId);
    }

    /**
     * 根据id查询分类详情
     * @param id 分类id
     * @return Category
     */
    @Override
    public Category findById(Integer id) {
        return categoryMapper.findById(id);
    }

    /**
     * 更新分类
     * @param category 分类信息
     */
    @Override
    public void update(Category category) {
        category.setUpdateTime(LocalDateTime.now());
        categoryMapper.update(category);
    }

    /**
     * 删除分类
     * @param id 分类id
     */
    @Override
    public void deleteById(Integer id) {
        categoryMapper.deleteById(id);
    }
}
