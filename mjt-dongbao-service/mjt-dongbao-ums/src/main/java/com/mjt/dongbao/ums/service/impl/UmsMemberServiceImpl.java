package com.mjt.dongbao.ums.service.impl;

import com.mjt.dongbao.ums.entity.UmsMember;
import com.mjt.dongbao.ums.entity.dto.UmsMemberLoginParamDto;
import com.mjt.dongbao.ums.entity.dto.UmsMemberRegisterParamDTO;
import com.mjt.dongbao.ums.mapper.UmsMemberMapper;
import com.mjt.dongbao.ums.service.UmsMemberService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 后台用户表 服务实现类
 * </p>
 *
 * @author 马俊涛
 * @since 2021-12-27
 */
@Service
public class UmsMemberServiceImpl implements UmsMemberService {

    @Autowired
    UmsMemberMapper umsMemberMapper;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public String register(UmsMemberRegisterParamDTO umsMemberRegisterParamDTO) {
        // 将 DTO 转换成 实体对象
        UmsMember umsMember = new UmsMember();
        BeanUtils.copyProperties(umsMemberRegisterParamDTO, umsMember);

        // 将密码加密，不能明文存放在数据库
        String encode = passwordEncoder.encode(umsMemberRegisterParamDTO.getPassword());
        umsMember.setPassword(encode);
        int insert = umsMemberMapper.insert(umsMember);
        if (insert == 1){
            return "注册成功";
        }else {
            return "注册失败";
        }
    }

    @Override
    public String login(UmsMemberLoginParamDto umsMemberLoginParamDto) {

        UmsMember umsMember = umsMemberMapper.selectByName(umsMemberLoginParamDto.getUsername());
        if (null != umsMember){
            String passwordDb = umsMember.getPassword();

            if (!passwordEncoder.matches(umsMemberLoginParamDto.getPassword(), passwordDb)) {
                return "密码错误...";
            }
        }else {
            return "用户名不存在";
        }

        return "此时登录成功，应返回 Token！";
    }
}
