package com.example.springdemo.test.domain.comment;

import lombok.Setter;
import lombok.Getter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class CommentResponseDTO {

    private Integer id;
    private String content;
    private Integer bbsId;
}
