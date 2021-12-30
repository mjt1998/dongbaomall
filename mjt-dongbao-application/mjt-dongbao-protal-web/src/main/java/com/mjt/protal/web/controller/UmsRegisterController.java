package com.mjt.protal.web.controller;

import com.mjt.dongbao.ums.entity.UmsMember;
import com.mjt.dongbao.ums.entity.dto.UmsMemberLoginParamDto;
import com.mjt.dongbao.ums.entity.dto.UmsMemberRegisterParamDTO;
import com.mjt.dongbao.ums.service.UmsMemberService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

/**
 * @Description
 * @Author mjt
 * @Time 2021/12/29
 */
@RestController
@RequestMapping("/userRegister")
public class UmsRegisterController {

    @Autowired
    UmsMemberService umsMemberService;


    @PostMapping("/register")
    public String register(@RequestBody UmsMemberRegisterParamDTO umsMemberRegisterParamDTO){
        String registerResult = umsMemberService.register(umsMemberRegisterParamDTO);
        return registerResult;
    }

}
