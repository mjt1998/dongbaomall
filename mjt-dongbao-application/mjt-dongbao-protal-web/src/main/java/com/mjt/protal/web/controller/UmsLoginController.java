package com.mjt.protal.web.controller;

import com.mjt.dongbao.ums.entity.dto.UmsMemberLoginParamDto;
import com.mjt.dongbao.ums.service.UmsMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author mjt
 * @Time 2021/12/30
 */
@RestController
@RequestMapping("/userLogin")
public class UmsLoginController {

    @Autowired
    UmsMemberService umsMemberService;

    @PostMapping("/login")
    public String login(@RequestBody UmsMemberLoginParamDto umsMemberLoginParamDto){
        String login = umsMemberService.login(umsMemberLoginParamDto);
        return login;
    }
}
