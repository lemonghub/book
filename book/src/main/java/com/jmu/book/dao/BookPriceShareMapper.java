package com.jmu.book.dao;

import com.jmu.book.entity.BookPriceShare;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface BookPriceShareMapper {
    int insert(BookPriceShare record);
    int insertSelective(BookPriceShare record);
    List<String> selectAllYear();
    List<String> selectAllCategoryName();
    BookPriceShare selectBookPriceShareByYearAndCategoryName(@Param("year") String year, @Param("categoryName") String categoryName);

}