package com.jmu.book.dao;

import com.jmu.book.entity.BookPriceShare;

public interface BookPriceShareMapper {
    int insert(BookPriceShare record);

    int insertSelective(BookPriceShare record);
}