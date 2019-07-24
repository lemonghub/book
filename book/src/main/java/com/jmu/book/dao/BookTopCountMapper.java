package com.jmu.book.dao;

import com.jmu.book.entity.BookTopCount;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface BookTopCountMapper {
    //根据年份查询当年的图书类别
    public List<String> findRankCateGoryByYear(@Param("year")String year);

    //根据类别和年份查占比
    public Double findRatioByYearAndCategory(@Param("year")String year, @Param("category")String category);
}