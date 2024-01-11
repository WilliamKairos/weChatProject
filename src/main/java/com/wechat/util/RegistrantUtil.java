package com.wechat.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wechat.entity.Registrant;
import com.wechat.entity.RegistrantDTO;

public class RegistrantUtil {
    public static Registrant RegistrantDTOtoRegistrant(RegistrantDTO registrantDTO) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Registrant registrant = new Registrant();
        registrant.setIC(registrantDTO.getIC());
        registrant.setAge(registrantDTO.getAge());
        registrant.setAvatar(registrantDTO.getAvatar());
        registrant.setEmpInfo(registrantDTO.getEmpInfo());
        registrant.setIdentity(registrantDTO.getIdentity());
        registrant.setDateOfBirth(registrantDTO.getDateOfBirth());
        registrant.setPhoneNumber(registrantDTO.getPhoneNumber());
        registrant.setUid(registrantDTO.getUid());
        registrant.setName(registrantDTO.getName());
        registrant.setNickname(registrantDTO.getNickname());
        if (registrantDTO.getMaterialDTO() != null) {
            String applicationMaterial = mapper.writeValueAsString(registrantDTO.getMaterialDTO());
            registrant.setMaterial(applicationMaterial);
        }
        return registrant;
    }
}
