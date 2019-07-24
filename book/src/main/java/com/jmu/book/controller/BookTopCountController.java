package com.jmu.book.controller;

import com.jmu.book.entity.BookTopCount;
import com.jmu.book.service.BookTopCountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BookTopCountController {
    @Autowired
    private BookTopCountService bookTopCountService;

    //根据年份获取当年所有的图书类别
    @RequestMapping("/findBookCategorybyYear")
    @ResponseBody
    public String findBookCategorybyYear(Model model, String year){
        List<String> list= bookTopCountService.findRankCateGoryByYear(year);
        return BookBigController.ListToJson(list);
    }

    //根据年份查当年各类图书top榜占比
    @RequestMapping("/findRatioByYearAndCategory")
    @ResponseBody
    public String findRatioByYearAndCategory(Model model,String year){
        List<String> list1= bookTopCountService.findRankCateGoryByYear(year);
        List<String> list2 = new ArrayList<>();
        for (String s : list1) {
            Double ratio = bookTopCountService.findRatioByYearAndCategory(year,s);
            list2.add(ratio.toString());
        }
        List<List<String>> list = new ArrayList<>();
        list.add(list1);
        list.add(list2);
        return BookBigController.ListToJson(list);
    }
}
