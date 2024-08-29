package com.example.springdemo;

import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.springdemo.test.domain.BbsRequestDTO;
import com.example.springdemo.test.service.BbsService;

@SpringBootTest
public class ServiceApplicationTests {

    @Autowired
    private BbsService bbsService;

    @Test
    public void saveService() {
        System.out.println("Debug >>> junit service save");
    }

    @Test
    public void saveTest() {
        System.out.println("debug mapper >>> " + bbsService);
        BbsRequestDTO request = BbsRequestDTO.builder()
                .title("겁나 어렵다")
                .content("뻥이야 쉬워요")
                .build();

        bbsService.save(request);
        System.out.println("debug >>> save success!");
    }

    @Test
    public void updateService() {
        System.out.println("debug mapper >>> " + bbsService);
        BbsRequestDTO request = BbsRequestDTO.builder()
                .id(1)
                .title("바꿔보자")
                .content("바꿔보자고")
                .build();

        bbsService.update(request);
        System.out.println("debug >>> update success!");
    }
}
