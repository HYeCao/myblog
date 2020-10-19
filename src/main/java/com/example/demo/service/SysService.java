package com.example.demo.service;
import com.example.demo.dto.SysLog;
import com.example.demo.dto.SysView;
import com.example.demo.dto.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SysService {
    public User GetUser(String ID);

    public boolean UpDateUser(User user);

    public boolean DeleteUser(String ID);

    public boolean AddUser(User user);

    public User getUserByNamePassword(String username, String password);

    public void addLog(SysLog sysLog);

    public void addView(SysView sysView);

    public int getLogCount();

    public int getViewCount();

    public List<SysLog> getAllLog();

    public List<SysView> getAllView();

}