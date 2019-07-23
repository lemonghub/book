package com.jmu.book.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jmu.book.entity.BookBig;
import com.jmu.book.service.BookBigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BookBigController {

    @Autowired
    private BookBigService bookBigService;

    //获取所有的图书类别
    @RequestMapping("findAllCategory")
    @ResponseBody
    public String findAllCategory(){
        List<String> list = bookBigService.findAllCategory();
        String json = ListToJson(list);
        return json;
    }

    //按照年份获取当年所有的图书类别
    @RequestMapping("/findCategoryByYear")
    @ResponseBody
    public String findCategoryByYear(Model model,Integer year){
        List<String> list = bookBigService.findCategoryByYear(year);
        String json = ListToJson(list);
        return json;
    }

    //获取所有年份
    @RequestMapping("/findAllYear")
    @ResponseBody
    public String findAllYear(){
        List<String> list = bookBigService.findAllYear();
        String json = ListToJson(list);
        return json;
    }

    //根据图书类别和年份查找前三的图书
    @RequestMapping("/selectTopThreeBookByYear")
    @ResponseBody
    public String selectTopThreeBookByYear(Model model, String year,String category){
        List<BookBig> list = bookBigService.selectTopThreeBookByYear(year,category);
        String json= ListToJson(list);
        return json;
    }

    //List转json字符串的方法
    public String ListToJson(List<?> list){
        ObjectMapper obj = new ObjectMapper();
        String json = null;
        try {
            json = obj.writeValueAsString(list);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return json;
    }

    //所有年份和图书类别
    @RequestMapping("/findAllYearAndCategory")
    public String findAllYearAndCategory(Model model){
        List<String> list1 = bookBigService.findAllYear();
        List<String> list2 = bookBigService.findAllCategory();
        List<List<String>> list = new ArrayList<>();
        list.add(list1);
        list.add(list2);
        model.addAttribute("list",list);
        return "selectTopThreeBookYear";
    }

}
