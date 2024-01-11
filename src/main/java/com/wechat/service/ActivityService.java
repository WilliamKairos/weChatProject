package com.wechat.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wechat.entity.Activity;

import java.util.List;

public interface ActivityService extends IService<Activity> {
    public List<Activity> findActivityByTitle(String title);
    public List<Activity> findAllActivity();
    public void addActivity(Activity activity);
    public void deleteActivity(String id);
    public void modifyActivity(Activity activity);
}
