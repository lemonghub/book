package com.jmu.book.dao;

import com.jmu.book.entity.BookCommentCount;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface BookCommentCountMapper {

    public List<BookCommentCount> findByYearOrCategory(String year, String category);
}