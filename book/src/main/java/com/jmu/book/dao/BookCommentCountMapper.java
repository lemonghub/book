package com.jmu.book.dao;

import com.jmu.book.entity.BookCommentCount;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface BookCommentCountMapper {

    public List<BookCommentCount> findByYearOrCategory(@Param("year")String year, @Param("category")String category);

    public List<BookCommentCount> findTopThreeRecommend();
}