package com.wechat.entity;

import lombok.Data;

import java.util.List;

@Data
public class RegistrantDTO extends Registrant {
    private List<String> materialDTO; //身份材料
}
