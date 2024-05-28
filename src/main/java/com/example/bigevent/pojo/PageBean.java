package com.example.bigevent.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 分页返回结果对象
 * @param <T>
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageBean<T> {
    /**
     * 总条数
     */
    private Long total;
    /**
     * 当前页数据集合
     */
    private List<T> items;
}
