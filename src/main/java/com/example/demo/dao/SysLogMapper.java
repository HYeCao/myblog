package com.example.demo.dao;

import com.example.demo.dto.SysLog;
import com.example.demo.dto.SysView;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SysLogMapper {
    public int deleteByPrimaryKey(Long id);

    public int insert(SysLog record);

    public int insertSelective(SysLog record);

    public SysLog selectByPrimaryKey(Long id);

    public int updateByPrimaryKeySelective(SysLog record);

    public int updateByPrimaryKey(SysLog record);

    public int count();

    public List<SysLog> selectAll();

    public List<SysView> selectAllView();
}