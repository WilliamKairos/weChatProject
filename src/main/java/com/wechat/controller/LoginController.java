package com.wechat.controller;

import com.wechat.entity.Admin;
import com.wechat.service.AdminServe;
import com.wechat.util.JwtUtils;
import com.wechat.util.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private AdminServe adminServe;

    @PostMapping("")
    public Result login(@RequestBody Admin admin){
        log.info("管理员登录：{}", admin);
        Admin selectAdmin = adminServe.getByUsernameAndPassword(admin);
        if (selectAdmin != null){
            Map<String, Object> claims = new HashMap<>();
            claims.put("id", selectAdmin.getId());
            claims.put("username", selectAdmin.getUsername());
            claims.put("password", selectAdmin.getPassword());
            return Result.success(JwtUtils.generateJwt(claims));
        }else {
            return Result.error("用户名或密码错误！");
        }
    }

}
