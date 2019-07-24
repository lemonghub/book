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

        List<List<String>> list = mySort(list1,list2);
        return BookBigController.ListToJson(list);
    }

    public List<List<String>> mySort(List<String> list1, List<String> list2){

        for (int i = 0; i < list2.size() - 1; i++) {
            int k = i;
            for (int j = i + 1; j < list2.size(); j++) {
                Double listj = Double.parseDouble(list2.get(j));
                Double listk = Double.parseDouble(list2.get(k));
                if(listj < listk){
                    k = j;
                }
            }
            if(k != i){
                String temp1 = list2.get(i);
                list2.set(i, list2.get(k));
                list2.set(k, temp1);

                String temp2 = list1.get(i);
                list1.set(i, list1.get(k));
                list1.set(k, temp2);
            }
        }
        List<List<String>> list = new ArrayList<>();
        list.add(list1);
        list.add(list2);
        return list;
    }
}
