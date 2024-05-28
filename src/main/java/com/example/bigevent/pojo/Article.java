package com.example.bigevent.pojo;

import com.example.bigevent.anno.State;
import lombok.Data;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDateTime;
@Data
public class Article {
    /**
     * 主键ID
     */
    private Integer id;
    /**
     * 文章标题
     */
    @NotEmpty
    @Pattern(regexp = "^\\S{1,10}$")
    private String title;
    /**
     * 文章内容
     */
    @NotEmpty
    private String content;
    /**
     * 封面图像
     */
    @NotEmpty
    @URL
    private String coverImg;
    /**
     * 发布状态 已发布|草稿
     */
    @State
    private String state;
    /**
     * 文章分类id
     */
    @NotNull
    private Integer categoryId;
    /**
     * 创建人ID
     */
    private Integer createUser;
    /**
     * 创建时间
     */
    private LocalDateTime createTime;
    /**
     * 更新时间
     */
    private LocalDateTime updateTime;
}
