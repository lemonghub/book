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

    @Test
    public void Test1(){
        List<BookBig> list = bookBigService.selectTopThreeBookByYear(2017);
        for (BookBig bookBig : list) {
            System.out.println(bookBig);
        }
    }
}
