package com.wechat.entity;

import lombok.Data;

import java.util.List;

@Data
public class ActivityDTO extends Activity {
    private List<Activity> photoDTO;

}
