package com.example.bigevent.mapper;

import com.example.bigevent.pojo.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {
    /**
     * 根据用户名查询用户
     * @param username 用户账号
     * @return 用户信息
     */
    @Select("select * from user where username=#{username}")
    User findByUserName(String username);

    /**
     * 添加用户
     * @param username 用户账号
     * @param password 用户密码
     */
    @Insert("insert into user(username,password,create_time,update_time) values(#{username},#{password},now(),now())")
    void add(@Param("username") String username, @Param("password") String password);

    @Update("update user set nickname=#{nickname},email=#{email},update_time=#{updateTime} where id=#{id}")
    void update(User user);

    @Update("update user set user_pic=#{avatarUrl},update_time=now() where id=#{id}")
    void updateAvatar(String avatarUrl,Integer id);

    @Update("update user set password=#{md5String},update_time=now() where id=#{id}")
    void updatePwd(@Param("md5String") String md5String, @Param("id") Integer id);
}
