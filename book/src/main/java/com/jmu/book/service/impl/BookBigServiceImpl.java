package com.jmu.book.service.impl;

import com.jmu.book.dao.BookBigMapper;
import com.jmu.book.entity.BookBig;
import com.jmu.book.service.BookBigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 郭秦平
 * @data: 2019/07/21
 **/
@Service
public class BookBigServiceImpl implements BookBigService {
    @Autowired
    private BookBigMapper bookBigMapper;

    @Override
    public List<String> findAllCategory() {
        return bookBigMapper.findAllCategory();
    }

    @Override
    public List<String> findCategoryByYear(Integer year) {
        return bookBigMapper.findCategoryByYear(year);
    }

    @Override
    public List<String> findAllYear() {
        return bookBigMapper.findAllYear();
    }

    @Override
    public List<BookBig> selectTopThreeBookByYear(String year,String category) {
        List<BookBig> list = bookBigMapper.selectTopThreeBookByYear(year,category);
        return list;
    }


}
