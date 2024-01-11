package com.wechat.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wechat.entity.Registrant;
import com.wechat.mapper.RegistrantMapper;
import com.wechat.service.RegistrantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistrantServiceImpl extends ServiceImpl<RegistrantMapper, Registrant> implements RegistrantService {
    @Autowired
    private RegistrantMapper registrantMapper;

    @Override
    public List<Registrant> findRegistrantByName(String name) {
//        QueryWrapper<Registrant> registrantQueryWrapper = new QueryWrapper<>();
//        registrantQueryWrapper.eq("name", name);
//        return registrantMapper.selectList(registrantQueryWrapper);
        return registrantMapper.selectList(new QueryWrapper<Registrant>().eq("name", name));
    }

    @Override
    public Registrant findRegistrantByPhone(String phone ) {
        return registrantMapper.selectOne(new QueryWrapper<Registrant>().eq("phone_number", phone));
    }

    @Override
    public List<Registrant> findAllRegistrant() {
        return registrantMapper.selectList(null);
    }

    @Override
    public void addRegistrant(Registrant registrant) {
        registrantMapper.insert(registrant);
    }

    @Override
    public void deleteRegistrant(String uid) {
        registrantMapper.deleteById(uid);
    }
    @Override
    public void modifyRegistrant(Registrant registrant) {
        UpdateWrapper<Registrant> registrantUpdateWrapper = new UpdateWrapper<>();
        registrantUpdateWrapper.eq("uid", registrant.getUid())
                .set("name", registrant.getName())
                .set("nickname", registrant.getNickname())
                .set("avatar", registrant.getAvatar())
                .set("emp_info", registrant.getEmpInfo())
                .set("phone_number", registrant.getPhoneNumber())
                .set("identity", registrant.getIdentity())
                .set("ic", registrant.getIC())
                .set("age", registrant.getAge())
                .set("material", registrant.getMaterial())
                .set("date_of_birth", registrant.getDateOfBirth());
        update(registrant, registrantUpdateWrapper);
    }


}

