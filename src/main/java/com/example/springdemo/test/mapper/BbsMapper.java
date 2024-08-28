package com.example.springdemo.test.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.example.springdemo.test.domain.BbsRequestDTO;
import com.example.springdemo.test.domain.BbsResponseDTO;

@Mapper
public interface BbsMapper {

    public void saveRow(BbsRequestDTO params);

    public List<BbsResponseDTO> selectRow();

    public BbsResponseDTO getRow(Map<String, Integer> map);

    public void deleteRow(Map<String, Integer> map);

}
