package com.mjt.dongbao.ums.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Description：使用 mybatis-plus 统一管理创建时间和修改时间
 * @Author mjt
 * @Time 2021/12/29
 */
@Component
public class MyTimeHandler implements MetaObjectHandler {
    // 自动设置插入时间
    @Override
    public void insertFill(MetaObject metaObject) {
        System.out.println("插入添加时间");
        this.setFieldValByName("gmtCreate", new Date(), metaObject);
        this.setFieldValByName("gmtModified", new Date(), metaObject);
    }

    // 自动设置修改时间
    @Override
    public void updateFill(MetaObject metaObject) {
        System.out.println("修改更新时间");
        this.setFieldValByName("gmtModified", new Date(), metaObject);
    }
}
