package com.example.demo;

import com.example.demo.dao.SysLogMapper;
import com.example.demo.dao.UserMapper;
import com.example.demo.dto.SysLog;
import com.example.demo.dto.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class DemoApplicationTests {
	@Autowired(required = false)
	SysLogMapper sysLogMapper;

	@Autowired(required = false)
	UserMapper userMapper;

	@Test
	void contextLoads() {
	}
//
//	@Test
//	void sqlTest() {
//		List<SysLog> sysLogs = sysLogMapper.selectAll();
//		for(SysLog sysLog : sysLogs) {
//			System.out.println(sysLog.getCreateBy());
//		}
//		System.out.println(sysLogs.size());
//	}

	@Test
	void loginUserTest() {
		String username = "admin";
		String password = "123";

		User user = userMapper.LoginUser(username, password);
		System.out.println(user.getEmail());
	}

}
