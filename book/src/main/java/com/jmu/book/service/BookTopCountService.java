package com.jmu.book.service;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface BookTopCountService {

    //根据年份查询当年的图书类别
    public List<String> findRankCateGoryByYear(String year);

    //根据类别和年份查占比
    public Double findRatioByYearAndCategory(String year,String category);
}
