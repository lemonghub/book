package com.jmu.book.service;

import com.jmu.book.entity.BookBig;

import java.util.List;

/**
 * @author 郭秦平
 * @data: 2019/07/21
 **/
public interface BookBigService {

    //获取所有类别
    List<String> findAllCategory();

    //按年份获取图书列别
    List<String> findCategoryByYear(Integer year);

    //获取所有年份
    List<String> findAllYear();

    //按照年份和类别查询最受欢迎的前三本书
    List<BookBig> selectTopThreeBookByYear(String year,String category);
}
