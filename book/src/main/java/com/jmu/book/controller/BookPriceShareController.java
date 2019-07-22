package com.jmu.book.controller;

import com.jmu.book.entity.BookPriceShare;
import com.jmu.book.service.BookPriceShareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BookPriceShareController {

    @Autowired
    private BookPriceShareService bookPriceShareService;

    @GetMapping("/bookPriceShare")
    public String bookPriceShare(Model model) {
        List<String> list1 =  bookPriceShareService.selectAllYear();
        List<String> list2 =  bookPriceShareService.selectAllCategoryName();
        List<List<String>> list = new ArrayList<List<String>>();
        list.add(list1);
        list.add(list2);
        model.addAttribute("list",list);
        return "bookPriceShare";
    }

    @ResponseBody
    @PostMapping("/doBookPriceShare")
    public BookPriceShare doBookPriceShare(String year, String categoryName) {

        return bookPriceShareService.selectBookPriceShareByYearAndCategoryName(year,categoryName);
    }


}
