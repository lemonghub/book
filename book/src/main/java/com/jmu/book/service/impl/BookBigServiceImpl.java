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
    public void selectEveryTopTenBook(int topNum) {
        List<BookBig> list = bookBigMapper.selectTopTenEveryYearCategory(topNum);
        for (BookBig bookBig:list){
            System.out.println(list);
        }
    }

    @Override
    public List<BookBig> selectTopThreeBookByYear(Integer year) {
        List<BookBig> list = bookBigMapper.selectTopThreeBookByYear(year);

        return list;
    }


}
