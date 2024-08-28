package com.example.springdemo.test.domain;

import lombok.Setter;
import lombok.Getter;
import lombok.ToString;
import lombok.Builder;

@Setter
@Getter
@ToString
@Builder
public class BbsRequestDTO {
    private String title ;
    private String content ;

}
