package com.example.springdemo.test.ctrl;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.springdemo.test.domain.BbsResponseDTO;
import com.example.springdemo.test.domain.comment.CommentRequestDTO;
import com.example.springdemo.test.service.BbsService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import com.example.springdemo.test.domain.BbsRequestDTO;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/bbs")
@Tag(name = "BBS API", description = "게시글 관련 API 목록")
public class BbsContoller {

    @Autowired
    private BbsService bbsService;

    @DeleteMapping("delete/{id}")
    @Operation(summary = "게시글 삭제", description = "게시글 키값을 가지고 삭제")
    public ResponseEntity<String> delete(@PathVariable("id") Integer id) {
        System.out.println("debug >>> bbs controller client path / delete");
        System.out.println("debug >>> id param value " + id);

        Map<String, Integer> map = new HashMap();
        map.put("id", id);

        bbsService.delete(map);

        return new ResponseEntity<String>(id + "번째 데이터 삭제", HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<List<BbsResponseDTO>> getList() {
        System.out.println("debug >>> bbs controller client path / list");

        List<BbsResponseDTO> list = bbsService.list();

        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/view/{id}")
    public ResponseEntity<Object> view(@PathVariable("id") Integer id) {
        System.out.println("debug >>> bbs controller client path / delete");
        System.out.println("debug >>> id param value " + id);
        Map<String, Integer> map = new HashMap();
        map.put("id", id);

        Optional<BbsResponseDTO> response = bbsService.select(map);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // @PostMapping("/post")
    // public ResponseEntity<String> save( @RequestParam("title") String title,
    //                                     @RequestParam("content") String content) {
    //     BbsRequestDTO params = BbsRequestDTO.builder()
    //             .title(title)
    //             .content(content)
    //             .build();
    //     System.out.println(">>>>>>>>>>>>> request dto, " + params);
    //     return ResponseEntity.ok("게시물이 성공적으로 저장되었습니다. >>> title : " + title + " content : " + content);
    // }
    @PostMapping("/post")
    public ResponseEntity<BbsRequestDTO> save(@RequestBody BbsRequestDTO params) {

        System.out.println("debug >>> bbs controller client path / post");
        System.out.println(">>>>>>>>>>>>> request dto, " + params);

        return null;
    }

    @PutMapping("/update")
    public ResponseEntity<Void> update(BbsRequestDTO params) {
        System.out.println("debug >>> bbs controller client path / update");
        System.out.println(">>>>>>>>>>>>> request dto, " + params);
        bbsService.update(params);

        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    //////////////comment

    @PostMapping("/comment/post")
    public ResponseEntity<String> postMethodName(@RequestBody CommentRequestDTO params) {
        System.out.println("debug >>> bbs controller client path / post");
        System.out.println(">>>>>>>>>>>>> request dto, " + params);

        return null;
    }

}
