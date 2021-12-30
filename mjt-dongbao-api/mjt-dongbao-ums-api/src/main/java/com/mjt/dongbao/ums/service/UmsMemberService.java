package com.mjt.dongbao.ums.service;

import com.mjt.dongbao.ums.entity.dto.UmsMemberLoginParamDto;
import com.mjt.dongbao.ums.entity.dto.UmsMemberRegisterParamDTO;

/**
 * <p>
 * 后台用户表 服务类
 * </p>
 *
 * @author 马俊涛
 * @since 2021-12-27
 */
public interface UmsMemberService {
    public String register(UmsMemberRegisterParamDTO umsMemberRegisterParamDTO);

    String login(UmsMemberLoginParamDto umsMemberLoginParamDto);
}
