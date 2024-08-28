package com.example.springdemo;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.junit.jupiter.api.Test;

// Junit 을 이용한 test case 작성 
@SpringBootTest
public class DatabaseApplicationTests {

    @Autowired
    private SqlSessionFactory factory ; 
    
    @Autowired
    private ApplicationContext context ; 


    @Test
    public void testByFactory() {
        try{
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> factory");
            System.out.println( factory.toString() ) ; 
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        }catch(Exception e) {
            e.printStackTrace();
        }

    }
}