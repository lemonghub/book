package com.jmu.book.service.impl;

import com.jmu.book.dao.BookPriceShareMapper;
import com.jmu.book.entity.BookPriceShare;
import com.jmu.book.service.BookPriceShareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookPriceShareServiceImpl implements BookPriceShareService {
    @Autowired
    private BookPriceShareMapper bookPriceShareMapper;

    @Override
    public List<String> selectAllYear() {
        return bookPriceShareMapper.selectAllYear();
    }

    @Override
    public List<String> selectAllCategoryName() {

        return bookPriceShareMapper.selectAllCategoryName();
    }

    @Override
    public BookPriceShare selectBookPriceShareByYearAndCategoryName(String year, String categoryName) {

        return bookPriceShareMapper.selectBookPriceShareByYearAndCategoryName(year,categoryName);
    }
}
