package com.example.springdemo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.springdemo.test.domain.BbsRequestDTO;
import com.example.springdemo.test.domain.BbsResponseDTO;
import com.example.springdemo.test.mapper.BbsMapper;

@SpringBootTest
public class MyBatisApplicationTests {

    @Autowired
    private BbsMapper bbsMapper;

    @Test
    public void saveTest() {
        System.out.println("debug mapper >>> " + bbsMapper);
        BbsRequestDTO request = BbsRequestDTO.builder()
                .title("겁나 어렵다")
                .content("뻥이야 쉬워요")
                .build();

        bbsMapper.saveRow(request);
        System.out.println("debug >>> save success!");
    }

    @Test
    public void selectTest() {
        System.out.println("debug mapper >>> " + bbsMapper);
        List<BbsResponseDTO> list = bbsMapper.selectRow();
        for (BbsResponseDTO dto : list) {
            System.out.println(dto);
        }

    }

    public void selectOne() {
        System.out.println("debug mapper >>> " + bbsMapper);
        Map<String, Integer> map = new HashMap();
        map.put("id", 1);
        BbsResponseDTO response = bbsMapper.getRow(map);
        System.out.println("debug >>> SelectOne " + response);
    }

    @Test
    public void deleteTest() {
        System.out.println("debug mapper >>> " + bbsMapper);
        Map<String, Integer> map = new HashMap();
        map.put("id", 2);
        bbsMapper.deleteRow(map);
        System.out.println("debug >>> delete OK!");
    }

}
