package com.wechat.controller;

import com.wechat.entity.Activity;
import com.wechat.service.ActivityService;
import com.wechat.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/activity")
public class ActivityController {

    @Autowired
    private ActivityService activityService;


    //    实现增删改查的功能
    @RequestMapping("/add")
    public Result addActivity(@RequestBody Activity activity){
        try {
            activityService.addActivity(activity);
            return Result.success();
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("添加错误！");
        }
    }

    @DeleteMapping("/delete/{id}")
    public Result deleteActivity(@PathVariable("id") String id)
    {
        try {
            activityService.deleteActivity(id);
            return Result.success("删除成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("删除错误！");
        }
    }

    @GetMapping("/find_by_title/{title}")
    public Result findByTitle(@PathVariable(value = "title") String title){
        try {
//            Registrant result = registrantService.findRegistrantByName(name);
            System.out.println(title);
            List<Activity> activityList = activityService.findActivityByTitle(title);
            System.out.println(activityList);
            if ( activityList != null) {
                return Result.success(activityList);
            } else {
                return Result.error("未找到对应的结果");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("查询错误！");
        }
    }

    @GetMapping("/find_all")
    public Result findAll(){
        try {
//            registrantService.findAllRegistrant();
            return Result.success(activityService.findAllActivity());
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("查询错误！");
        }
    }


    @RequestMapping("/modify")
    public Result modifyActivity(@RequestBody Activity activity){
        try {
            if (activityService.getById(activity.getId()) != null){
//                activityService.modifyActivity(RegistrantUtil.RegistrantDTOtoRegistrant(activity));
                return Result.success("更新成功！");
            }else {
                return Result.error("未找到相关信息");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("修改错误！");
        }
    }
}
