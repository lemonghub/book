package com.jmu.book.service;

import com.jmu.book.entity.BookBig;

import java.util.List;

/**
 * @author 郭秦平
 * @data: 2019/07/21
 **/
public interface BookBigService {

    public void selectEveryTopTenBook(int topNum);

    List<BookBig> selectTopThreeBookByYear(Integer year);
}
