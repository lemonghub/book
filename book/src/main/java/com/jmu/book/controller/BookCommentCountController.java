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

    //查所有年份和图书类别
    @RequestMapping("/findYearAndCategory1")
    public String findYearAndCategory1(Model model,String flag){
        List<String> list1 = bookBigService.findAllYear();
        List<String> list2 = bookBigService.findAllCategory();
        List<List<String>> list = new ArrayList<>();
        list.add(list1);
        list.add(list2);
        model.addAttribute("list",list);
        if("1".equals(flag))
            return "BookCommentCountForYear";
        else
            return "BookCommentCountForCategory";
    }

    //按照年份或者图书类别查图书评论数
    @RequestMapping("/findByYearOrCategory")
    @ResponseBody
    public String findByYearOrCategory(Model model, String year, String category){
        List<BookCommentCount> list = bookCommentCountService.findByYearOrCategory(year, category);
        return BookBigController.ListToJson(list);
    }

    //所有的图书评论数
    @RequestMapping("/findAllCommentCount")
    @ResponseBody
    public String findAllCommentCount(){
        List<String> list1 = bookBigService.findAllCategory();
        List<List<BookCommentCount>> list = new ArrayList<>();
        for (String s : list1) {
            List<BookCommentCount> list2 = bookCommentCountService.findByYearOrCategory(null,s);
            list.add(list2);
        }
        return BookBigController.ListToJson(list);
    }

    //预测分析2019推荐前三
    @RequestMapping("/findTopThreeRecommend")
    @ResponseBody
    public String findTopThreeRecommend(){
        List<BookCommentCount> list = bookCommentCountService.findTopThreeRecommend();
        return BookBigController.ListToJson(list);
    }

    @RequestMapping("/findTopThreeRecommend_")
    public String returnFindTop(){

        return "findTopThreeRecommend";
    }
}
