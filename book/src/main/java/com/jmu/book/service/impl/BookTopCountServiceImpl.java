package com.jmu.book.service.impl;

import com.jmu.book.dao.BookTopCountMapper;
import com.jmu.book.service.BookTopCountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookTopCountServiceImpl implements BookTopCountService {

    @Autowired
    private BookTopCountMapper bookTopCountMapper;

    @Override
    public List<String> findRankCateGoryByYear(String year) {
        return bookTopCountMapper.findRankCateGoryByYear(year);
    }

    @Override
    public Double findRatioByYearAndCategory(String year, String category) {
        return bookTopCountMapper.findRatioByYearAndCategory(year, category);
    }
}
