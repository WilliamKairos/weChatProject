package com.wechat.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wechat.entity.Admin;

public interface AdminServe extends IService<Admin> {
    public Admin getByUsernameAndPassword(Admin admin);

}
