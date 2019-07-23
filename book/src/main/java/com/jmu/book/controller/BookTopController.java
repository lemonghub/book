package com.jmu.book.controller;

import com.jmu.book.entity.BookRank;
import com.jmu.book.service.BookTopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BookTopController {
    @Autowired
    private BookTopService bookTopService;

    //top前10和每年出现的排名
    @RequestMapping("/findTopTen")
    @ResponseBody
    public String findTopTen(){
        List<List<String>> list = findBookNameAndCount();
        List<List<BookRank>> list1 = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list1.add(bookTopService.bookAllRank(list.get(0).get(i)));
        }
        return BookBigController.ListToJson(list1);
    }

    //返回入榜前10的书名和入榜次数
    @RequestMapping("findTopTenNameAndCount")
    @ResponseBody
    public String findTopTenNameAndCount(){
        List<List<String>> list = findBookNameAndCount();
        return BookBigController.ListToJson(list);
    }

    /*
    * 查找前入围次数最多的前十本书的书名和入围次数
    * 返回二维数组，二维数组中第一个数组是书名，第二个数组是对应的入榜次数
    * */
    public List<List<String>> findBookNameAndCount(){
        List<String> list1 = bookTopService.findTopTenBookName();
        List<String> list2 = new ArrayList<>();
        for (String s : list1) {
            String rank = bookTopService.findTopTenCount(s);
            list2.add(rank);
        }
        List<List<String>> list = new ArrayList<>();
        list.add(list1);    //书名
        list.add(list2);    //入榜次数
        return list;
    }
}
