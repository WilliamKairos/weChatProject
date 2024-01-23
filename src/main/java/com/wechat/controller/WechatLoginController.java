package com.wechat.controller;

import com.alibaba.fastjson.JSONObject;
import com.wechat.entity.Registrant;
import com.wechat.service.RegistrantService;
import com.wechat.util.JwtUtils;
import com.wechat.util.Result;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/wechat_login")
public class WechatLoginController {

    @Autowired
    private RegistrantService registrantService;

    String AppId = "wx8078703fc99a8557";  //公众平台自己的appId
    String AppSecret = "f54873d4321214223cf6b8fc61faca99";  //AppSecret
    @GetMapping("/login")
    public Result wxLogin(@RequestParam("code") String code) throws Exception {
        System.out.println("小程序传来的code是：" + code);
        String url = "https://api.weixin.qq.com/sns/jscode2session?" +
                "appid=" + AppId +
                "&secret=" + AppSecret +
                "&js_code=" + code +
                "&grant_type=authorization_code";

        CloseableHttpClient client = null;
        CloseableHttpResponse response = null;
        HttpEntity entity = null;

        try {
            // 创建httpGet请求
            HttpGet httpGet = new HttpGet(url);
            // 发送请求
            client = HttpClients.createDefault();
            // 执行请求
            response = client.execute(httpGet);
            // 得到返回数据
            entity = response.getEntity();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String urlResult = EntityUtils.toString(entity);
        System.out.println("微信返回的结果" + urlResult);

        JSONObject json_test = JSONObject.parseObject(urlResult);
        String openid = json_test.getString("openid");
        String sessionKey = json_test.getString("session_key");
        System.err.println("openid值： " + openid);
        System.err.println("sessionKey值：" + sessionKey);


        if (openid == null){
            return Result.error("未获取到openid");
        }else {


            if (registrantService.getById(openid) == null) {
                Registrant registrantAdd = new Registrant(openid);
                registrantService.addRegistrant(registrantAdd);
            }

            Map<String, Object> claims = new HashMap<>();
            claims.put("openid", openid);
            claims.put("sessionKey", sessionKey);
            return Result.success(JwtUtils.generateJwt(claims));
        }
    }
}


