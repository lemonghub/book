package com.jmu.book.service.impl;

import com.jmu.book.dao.BookCommentCountMapper;
import com.jmu.book.entity.BookCommentCount;
import com.jmu.book.service.BookCommentCountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookCommentCountServiceImpl implements BookCommentCountService {

    @Autowired
    private BookCommentCountMapper bookCommentCountMapper;

    @Override
    public List<BookCommentCount> findByYearOrCategory(String year, String category) {
        return bookCommentCountMapper.findByYearOrCategory(year, category);
    }

    @Override
    public List<BookCommentCount> findTopThreeRecommend() {
        return bookCommentCountMapper.findTopThreeRecommend();
    }
}
