package com.test.system.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.system.entity.Msg;

@RestController
public class HomeController {
	
	@RequestMapping("/admin/index")
	@ResponseBody
    public Msg index() {
        Msg msg = new Msg("测试标题", "测试内容", "额外信息，只对管理员显示");
        return msg;
    }
    
    @PreAuthorize("hasAuthority('ROLE_USER')")
    @RequestMapping(value="/admin/test1")
    @ResponseBody
    public String adminTest1() {
        return "ROLE_USER";
    }
    
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @RequestMapping("/admin/test2")
    @ResponseBody
    public String adminTest2() {
        return "ROLE_ADMIN";
    }

}
