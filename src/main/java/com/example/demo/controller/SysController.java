package com.example.demo.controller;


import com.example.demo.dto.SysLog;
import com.example.demo.dto.SysView;
import com.example.demo.service.SysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class SysController {

    @Autowired
    SysService sysService;


    @GetMapping("/sys/log")
    public List<SysLog> listAllLog() {
        return sysService.getAllLog();
    }

    @GetMapping("/sys/view")
    public List<SysView> listAllView() {
        return  sysService.getAllView();
    }

}
