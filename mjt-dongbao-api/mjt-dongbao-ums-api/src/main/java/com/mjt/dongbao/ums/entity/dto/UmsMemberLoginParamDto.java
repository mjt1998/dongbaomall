package com.mjt.dongbao.ums.entity.dto;

import lombok.Data;
import lombok.ToString;

/**
 * @Description
 * @Author mjt
 * @Time 2021/12/29
 */

@Data
@ToString
public class UmsMemberLoginParamDto {

    private String username;
    private String password;
}
