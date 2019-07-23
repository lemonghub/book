package com.jmu.book.controller;

import com.jmu.book.entity.BookCommentCount;
import com.jmu.book.service.BookBigService;
import com.jmu.book.service.BookCommentCountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BookCommentCountController {

    @Autowired
    private BookCommentCountService bookCommentCountService;
    @Autowired
    private BookBigService bookBigService;

    @RequestMapping("/findYearAndCategory1")
    @ResponseBody
    public String findYearAndCategory1(){
        List<String> list1 = bookBigService.findAllYear();
        List<String> list2 = bookBigService.findAllCategory();
        List<List<String>> list = new ArrayList<>();
        list.add(list1);
        list.add(list2);
        return BookBigController.ListToJson(list);
    }

    @RequestMapping("/findByYearOrCategory")
    @ResponseBody
    public String findByYearOrCategory(Model model, String year, String category){
        List<BookCommentCount> list = bookCommentCountService.findByYearOrCategory(year, category);
        return BookBigController.ListToJson(list);
    }
}
