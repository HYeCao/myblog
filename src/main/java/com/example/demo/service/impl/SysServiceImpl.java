package com.example.demo.service.impl;

import com.example.demo.dao.SysLogMapper;
import com.example.demo.dao.SysViewMapper;
import com.example.demo.dao.UserMapper;
import com.example.demo.dto.SysLog;
import com.example.demo.dto.SysView;
import com.example.demo.dto.User;
import com.example.demo.service.SysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysServiceImpl implements SysService {
    @Autowired(required = false)
    private UserMapper userMapper;

    @Autowired(required = false)
    private SysLogMapper sysLogMapper;

    @Autowired(required = false)
    private SysViewMapper sysViewMapper;

    @Override
    public User GetUser(String ID){
        return userMapper.GetUser(ID);
    }

    @Override
    public boolean UpDateUser(User user) {
        return userMapper.UpDateUser(user);
    }

    @Override
    public boolean DeleteUser(String ID) {
        return userMapper.DeleteUser(ID);
    }

    @Override
    public boolean AddUser(User user) {
        return userMapper.AddUser(user);
    }

    @Override
    public User getUserByNamePassword(String username, String password) {
        return userMapper.LoginUser(username, password);
    }

    @Override
    public void addLog(SysLog sysLog) {
        sysLogMapper.insert(sysLog);
    }

    @Override
    public void addView(SysView sysView) {
        sysViewMapper.insert(sysView);
    }

    @Override
    public int getLogCount() {
        return sysLogMapper.count();
    }

    @Override
    public int getViewCount() {
        return sysViewMapper.count();
    }

    @Override
    public List<SysLog> getAllLog() {
        System.out.println("得到所有日志");
        return sysLogMapper.selectAll();
    }

    @Override
    public List<SysView> getAllView() {
        return sysViewMapper.selectAll();
    }
}
