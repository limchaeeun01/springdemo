package com.example.springdemo.test.domain;

import java.util.ArrayList;

import com.example.springdemo.test.domain.comment.CommentResponseDTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BbsResponseDTO {

    private Integer id;
    private String title;
    private String content;

    ///////////////
    private ArrayList<CommentResponseDTO> comments;

    public void setComments(ArrayList<CommentResponseDTO> list) {
        this.comments = list;
    }

}
