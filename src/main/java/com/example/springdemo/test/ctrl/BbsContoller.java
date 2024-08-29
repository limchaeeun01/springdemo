package com.example.springdemo.test.ctrl;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.springdemo.test.service.BbsService;
import com.example.springdemo.test.domain.BbsResponseDTO;
import com.example.springdemo.test.domain.BbsRequestDTO;

import java.util.Map;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("api/bbs")
public class BbsContoller {

    @Autowired
    private BbsService bbsService;

    @PostMapping("/test")
    public ResponseEntity<BbsResponseDTO> test() {
        BbsResponseDTO response = BbsResponseDTO.builder()
                .id(1)
                .title("test")
                .content("test")
                .build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Integer id) {
        System.out.println("debug >>> bbs controller client path / delete");
        System.out.println("debug >>> id param value " + id);
        Map<String, Integer> map = new HashMap<>();
        map.put("id", id);

        bbsService.delete(map);

        return new ResponseEntity<String>(id + "번째 데이터 삭제 ", HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<List<BbsResponseDTO>> getList() {
        System.out.println("debug >>> bbs controller client path / list");
        List<BbsResponseDTO> list = bbsService.list();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/view/{id}")
    public ResponseEntity<BbsResponseDTO> view(@PathVariable("id") Integer id) {
        System.out.println("debug >>> bbs controller client path / delete");
        System.out.println("debug >>> id param value " + id);
        Map<String, Integer> map = new HashMap<>();
        map.put("id", id);

        BbsResponseDTO response = bbsService.select(map);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/post")
    public ResponseEntity<String> save(@RequestParam("title") String title,
            @RequestParam("content") String content) {

        BbsRequestDTO params = BbsRequestDTO.builder()
                .title(title)
                .content(content)
                .build();

        System.out.println(">>>>>>>>>>>>> request dto, " + params);
        return ResponseEntity.ok("게시물이 성공적으로 저장되었습니다. >>> title : " + title + " content : " + content);
    }

}
