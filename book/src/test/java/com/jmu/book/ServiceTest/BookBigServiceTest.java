package com.jmu.book.ServiceTest;

import com.jmu.book.entity.BookBig;
import com.jmu.book.entity.BookRank;
import com.jmu.book.service.BookBigService;
import com.jmu.book.service.BookTopCountService;
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

    @Autowired
    private BookTopCountService bookTopCountService;

    @Test
    public void test6(){
        List<String> list1= bookTopCountService.findRankCateGoryByYear("2014");
        List<String> list2 = new ArrayList<>();
        for (String s : list1) {
            Double ratio = bookTopCountService.findRatioByYearAndCategory("2014",s);
            list2.add(ratio.toString());
        }
        System.out.println(list1);
        System.out.println(list2);
        for (int i = 0; i < list2.size() - 1; i++) {
            int k = i;
            for (int j = i + 1; j < list2.size(); j++) {
                double listj = Double.parseDouble(list2.get(j));
                double listk = Double.parseDouble(list2.get(k));
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
        System.out.println(list1);
        System.out.println(list2);
    }

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
