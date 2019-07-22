package com.jmu.book.service;


import com.jmu.book.entity.BookPriceShare;

import java.util.List;

public interface BookPriceShareService {

    public List<String> selectAllYear();
    public List<String> selectAllCategoryName();
    BookPriceShare selectBookPriceShareByYearAndCategoryName(String year, String categoryName);
}
