package com.jmu.book.dao;

import com.jmu.book.entity.BookRank;
import com.jmu.book.entity.BookTop;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface BookTopMapper {

    //top榜获取前10的书名
    public List<String> findTopTenBookName();

    //根据书名获取它的的入榜次数
    public String findTopTenCount(String bookName);

    //根据书名获取其入榜的年份和排名
    public List<BookRank> bookAllRank(String bookName);
}