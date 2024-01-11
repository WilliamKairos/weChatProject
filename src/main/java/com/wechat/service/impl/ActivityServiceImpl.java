package com.wechat.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wechat.entity.Activity;
import com.wechat.mapper.ActivityMapper;
import com.wechat.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityServiceImpl extends ServiceImpl<ActivityMapper, Activity> implements ActivityService {

    @Autowired
    private ActivityMapper activityMapper;
    @Override
    public List<Activity> findActivityByTitle(String title) {
        return activityMapper.selectList(new QueryWrapper<Activity>().eq("title", title));
    }

    @Override
    public List<Activity> findAllActivity() {
        return activityMapper.selectList(null);
    }

    @Override
    public void addActivity(Activity activity) {
        activityMapper.insert(activity);
    }

    @Override
    public void deleteActivity(String id) {
        activityMapper.deleteById(id);
    }

    @Override
    public void modifyActivity(Activity activity) {
        UpdateWrapper<Activity> activityUpdateWrapper = new UpdateWrapper<>();
        activityUpdateWrapper.eq("id", activity.getId())
                .set("title", activity.getTitle())
                .set("photo", activity.getPhoto())
                .set("activity_date", activity.getActivityDate())
                .set("originator", activity.getOriginator())
                .set("init_time", activity.getInitTime());
        update(activity, activityUpdateWrapper);
    }
}
