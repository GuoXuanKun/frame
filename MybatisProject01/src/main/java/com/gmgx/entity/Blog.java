package com.gmgx.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Blog implements Serializable {
    private Integer blogId;
    private String blogTitle;
    private String blogContent;
    private Integer userId;

    private User author;

    public Blog(Integer blogId, String blogTitle, String blogContent, Integer userId) {
        this.blogId = blogId;
        this.blogTitle = blogTitle;
        this.blogContent = blogContent;
        this.userId = userId;
    }
}
