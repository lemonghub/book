package com.jmu.book.ServiceTest;

import com.jmu.book.entity.BookBig;
import com.jmu.book.entity.BookRank;
import com.jmu.book.service.BookBigService;
import com.jmu.book.service.BookTopService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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

    @Autowired
    private BookTopService bookTopService;

    @Test
    public void test5(){
        List<String> list = bookTopService.findTopTenBookName();
        for (int i = 0; i < list.size(); i++) {
            List<BookRank> list1 = bookTopService.bookAllRank(list.get(i));
            List<BookRank> list2 = new ArrayList<>();
//            System.out.println(list1);
            Integer year = 2008;
            for (int j = 0; j < list1.size(); j++) {
                if(!year.toString().equals(list1.get(j).getYear())){
                    BookRank bookRank = new BookRank();
                    bookRank.setBookName(list1.get(j).getBookName());
                    bookRank.setRanking("0");
                    bookRank.setYear(year.toString());
                    list2.add(bookRank);
                }else{
                    list2.add(list1.get(j));
                }
            }
            System.out.println(list2.toString());
        }
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
