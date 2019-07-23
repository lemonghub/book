package com.jmu.book.service.impl;

import com.jmu.book.dao.BookTopMapper;
import com.jmu.book.entity.BookRank;
import com.jmu.book.service.BookTopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class BookTopServiceImpl implements BookTopService {

    @Autowired
    private BookTopMapper bookTopMapper;


    @Override
    public List<String> findTopTenBookName() {
        return bookTopMapper.findTopTenBookName();
    }

    @Override
    public String findTopTenCount(String bookName) {
        return bookTopMapper.findTopTenCount(bookName);
    }

    @Override
    public List<BookRank> bookAllRank(String bookName) {
        return bookTopMapper.bookAllRank(bookName);
    }
}
