package com.jmu.book.ServiceTest;

import com.jmu.book.entity.BookBig;
import com.jmu.book.service.BookBigService;
import com.jmu.book.service.impl.BookBigServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 郭秦平
 * @data: 2019/07/21
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class BookBigServiceTest {

    @Autowired
    private BookBigService bookBigService;
    @Test
    public void Test(){

        bookBigService.selectEveryTopTenBook(5);
    }

    //按照年份和类别查询每年欢迎度前三的图书测试
    @Test
    public void Test1(){
        List<BookBig> list = bookBigService.selectTopThreeBookByYear("2018","英文原版书");
        for (BookBig bookBig : list) {
            System.out.println(bookBig);
        }
    }

    //查询图书的所有类别
    @Test
    public void Test2(){
        List<String> list = bookBigService.findAllCategory();
        for (String s : list) {
            System.out.println(s);
        }
    }

    //按照年费查询当年的图书的类别
    @Test
    public void Test3(){
        List<String> list = bookBigService.findCategoryByYear(2018);
//        System.out.println(list.size());
        for (String s : list) {
            System.out.println(s);
        }
    }


    //查询所有年份
    @Test
    public void Test4(){
        List<String> list = bookBigService.findAllYear();
//        System.out.println(list.size());
        for (String s : list) {
            System.out.println(s);
        }
    }
}
