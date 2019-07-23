package com.jmu.book.controller;

import com.jmu.book.entity.BookTopCount;
import com.jmu.book.service.BookTopCountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BookTopCountController {
    @Autowired
    private BookTopCountService bookTopCountService;

    @RequestMapping("/findRatioByYearAndCategory")
    @ResponseBody
    public String findRatioByYearAndCategory(String year){
        List<String> list1= bookTopCountService.findRankCateGoryByYear("2018");
        List<String> list2 = new ArrayList<>();
        for (String s : list1) {
            Double ratio = bookTopCountService.findRatioByYearAndCategory("2018",s);
            list2.add(ratio.toString());
        }
        List<List<String>> list = new ArrayList<>();
        list.add(list1);
        list.add(list2);
        return BookBigController.ListToJson(list);
    }
}
