package com.wzz.wechat.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Getter @Setter
public class Area {

    @Id
    private Integer areaId;

    private String areaName;

    private Integer priority;

    private Date createTime;

    private Date lastEditTime;

}
