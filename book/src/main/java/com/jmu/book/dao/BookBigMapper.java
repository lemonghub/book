package com.jmu.book.dao;

import com.jmu.book.entity.BookBig;
import org.apache.ibatis.annotations.Mapper;
import org.jboss.logging.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface BookBigMapper {
    int insert(BookBig record);

    int insertSelective(BookBig record);

    /**
     * 查询每年前十的所有分类榜单
     * @return
     */
    List<BookBig> selectTopTenEveryYearCategory(int topNum);

    //获取所有类别
    List<String> findAllCategory();

    //按年份获取图书列别
    List<String> findCategoryByYear(Integer year);

    //获取所有年份
    List<String> findAllYear();

    //按照年份和类别查询最受欢迎的前三本书
    List<BookBig> selectTopThreeBookByYear(String year,String category);
}