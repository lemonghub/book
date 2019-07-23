package com.jmu.book.service;

import com.jmu.book.entity.BookCommentCount;

import java.util.List;

public interface BookCommentCountService {

    public List<BookCommentCount> findByYearOrCategory(String year, String category);
}
