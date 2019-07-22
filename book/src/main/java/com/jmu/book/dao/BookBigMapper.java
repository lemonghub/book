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


    //按照年份查询最受欢迎的前三本书
    List<BookBig> selectTopThreeBookByYear(Integer year);
}