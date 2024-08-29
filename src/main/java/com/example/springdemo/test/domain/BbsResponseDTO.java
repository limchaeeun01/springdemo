package com.example.springdemo.test.domain;

import lombok.Builder;
import lombok.Setter;
import lombok.Getter;

@Getter
@Setter
@Builder
public class BbsResponseDTO {

    private int id;
    private String title;
    private String content;
}
