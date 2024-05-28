package com.example.bigevent.mapper;

import com.example.bigevent.pojo.Article;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ArticleMapper {
    /**
     * 新增文章
     *
     * @param article 文章
     */
    @Insert("insert into article(title,content,cover_img,state,category_id,create_user,create_time,update_time) values(#{title},#{content},#{coverImg},#{state},#{categoryId},#{createUser},#{createTime},#{updateTime})")
    void add(Article article);


    /**
     * 获取文章列表
     * @param userId 用户id
     * @param categoryId 分类id
     * @param state 状态
     * @return List<Article>
     */
    List<Article> list(@Param("userId") Integer userId, @Param("categoryId") Integer categoryId, @Param("state") String state);
}
