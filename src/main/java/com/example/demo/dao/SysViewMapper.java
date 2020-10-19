package com.example.demo.dao;

import com.example.demo.dto.SysView;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SysViewMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysView record);

    int insertSelective(SysView record);

    SysView selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysView record);

    int updateByPrimaryKey(SysView record);

    int count();

    List<SysView> selectAll();
}