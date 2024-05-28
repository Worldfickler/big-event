package com.example.bigevent.mapper;

import com.example.bigevent.pojo.Category;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CategoryMapper {
    /**
     * 新增类别
     */
    @Insert("insert into category(category_name,category_alias,create_user,create_time,update_time) values(#{categoryName},#{categoryAlias},#{createUser},#{createTime},#{updateTime})")
    void add(Category category);

    /**
     * 查询所有
     *
     * @param userId 用户id
     * @return List<Category>
     */
    @Select("select * from category where create_user = #{userId}")
    List<Category> list(Integer userId);

    /**
     * 根据id查询分类详情
     *
     * @param id 分类id
     * @return Category
     */
    @Select("select * from category where id = #{id}")
    Category findById(Integer id);

    /**
     * 更新分类
     *
     * @param category 分类信息
     */
    @Update("update category set category_name=#{categoryName},category_alias=#{categoryAlias},update_time=#{updateTime} where id=#{id}")
    void update(Category category);

    //根据id删除
    @Delete("delete from category where id=#{id}")
    void deleteById(Integer id);
}
