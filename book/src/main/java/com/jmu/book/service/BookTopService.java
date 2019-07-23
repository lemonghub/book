package com.jmu.book.service;

import com.jmu.book.entity.BookRank;

import java.util.List;
import java.util.Map;

public interface BookTopService {

    //top榜获取前10的书名
    public List<String> findTopTenBookName();

    //根据书名获取它的的入帮次数
    public String findTopTenCount(String bookName);

    //根据书名获取其入榜的年份和排名
    public List<BookRank> bookAllRank(String bookName);
}
