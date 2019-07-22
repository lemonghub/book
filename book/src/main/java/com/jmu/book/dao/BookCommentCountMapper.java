package com.jmu.book.dao;

import com.jmu.book.entity.BookCommentCount;

public interface BookCommentCountMapper {
    int insert(BookCommentCount record);

    int insertSelective(BookCommentCount record);
}