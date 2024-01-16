package com.wechat.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wechat.entity.Admin;
import com.wechat.mapper.AdminMapper;
import com.wechat.service.AdminServe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServeImpl extends ServiceImpl<AdminMapper, Admin> implements AdminServe {
    @Autowired
    private AdminMapper adminMapper;

    @Override
    public Admin getByUsernameAndPassword(Admin admin){
        return adminMapper.selectOne(new QueryWrapper<Admin>()
                .eq("password", admin.getPassword())
                .eq("username", admin.getUsername()));
    }


}
