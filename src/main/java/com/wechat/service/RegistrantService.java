package com.wechat.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wechat.entity.Registrant;

import java.util.List;

public interface RegistrantService extends IService<Registrant> {
    public List<Registrant> findRegistrantByName(String name);
    public Registrant findRegistrantByPhone(String phone);
    public List<Registrant> findAllRegistrant();
    public void addRegistrant(Registrant registrant);
    public void deleteRegistrant(String uid);
    public void modifyRegistrant(Registrant registrant);

}
