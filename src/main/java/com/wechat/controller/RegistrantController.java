package com.wechat.controller;

import com.wechat.entity.Registrant;
import com.wechat.entity.RegistrantDTO;
import com.wechat.service.RegistrantService;
import com.wechat.util.RegistrantUtil;
import com.wechat.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/registrant")
public class RegistrantController {
    @Autowired
    private RegistrantService registrantService;

//    实现增删改查的功能
    @RequestMapping("/add")
    public Result addRegistrant(@RequestBody RegistrantDTO registrantDTO){
        try {
            if (registrantService.getById(registrantDTO.getUid()) == null){
                registrantService.addRegistrant(RegistrantUtil.RegistrantDTOtoRegistrant(registrantDTO));
            }else {
                return Result.error("已经存在");
            }
            return Result.success();
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("添加错误！");
        }
    }

    @DeleteMapping("/delete/{uid}")
    public Result deleteRegistrant(@PathVariable("uid") String uid)
    {
        try {
            if (registrantService.getById(uid) != null){
                registrantService.deleteRegistrant(uid);
                return Result.success("更新成功！");
            }else {
                return Result.error("未找到相关信息");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("删除错误！");
        }
    }

    @RequestMapping("/modify")
    public Result modifyRegistrant(@RequestBody RegistrantDTO registrantDTO){
        try {
            if (registrantService.getById(registrantDTO.getUid()) != null){
                System.out.println(registrantDTO);
                System.out.println(registrantDTO.getMaterialDTO());
                registrantService.modifyRegistrant(RegistrantUtil.RegistrantDTOtoRegistrant(registrantDTO));
                System.out.println(RegistrantUtil.RegistrantDTOtoRegistrant(registrantDTO));
                return Result.success("更新成功！");
            }else {
                return Result.error("未找到相关信息");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("修改错误！");
        }
    }

    @GetMapping("/find_by_name/{name}")
    public Result findByName(@PathVariable(value = "name") String name){
        try {
//            Registrant result = registrantService.findRegistrantByName(name);
            List<Registrant> registrantList = registrantService.findRegistrantByName(name);
            if ( registrantList != null) {
                return Result.success(registrantList);
            } else {
                return Result.error("未找到对应的结果");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("查询错误！");
        }
    }

    @GetMapping("/find_by_phone/{phone}")
    public Result findByPhone(@PathVariable(value = "phone") String phone) {
        try {
            Registrant result = registrantService.findRegistrantByPhone(phone);

            if (result != null) {
                return Result.success(result);
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
            return Result.success(registrantService.findAllRegistrant());
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("查询错误！");
        }
    }
}
